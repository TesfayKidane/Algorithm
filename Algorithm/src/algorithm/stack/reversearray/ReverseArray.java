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
public class ReverseArray{
    
    public static <E> void reverse(E[] e){
       Stack<E> buffer = new ArrayStack<>(e.length);
       
       for(int i = 0; i < e.length ; i++){
           buffer.push(e[i]);
       }
        
       for(int j = 0; j < e.length; j++){
           e[j] = buffer.pop();
       }
    }
    
    public static void main(String[] args){
        Integer[] ints = new Integer[]{1,2,3,4,5};
        reverse(ints);
        Arrays.asList(ints).stream().forEach((t) -> System.out.print(t+", "));
    }
}
