/**
 * Copyright 2014 SINTEF <brice.morin@sintef.no>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package diva.alloy;

import static edu.mit.csail.sdg.alloy4.A4Reporter.NOP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;

import diva.Configuration;
import diva.Context;
import diva.DivaFactory;
import diva.VariableValue;
import diva.Variant;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.ast.ExprVar;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;

public class AlloyWrapper implements Callable<Entry<Context, List<Configuration>>> {

	String system;
	Context ctx;
	Map<String, Variant> variants;

	File input;
	List<Configuration> results;
	
	Thread t;

	static volatile A4Options opt = new A4Options();
	static {
		// Chooses the Alloy4 options
		opt.solver = A4Options.SatSolver.SAT4J;
	}

	boolean done = false;

	public AlloyWrapper(String system, Context ctx, Map<String, Variant> variants) {
		this.system = system;
		this.ctx = ctx;
		this.variants = variants;

	}
	
	public void kill() {
		if (t!=null) {
			t.interrupt();
			t.stop();
		}
		Thread.currentThread().interrupt();
	}

	private class RunAlloy implements Runnable {

		A4Solution solution;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Module world = CompUtil.parseEverything_fromFile(null, null, input.getAbsolutePath());
				solution = TranslateAlloyToKodkod.execute_command(NOP, world.getAllReachableSigs(), world.getAllCommands().get(0), opt);
			} catch (Err e) {
				System.err.println("Alloy ERROR:\n" + e.msg);
				e.printStackTrace();
				Thread.currentThread().interrupt();
			} finally {
				input.delete();
			}

		}

	}

	private String computeConfigurations() throws Err, InterruptedException {
		RunAlloy r = new RunAlloy();
		t = new Thread(r);
		t.start();
		t.join(5000);
		
		if (r.solution != null) {
			StringBuilder result = new StringBuilder();
			result.append("");
			A4Solution s = r.solution;
			int i = 0;
			while(s.satisfiable() && i <= 100) {
				Iterator<ExprVar> atoms = s.getAllAtoms().iterator();
				while(atoms.hasNext()) {
					ExprVar v = atoms.next();
					result.append(v.label.replaceAll("\\$0", "") + " ");
				}
				result.append("\n");
				s = s.next();
				i++;
			}
			t.interrupt();
			t.stop();
			return result.toString(); 
		} else {
			System.err.println("Alloy freezes on " + ctx.getName());
			t.interrupt();
			t.stop();
			Thread.currentThread().interrupt();
			return null;
		}
	}

	public Entry<Context, List<Configuration>> call() throws Exception {
		if (!done) {		
			done = true;
			ctx.getConfiguration().clear();
			String context = "";
			int i = 0;
			for(VariableValue v : ctx.getVariable()) {
				if (i > 0)
					context += " and ";
				StringBuilder b = new StringBuilder();
				v.toAlloy(b);
				context += b.toString();
				i++;
			}

			// create a temp file
			FileWriter fw = null;
			try {
				input = File.createTempFile("alloy_system", ".als");
				fw = new FileWriter(input);
				fw.write(system);
				fw.write("\n");
				fw.write("run {" + context + "}");
				fw.close();
				input.deleteOnExit();
			} catch (IOException e) {

			} finally {
				if (fw != null)
					try {
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}

			String alloyResult = computeConfigurations();
			if (alloyResult != null) {
				results = new ArrayList<Configuration>();
				for(String solution : alloyResult.split("\n")) {
					//System.out.println("Solution: " + solution);
					Configuration nc = DivaFactory.eINSTANCE.createConfiguration();
					for(String atom : solution.split(" ")) {
						for(Entry<String, Variant> v : variants.entrySet()) {
							if(atom.equals(v.getKey())) {
								nc.addVariant(v.getValue());
							}
						}
					}
					if (nc.getVariant().size() > 0) {
						results.add(nc);
					}
				}
			}
		}
		if (results != null)
			return new AbstractMap.SimpleEntry<Context, List<Configuration>>(ctx, results);
		else
			return null;
	}
}