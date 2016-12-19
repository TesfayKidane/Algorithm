/*
* Write function to compute Nth fibonacci number:
*/
package algorithm.fibonacci;

/**
 *
 * @author Tesfay
 */
public class Fibonacci {
    public static int fibonacci(int n){
        return n <= 1 ? n : fibonacci(n-1) + fibonacci(n-2);
    }
}
