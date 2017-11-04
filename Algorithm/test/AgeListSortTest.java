/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import algorithm.sort.sortagelist.AgeListSort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Tesfay
 */
public class AgeListSortTest {
    public static List<Integer> ages ;
    public static final int MAXLISTSIZE = 10000000;
    public static AgeListSort ageListSort;
    public AgeListSortTest() {
    }
    
    @BeforeClass
    public static void setUpClass(){
        
        ages = new ArrayList<>();
        for(int i = 0 ; i < MAXLISTSIZE; i = i+130){
            List<Integer> randomAges = IntStream.rangeClosed(0, 130).boxed().collect(Collectors.toList());
            ages.addAll(randomAges);
            if(ages.size() > MAXLISTSIZE)
            {
                ages.subList(0, MAXLISTSIZE);
                break;
            }
        }
        
        ageListSort = new AgeListSort();
    } 
    
    
    @Test
    public void testAgeListSort(){
        List<Integer> expectedSortedAges = new ArrayList<>(ages);
        Collections.sort(expectedSortedAges);
        List<Integer> actualSotedAges = ageListSort.sortAgeList(ages);
        assertArrayEquals(expectedSortedAges.toArray(), actualSotedAges.toArray());
    }
    
    @Test
    public void testAgeListSort2(){
        List<Integer> expectedSortedAges = new ArrayList<>(ages);
        Collections.sort(expectedSortedAges);
        
        List<Integer> actualSotedAges = ageListSort.sortAgeList2(ages);
        assertArrayEquals(expectedSortedAges.toArray(), actualSotedAges.toArray()); 
    }
    
    @Test
    public void testAgeListSort3(){
        List<Integer> expectedSortedAges = new ArrayList<>(ages);
        Collections.sort(expectedSortedAges);
        List<Integer> actualSotedAges = ageListSort.sortAgeList3(ages);
        assertArrayEquals(expectedSortedAges.toArray(), actualSotedAges.toArray()); 
    }
    
     @Test
    public void testAgeListSort4(){
        List<Integer> expectedSortedAges = new ArrayList<>(ages);
        Collections.sort(expectedSortedAges);
        List<Integer> actualSotedAges = ageListSort.sortAgeList4(ages);
        assertArrayEquals(expectedSortedAges.toArray(), actualSotedAges.toArray()); 
    }
}
