/*
 * 1. Run length encoding of a string. Ex – Input – aaaabbcd , Output – a4b2c1d1
 */
package com.amazon;

import java.util.HashMap;

/**
 *
 * @author Tesfay
 */
public class StringEncoding {
    
    public static String encodedString(String str){
        
        // first create hashmap of every character (lowercase).
        HashMap<Integer, HashMap<Integer,Integer>> alpha =  new HashMap<>();
        
       int encodingCount = 0 ; 
       int currChar = str.charAt(0) - 'a';
       int currCharCount = 1;
       int charPosition = 0;
       
       HashMap<Integer, Integer> value =  new HashMap<Integer, Integer>();
       value.put(charPosition, currCharCount);
       alpha.put(currChar, value);

       for(int i = 1 ; i < str.length() ; i++){
            int temp = str.charAt(i) - 'a';
            if(temp == currChar){
                value = new HashMap<Integer, Integer>();
                value = alpha.get(currChar);
                if(value.containsKey(charPosition)){
                    int count = value.get(charPosition);
                    value.put(charPosition, ++count);
                    alpha.put(currChar, value);
                }
                else{
                   value = new HashMap<Integer, Integer>();
                   value.put(charPosition, 1);
                   alpha.put(currChar, value);
                }
            }
            else{
                currChar = temp;
                charPosition++;
                value = new HashMap<Integer, Integer>();
                value.put(charPosition, 1);
                alpha.put(currChar, value);
            }
       }
       return "";
    }
    
    public static void main(String[] args)
    {
        System.out.println(encodedString("aaaabbbcccdddaaaeeeaaa"));
    }
}
