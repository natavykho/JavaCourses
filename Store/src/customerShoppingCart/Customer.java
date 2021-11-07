package customerShoppingCart;

public class Customer {
	
	private String firstName;
	private String lastName;
	private String mailingAddress;
	private Cart cart;	
	
	
	public Customer(String firstName, String lastName, String mailingAddress) {  //constructor does not have a return type, it just builds "this"
		this.firstName = firstName;
		this.lastName = lastName;
		this.mailingAddress = mailingAddress;
		cart = new Cart();
	}
	
	
	public String getfirstName() {
		return firstName;
	}
	
	
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getlastName() {
		return lastName;
	}
	
	
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getmailingAddress() {
		return mailingAddress;
	}
	
	
	public void setmailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
	
	
	public String toString() {
		return firstName + " " + lastName + ", Address: " + mailingAddress;
	}


	public Cart getCart() {
		return cart;
	}

	
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
}
