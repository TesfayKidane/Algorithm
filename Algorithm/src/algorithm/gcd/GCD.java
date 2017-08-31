/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.gcd;

/**
 *
 * @author Tesfay
 */
public class GCD {
    
    public static int gcd(int m, int n){
        return (n == 0) ? m : gcd(n, m%n);
    }
    
    public static void main(String[] args){
        System.out.println("gcd(5,11) : " + gcd(5,11));
    }
}
