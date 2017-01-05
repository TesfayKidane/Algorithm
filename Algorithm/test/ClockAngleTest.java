/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import algorithm.clockangle.HourMinuteAngel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tesfay
 */
public class ClockAngleTest {
    
    public ClockAngleTest() {
    }
    
    private static HourMinuteAngel hourMinuteAngel;
            
    @BeforeClass
    public static void setUpClass() {
        hourMinuteAngel = new HourMinuteAngel();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testHourMinuteAngle(){
        assertEquals(165, hourMinuteAngel.hourAndMinuteAngle(12.0, 30.0));
        assertEquals(75, hourMinuteAngel.hourAndMinuteAngle(3.0, 30.0));
    }
    
}
