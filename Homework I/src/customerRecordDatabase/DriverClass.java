package customerRecordDatabase;

import java.io.IOException;
import java.util.Scanner;

public class DriverClass {

	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		
		// read text file, populate database
		// call getCustomerList
		
		// print menu
		// a. add record
		// f. find record 
		// d. delete record
		// q. quit and save 
		
		CustomerList db = new CustomerList();
		db.getCustomerList("database.txt"); 
		
		
		while(true) {
			
		System.out.println("menu: ");
		System.out.println("a. add record");
		System.out.println("f. find record");
		System.out.println("d. delete record");
		System.out.println("q. quit and save");
		System.out.println();
		
				
		
			String command = scan.next();
			if (command.equalsIgnoreCase("f")) {
				System.out.println("Please enter customer number: ");
				int num = scan.nextInt();
				//if (num == db.getCustomerRecord())
				CustomerRecord record = db.getCustomerRecord(num);
				System.out.println(record);
				System.out.println();
				scan.close();
				
				
			} else if (command.equalsIgnoreCase("a")) {
				System.out.println("enter Customer number: ");
				int n = scan.nextInt();
				System.out.println("Enter Customer First name: ");
				String f = scan.next();
				System.out.println("Enter Customer Last name: ");
				String l = scan.next();
				System.out.println("Enter Customer balance: ");
				Double d = scan.nextDouble();
				CustomerRecord record = new CustomerRecord (n, f, l, d);
				db.enterCustomerRecord(record);
				scan.close();
				
				
			} else if (command.equalsIgnoreCase("d")) {
				System.out.println("Please enter a customer number: ");
				int num = scan.nextInt();
				//CustomerRecord record = db.deleteCustomerRecord(num);
				db.deleteCustomerRecord(num);
				scan.close();
				
				
			} else if (command.equalsIgnoreCase("q")) {
				db.saveCustomerList("newdatabase.txt");
				return;
			} else {
				System.out.println("please enter f, a, d, or q");
			}
			
			
		}
		
	
		
		

		
		
		

		

	}

}
