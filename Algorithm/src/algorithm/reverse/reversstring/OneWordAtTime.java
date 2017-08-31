/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.reverse.reversstring;

/**
 *
 * @author Tesfay
 */
public class OneWordAtTime {
    
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
}
