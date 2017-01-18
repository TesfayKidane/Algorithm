/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.stack.reversearray;

import datastructure.stack.ArrayStack;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author Tesfay
 */
public class StackReverseArray{
    
    public static <E> void stackReverseArray(E[] e){
       Stack<E> buffer = new ArrayStack<>(e.length);
       
       for(int i = 0; i < e.length ; i++){
           buffer.push(e[i]);
       }
        
       for(int j = 0; j < e.length; j++){
           e[j] = buffer.pop();
       }
    }
    
    public static <E> void reverseArrayIterative(E[] e){
        int low = 0 ; 
        int high = e.length - 1; 
        
        while(low < high){
            E temp = e[low];
            e[low++] = e[high];
            e[high--] = temp;
        }
    }
    
    public static <E> void reverseArrayIterativeOther(E[] e){
        int low = 0 ; 
        int high = e.length - 1; 
        
        for(int i = 0 ; i < high/2 ; i ++){
            Integer temp = (Integer)e[i];
            e[i] = e[high - i];
            e[high - i] = (E)temp;
        }
    }
    
    public static void main(String[] args){
        Integer[] ints = new Integer[]{1,2,3,4,5};
        stackReverseArray(ints);
        Arrays.asList(ints).stream().forEach((t) -> System.out.print(t+", "));
        
        System.out.println("\n");
        
        reverseArrayIterative(ints);
        Arrays.asList(ints).stream().forEach((t) -> System.out.print(t+", "));
        
        System.out.println("\n");
        
        reverseArrayIterativeOther(ints);
        Arrays.asList(ints).stream().forEach((t) -> System.out.print(t+", "));
        
        System.out.println("\n");
        // now use really long array to measure time complexity
        ints  = myutils.Database.getIntArrayData(10000000);
        long start = System.nanoTime();
        stackReverseArray(ints);
        System.out.println("stackReverseArray compute time : " + (System.nanoTime() - start));
        
        start = System.nanoTime();
        reverseArrayIterative(ints);
        System.out.println("reverseArrayIterative compute time : "+(System.nanoTime() - start));
        
        start = System.nanoTime();
        reverseArrayIterativeOther(ints);
        System.out.println("reverseArrayIterativeOther compute time : "+(System.nanoTime() - start));
    }
}
