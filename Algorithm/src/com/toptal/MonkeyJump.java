/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toptal;

import java.util.HashMap;

/**
 *
 * @author Tesfay
 */
public class MonkeyJump {
    public static int solution(int[] A, int D){
        int jump = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }
        
        for(int i = 0; i < A.length; i++) {
            if(map.containsKey(i)) {
                int pos = map.get(i);
                if(pos <= D)
                    D += D;
                if(D < A.length) {
                    jump = i;
                    break;
                }
            }                
        }
        return jump;
    }
}
