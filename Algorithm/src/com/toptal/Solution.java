/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toptal;

/**
 *
 * @author Tesfay
 */
public class Solution {
    
    public static void main(String[] args) {
        int[] arr = new int[] {1,1,2,3,1,1};
        System.out.println(solution(arr));
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
