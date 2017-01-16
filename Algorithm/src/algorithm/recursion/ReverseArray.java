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
public class ReverseArray {
    /**
     * Because each recursive call uses some space on the stack. If your recursion is too deep, then it will result in StackOverflow,
     * depending upon the maximum allowed depth in the stack.
     * @param data
     * @param low
     * @param high
     * @throws IllegalStateException 
     */
    public static void recursiveReverseArray(Integer[] data, int low, int high) throws IllegalStateException{
        
        if(low < 0 || high < 0 || low > data.length-1 || high > data.length-1) {
            throw new IllegalStateException("Illegal Input");
        }
        if(low < high){
            int temp = data[low];
            data[low] = data[high];
            data[high] = temp;
            recursiveReverseArray(data, low+1, high-1);
        }
    }
}
