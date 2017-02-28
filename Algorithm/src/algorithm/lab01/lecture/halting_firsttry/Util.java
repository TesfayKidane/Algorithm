package algorithm.lab01.lecture.halting_firsttry;

/**
 * Utility methods for extracting class name and public function
 * name from a normal Java program. Utilties do not check whether
 * the input string is really a compilable java program -- this should
 * be done (using CompileTester) before using these utilities.
 * 
 * @author pcorazza
 *
 */
public class Util {
	/**  Reads class name of the input program.
	 *   Assumption: there is a space after the class name
	 */
	public static String readClassName(String program) {
		String searchStr = "public class ";
		String space = " ";
		if(program.indexOf(searchStr) == -1) {
			throw new IllegalArgumentException(
			   "A normal Java class must be declared public");
		}
		int start = program.indexOf(searchStr) + searchStr.length();
		int end = program.indexOf(space, start);
		return program.substring(start, end);
	}
	/** Reads first public method name. 
	 *  Assumption: there is no space between function name and character '('
	 */
	public static String readFunctionName(String program) {
		String searchStr1 = "public BigInteger ";
		String searchStr2 = "public java.math.BigInteger ";
		int location = program.indexOf(searchStr1);
		int len =searchStr1.length();
		if(location == -1) {
			location = program.indexOf(searchStr2);
			len = searchStr2.length();
		} 
		
		if(location == -1) {
			throw new IllegalArgumentException(
			   "A normal Java class must have a public method with return value of type BigInteger.");
		}
		String space = "(";
		int start = location + len;
		int end = program.indexOf(space, start);
		return program.substring(start, end);
	}
	/**
	 * Returns true if the program contains the code
	 *    while(true) {;}
	 *       
	 * @param program
	 * @return
	 */
	public static boolean containsEndless(String program) {
		return program.contains("while(true){}") ||
			program.contains("while(true) {}");
	}
	
	public static void main(String[] args) {
		String program = SampleCode.SAMPLE;
		System.out.println("Class name: " + readClassName(program));
		System.out.println("Function name: " + readFunctionName(program));
		
	}
}
