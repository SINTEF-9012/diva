package diva.alloy;

import static edu.mit.csail.sdg.alloy4.A4Reporter.NOP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;

import kodkod.ast.Variable;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.ast.ExprVar;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.parser.Module;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;
//import fr.irisa.triskell.kermeta.runtime.RuntimeObject;

public class AlloyWrapper {

	
	/*public static RuntimeObject KComputeConfigurations(RuntimeObject system, RuntimeObject context) {
		String sys = fr.irisa.triskell.kermeta.runtime.basetypes.String.getValue(system);
		String ctx = fr.irisa.triskell.kermeta.runtime.basetypes.String.getValue(context);
		String result;
		try {
			result = computeConfigurations(sys, ctx);
		} catch (Throwable e) {
			Writer st = new StringWriter();
			e.printStackTrace(new PrintWriter(st));
			result = "ALLOY: " + e.getMessage() + "\n" + st.toString();
		}

		return fr.irisa.triskell.kermeta.runtime.basetypes.String.create(result, system.getFactory());
	}*/
	
	public static String computeConfigurations(String system, String context) throws Err, IOException {
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
        while(s.satisfiable()) {
        	
        	Iterator<ExprVar> atoms = s.getAllAtoms().iterator();
        	while(atoms.hasNext()) {
        		ExprVar v = atoms.next();
        		result += v.label.replaceAll("\\$0", "") + " ";
        	}
        	result += "\n";
        	
        	s = s.next();
        	i++;
        	if (i > 100) break; // just for security
        }
        return result;
	}
	
}
