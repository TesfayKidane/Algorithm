/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import algorithm.recursion.BinarySearch;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tesfay
 */
public class BinarySearchTest {
    
    public BinarySearchTest() {
    }
    
    private static Integer[] ints = new Integer[10000];
    @BeforeClass
    public static void setUpClass() {
       List<Integer> list = IntStream.rangeClosed(0, 10000).boxed().collect(Collectors.toList());
       list.toArray(ints);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void binarySearchTest(){
    
        assertTrue(BinarySearch.binarySearchRecursive(ints, 9999, 0, 10000));
    }
}
