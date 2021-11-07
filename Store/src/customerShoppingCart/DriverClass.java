package customerShoppingCart;

import java.util.Scanner;

public class DriverClass {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Customer customer = new Customer("Nataliya", "Vykhovanets", "123 Street Rd.");
		
//		System.out.print(customer.getfirstName() + " ");
//		System.out.println(customer.getlastName());
//		System.out.println(customer.getmailingAddress());
//		System.out.println("");

		
		Item item1 = new Item( "Java Programming From the Beginning", "Computer Science Textbook", 50.00);
		Item item2 = new Item( "The 5-Minute Linguist", "Linguistics textbook", 15.00);
		Item item3 = new Item( "Calculus", "Calculus textbook", 100.00);	
		
		
		System.out.println("Menu:");
		System.out.println("1: view profile");
		System.out.println("2: list items");
		System.out.println("3: add item to cart");
		System.out.println("4: remove item from cart");
		System.out.println("5: display cart");
		System.out.println("6: calculate total");
		System.out.println("7: flush cart");
		System.out.println("8: exit");
		System.out.println("");
			
		
		try {
			commandLoop:
			while(true) {
				System.out.println("Enter an Option: ");
				int input = scanner.nextInt();
				switch (input) {
				case 1: 
					System.out.println(customer);
					System.out.println("");
					break;
				case 2: 
					System.out.println("");
					System.out.println("Item 1 :" + item1.getname());
					System.out.println(item1.getdescription());
					System.out.println("$" + item1.getprice() + "0");
					System.out.println("");
					System.out.println("Item 2: " + item2.getname());
					System.out.println(item2.getdescription());
					System.out.println("$" + item2.getprice() + "0");
					System.out.println("");
					System.out.println("Item 3: " + item3.getname());
					System.out.println(item3.getdescription());
					System.out.println("$" + item3.getprice() + "0");
					System.out.println("");
					break;
				case 3: 
					System.out.println("Choose item to add to cart: ");
					int input2 = scanner.nextInt();
					if (input2 == 1) {
						customer.getCart().addItem(item1);
						System.out.println("Item 1 has been added to cart");
					}
					if (input2 == 2) {
						customer.getCart().addItem(item2);
						System.out.println("Item 2 has been added to cart");
					}
					if (input2 == 3) {
						customer.getCart().addItem(item3);
						System.out.println("Item 3 has been added to cart");
					}
					break;
				case 4:
					System.out.println("Choose item to remove from cart: ");
					int input3 = scanner.nextInt();
					if (input3 == 1) {
						customer.getCart().removeItem(item1);
						System.out.println("Item 1 has been removed from cart");
					}
					if (input3 == 2) {
						customer.getCart().removeItem(item2);
						System.out.println("Item 2 has been removed from cart");
					}
					if (input3 == 3) {
						customer.getCart().removeItem(item3);
						System.out.println("Item 3 has been removed from cart");
					}
					break;
				case 5: 
					System.out.println(customer.getCart());
					break;
				case 6: 
					System.out.println("Total: $" + customer.getCart().calculateTotal() + "0");
					break;
				case 7: 
					customer.getCart().flushCart();   
					System.out.println("Cart has been flushed");
					break;
				case 8: break commandLoop;
				default:
					System.out.println("Bad option");
					break;  
				}
			}
		} finally {
			scanner.close();
		}	
	}	
		
}		



