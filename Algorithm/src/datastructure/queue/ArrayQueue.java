/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.queue;

import sun.misc.Queue;

/**
 *
 * @author Tesfay
 */
public class ArrayQueue<E> extends Queue<E> {
    
    private static final int CAPACITY = 1000;
    private E[] data; // array to hold the elements
    private int f = 0 ; // index of the front element
    private int sz = 0 ;   // number of elements in the queue
    
    public ArrayQueue(){
        this(CAPACITY);
    }
    
    public ArrayQueue(int capacity){
        data = (E[])new Object[capacity];
    }
    
    public int size(){
        return sz;
    }
    
    public boolean isEmpty(){
        return (sz == 0);
    }
    
    public void enqueue(E e) throws IllegalStateException{
        if(sz == data.length) throw new IllegalStateException("Queue is full");
        int index = (f + sz) % data.length;  // use circular array
        data[index] = e;
        sz++;        
    }
    public E first(){
        if(isEmpty()) return null;
        return data[f];
    }
    public E dequeue(){
    
        if(isEmpty()) return null;
        E answer  = data[f];
        data[f] = null;
        f = (f+1)%data.length;
        sz--;
        return answer;
    }
    
    
}
