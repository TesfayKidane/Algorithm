/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.recursion;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Tesfay
 */
public class BinarySearch {

    public static boolean binarySearchRecursive(Integer[] data, int target, int low, int high) throws IllegalStateException {

        if (data.length == 0 || low < 0 || high < 0 || low > high) {
            return false;
        }
        int mid = (int)((low + high) / 2);
        if (target == data[mid]) {
            return true; // match found
        } else if (target < data[mid]) {
            return binarySearchRecursive(data, target, low, mid - 1);
        } else {

            return binarySearchRecursive(data, target, mid + 1, high);
        }
    }

    //assumption is the input array is sorted
    public static boolean binarySearchIterative(Integer[] data, int target) {

        int low = 0;
        int high = data.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;  // find the midian
            if (target == data[mid]) {
                return true;  // match found
            } else if (target < data[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false; // no match found.  
    }

    public static void main(String[] args) {
         int target = 90;
        int low = 0 ;
        int high = 100;
//        Integer[] ints = new Integer[high];
//        List<Integer> list = IntStream.rangeClosed(low, high+1).boxed().collect(Collectors.toList());
//        list.toArray(ints);
        
        Integer[] ints = {0,1,2,3,4,5,6,7,8,9,10};
        long start = System.nanoTime();
        System.out.println("binarySearchRecursive : " + binarySearchRecursive(ints, target, low, high)+ ", time : " + (System.nanoTime() - start));
        
        start = System.nanoTime();
        System.out.println("binarySearchIterative : " + binarySearchIterative(ints, target)+ ", time : " + (System.nanoTime() - start));
    }
}
