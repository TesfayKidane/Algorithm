/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import algorithm.sort.quicksort.QuickSort;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tesfay
 */
public class QuickSortTest {
    
    public QuickSortTest() {
    }
    
    @Test
    public void testQuickSort(){
    
         LinkedList<Integer> unSortedList = new LinkedList<>();
         unSortedList.addAll(Arrays.asList(new Integer[]{8,2,3}));
         
         LinkedList<Integer> sortedList = new LinkedList<>();
         sortedList.addAll(Arrays.asList(new Integer[]{2,3,8}));
         assertEquals(sortedList,QuickSort.quickSort(unSortedList, (c1,c2)->Integer.compare(c1, c2)));//.stream().forEach(System.out::println);
    }
}
