/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.sort.mergesort;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Tesfay
 */
public class MergeSortArray {
    
    public static <K> void mergeSort(K[] s, Comparator<K> comp){
    
        int n = s.length;
        if(n < 2) return;    // it's trivially sorted
        
        //divide
        int mid = n/2;
        K[] s1 = Arrays.copyOfRange(s, 0, mid); // copy first half to s1
        K[] s2 = Arrays.copyOfRange(s, mid, n); // copy second half to s2
        //conquere
        mergeSort(s1, comp); // recursively sort s1
        mergeSort(s2, comp); // recursively sort s2
        //combiine
        merge(s1,s2,s,comp); // merge the two sorted arrays
        
       // return s;
    }

    private static <K> void merge(K[] s1, K[] s2, K[] s, Comparator<K> comp) {
        int i  = 0 ; int j = 0;
        while(i + j <  s.length)
        {
            if((j == s2.length) || (i < s1.length && comp.compare(s1[i], s[j]) < 0)){
                s[i+j] = s1[i];
                i++;
            }
            else{
                s[i+j] = s2[j];
                j++;
            }
        }
    }
}
