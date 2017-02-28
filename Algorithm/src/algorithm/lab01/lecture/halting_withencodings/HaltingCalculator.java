package algorithm.lab01.lecture.halting_withencodings;

import java.math.BigInteger;

/**
 * This is an attempt to solve the Halting Problem. Since there
 * is no algorithmic solution, this attempt fails, but it shows 
 * how a reasonable attempt to solve the problem would look.
 * 
 * @author pcorazza
 *
 */
public class HaltingCalculator {
	private BigInteger encodedProgram;
	private boolean containsEndless = false;
	private String className = null;
	
	public HaltingCalculator(BigInteger code) {
		validateArgument(code);
		this.encodedProgram = code;
		containsEndless = Util.containsEndless(EncodeDecode.decodeInteger(code));	
	}

	
	/**
	 * Returns 1 if program halts on given input, 0 otherwise
	 */
	public int halts(BigInteger input) {
		if (containsEndless) {
			return 0;
		}
		UniversalProgram up = new UniversalProgram();
		try {

			up.runProgram(encodedProgram, input);

			return 1;
		} catch (Throwable t) {
			return 0;
		}
	}
	
	
	
	private void validateArgument(BigInteger code) {  
		CompileTester ct = new CompileTester();
		//verifies that encoded program is a compilable Java class
		
		boolean compilable = ct.test(code);
		if(!compilable) {
			throw new IllegalArgumentException("Input string is not a compilable Java program.");
		}
	}
	public static void main(String[] args) {
		HaltingCalculator calc = new HaltingCalculator(EncodeDecode.encodeProgram(SampleCode.SAMPLE));
		BigInteger input = BigInteger.valueOf(11);
		System.out.println("Test Code:\n" + SampleCode.SAMPLE);
		System.out.println("Does this program halt on input " + input.intValue() + "?\n" + (calc.halts(input) == 1));
	    System.out.println("====================");
		System.out.println(SampleCode2.SAMPLE);
		calc = new HaltingCalculator(EncodeDecode.encodeProgram(SampleCode2.SAMPLE));
		input = BigInteger.valueOf(11);
		System.out.println("Test Code:\n" + SampleCode2.SAMPLE);
		System.out.println("Does this program halt on input " + input.intValue() + "?\n" + (calc.halts(input) == 1));

		System.out.println("====================");
		String program = Util.convertJavaFileToString("TestClass.java", false);
		System.out.println(program);
		System.out.println("\nCompiles? " + (new CompileTester()).test(program)); 
		
		calc = new HaltingCalculator(EncodeDecode.encodeProgram(program));
		input = BigInteger.valueOf(11);
		System.out.println("\nCompiles? " + (new CompileTester()).test(program)); 
		System.out.println("Does this program halt on input " + input.intValue() + "?\n" + (calc.halts(input) == 1));
		
	}
}
