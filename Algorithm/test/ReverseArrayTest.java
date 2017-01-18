/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import algorithm.recursion.ReverseArray;
import algorithm.stack.reversearray.StackReverseArray;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import myutils.Database;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tesfay
 */
public class ReverseArrayTest {
    
    public ReverseArrayTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void recursiveReverseArrayTest(){
        int arraySize = 1000000;
        Integer[] intsActual = Database.getIntArrayData(arraySize);
        Integer[] intsExpected = new Integer[arraySize];
        long start = System.currentTimeMillis();
        //ReverseArray.recursiveReverseArray(intsActual, 0, arraySize-1);
        System.out.println("Time Elapsed - recursiveReverseArray  : " + (System.currentTimeMillis() - start));
        //assertArrayEquals(IntStream.range(0, arraySize).map(i -> arraySize - i + 0 - 1).boxed().collect(Collectors.toList()).toArray(intsExpected), intsActual);
        //Arrays.asList(intsActual).stream().forEach(System.out::println);
        
        start = System.currentTimeMillis();
        StackReverseArray.stackReverseArray(intsActual);
        System.out.println("Time Elapsed - stackReverseArray  : " + (System.currentTimeMillis() - start));
        assertArrayEquals(IntStream.range(0, arraySize).boxed().collect(Collectors.toList()).toArray(intsExpected), intsActual);
    }
    
}
