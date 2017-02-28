/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.hackerrank;

import java.util.Scanner;

/**
 *
 * @author Tesfay
 */
public class FibonacciGCD {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 1 || n > 2 * Math.pow(10, 5)) {
            return;
        }
        long x = in.nextLong();
        if (x < 1 || x > Math.pow(10, 12)) {
            return;
        }

        x = fibonacciMatrix(x);
        if (n == 1) {
            System.out.println(x%(Math.pow(10, 9) + 7));
            return;
        }
        
        long y = in.nextLong();
        if (y < 1 || y > Math.pow(10, 12)) {
            return;
        }
        
        y = fibonacciMatrix(y);
        long gcd = gcd(x, y);
        for (int i = 2; i < n; i++) {
            gcd = gcd(gcd, fibonacciMatrix(in.nextInt()));
        }
        System.out.println(gcd%(Math.pow(10, 9) + 7));
    }

    public static long gcd(long x, long y) {
        if (x % y == 0) {
            return y;
        } else {
            return gcd(y, x % y);
        }
    }

    /* function that returns nth Fibonacci number */
    public static int fibonacciMatrix(long n) {
        int F[][] = new int[][]{{1, 1}, {1, 0}};
        if (n == 0) {
            return 0;
        }
        power(F, n - 1);

        return F[0][0];
    }

    static void multiply(int F[][], int M[][]) {
        int x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
        int y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
        int z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
        int w = F[1][0] * M[0][1] + F[1][1] * M[1][1];

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    /* Optimized version of power() in method 4 */
    static void power(int F[][], long n) {
        if (n == 0 || n == 1) {
            return;
        }
        int M[][] = new int[][]{{1, 1}, {1, 0}};

        power(F, n / 2);
        multiply(F, F);

        if (n % 2 != 0) {
            multiply(F, M);
        }
    }
}
