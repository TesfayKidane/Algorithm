/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import algorithm.lfucache.LFUCache;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tesfay
 */
public class TestLFUCache {

    public TestLFUCache() {
    }

    @Test
    public void testLFUCache0() {
        LFUCache cache = new LFUCache(2);
        cache.set(1, 1);
        cache.set(2, 2);
        assertEquals(1, cache.get(1));

        cache.set(3, 3);
        assertEquals(-1, cache.get(2)); // test 2 is evicted
        assertEquals(3, cache.get(3));

        cache.set(4, 4);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));     
    }

    @Test
    public void testLFUCache1() {
        LFUCache cache3 = new LFUCache(2);
        cache3.set(2, 1);
        cache3.set(1, 1);
        cache3.set(2, 3);
        cache3.set(4, 1);
        assertEquals(-1, cache3.get(1));
        assertEquals(3, cache3.get(2));
    }

    @Test
    public void testLFUCache2() {
        LFUCache cache1 = new LFUCache(0);
        cache1.set(0, 0);
        assertEquals(-1, cache1.get(0));
        
        LFUCache cache2 = new LFUCache(Integer.MIN_VALUE);
        cache2.set(0, 0);
        assertEquals(-1, cache2.get(0));
    }
    @Test
    public void testLFUCache3(){
        LFUCache cache4 = new LFUCache(2);
        cache4.set(2, 1);
        cache4.set(3, 2);
        cache4.get(3);
        cache4.get(2);
        cache4.set(4, 3);
        assertEquals(1, cache4.get(2));
        assertEquals(-1, cache4.get(3));
        assertEquals(3, cache4.get(4));
    }
}
