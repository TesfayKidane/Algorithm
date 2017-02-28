package algorithm.lab01.lecture.halting_withencodings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Utility methods for normal Java programs. 
 * There are utilities for extracting class name and public function
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
	
	/**  Reads package name of the input program.
	 *   Often our code will not have a package (since it is read
	 *   from memory rather than from a file system), so
	 *   package may be an empty string.
	 *   
	 *   We search for the keyword "package", but we do
	 *   not want to consider it a match if we find the
	 *   word "package" embedded in comments somewhere.
	 *   So we look for the keyword "package" among
	 *   the first 40 characters of the program
	 */
	public static String readPackageName(String program) {
		String searchStr = "package ";
		String semicolon = ";";
		String packagePrefix = "";
		int pos = program.substring(0,40).indexOf(searchStr);
		if(pos > -1) {
			int start = pos + searchStr.length();
			int end = program.indexOf(semicolon, start);
			packagePrefix = program.substring(start, end);
		}
		
		//package is empty string if not found; it's packagePrefix + . otherwise
		String retval = (pos == -1) ? packagePrefix : packagePrefix + ".";
		return retval;
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
		System.out.println(convertJavaFileToString("SelfApp.java", false));
		
		
	}
	
	public static String convertJavaFileToString(String filename, boolean isFullPath) {
		String path = System.getProperty("user.dir") + "\\src\\halting_withencodings\\";
		if(isFullPath) {
			path = filename;
		} else {
			path = path + filename;
		}
		String retVal = null;
		File f = new File(path);
		try(BufferedReader buf = new BufferedReader(new FileReader(f))) {
			Stream<String> lines = buf.lines();
			retVal = lines.collect(Collectors.joining("\n"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return retVal;		
		
	}
}
