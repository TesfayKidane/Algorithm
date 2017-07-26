/*
Check if an array of intergers is sortable in to a non-decreasing order by only one swap
ele A = [1 , 5, 4, 3, 6] : this array can be sorted by only swapping 5 and 3.
 */
package com.toptal;

/**
 *
 * @author Tesfay
 */
public class SortableArrayBySingleSwap {
    
    public static void main(String[] args) {
        int[] arr = new int[] {1,1,2,3,1,1};
        System.out.println(solution(arr));
        
        int[] arr2 = new int[]{1, 5, 4, 3, 6};
        System.out.println(solution(arr2));
    }
    
    public static boolean solution(int[] A) {

        for(int i = 0; i < A.length - 1; i++) {
            if(A[i] > A[i+1]) {
                int min = i+1;
                for(int j = i+1; j < A.length; j++) {
                    if(A[j] <= A[min])
                        min = j;
                }
                int temp = A[min];
                A[min] = A[i];
                A[i] = temp;
                // check if sorted
                for(int k = 0 ; k < A.length - 1; k++){
                    if(A[k] > A[k+1])
                        return false;
                }
                return true;
            }
        }
        return true;
    }    
    
}
