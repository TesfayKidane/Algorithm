/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.ctci;

import algorithm.ctci.library.LinkedListNode;

/**
 *
 * @author Tesfay
 */
public class SumLinkedList {
    
    public static LinkedListNode sumList(LinkedListNode head1, LinkedListNode head2){
        LinkedListNode resultHead = new LinkedListNode();
        LinkedListNode resultEnd = resultHead;
        int carry = 0 ;
        while(head1 != null || head2 != null){
           int sum =  carry;
           if(head1 != null) sum += head1.data;
           if(head2 != null) sum += head2.data;
           
           resultEnd.data = sum % 10;
           carry = sum > 9 ? 1 : 0;
           
           resultEnd.next = (head1.next != null || head2.next != null)? new LinkedListNode() : null;
           
           if(resultEnd.next != null){
               LinkedListNode nextResultEnd = resultHead.next;
               resultEnd = nextResultEnd;
           }
           LinkedListNode next1 = head1.next;
           LinkedListNode next2 = head2.next;
           head1 = next1;
           head2 = next2;        
        }
        
        return resultHead;
    }
}
