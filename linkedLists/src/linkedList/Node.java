package linkedList;

public class Node {
	
	//data component
	public String data;
	//referance to next node
	public Node next;
	
	
	public Node (String s, Node n) {
		this.data = s;
		this.next = n;
	}
	
	//this Node is a referance to next node
	//it will return the referance to next node
	public Node getNext() {
		return next;
	}

	//this sets reference for next node
	public void setNext(Node n) {
		n = next;
	}
	
	//this will return the data component of node
	public String getData() {
		return data;
	}
	
	//this will set data component of node
	public void setData(String s) {
		s = data;
	}

	
	

}
