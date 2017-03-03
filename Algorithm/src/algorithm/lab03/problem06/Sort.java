/*
 Interview Question. An array A holds n integers, and all integers in A belong to the
set {0, 1, 2}. Describe an O(n) sorting algorithm for putting A in sorted order. Your
algorithm may not make use of auxiliary storage such as arrays or hashtables (more
precisely, the only additional space used, beyond the given array, is O(1)). Give an
argument to explain why your algorithm runs in O(n) time.
 */
package algorithm.lab03.problem06;

import java.util.Arrays;

/**
 *
 * @author Tesfay
 */
public class Sort {
 
    public Integer[] sort(Integer[] arr){
        
        int[] elementCount = new int[]{0,0,0};
        
        // count how many times an element occor on the input array
        for(int i = 0 ; i < arr.length; i++){
            if (arr[i] == 0)
                elementCount[0]++;
            else if(arr[i] == 1)
                elementCount[1]++;
            else if(arr[i] == 2)
                elementCount[2]++;
            else
                return null;
        }
        // reconstruct array and return         
        for(int j = 0 ; j < arr.length; j++)
        {
            if(j < elementCount[0])
                arr[j] = 0;
            else if (j >= elementCount[0] && j < elementCount[0] + elementCount[1])
                arr[j] = 1;
            else
                arr[j] = 2;
        }
       
        return arr;
    }
    
    
    public static void main(String[] args)
    {
        Integer[] random = new Integer[]{1,2,2,0,0,1,0,1,2,1};
        Sort s = new Sort();
        System.out.print("\nSort input : ");
        Arrays.asList(random).stream().forEach(x -> System.out.print(" , " + x));
        long start = System.nanoTime();
        s.sort(random);
        System.out.println("\nSort time : " + (System.nanoTime() - start));
        System.out.print("Sort output : ");
        Arrays.asList(random).stream().forEach(x -> System.out.print(" , " + x));
        System.out.println("");
    }
}
