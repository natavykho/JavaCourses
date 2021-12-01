package projectPackage;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class DriverClass {

	public static void main(String[] args) throws SQLException, IOException {
		
		// project description: https://www.youtube.com/watch?v=edfT16TYsSE
		
		
		// create scanner. use only 1 scanner object
		// pass it as parameter for database class to read input
		Scanner scanner = new Scanner(System.in);
		
		// print out menu
		System.out.println("*********************************************************************");
		System.out.println("***                                                               ***");
		System.out.println("***             Welcome to Online Registration System             ***");
		System.out.println("***                                                               ***");
		System.out.println("*********************************************************************");
		System.out.println();
		
		System.out.println("1. Add a course");
		System.out.println("2. Delete a course");
		System.out.println("3. Add a student");
		System.out.println("4. Delete a student");
		System.out.println("5. Register a course");
		System.out.println("6. Check student registration");
		System.out.println("7. Upload grades");
		System.out.println("8. Quit");
		
		
		
		// load oracle JDBC driver
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
		} 
		catch(ClassNotFoundException e) {
			System.out.println("Could not load the driver");
		}
		
		
		// try to connect to driver manager
		try {
			String url = "jdbc:oracle:thin:@fedora2.uscupstate.edu:1521:xe";
			Connection conn = DriverManager.getConnection(url,"testw","t123456");
			Database db = new Database();
			
			
			
			//switch statement to choose menu item which loops until user input 8:
			boolean flag = true;
			while(flag) {
				System.out.println("\nPlease select from menu: ");	
				
				// validate user input. make sure they input number 1-8
				while(!scanner.hasNextInt()) {
					System.out.println("Please enter valid menu option: ");
					scanner.next();
				}
				int input = scanner.nextInt();
				switch(input) {
				case 1:
					db.addCourse(conn, scanner);
					break;
				case 2:
					db.deleteCourse(conn, scanner);
					break;
				case 3:
					db.addStudent(conn, scanner);
					break;
				case 4: 
					db.deleteStudent(conn, scanner);
					break;
				case 5:
					db.regCourse(conn, scanner);
					break;
				case 6:
					db.checkReg(conn, scanner);
					break;
				case 7: 	
					db.uploadGrade(conn, scanner);
					break;
				case 8: 
					flag = false;
					break;
				default: 
					System.out.println("Enter valid menu option: ");
					break;
				}
			}
			conn.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	
		

	}

}

