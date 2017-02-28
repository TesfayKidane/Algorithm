/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    
     public static List<String> getStringArrayData (int total, int stringLength){
         List<String> randomListOfStrings = new ArrayList<>();
         for(int i = 0 ;  i < total; i++){
             randomListOfStrings.add(RandomString.randomString(stringLength));
         }
         return randomListOfStrings;
    }
}
