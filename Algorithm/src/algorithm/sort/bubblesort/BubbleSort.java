/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.sort.bubblesort;

/**
 *
 * @author Tesfay
 */
public class BubbleSort {
         
   public void sort(Integer[] arr){    
        int len = arr.length;
        for(int i = 0 ; i < len ; i++){
            for(int j = 0 ; j < len - 1; j++){
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
