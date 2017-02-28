package algorithm.lab01.lecture.halting_withencodings;

import java.math.BigInteger;

/**
 * If the halting function is computable, this SelfApp function apply must also
 * be computable.
 * 
 * This SelfApp is a normalized Java program -- it is a single public method
 * that takes a single BigInteger argument, and all the supporting classes have
 * been placed inside SelfApp as static nested classes.
 * 
 * Since SelfApp is a normalized Java program, we can find its code and execute
 * the apply method on its own code -- and ask whether, in this case, the apply
 * method halts. This question leads to a paradox: the apply method halts in
 * this case if and only if it does not halt.
 * 
 * @author pcorazza
 *
 */
public class SelfApp {
	/**
	 * Returns 1 if HaltingCalculator returns 0. 
	 * Goes into endless loop if
	 * HaltingCalculator returns 1
	 */
	public BigInteger apply(BigInteger code) {
		HaltingCalculator halting 
		   = new HaltingCalculator(code);
		Integer result = halting.halts(code);
		if (result.intValue() == 1) {
			while(true) {;}
		}
		return BigInteger.valueOf(1);
	}  


	public static void main(String[] args) {
		//Note that apply will return 1 if the while loop is written
		//in a way that it can be found by a string search (as in other examples) 
		//in that case it prematurely
		//detects the while(true) loop, which might not actually be executed
		//If the while loop is changed slightly (so it won't be detected), then
		//apply will go into an endless loop
		
//		SelfApp sa = new SelfApp();
//		BigInteger bigInt = EncodeDecode.encodeProgram(
//				Util.convertJavaFileToString("SelfApp.java",  false));
//		System.out.println("When SelfApp.selfApply is applied to SelfApp.java, "
//				+ "output is " + sa.apply(bigInt));
		
		////// This code tests SelfApp when codes of other normal programs are passed in
		
		SelfApp sa = new SelfApp();
		BigInteger bigInt = EncodeDecode.encodeProgram(SampleCode2.SAMPLE);
		System.out.println("When SelfApp.apply is applied to SampleCode2, "
				+ "output is " + sa.apply(bigInt));
		
		
		/* Gives you some idea of how big the code is for SelfApp*/
		
//		BigInteger selfAppCode = 
//			EncodeDecode.encodeProgram(
//				Util.convertJavaFileToString("SelfApp.java", false));
//		System.out.println(selfAppCode.bitCount());
		
		//sa.apply(selfAppCode);
		
		
		
	}
}
