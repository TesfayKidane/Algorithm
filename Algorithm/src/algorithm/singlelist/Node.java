package algorithm.singlelist;

public class Node {

	private Node next;
	private Integer value;

	public Node(Integer value) {
		this.value = value;
	}

	public Node() {
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [next value =" + getNext().getValue() + ", current value=" + value + "]";
	}	
}