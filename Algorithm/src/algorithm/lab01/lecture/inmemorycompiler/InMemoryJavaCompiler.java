package algorithm.lab01.lecture.inmemorycompiler;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;
import java.util.Arrays;

/**
 * Created by trung on 5/3/15.
 */
public class InMemoryJavaCompiler {
	//On some machines, may not find the java compiler, so javac is null
	//If that happens, write a line in a static block like:
	// System.setProperty("java.home", "c:\\Program Files\\java\\jdk1.8.45\\jre")
	//This is how the problem is fixed. 
    static JavaCompiler javac = ToolProvider.getSystemJavaCompiler();

    //Note: className should be fully qualified name: package.class
    public static Class<?> compile(String className, String sourceCodeInText) throws Exception {
        SourceCode sourceCode = new SourceCode(className, sourceCodeInText);
        CompiledCode compiledCode = new CompiledCode(className);
        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(sourceCode);
        DynamicClassLoader cl = new DynamicClassLoader(ClassLoader.getSystemClassLoader());
        ExtendedStandardJavaFileManager fileManager = new ExtendedStandardJavaFileManager(javac.getStandardFileManager(null, null, null), compiledCode, cl);
        JavaCompiler.CompilationTask task = javac.getTask(null, fileManager, null, null, null, compilationUnits);
        boolean result = task.call();
        if(result) 
        	return cl.loadClass(className);
        else
        	return null;
    }
}