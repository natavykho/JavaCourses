package customerRecordDatabase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CustomerList {
	
	
	// instance variable declaration 
	// database: array of customerRecord (array of objects)
	private CustomerRecord[] data;
	
	
	// numRecords: how many records in database
	private int numRecords;
	
	
	// name: customerList
	// behavior: construct default CustomerList object
	// parameter: name
	// return: none
	// API
	public CustomerList() {
		//create array of CustomerRecord
		data = new CustomerRecord[100];
		numRecords = 0;
	}
	
	
	// name: getCustomerList
	// behavior: read text file, populate database
	// parameter: fileName (String)
	// return: none
	public void getCustomerList(String fileName)  throws IOException {		
		// create scanner for the file 
		Scanner scan = new Scanner(new File(fileName));		
		// read textFile, line by line: 
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
	
	
	
	// name: getCustomerRecord
	// behavior: find customer record given customer number
	// parameter: customer number (int)
	// return: CustomerRecord
	public CustomerRecord getCustomerRecord(int customerNumber) {
		for(int i = 0; i < numRecords; i++) {
			if(data[i].getCustomerNumber() == customerNumber); {
				//data[i] is an object
				//so a referance to each record
				return data[i];
			}
		}
		//if nothing to be found:
		return null;
	}
	

	// name: saveCustomerNumber
	// behavior: save updated info into textfile
	// parameter: fileName (String)
	// return: none
	public void saveCustomerList(String fileName) throws IOException {		
		PrintWriter out = new PrintWriter(new FileWriter(fileName));
		for (int i = 0; i < numRecords; i++) {
			//output one record per line 
			out.println(data[i]);
		}
		out.close();
	}			
	

	// name: enterCustomerRecord	
	// behavior: add a new record into database
	// parameter: customerRecord
	// return: none
	public void enterCustomerRecord(CustomerRecord record) {
		data[numRecords] = record;
		numRecords += 1;  //not numRecords++;					
	}
	
	
	// name: deleteCustomerRecord
	// behavior: remove customer record from data base given its customer number
	// parameter: customer number (int)
	// return: none
	public void deleteCustomerRecord(int customerNumber) {
		 
		for (int i = 0; i < numRecords; i++) {
			if (data[i].getCustomerNumber() == customerNumber) {
				data[i] = data[numRecords - 1];
				numRecords -= 1;
				return;  //why return???
			}
		}
	}
	
	

}
