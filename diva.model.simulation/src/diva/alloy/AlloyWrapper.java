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

	public AlloyWrapper(String system, Context ctx, Map<String, Variant> variants) {
		this.system = system;
		this.ctx = ctx;
		this.variants = variants;
		
	}

	private String computeConfigurations() throws Err, IOException {
		String result = "";

		// Chooses the Alloy4 options
		A4Options opt = new A4Options();
		opt.solver = A4Options.SatSolver.SAT4J;

		Module world = CompUtil.parseEverything_fromFile(null, null, input.getAbsolutePath());

		A4Solution solution = TranslateAlloyToKodkod.execute_command(NOP, world.getAllReachableSigs(), world.getAllCommands().get(0), opt);
		A4Solution s = solution;
		int i = 0;
		while(s.satisfiable() && i <= 100) {

			Iterator<ExprVar> atoms = s.getAllAtoms().iterator();
			while(atoms.hasNext()) {
				ExprVar v = atoms.next();
				result += v.label.replaceAll("\\$0", "") + " ";
			}
			result += "\n";

			s = s.next();
			i++;
		}
		return result;
	}

	public Entry<Context, List<Configuration>> call() throws Exception {
		if (results == null) {		
			results = new ArrayList<Configuration>();
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
		return new AbstractMap.SimpleEntry<Context, List<Configuration>>(ctx, results);
	}
}