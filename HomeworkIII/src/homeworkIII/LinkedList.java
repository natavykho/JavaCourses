package homeworkIII;

public class LinkedList {
	
	private LinkedListNode head;
	
	
	public LinkedList() {
		head = null;
	}
	
	
	public void insertFront(Object item) {
		LinkedListNode temp = new LinkedListNode(item);
		if (head == null) 
			head = temp;
		else {
			temp.setNext(head);
			head = temp;
		}
	}
	
	
	public Object removeFront() {   
		Object item = head.getData();
		head = head.getNext();
		return item;
	}
	
	
	public LinkedListNode getHead() {
		return head;
	}
	
	
	public void setHead(LinkedListNode node) {
		head = node;
	}
	
	

}
