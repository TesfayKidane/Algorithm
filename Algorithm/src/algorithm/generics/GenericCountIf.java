/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Tesfay
 */
//Write a generic method to count the number of elements in a collection that have a specific property (for example, odd integers, prime numbers, palindromes).
public class GenericCountIf {

    public static <T> int countIf(Collection<T> c, UnaryPredicate<T> up) {
        int count = 0;
        for(T t : c){
            if(up.test(t))
                count++;
        }
        return count;
    }

     public static void main(String[] args) {
        Collection<Integer> ci = Arrays.asList(1, 2, 3, 4);
        int count = GenericCountIf.countIf(ci, new OddNumberUnaryPredicateImpl());
        System.out.println("Number of odd integers = " + count);
        
        List<? super Integer > ints1 = Arrays.asList(12,32,34,3);
        List<Number> nums = Arrays.asList(12,32,34,3);
        List<Integer> ints2 = Arrays.asList(12,32,34,3);
        ints1 = nums;
        ints1 = ints2 ;
        
        List<? extends Integer> ints3 = Arrays.asList(12,32,34,3);
        //ints3 = nums; // Compile error, Number doesn't not extend from Integer
        ints3 = ints2;
    }
     
    public interface UnaryPredicate<T> {

        public boolean test(T t);
    }
    
    public static class OddNumberUnaryPredicateImpl implements UnaryPredicate<Integer>{
        @Override
        public boolean test(Integer t) {
           return t%2 != 0;
        }
    }
}
