/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Tesfay
 */
public class LinkedStack<E> extends Stack<E>{
    
    List<E> buffer = new ArrayList<>();
    
    public LinkedStack(){
    }
    
    public E push(E e){
        buffer.add(e);
        return e;
    }
    
    public synchronized E pop(){
       if(isEmpty()) return null;
       int last = buffer.size() -1 ;
       return buffer.remove(last);
    }
    
    public boolean isEmpty(){
        return buffer.isEmpty();
    }
    
    public int size(){
        return  buffer.size();
    }
    
    public E top(){
        if(isEmpty()) return null;
        return buffer.get(buffer.size() - 1);
    }
}
