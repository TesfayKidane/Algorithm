/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myutils;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Tesfay
 */
public class Database {
    
    public static Integer[] getIntArrayData (int length){
        Integer[] ints = new Integer[length];
        return IntStream.range(0, length).boxed().collect(Collectors.toList()).toArray(ints);
    }
}
