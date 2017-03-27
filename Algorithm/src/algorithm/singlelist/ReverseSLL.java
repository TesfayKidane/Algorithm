package algorithm.singlelist;

public class ReverseSLL {

	public static Node reverseSLL(Node first) {
		ArrayStack<Node> arrayStack = new ArrayStack<>();
		// push the nodes to stack
		while (first.getNext() != null) {
			arrayStack.push(first);
			first = first.getNext();
		}
		// push the last one
		arrayStack.push(first);

		// now pop the nodes from the stack, which gives you the reverse of the
		// input linked list
		Node header = arrayStack.pop();
		first = header;
		while (!arrayStack.isEmpty()) {

			Node node = arrayStack.pop();
			first.setNext(node);
			first = node;
		}

		// set the next of the last node to null
		first.setNext(null);

		return header;
	}
        
        public static Node reverseSSLBetter(Node first){
        
            // [a, b, c, d] => [b, a, c, d] => [c, b, a, d] => [d, c, b, a]
            Node head = first; 
            
            while(first.getNext() != null){                
                Node newHead = first.getNext();                
                first.setNext(newHead.getNext());
                newHead.setNext(head);
                head = newHead;                
            }
            
            return head;            
        }
}
