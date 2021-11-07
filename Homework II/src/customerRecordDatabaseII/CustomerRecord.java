package customerRecordDatabaseII;

public class CustomerRecord {
	
	private int customerNumber;
	private String firstName;
	private String lastName;
	private double balance;
	
	
	

	public CustomerRecord(int customerNumber, String firstName, String lastName, double balance) {
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		
	}



	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String toString() {
		return  customerNumber + " " + 
	firstName + " " + lastName + " " + balance;
				
	}

}
