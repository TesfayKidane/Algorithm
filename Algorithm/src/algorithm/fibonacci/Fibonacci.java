/*
* Write function to compute Nth fibonacciBad number:
*/
package algorithm.fibonacci;

/**
 *
 * @author Tesfay
 */
public class Fibonacci {
    // computes is O(pow(2,n)) time
    public static int fibonacciBad(int n){
        return n <= 1 ? n : fibonacciBad(n-1) + fibonacciBad(n-2);
    }
    
    // computes is O(n) time
    public static long[] fibonacciGood(int n)
    {
        if(n <= 1 ){
            long[] answer = {n,0};
            return answer;
        }
        else{
            long[] temp = fibonacciGood(n-1); // returns fn-1, fn-2
            long[] answer = {temp[0] + temp[1], temp[0]}; // we want fn,fn-1
            return answer;
        }
    }
    
    public static void main(String[] args){
        int n = 100;
        long start = System.nanoTime();
        System.out.println("fibBad : " + fibonacciBad(n) + " time : " + (System.nanoTime() - start));
        start = System.nanoTime();       
        System.out.println("fibGood : " +  fibonacciGood(n)[0] + " time : " + (System.nanoTime() - start));
    }
}
