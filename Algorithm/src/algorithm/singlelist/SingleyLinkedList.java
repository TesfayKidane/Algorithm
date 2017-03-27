package algorithm.singlelist;

import algorithm.singlelist.Node;

public class SingleyLinkedList {

	private Node first;

	public SingleyLinkedList(Node header) {
		this.first = header;
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

}
