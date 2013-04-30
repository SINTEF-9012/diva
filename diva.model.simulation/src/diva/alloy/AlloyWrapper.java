package diva.alloy;

import static edu.mit.csail.sdg.alloy4.A4Reporter.NOP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.Callable;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.ast.ExprVar;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;

public class AlloyWrapper implements Callable<String> {
	
	String system, context;
	
	public AlloyWrapper(String system, String context) {
		this.system = system;
		this.context = context;
	}
	
	private String computeConfigurations() throws Err, IOException {
		String result = "";
		
		// Chooses the Alloy4 options
        A4Options opt = new A4Options();
        opt.solver = A4Options.SatSolver.SAT4J;
        
        
        // create a temp file
        File tempfile = File.createTempFile("alloy_system", ".als");
        FileWriter fw = new FileWriter(tempfile);
        fw.write(system);
        fw.write("\n");
        fw.write("run {" + context + "}");
        fw.close();
        tempfile.deleteOnExit();
        
		Module world = CompUtil.parseEverything_fromFile(null, null, tempfile.getAbsolutePath());
		
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

	public String call() throws Exception {
		return computeConfigurations();
	}
	
}
