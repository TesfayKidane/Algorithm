/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.generics;

import java.util.List;

/**
 *
 * @author Tesfay
 */
public class GenericMax{
    
    public static <T extends Comparable<T>> T max(T a, T b){
        if(a == null)
        {
            if ( b == null) 
                return a;
            else
                return b;
        }
        if(b == null)
            return a;
        
           return a.compareTo(b) > 1 ? a : b;
    }
    
    // Write a generic method to find the maximal element in the range [begin, end) of a list.
    
    public static <T extends Object & Comparable<? super T>> T max(List<? extends T> list, int begin, int end){
    
        T max = list.get(begin);
        for(++begin; begin < end; ++begin)
        {
            if(max.compareTo(list.get(begin)) < 0)
                max = list.get(begin);
        }
        return max;
    }
}
