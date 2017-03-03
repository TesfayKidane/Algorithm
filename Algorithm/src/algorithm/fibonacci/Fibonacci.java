/*
* Write function to compute Nth fibonacciBad number:
 */
package algorithm.fibonacci;

/**
 * Fibonacci numbers have always been interesting since ancient times. The
 * initial puzzle that Fibonacci posed was: how many pairs of rabbits will there
 * be in one year if all of them can mate with each other.
 *
 * @author Tesfay
 */
public class Fibonacci {

    // computes in O(pow(2,n)) time
    public static long fibonacciBad(int n) {
        return n <= 1 ? n : fibonacciBad(n - 1) + fibonacciBad(n - 2);
    }

    // computes in O(n) time
    public static long[] fibonacciGood(int n) {
        if (n <= 1) {
            long[] answer = {n, 0};
            return answer;
        } else {
            long[] temp = fibonacciGood(n - 1); // returns fn-1, fn-2
            long[] answer = {temp[0] + temp[1], temp[0]}; // we want fn,fn-1
            return answer;
        }
    }

    // computes in O(n) time
    public static long findFibonacci(int n) {
        if (n < 1) {
            return 0;
        }
        int fibo1 = 0;
        int fibo2 = 1;

        int fibo = fibo2;
        for (int i = 1; i < n; i++) {
            fibo = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = fibo;
        }

        return fibo;
    }

    public static int iterativeFib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int accum1 = 0, accum2 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = accum1;
            accum1 = accum2;
            accum2 += temp;
        }
        return accum2;
    }

    public static int iterativeFib2(int n) {
        if (n == 0) {
            return n;
        }

        int accum1 = 0, accum2 = 1;
        for (int i = 1; i < n; i++) {
            int temp = accum1;
            accum1 = accum2;
            accum2 += temp;
        }
        return accum2;
    }
    
       public static int iterativeFib3(int n) {
        if (n == 0) {
            return n;
        }

        int accum1 = 0, accum2 = 1;
        int temp = 0;
        for (int i = 1; i < n; i++) {
            temp = accum1;
            accum1 = accum2;
            accum2 += temp;
        }
        return accum2;
    }

    public static void main(String[] args) {
        int n = 1000;
        long start = System.nanoTime();
        System.out.println("iterativeFib : " + iterativeFib(n) + " time : " + (System.nanoTime() - start));
        start = System.nanoTime();
        System.out.println("iterativeFib2 : " + iterativeFib2(n) + " time : " + (System.nanoTime() - start));
        start = System.nanoTime();
        System.out.println("iterativeFib3 : " + iterativeFib3(n) + " time : " + (System.nanoTime() - start));
        start = System.nanoTime();
        System.out.println("fibonacciGood : " + fibonacciGood(n)[0] + " time : " + (System.nanoTime() - start));
        start = System.nanoTime();
        System.out.println("findFibonacci : " + findFibonacci(n) + " time : " + (System.nanoTime() - start));
        start = System.nanoTime();
        System.out.println("fibonacciMatrix : " + FibonacciMatrix.fibonacciMatrix(n) + " time : " + (System.nanoTime() - start));
    }
}
