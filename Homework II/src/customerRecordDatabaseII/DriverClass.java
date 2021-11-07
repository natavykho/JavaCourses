
package customerRecordDatabaseII;

import java.io.IOException;
import java.util.Scanner;

public class DriverClass {
	
	public static void main(String [] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		
		CustomerList db = new CustomerList();
		db.getCustomerList("database.txt");
		
		while (true) {
			
		System.out.println("menu: ");
		System.out.println("a. add record");
		System.out.println("f. find record");
		System.out.println("d. delete record");
		System.out.println("q. quit and save");
		System.out.println();
		
			String command = scan.next();
			if (command.equalsIgnoreCase("f")) {
				System.out.println("please enter customer number: ");
				int num = scan.nextInt();
				CustomerRecord record = db.getCustomerRecord(num);
				System.out.println(record);
				
			
			} else if (command.equalsIgnoreCase("a")) {
				System.out.println("enter customer number: ");
				int n = scan.nextInt();
				System.out.println("enter customer first name: ");
				String fn = scan.next();
				System.out.println("enter customer last name: ");
				String ln = scan.next();
				System.out.println("enter custumer balance: ");
				double b = scan.nextDouble();
				CustomerRecord record = new CustomerRecord(n, fn, ln, b);
				db.enterCustomerRecord(record);
				
				
				
			} else if (command.equalsIgnoreCase("d")) {
				System.out.println("enter customer number: ");
				int num = scan.nextInt();
				db.deleteCustomerRecord(num);
				
			} else if (command.equalsIgnoreCase("q")) {
				db.saveCustomerList("newdatabase.txt");
				return;
			
			} else {
				System.out.println("please enter f, a, d, or q. ");
			}
			
			
		
		
		
		}
		
		
			
	}

}
