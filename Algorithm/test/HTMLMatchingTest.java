/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import algorithm.stack.matching.HTMLMatching;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tesfay
 */
public class HTMLMatchingTest {
    
    public HTMLMatchingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void isHTMLMatchedTest(){
        String html = "<html>"
                + "<body>"
                + "<p> This is test string </p>"
                + "<h1> <i> Italic text </i> </h1>"
                + "</body>"
                + "</html>";
        
        assertTrue(HTMLMatching.isHTMLMatched(html));
    }
}
