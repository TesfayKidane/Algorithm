package algorithm.lab01.lecture.halting_firsttry;

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
	private String program;
	private boolean containsEndless = false;
	public HaltingCalculator(String program) {
		//verifies that program is a compilable Java program
		validateArgument(program);
		this.program = program;
		containsEndless = Util.containsEndless(program);	
	}
	/**
	 * Returns 1 if program halts on given input, 0 otherwise
	 */
	public int halts(BigInteger input) {
		if(containsEndless) {
			return 0;
		}
		UniversalProgram up = new UniversalProgram();
		try {
			up.runProgram(program, input);
			return 1;
		} catch(Throwable t) {
			return 0;
		}
	}


	
	private void validateArgument(String program) {  
		CompileTester ct = new CompileTester();
		//verifies that binString is a compilable Java class
		boolean compilable = ct.test(program);
		if(!compilable) {
			throw new IllegalArgumentException("Input string is not a compilable Java program.");
		}
	}
	public static void main(String[] args) {
//		HaltingCalculator calc = new HaltingCalculator(SampleCode.SAMPLE);
//		BigInteger input = BigInteger.valueOf(11);
//		System.out.println("Test Code:\n" + SampleCode.SAMPLE);
//		System.out.println("Does this program halt on input " + input.intValue() + "?\n" + (calc.halts(input) == 1));
//	
		System.out.println(SampleCode2.SAMPLE);
		HaltingCalculator calc = new HaltingCalculator(SampleCode2.SAMPLE);
		BigInteger input = BigInteger.valueOf(11);
		System.out.println("Test Code:\n" + SampleCode2.SAMPLE);
		System.out.println("Does this program halt on input " + input.intValue() + "?\n" 
		   + (calc.halts(input) == 1));

	}
}
