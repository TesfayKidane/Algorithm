/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.lab02.problem03;

import java.util.Arrays;

/**
 *
 * @author Tesfay
 */
public class Merge {
    
    public int[] merge(int[] arr1, int[] arr2){
    
        int mergedSize = arr1.length + arr2.length;
        
        int[] mergedArray = new int[mergedSize];
        
        int i = 0 ; int j = 0 ;
        
        while(i + j < mergedSize){
            if( j == arr2.length || (i < arr1.length && arr1[i] < arr2[j])){
                mergedArray[i+j] = arr1[i];
                i++;
            }
            else{
                mergedArray[i+j] = arr2[j];
                j++;
            }        
        }
        return mergedArray;
    }
    
    public static void main(String[] args){
    
        Merge m = new Merge();
        Arrays.asList(m.merge(new int[]{1, 4, 5, 8, 17}, new int[]{2, 4, 8, 11, 13, 21, 23, 25})).stream().forEach(x -> System.out.println(" " + Arrays.toString(x)));
    }
}
