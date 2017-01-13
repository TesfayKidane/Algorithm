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
public class BinarySearch {
    
    public static boolean binarySearch(Integer[] data, int target, int low, int high) throws IllegalStateException{
        
        if(data.length == 0 || low < 0 || high < 0 || low > high) return false;
        int mid = (low + high)/2;
        if(target == data[mid])
            return true; // match found
        else if( target < data[mid]){
            return binarySearch(data, target, low, mid-1);
        }           
        else{
            
            return binarySearch(data, target, mid+1, high);
        }
    }
}
