/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.sort.quicksort;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Tesfay
 */
public class QuickSort {
  
    public static <K> LinkedList<K> quickSort(LinkedList<K> s, Comparator<K> comp){
        int n = s.size();
        if(n < 2) return null;
        
        //divide
        K pivot = s.peek();
        LinkedList<K> L = new LinkedList<>();
        LinkedList<K> E = new LinkedList<>();
        LinkedList<K> G = new LinkedList<>();
        
        while(!s.isEmpty()){
            K element = s.poll();
            int c = comp.compare(element, pivot);
            if(c < 0)
            {
                L.add(element);
            }
            else if(c == 0)
            {
                E.add(element);
            }
            else{
                G.add(element);
            }
        }
        // conquer
        quickSort(L,comp);
        quickSort(G,comp);
        
        //concatenate results
        while(!L.isEmpty()){
            s.add(L.poll());
        }
        while(!E.isEmpty()){
            s.add(E.poll());
        }
        while(!G.isEmpty()){
            s.add(G.poll());
        }
        return s;
    }
}
