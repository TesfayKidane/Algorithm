/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amazon;

/**
 *
 * @author Tesfay
 */
import java.util.Scanner;

public class Main {
    
    private static Integer solve(int valueToFind) {
        valueToFind = Integer.MIN_VALUE;
        String binary = Integer.toBinaryString(valueToFind);
        System.out.println(binary);
        int i = 0 ; 
        int j = binary.length() - 1;
        
        while(i <= j){
            char a = binary.charAt(i);
            char b =  binary.charAt(j);
            if(a != b)
            {
               return 0;
            }
            i++;
            j--;
        }
        return 1;
    }
    
    private static int readParameter(String[] args) {
        int value = -1;
        try (Scanner in = new Scanner(System.in)) {
            value = in.nextInt();
        }
        return value;
    }
    
    private static void print(Integer result) {
        System.out.println(result);
    }
    
    public static void main(String[] args) {
        int value = readParameter(args);
        Integer out = solve(value);
        print(out);
    }
}