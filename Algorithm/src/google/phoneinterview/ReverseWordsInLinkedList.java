/*
 * How do you reverse the words in a linked list? 
 * For ex, Convert " H-e-l-l-o- -W-o-r-l-d " (There is a space between the word), into " o-l-l-e-H- -d-l-r-o-W " 
 * Write a Java code to use as less Space Complexity as possible. (So not too many spaces should be used) 
 * Linked List Structure:

    class Node {
            char val;
            Node next;
    }
 */
package google.phoneinterview;

/**
 *
 * @author Tesfay
 */
public class ReverseWordsInLinkedList {
    
    class Node{
        char val;
        Node next;
    }
    
    public static Node reverseEachWordInLL(Node n){
    
        Node curr = n, root = null, tempNext = null, ws = n, space = null, prev = null;
        
        while(curr != null){
            if(curr.val == ' '){
                
               // root of the new linked list should the last char of the first word in the ll
                if(root == null)
                   root = prev; 
                
                if(space != null)
                    space.next = prev;
                
               space = curr; 
               prev = null;
               
               ws.next = curr;
               
               ws = curr.next;
               curr = curr.next;         
               continue;
            }
            tempNext = curr.next;
            curr.next = prev; 
            
            if(tempNext == null && space != null)
                space.next = curr;
            
            if(prev == null)
            {
                ws = curr;
            }
            prev = curr;
            curr = tempNext;
            
        }
        
        return root;
    }
    
    public static void main(String[] args){
        Node root = new ReverseWordsInLinkedList().new Node();
        root.val = 'H';
        
        Node two = new ReverseWordsInLinkedList().new Node();
        two.val = 'E';
        root.next = two;
        
        Node three = new ReverseWordsInLinkedList().new Node();
        three.val = ' ';
        two.next = three;
        
        Node four = new ReverseWordsInLinkedList().new Node();
        four.val = 'S';
        three.next = four;
        
        Node five = new ReverseWordsInLinkedList().new Node();
        five.val = 'H';
        four.next = five;
        
        Node six = new ReverseWordsInLinkedList().new Node();
        six.val = 'E';
        five.next = six;
        //five.next = six;
        
        Node seven = new ReverseWordsInLinkedList().new Node();
        seven.val = ' ';
        six.next = seven;
        
        Node eight = new ReverseWordsInLinkedList().new Node();
        eight.val = '1';
        seven.next = eight;
        
        eight.next = null;
        
        Node result = reverseEachWordInLL(root);
        
        while(result != null)
        {
            System.out.println(result.val);
            result = result.next;
        }
        
    }
}

