/*
Example: Design an algorithm to print all permutations of a string. For simplicity, assume all
characters are unique.
Consider a test string abcdefg.
Case "a" --> {"a"}
Case "ab" --> {"ab", "ba"}
Case "abc" --> ?
This is the first "interesting" case. If we had the answer to P("ab"), how could we
generate P("abc")? Well, the additional letter is "c," so we can just stick c in at every
possible point. That is:
P("abc") = insert "c" into all locations of all strings in P("ab")
P("abc") = insert "c" into all locations of all strings in
{"ab'Y'ba"}
P("abc") = merge({"cab", "acb", "abc"}, {"cba", "bca", bac"})
P("abc") = {"cab", "acb", "abc", "cba", "bca", bac"}
Now that we understand the pattern, we can develop a general recursive algorithm. We
generate all permutations of a string si... sn by "chopping off" the last character and
generating all permutations of s1— sn r Once we have the list of all permutations of
Sj.. .sn j, we iterate through this list, and for each string in it, we insert sn into every
location of the string.
 */
package algorithm.stringperm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tesfay
 */
public class StringPermutation {
    
    public static List<String> stringPermutation(String s){
        if(s.length() == 0) throw new IllegalArgumentException("String input should have atleast one character");
        List<String> result = new ArrayList<>();
        permutation("",s, result);
        return result;
    }

    private static void permutation(String prefix, String s, List<String> result) {
        int n = s.length();
        if(n == 0) { 
            result.add(prefix);
        }        
        else{
            for(int i = 0 ; i < n ; i++){
                permutation(prefix + s.charAt(i), s.substring(0, i)+s.substring(i+1, n), result);
            }
        }
    }
    
    public static void main(String[] args){
    
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(stringPermutation(alphabet.substring(0,3)));
    }
}
