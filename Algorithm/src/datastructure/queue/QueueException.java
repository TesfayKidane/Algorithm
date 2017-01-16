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
class QueueException extends Exception {
   
    public QueueException(){
    
    }
     public QueueException(String msg){
        super(msg);
    }
      public QueueException( Throwable throwable){
          super(throwable);
    }
    
    
}
