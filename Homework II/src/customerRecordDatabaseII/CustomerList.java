package customerRecordDatabaseII;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class CustomerList {
	
	private Node head;
	
	public CustomerList() {
		head = null;
	}
	
	
	public void getCustomerList(String filename) throws IOException{
		Scanner scan = new Scanner(new File(filename));
		while (scan.hasNext()) {
			
			int n = scan.nextInt();
			String f = scan.next();
			String l = scan.next();
			double d = scan.nextDouble();		
		CustomerRecord record = new CustomerRecord(n, f, l, d);
		enterCustomerRecord(record);		
		}	
		scan.close();
	}
	
	
	
	public CustomerRecord getCustomerRecord(int customerNumber) {
		Node current = head;
		while (current != null) {
			//while you have not reached end of list
			if (current.getData().getCustomerNumber() == customerNumber) {
				return current.getData();
			}
			current = current.getNext(); //i didnt have this
		}
		return null;
	}
	
	
	
	public void enterCustomerRecord(CustomerRecord record) {
		Node temp = new Node(record);
		if (head == null) {
			head = temp;
		} else {
			temp.setNext(head);
			head = temp;
			
		}
	}
	
	
	public void deleteCustomerRecord( int customerNumber) {
		Node current = head;
		Node previous = null;
		while (current != null && current.getData().getCustomerNumber() != customerNumber) {
			previous = current;
			current = current.getNext();
		}
		if (current == null) {
			System.out.println("Error: CustomerRecord not found");
		}
		else if (previous == null) {
			//then CustomerRecord is first node
			head = head.getNext();
			current.setNext(null);
		}
		else 
			previous.setNext(current.getNext());
			current.setNext(null);
	}
	
	
	
	public void saveCustomerList(String filename) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(filename));
		Node current = head;
		while(current != null) {
			out.println(current.getData());
			current = current.getNext();
		}
		out.close();
	}
	
		

}
