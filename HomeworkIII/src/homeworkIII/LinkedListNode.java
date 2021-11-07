package homeworkIII;

public class LinkedListNode {
	
	private Object data;
	private LinkedListNode next;
	
	public LinkedListNode(Object initialData) {
		data = initialData;
	}
	
	public LinkedListNode getNext() {
		return next;
	}
	
	public void setNext(LinkedListNode newNext) {
		next = newNext;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object newData) {
		data = newData;
	}

}
