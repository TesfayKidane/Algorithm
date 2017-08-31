/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.lfucache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Tesfay
 */
public class LFUCache {

    private long currentTime = 0 ;
    private long getCurrentTime() {
        return ++currentTime;
    }
    class CacheEntry
    {
        private int data;
        private int frequency; 
        private long lastUseMS; 

        public long getLastUseMS() {
            return lastUseMS;
        }

        public void setLastUseMS(long lastUseMS) {
            this.lastUseMS = lastUseMS;
        }
        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        public CacheEntry() {
        }
    }
    
    LinkedHashMap<Integer, CacheEntry> cacheMap = new LinkedHashMap<>();
    
    private int capacity = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    } 
  
    
    public int get(int key) {
        if(cacheMap.containsKey(key))
        {
            CacheEntry cacheEntry = cacheMap.get(key);
            cacheEntry.setFrequency(cacheEntry.getFrequency()+1);
            cacheEntry.setLastUseMS(getCurrentTime());
            cacheMap.put(key, cacheEntry);
            return cacheEntry.data;
        }
        return -1;
    }
    
    public void set(int key, int value) {
 
        if (capacity <= 0) {
            return;
        }
       
        if(!isCacheFull())
        {
            CacheEntry cacheEntry = new CacheEntry();   
            cacheEntry.setLastUseMS(getCurrentTime());
            cacheEntry.setData(value); 
            if(cacheMap.containsKey(key))
            { 
                cacheEntry.setFrequency(cacheMap.get(key).getFrequency()+1);
            }
            else
            {
                cacheEntry.setFrequency(0);
            }
            cacheMap.put(key, cacheEntry);
        }
        else
        {
           CacheEntry cacheEntry;
           if(cacheMap.containsKey(key))
            { 
                // if the key existes in the map, then we are updating the value, therefore increment the frequency and lastuse
                cacheEntry = cacheMap.get(key);
                cacheEntry.setFrequency(cacheEntry.getFrequency()+1);
                cacheEntry.setLastUseMS(getCurrentTime());
                cacheEntry.setData(value); 
            }
            else
            {
                int keyToBeRomved = getLFUEntry();
                cacheMap.remove(keyToBeRomved);                
                cacheEntry = new CacheEntry();         
                cacheEntry.setLastUseMS(getCurrentTime());
                cacheEntry.setData(value); 
                cacheEntry.setFrequency(0);
            }
            cacheMap.put(key, cacheEntry);             
        }
    }
    
     private boolean isCacheFull() {
       if(cacheMap.size() == capacity)
           return true;
       return false;          
    }
    
      private int getLFUEntry() {
         
        int key = 0 ;
        int min = Integer.MAX_VALUE;
        
        for(Map.Entry<Integer, CacheEntry> entry : cacheMap.entrySet())
        {
            if(min > entry.getValue().getFrequency()){
                min = entry.getValue().getFrequency();
                key = entry.getKey();
            }
            else if(min == entry.getValue().getFrequency())
            {
                if(cacheMap.get(key).getLastUseMS() > entry.getValue().getLastUseMS())
                {
                    min = entry.getValue().getFrequency();
                    key = entry.getKey();
                }
            }
        }
        return key;
    }  
}
