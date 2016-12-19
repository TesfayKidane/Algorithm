/*
* Write function to compute Nth fibonacci number:
*/
package algorithm.reversstring;

/**
 *
 * @author Tesfay
 */
public class ReverseString {
    
    
    public static String reverse(String s){
    
        int length = s.length(), last = length - 1 ;
        char[] chars = s.toCharArray();
        
        for(int i = 0 ; i < length/2 ; i++)
        {
            char c = chars[last-i];
            chars[last-i] = chars[i];
            chars[i] = c;
        }
        
        return String.copyValueOf(chars);       
    }
}
