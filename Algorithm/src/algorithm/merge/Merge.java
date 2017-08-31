/*
To measure the time complexity of the merge sort above, let i and j be the length of A1 and A2 respectively. 
Inside the while loop each operation performed takes O(1) time. The algorithm is designed to copy one element
from either A1 or A2 to A during each iteration in the while loop. After an element is copied to A it is not 
visited any more. Therefor the while loop iterate a total of i + j times, which leads us to conclude the merge
algorithm has a time complexity of O(i + j).
 */
package algorithm.merge;

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
