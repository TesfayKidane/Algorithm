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
public class BinarySum {
    public static int binarySum(int[] data, int low, int high){
        
        if(low > high)
            return 0;
        else if(low == high)
            return data[low] ;// there is only one element in the array
        else {
            int mid = (low + high)/2;
            return binarySum(data, low, mid) + binarySum(data, mid+1, high);
        }
    }
}
