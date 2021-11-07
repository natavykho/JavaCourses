package homeworkIII;

public class ObjectStack extends LinkedList implements Stack{
	
	private int size;
	
	public ObjectStack() {
		//call constructore from LinkedList
		super();
	}
	
	
	public int size() {
		return size;
	}
	
	
	public boolean isEmpty() {
		if (getHead() == null) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public Object top() throws EmptyStackException {  //try and catch 
		if (isEmpty()) {
			throw new EmptyStackException("stack empty");
		} else {
			return getHead().getData();
		}
		//LinkedListNode temp = new LinkedListNode(getHead());
		//super.removeFront();
		//return temp;
	}
	
	
	public Object pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Pop-stack empty");
		} else  {
			size--;
			Object item = removeFront();
			return item;
		}
	}
	

	
	public void push(Object item) {
		super.insertFront(item);
		size++;
		
	}
	

	
		
		
	

}
