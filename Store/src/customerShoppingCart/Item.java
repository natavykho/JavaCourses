package customerShoppingCart;

public class Item {
	
	private String name; 
	private String description;
	private double price;
	
	public Item(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public String getname() {
		return name;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public String getdescription() {
		return description;
	}
	
	public void setdescription(String description) {
		this.description = description;
	}

	public double getprice() {
		return price;
	}
	
	public void setprice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return name;

	}
	
}
