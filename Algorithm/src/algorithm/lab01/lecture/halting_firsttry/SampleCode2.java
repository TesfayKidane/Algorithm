package algorithm.lab01.lecture.halting_firsttry;

/**
 * A normal Java program as a string. 
 * The program, when executed, adds 3 to the input integer
 * but then enters an endless loop and therefore never halts.
 *
 */
public class SampleCode2 {
	public static final String SAMPLE = 
			"public class Endless {\n" +
		    "  public java.math.BigInteger aMethod(java.math.BigInteger x) {\n "  +
			"    int w = x.intValue() + 3;\n" +
			"    while(true){}\n" +
			"  }\n" +
			"}";
}
