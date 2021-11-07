package customerRecordDatabaseII;

public class Node {
	
	public CustomerRecord data;
	public Node next;

	
	public Node(CustomerRecord r, Node n) {
		data = r;
		this.next = n;
	}
	public Node(CustomerRecord record) {
		data = record;
		next = null;
	}
	
	
	public Node getNext() {
		return next;
	}
	public CustomerRecord getData() {
		return data;
	}
	
	public void setNext( Node n) {
		next = n;
	}
	public void setData(CustomerRecord r) {
		data = r;
	}
	

}
