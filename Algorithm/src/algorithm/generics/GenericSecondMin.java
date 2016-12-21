/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.generics;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Tesfay
 */
public class GenericSecondMin {
    public static  <T extends Comparable<? super T>> T secondSmallest(List<T> list){
        if(list.size() < 2) return null;
        
        T firstMin = list.get(0);
        T secondMin = list.get(1);
        
        for(T t : list)
        {
            if(t.compareTo(firstMin) < 0){
                secondMin = firstMin;
                firstMin = t ;
            }
            else if(t.compareTo(secondMin) < 0 && t != firstMin )
            {
                secondMin = t;
            }
        }
        return secondMin;        
    }
    
    public static void main(String[] args){
        List<Integer> ints = Arrays.asList(1,2,3,4,5);
        System.out.println("2nd Smallest Element : " + secondSmallest(ints));
        
        List<String> strs = Arrays.asList("abcd", "dcde", "dcaes", "eeee");
        System.out.println("2nd Smallest Element : " + secondSmallest(strs));
    }
}
