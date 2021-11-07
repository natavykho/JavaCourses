package customerShoppingCart;

//import java.util.Arrays;

public class Cart {
	
Item[] items = new Item[10];
	
	
	public void addItem(Item item) { 
		for (int i = 0; i < items.length; i++) {
			if (items[i] == null) {
				items[i] = item;
				break;
			}
		}
	}
	
	
	public void removeItem(Item name) {
		for(int i = 0; i < items.length; i++) {              
			if(items[i] != null && items[i] == name) {  			  
				items[i] = null;
				break;
			}
		}
	}
	
	
	public void flushCart() {
		items = new Item[10];  
	}
	
	
	public double calculateTotal() {   			   
		double total = 0;                          
		for(int i = 0; i < items.length; i++) {    
			if (items[i] != null) {
				total += items[i].getprice();
			} 
		}
		return total;	
	}
	

//	public String toString() {
//		return Arrays.deepToString(items);       
//	}
	
	
	public String toString() {
		String allItems = "";
		for(int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				allItems += items[i].getname() + ", ";
				
			}
		}
		return allItems;
	}

}
