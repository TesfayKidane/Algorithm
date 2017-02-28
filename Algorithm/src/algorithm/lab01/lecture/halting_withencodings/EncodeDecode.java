package algorithm.lab01.lecture.halting_withencodings;

import java.math.BigInteger;

/**
 * This class performs encoding of a String having only extended ascii characters
 * (typically, a Java class file loaded into memory as a String)  to a binary string
 * (string of 0s and 1s). This is done by transforming each character of the input to
 * its numeric ascii equivalent, and then converting that decimal integer into 
 * a binary string of length 9 (the string is padded with 0s at the front in case it
 * has length < 9). 
 * 
 * This class also performs the inverse operation of decoding. Input can either
 * be a binary string  or any BigInteger. Output will in this case be a String
 * (which will often turn out to be a java program). The output is obtained by
 * first converting input to a binary string (in case input is an integer) and then
 * reading successive blocks of 9 characters, converting to an integer, and then
 * converting the integer to a character via the ASCII table.
 * 
 * @author pcorazza
 *
 */
public class EncodeDecode {
	public static void main(String[] args) {
		String program = "public class Test {\n" 
		+ "   public BigInteger myMethod(BigInteger x) {\n"
		+"         BigInteger y = x.add(x);\n"
		+"         return y;\n"
		+"    }\n"
		+"}";
		
		System.out.println(program);
		BigInteger encoded = encodeProgram(program);
		System.out.println("Encoding:\n" + encoded.toString());
		String origProgram = decodeInteger(encoded);
		System.out.println("\nDecoding the code:\n" + origProgram);
//		
//		encoded = encode(test);
//		System.out.println("Original string:\n" + test);
//		System.out.println(encoded);
//		System.out.println(decode(encoded));
		
	}
	
	//Primary encode/decode methods are here
	//from Java program to BigInteger (encoding)
	//from BigInteger to JavaProgram (decoding)
	
	public static BigInteger encodeProgram(String program) {
		return encode(program, false);
	}
	
	public static String decodeInteger(BigInteger code) {
		return decode(code);
	}
	
	/////// Code below provides support methods //////////
	
	private static final int WORD_LENGTH = 8;
	
	/** Converts input string into a binary string. See class comments. */
	public static String encode(String s) {
		char[] chars = s.toCharArray();
		StringBuilder output = new StringBuilder();
		for(char c : chars) {
			output.append(asLength8Binary(c));
		}
		return output.toString();
		
	}
	
	/**
	 * Returns BigInteger equivalent
	 *  - binstr true means the input is an encoded binary string 
	 *  - binstr false means the input is like a java program - not encoded yet
	 * @param s
	 * @param bigint
	 * @return
	 */
	public static BigInteger encode(String s, boolean binstr) {
		if(binstr) {
			return new BigInteger(s,2);
			
		} else {
			return new BigInteger(encode(s),2);
		}
	}
	/** Converts input binary string to a String of characters. 
	 *  Throws IllegalArgumentException if input is not a binary string
	 *  or if input length is not a multiple of 9. Conversion is done
	 *  by reading length-9 blocks from the input and converting to
	 *  characters using the ASCII table
	 * 
	 */
	public static String decode(String binStr) {
		if(binStr.length() % WORD_LENGTH != 0) 
			throw new IllegalArgumentException("Input string must have length a multiple of "  + WORD_LENGTH);
		try {
			new BigInteger(binStr,2);
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException("Input string must consist of 0s and 1s only");
		}
		int start = 0;
		int end = WORD_LENGTH;
		int steps = binStr.length()/WORD_LENGTH;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < steps; ++i) {
			sb.append(convertToChar(nextBlock(binStr, start, end)));
			start += WORD_LENGTH;
			end +=WORD_LENGTH;
		}
		return sb.toString();
	}
	public static String decode(BigInteger num) {
		String binaryStr = num.toString(2);
		int len = binaryStr.length();
		int nextMultiple =(len % WORD_LENGTH == 0) 
				              ? len 
				              : len + (WORD_LENGTH - (len % WORD_LENGTH));
		return decode(pad(num.toString(2), nextMultiple));
	}
	
	public static BigInteger binStringToBigInteger(String binStr) {
		return new BigInteger(binStr,2);
	}
	private static String nextBlock(String binStr, int start, int end) {
		return binStr.substring(start, end);
	}
	private static String convertToChar(String block) {
		return "" + (char) Integer.parseInt(block, 2);
	}
	private static String asLength8Binary(char c) {
		return pad(Integer.toBinaryString((int) c));
	}
	public static String pad(String s, int nextMultiple) {
		while(s.length() < nextMultiple) {
				s = "0" + s;
		}
		return s;
	}
	public static String pad(String s) {
		while(s.length() < WORD_LENGTH) {
				s = "0" + s;
		}
		return s;
	}
}
