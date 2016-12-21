/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.generics;

/**
 *
 * @author Tesfay
 */
public class GenericCounter {
    
    public static <T> int countGreater(T[] ary, T elem){
        int count = 0 ;
        for(T e : ary){
            //if(e > elem) // Compile error :  does not compile because the greater than operator (>) applies only to primitive types such as short, int, double, long, float, byte, and char. You cannot use the > operator to compare objects. 
                count++;
        }
        return count;
    }

    public static <T extends Comparable<T>> int countGreate(T[] ary, T elem){
        int count = 0 ; 
        for(T e : ary){
            if(e.compareTo(elem) > 0) count++;
        }
        return count;
    }
}
