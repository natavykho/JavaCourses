package linkedList;

public class LinkedList {
	
	//head is reference to first node
	public Node head;
	
	//list is empty
	public LinkedList() {
		head = null;
	}
	
	//insert a node at the front
	public void insert(Node v) {
		//check whether list is empty
		if (head == null) {
			head = v;
		} else {
			//setting v's next node to first node
			v.setNext(head);
			head = v;
		}
		
	}
	//everything is a reference
	//everything is object assignment (reference)
	
	
	public void deleteFirstNode() {
		if (head == null) {
			System.out.println("error: list is empty");
		} else {
			Node current = head;
			head = head.getNext();
			current.setNext(null);
		}
	}
	
	
	//delete any node
	public void removeNode(String n) {
		Node current = head;
		Node previous = null;
		while (current != null && current.getData() != n) {
			previous = current;
			current = current.getNext();
		}
		if (current == null) {
			System.out.println("error: list is empty");
		} else if (previous == null) {
			current.setNext(null);
		} else {
			previous.setNext(current.getNext()); 
			current.setNext(null);
		}
				
	}	
	
	public String search(String str) {
		Node current = head;
		while (current != null) {
			if (current.getData().contentEquals(str)) {
				return current.getData();
			}
			current = current.getNext();
			
			
		}
		return null;
	}

	
	//search a node
//	public Data search(target) {
//		//will refer to first node
//		Node current = head;
//		// you didn't reach end of list
//		while (current != null) {$
//			if (current.getData(target)) {
//				return current.getData();
//			}
//			//move current to next mode
//			current = current.getNext();
//		}
//		return null;
//	}
	
	
	
	public void insertAtEnd( Node v) {
		Node cur = head;
		//cur.setNext(head);
		if (head == null) {
			head = v;
		} 
		while (cur.getNext() != null) {
			cur = cur.getNext();
		}	
		if (cur.getNext() == null) {
			cur.setNext(v);
		}
	}

}
