/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.sort.mergesort;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author Tesfay
 */
public class MergeSortQueue {
    
    
    public static <K> LinkedList<K> mergeSort(LinkedList<K> s, Comparator<K> comp){
        
        int n = s.size();
        if(n < 2) return null;   // sorted trivially
        
        //devide
        LinkedList<K> s1 = new LinkedList<>();
        LinkedList<K> s2 = new LinkedList<>();
        
        while(s1.size() < n/2)
            s1.add(s.poll());
        
        while(!s.isEmpty())
            s2.add(s.poll());
        
        // conquere
        mergeSort(s1, comp);
        mergeSort(s2, comp);
        
        // combine
        merge(s1,s2,s,comp);
        
        return s;
    }

    private static <K> void merge(Queue<K> s1, Queue<K> s2, Queue<K> s, Comparator<K> comp) {
        
        while(!s1.isEmpty() && !s2.isEmpty()){
            if(comp.compare(s1.peek(), s2.peek()) < 0)
                s.add(s1.poll());
            else
                s.add(s2.poll());
        }
        
        while(!s1.isEmpty())
        {
            s.add(s1.poll());
        }
        
        while(!s2.isEmpty())
        {
            s.add(s2.poll());
        }
    }
    
}
