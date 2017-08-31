/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import algorithm.twosum.TwoSum;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tesfay
 */
public class TestTwoSum {
    
    
    public TestTwoSum() {
    }
    
    @Test
    public void testTwoSum()
    {
        TwoSum twoSum = new TwoSum();
        assertArrayEquals(new int[]{0,1}, twoSum.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(null, twoSum.twoSum(new int[]{2, 7, 11, 15}, 1));
    }
}
