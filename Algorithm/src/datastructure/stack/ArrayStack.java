/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.stack;

import java.util.Stack;

/**
 *
 * @author Tesfay
 */
public class ArrayStack<E> extends Stack<E>{
    public static final int CAPACITY = 1000;
    public static int t = -1;
    public E[] data; 
    public ArrayStack(){
        this(CAPACITY);
    }
    public ArrayStack(int capacity){
        data = (E[])new Object[capacity];
    }
    
    public E push(E e) throws StackOverflowError{
       if(data.length == size()) throw new StackOverflowError();
       data[++t] = e;
       return e;
    }
    
    public synchronized E pop(){
        if(isEmpty()) return null;
        E result = data[t];
        data[t] = null;   // dereference to help the java garbage collector find unused memory
        t--;
        return result;
    }
    
    public boolean isEmpty(){
       return (t == -1 ) ;
    }
    
    public int size(){
        return t+1;
    }
    
    public E top(){
        if(isEmpty()) return null;
        return data[t];
    }
}
