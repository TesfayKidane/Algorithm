package algorithm.lab01.lecture.halting_firsttry;

import algorithm.lab01.lecture.inmemorycompiler.InMemoryJavaCompiler;

import java.util.logging.Logger;

/** 
 * This class tests whether a string is a (compilable) java program. 
 * If it is compilable, the Class object for the program is stored
 * in the variable compiledClass, and can be retrieved.
 
 * @author pcorazza
 *
 */
public class CompileTester {
	private static final Logger LOG = Logger.getGlobal();
	private Class<?> compiledClass;
	public Class<?> getCompiledClass() {
		return compiledClass;
	}
	
	public boolean test(String program) {
		
		try {
			String className = Util.readClassName(program);
			compiledClass = 
					InMemoryJavaCompiler.compile(className, program);			
		} catch(Exception e) {
			LOG.warning("Compilation failed: " + e.getMessage());
			return false;
		}
	    return compiledClass !=null;
	}
	
	public static void main(String[] args) {
		CompileTester t = new CompileTester();
		String program = 
		"public class TestProg { \n" +
		"   public static void main(String[] args) {\n" +
		"       System.out.println(\"hello\");\n" +
        "   }\n" +
		"}";
		System.out.println("The program:\n" + program);
		System.out.println("Compiles? " + t.test(program)); 
	}
}
