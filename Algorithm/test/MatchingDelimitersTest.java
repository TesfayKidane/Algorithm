/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import algorithm.stack.matching.MatchingDelimiters;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tesfay
 */
public class MatchingDelimitersTest {
    
    public MatchingDelimitersTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void isMatchedTest(){
        assertTrue(MatchingDelimiters.isMatched("({[]})"));
        assertTrue(MatchingDelimiters.isMatched("(woeiq{afa[sadfa]asfda}werq)"));
        assertFalse(MatchingDelimiters.isMatched("(x+y)*({d - f} / [am - s)"));
    }
}
