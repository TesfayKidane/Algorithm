/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.recursion;

/**
 *
 * @author Tesfay
 */
public class Factorial {
    
    public static int factorial(int n) throws IllegalStateException{
        if( n < 0) throw new IllegalStateException("n should be >= 0");
        
        else if( n == 0) return 1;
        
        else{
            return n*factorial(n-1);
        }
    }
    
    public static void main(String[] args){
        System.out.println(factorial(5));
    }
}
