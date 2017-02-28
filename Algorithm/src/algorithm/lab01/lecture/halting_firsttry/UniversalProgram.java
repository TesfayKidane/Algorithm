package algorithm.lab01.lecture.halting_firsttry;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.logging.Logger;

/**
 * This class is a "universal java program" in the following sense:
 * 
 * 1. A "normalized" Java class is one that has public class declaration
 * and a public method declaration for which the method accepts
 * a BigInteger argument and returns a BigInteger value.
 * 
 * 2. UniversalProgram will:
 *   a. accept as a string a normalized Java class 
 *       and also a BigInteger argument
 *   b. verify that Java program argument compiles
 *   c. compile the class to produce a Class file for the class
 *   d. create an instance of the class
 *   e. invoke the first public method (using reflection), 
 *       passing in the BigInteger input argument
 *   f. return the output of the method on this input
 *   
 * @author pcorazza
 *
 */
public class UniversalProgram {	
	private static final Logger LOG = Logger.getGlobal();
	/**
	 *@param program - a normalized 
	 *Java class loaded into memory as a string  
	 *@param - input is a BigInteger argument, to be accepted by 
	 *the method of the input program. 
	 */
	public BigInteger runProgram(String program, BigInteger input) {
		CompileTester ct = new CompileTester();
		//verifies that program is a compilable Java class
		boolean compilable = ct.test(program);
		BigInteger retVal = null;
		if(compilable) {
			//loads compiled code as class with class loader
			Class<?> cl = ct.getCompiledClass();
			try {
				//uses reflection to identify the Method for this normal class
				String functionName = Util.readFunctionName(program);
				Method method = cl.getMethod(functionName, BigInteger.class);
				//invokes the program's method on a new instance of this class, 
				//passing in input 
				retVal = (BigInteger)method.invoke(cl.newInstance(), input);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			LOG.warning("Input program did not compile");
		}
		return retVal;	
	}

	
	
	
	public static void main(String[] args) {
		UniversalProgram u = new UniversalProgram();
		System.out.println(SampleCode2.SAMPLE);
		System.out.println(u.runProgram(SampleCode2.SAMPLE, BigInteger.valueOf(5)));
	}
}
