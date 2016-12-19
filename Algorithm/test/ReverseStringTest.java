/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import algorithm.reversstring.ReverseString;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tesfay
 */
public class ReverseStringTest {
    
    public ReverseStringTest() {
    }
    
    @Test
    public void testReverse()
    {
        assertEquals("dcba", ReverseString.reverse("abcd"));
    }
}
