
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.queue;

/**
 *
 * @author Tesfay
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import sun.misc.Queue;

/**
 *
 * @author Tesfay
 */
public class ArrayQueue2 {
    
  private static int array[] = new int[2];
  private  static int front = -1;
  static int rear = 0;
    

    public static int size(){
       if(rear == 0){
         return 0;
       }
       
       if(rear >= array.length)
           rear = array.length - 1;
      return rear - front;
    }
    public static int resize(){
        int temp[] = new int [array.length * 2  + 1];
        for(int i =  0; i< array.length; i++){
           temp[i] = array[i];
        }
        array = temp;
        return array.length;        
        
    }
    
    public static boolean isEmpty(){
      return (size() == 0);
    }
    
    public static void enqueue(int num){
        if(array.length == size()){
            resize();
        }
        array[rear] = num;
       
        System.out.println("we pushed " + array[rear]);
        rear++;
    }
  
    public static int dequeue() throws QueueException{
        if(isEmpty()){
            throw new QueueException("queue is empty");
        }
        front++;
        int n = array[front];
        array[front] = -1;
        System.out.println("we dequeued " + n);
        return n;
    }
    public static void main(String args[]){
        Queue queueone = new Queue();
        for(int i = 0; i<4; i++){
            enqueue(i);
        }
        try {
            for(int i = 0; i<5; i++){
            dequeue();
            }
        } catch(QueueException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    
}

