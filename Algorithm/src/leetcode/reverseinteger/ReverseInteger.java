/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.reverseinteger;

import java.util.Arrays;

/**
 *
 * @author Tesfay
 */
public class ReverseInteger {

    public int reverse(int x) {
        boolean negative = false;
        long y = (long)x;
        if (y < 0) {
            negative = true;
            y = -y;
        }

        String num = String.valueOf(y);

        int i = 0;
        int j = num.length() - 1;
        char[] numChar = num.toCharArray();
        while (i < j) {
            char temp = numChar[i];
            numChar[i] = numChar[j];
            numChar[j] = temp;
            i++;
            j--;
        }

        num = String.copyValueOf(numChar);
        long result = Long.valueOf(num);
        
        if (negative) {
            result = -result;
        }  
        
         if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
         
        return (int)result;
    }
    
    public static void main(String[] args){
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(1234));
        System.out.println(ri.reverse(-1534236469));
        System.out.println(ri.reverse(-2147483648));
    }
}
