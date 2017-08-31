/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.addtwonumbers;

/**
 *
 * @author Tesfay
 */
public class AddTwoNumbers {

    private boolean nodeContainsPositiveValues(ListNode l1) {
        if(l1 == null)
            return false;
        
        ListNode current = l1;
        while(current != null){
            if(current.value < 0)
                return false; 
            current = current.next;
        }
        
        return true;
    }

    class ListNode{
        ListNode next;
        int value; 
        public ListNode(int x)
        {
            value = x; 
        }
    }


   public int addTwoNumbers(ListNode l1, ListNode l2) {
       
       if(!nodeContainsPositiveValues(l1)  || !nodeContainsPositiveValues(l2))
       {
           return 0;
       }  
       
       return 1;
    }


}