/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import algorithm.sort.mergesort.MergeSortArray;
import algorithm.sort.mergesort.MergeSortQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tesfay
 */
public class MergeSortTest {
    
    public MergeSortTest() {
    }
    
    //@Test
    public void testMergeSortArray(){
    
        Integer[] s = new Integer[]{8,2,3};
        MergeSortArray.mergeSort(s, new ComparatorInt());
//        assertArrayEquals(new Integer[]{1,2,3,5,7,8}, MergeSortArray.mergeSort(s, (c1,c2)->Integer.compare(c1, c2)));
        Arrays.asList(s).stream().forEach(System.out::println);
        
        System.out.println(new ComparatorInt().compare(2, 2));
        System.out.println("-----------------------------");       
    }
    
    @Test
    public void testMergeSortQueue(){
         LinkedList<Integer> unSortedList = new LinkedList<>();
         unSortedList.addAll(Arrays.asList(new Integer[]{8,2,3}));
         
         LinkedList<Integer> sortedList = new LinkedList<>();
         sortedList.addAll(Arrays.asList(new Integer[]{2,3,8}));
         assertEquals(sortedList, MergeSortQueue.mergeSort(unSortedList, (c1,c2)->Integer.compare(c1, c2)));//.stream().forEach(System.out::println);
    }
    
    
    class ComparatorInt implements Comparator<Integer>{

        @Override
        public int compare(Integer t, Integer t1) {
            return Integer.compare(t, t1);
        }
    
    }
}
