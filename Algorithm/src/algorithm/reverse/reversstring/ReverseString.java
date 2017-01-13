/*
* Write function to compute Nth fibonacci number:
 */
package algorithm.reverse.reversstring;

import java.util.Random;

/**
 *
 * @author Tesfay
 */
public class ReverseString {

    public static String reverse(String s) {

        int length = s.length(), last = length - 1;
        char[] chars = s.toCharArray();

        for (int i = 0; i < length / 2; i++) {
            char c = chars[last - i];
            chars[last - i] = chars[i];
            chars[i] = c;
        }

        return String.copyValueOf(chars);
    }

    // Esayas's code
    public static String esayasReverse(String str) {
        if (str.length() == 1) {
            return str;
        } else {
            return esayasReverse(str.substring(1)) + str.charAt(0);
        }
    }

    // Sirak's code
    private static String sirakReverse(String st, StringBuilder result) {
        if (st.isEmpty()) {
            return null;
        }
        if (st.length() == 1) {
            String s = "" + st.charAt(0);
            return s;
        } else {
            result.append(st.charAt(st.length() - 1));
            return sirakReverse(st.substring(0, st.length() - 1),result);
        }
    }
    
    public static void main(String[] args){
    
       final String textToBeReversed = randomString(1000000, "AaBbCcDdEeFfGgHhIiJjKkLlMmNnO oPpQqRrSsTtUuVvWwXxYyZz");
       long start = System.currentTimeMillis();
       reverse(textToBeReversed);
       System.out.println("Tesfay's Reverse Algo : " + (System.currentTimeMillis() - start)); 
       
       start = System.currentTimeMillis();
       esayasReverse(textToBeReversed);
       System.out.println("Esayas's Reverse Algo : " + (System.currentTimeMillis() - start)); 
       
       start = System.currentTimeMillis();
       sirakReverse(textToBeReversed,new StringBuilder());
       System.out.println("Sirak's Reverse Algo : " + (System.currentTimeMillis() - start)); 
       
    }
    
    public static String randomString(int length, String alphabet){
    
        Random random = new Random();
        int alphabetLength = alphabet.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(alphabet.charAt(random.nextInt(alphabetLength)));
        }
        return stringBuilder.toString();
    }
}
