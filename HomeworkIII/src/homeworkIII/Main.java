package homeworkIII;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		

		
		// read values.txt
		// Scanner scann = new Scanner(new File("/Users/nataliyavykhovanets/Desktop/values.txt"));
		Scanner scann = new Scanner(new File("values.txt"));
		LinkedList list = new LinkedList();
		
		// push the object value data into the stack
		// populate linked list
		while(scann.hasNext()) {
			String variable = scann.next();
			double value = scann.nextDouble();
			ValueData data = new ValueData(variable, value);
			list.insertFront(data);
			
		}
		scann.close();
			
		
	
		// Users/nataliyavykhovanets/Desktop/expression.txt	
		// read expression.txt
		Scanner scan = new Scanner(new File("expression.txt"));
		String expression = scan.next();
		System.out.println("expression: " + expression);
		System.out.println();
		scan.close();
		
		// build ObjectStack
		ObjectStack stack = new ObjectStack();
		
	
		// evaluate postfix expression 
		// see variable, push its value into stack
		// see operator, pop 2 numbers off the stack and apply operations, 
		// push results back
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '+') {
				try {
					Double A = (Double) stack.pop();
					Double B = (Double) stack.pop();
					System.out.println(A);
					System.out.println(B);
					System.out.println();
					Double C = A+B;//new Double(A+B);
					stack.push(C);				
				} catch (EmptyStackException e) {
					System.out.println(e);
				}
				
			} else if (expression.charAt(i) == '-') {
				try {
					Double A = (Double) stack.pop();
					Double B = (Double) stack.pop();
					System.out.println(A);
					System.out.println(B);
					System.out.println();
					Double C = A-B;
					stack.push(C);
				} catch (EmptyStackException e) {
					System.out.println(e);
				}
			
			} else if (expression.charAt(i) == '/') {
				try {
					Double A = (Double) stack.pop();
					Double B = (Double) stack.pop();
					System.out.println(A);
					System.out.println(B);
					System.out.println();
					Double C = A/B;
					stack.push(C);
				} catch (EmptyStackException e) {
					System.out.println(e);
				}
		
			} else if (expression.charAt(i) == '*') {
				try {
					Double A = (Double) stack.pop();
					Double B = (Double) stack.pop();
					System.out.println(A);
					System.out.println(B);
					System.out.println();
					Double C = A*B;
					stack.push(C);
				} catch (EmptyStackException e) {
					System.out.println(e);
					System.out.println();
				}
				
			} else {
				double value = find(list.getHead(), expression.substring(i, i+1));
				stack.push(value);
			}
		
			

		}
		
		double answer = 0.0;
		try {
			answer = (Double) stack.pop();
		} catch (EmptyStackException e) {
			System.out.println(e);
		}
		if (stack.isEmpty()) {
			System.out.println("answer: " + answer);
		} else {
			System.out.println("Illegal expression");
		}
	
		
	} // end of main


	
	public static double find(LinkedListNode head, String var) {
		LinkedListNode current = head;
		while (current != null) {
			ValueData item = (ValueData) current.getData();
			if (item.getVariable().equals(var)) { // i cant do this can i? item.getVariable() == var. nah since its a String and Strings are considrered to be objects im pretty sure 
				return item.getValue();
			}
			current = current.getNext();	
		}
		return 0.0d;
		
	}
}










//if (expression.charAt(i) == 'a') {
//list.find(list.getHead(), "a"); 
////stack.push(value of a);
//}
//else if (expression.charAt(i) == 'b') {
//stack.push(list.getData.getvalue);
//}
//else if (expression.charAt(i) == 'c') {
//stack.push(list.getData().getValue());
//}
//else if (expression.charAt(i) == '+') {
//double value1 = stack.pop();
//double value2 = stack.pop();
//double added = value1 + value2;
//stack.push(value2);
//}
//else if (expression.charAt(i) == '-') {
//double value1 = stack.pop();
//double value2 = stack.pop();
//double subtracted = value1-value2;
//stack.push(subtracted);
//}

