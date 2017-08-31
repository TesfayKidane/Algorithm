/*
Recall that in BubbleSort, at the end of the first pass through the outer loop,
the largest element of the array is in its final sorted position. After the next
pass, the next largest element is in its final sorted position. After the ith pass
(i=0,1,2,…), the largest, second largest,…, i+1st largest elements are in their
final sorted position. Use this observation to cut the running time of
BubbleSort in half. Implement your solution in code, and prove that you have
improved the running time in this way. Call your new Java file, which
contains the improvements from this problem and the previous problem,
BubbleSort2.java.
 */
package algorithm.sort.bubblesort;

/**
 *
 * @author Tesfay
 */
public class BubbleSort2 {
         
   public void sort(Integer[] arr){    
        int len = arr.length;
        for(int i = 0 ; i < len ; i++){
            for(int j = 0 ; j < len - i - 1; j++){
                if(arr[j] > arr[j+1])
                {
                    swap(arr, j, j+1);
                }
            }
        }
    }    
   public void swap(Integer[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
