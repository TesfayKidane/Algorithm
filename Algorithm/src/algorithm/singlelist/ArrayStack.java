package algorithm.singlelist;

public class ArrayStack<E> {
	
	private final static int CAPACITY = 1000;
	private int t = -1; 
	private E[] data;
	
	public ArrayStack(){
		this(CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity){
		
		data = (E[])new Object[capacity];
	}
	
	public void push(E e) {
		
		if(size() == data.length) throw new StackOverflowError();
		data[++t] = e;
		
	}
	
	public E pop(){
		if(isEmpty()) throw new Error("Stack is empty");
		E result = data[t];
		data[t] = null;
		t--;
		return result;
	}

	public boolean isEmpty() {
		
		return (t == -1);
	}

	public int size() {
		return t+1;
	}
	
	public E top()
	{
		if(isEmpty()) throw new Error("Stack is empty");
		return data[t];
	}
}
