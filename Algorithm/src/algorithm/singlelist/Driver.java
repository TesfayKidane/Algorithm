package algorithm.singlelist;

public class Driver {

	public static void main(String[] args) {
		Node header1 = new Node(0);
		Node header = header1;
                Node header2 = header1;
		SingleyLinkedList sll = new SingleyLinkedList(header);
		
		for(int i = 1 ;  i < 10 ; i++){
			Node node = new Node();			
			node.setValue(i);
			
			header.setNext(node);
			header = node; 
		}		
		header.setNext(null);
		
		// traverse the singley linked list.
		System.out.println("Before reversing linked list");
		Node first = sll.getFirst();
		while(first.getNext() != null)
		{
			System.out.println(first.toString());
			first = first.getNext();
		}		
		System.out.println("Node [next value = null , current value=" + first.getValue() + "]");
		
//		System.out.println("After reversing linked list");
//		Node first2 = ReverseSLL.reverseSLL(header1);
//		while(first2.getNext() != null)
//		{
//			System.out.println(first2.toString());
//			first2 = first2.getNext();
//		}		
//		System.out.println("Node [next value = null , current value=" + first2.getValue() + "]");
                
                System.out.println("[Better] After reversing linked list");
		Node first3 = ReverseSLL.reverseSSLBetter(header2);
		while(first3.getNext() != null)
		{
			System.out.println(first3.toString());
			first3 = first3.getNext();
		}		
		System.out.println("Node [next value = null , current value=" + first3.getValue() + "]");
	}

}
	