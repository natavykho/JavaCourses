package projectPackage;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Database {
	
	//constructor
	public Database() {}
	

	
	// Method addCourse(conn)
	// make sure a course like this doesn't already exist. check for course with same code
	// if user inputs course code of existing course code, then make sure they know database will reject it
	// this will cause an exception generated. Tell user what exactly is wrong.
	// execute select statement before insert statement to check for existing 
	public void addCourse(Connection conn, Scanner scan) throws SQLException, IOException{
		String code, title;
		PreparedStatement stmt = conn.prepareStatement("insert into Course values (?, ?)");
		scan.useDelimiter(System.lineSeparator());
		System.out.println("Enter course code: ");
		code = scan.next();
		System.out.println("Enter course title: ");
		title = scan.next();
		String query = "select code from Course where code = '" + code + "'";
		Statement stmt2 = conn.createStatement();
		
		
		// check to see if code already exists in database
		// if result.next(), then course already exists		
		try {
			ResultSet result = stmt2.executeQuery(query);
			if (result.next()) {
				System.out.print("Course already exists: ");
			}
		} catch (SQLException e) {
			System.out.println("continues on with method since course doesn't exist");
		}
		
		try {
			stmt.setString(1, code);
			stmt.setString(2, title);
			stmt.executeUpdate();
		} catch (SQLException e){
			System.out.println("Error adding course");
		}
		stmt.close();
			
	}
	
	
	// Method deleteCourse(conn, courseCode)
		// make sure user input code exists in the table first
		// when you delete a course, make sure you delete their registrations too
	public void deleteCourse(Connection conn, Scanner scan) throws SQLException, IOException {
		Statement stmt = conn.createStatement();
		Statement stmt2 = conn.createStatement();
		System.out.println("Please enter code of course to delete: ");
		String code = scan.next();
		String query = "delete from Course where code = '" + code + "'";
		String query2 = "delete from Registered where code = '" + code + "'";
		try {
			stmt2.executeUpdate(query2);
			int count = stmt.executeUpdate(query);
			if (count == 0) {
				System.out.println("Course doesn't exist. Deletion error.");
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		stmt.close();
			
	}
	
	
	// Method addStudent(conn)
		// use same scanner object
	public void addStudent(Connection conn, Scanner scan) throws SQLException, IOException{
		String ssn, name, address, major;
		PreparedStatement stmt = conn.prepareStatement("insert into Student values (?, ?, ?, ?)");
		
		scan.useDelimiter(System.lineSeparator());
		System.out.println("Enter student ssn: "); 
		ssn = scan.next();
		System.out.println("Enter student name: ");
		name = scan.next();
		System.out.println("Enter student address: ");
		address = scan.next();
		System.out.println("Enter student major: ");
		major = scan.next();
		String query = "Select ssn from Student where ssn = '" + ssn + "'";
		Statement stmt2 = conn.createStatement();
		
		//check to see if already exists using select statement. tell user it already exists 
		try {
			ResultSet result = stmt2.executeQuery(query);
			if (result.next()) {
				System.out.print("Student already exists: ");
			}
		} catch (SQLException e) {
			System.out.println("continues on with method since student doens't exist yet");
		}
		
		try {
			stmt.setString(1, ssn);
			stmt.setString(2, name);
			stmt.setString(3, address);
			stmt.setString(4, major);
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error adding student");
		}		
		stmt.close();
		
	}
	
	
	// Method deleteStudent(conn, studentSSN)
	// task: when you delete a student, make sure to delete their registrations too
	public void deleteStudent(Connection conn, Scanner scan) throws SQLException, IOException {
		Statement stmt = conn.createStatement();
		Statement stmt2 = conn.createStatement();
		System.out.println("Enter ssn of student from which to delete: ");
		String ssn = scan.next();
		String query = "delete from Student where ssn = '" + ssn + "'";
		String query2 = "delete from Registered where ssn = '" + ssn +"'";
		try {
			stmt2.executeUpdate(query2);
			int count = stmt.executeUpdate(query);
			if (count == 0) {
				System.out.println("Student doesn't exist. Deletion error");
			}
			
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
		stmt.close();
		
	}
	
	
	// Method regCourse(conn)
		// make sure that course and student exist. 
		// execute select statement, process result, show result to user
	public void regCourse(Connection conn, Scanner scan) throws SQLException, IOException {
		String ssn, code, year, sem;
		PreparedStatement stmt = conn.prepareStatement("insert into Registered(ssn, code, year, semester) values (?,?,?,?)");
		scan.useDelimiter(System.lineSeparator());
		System.out.println("Enter student ssn: ");
		ssn = scan.next();
		System.out.println("Enter course code: ");
		code = scan.next();
		System.out.println("Enter year: ");
		year = scan.next();
		System.out.println("Enter semester: ");
		sem = scan.next();
		Statement stmt2 = conn.createStatement();
		Statement stmt3 = conn.createStatement();
		String studentQuery = "select ssn from Student where ssn = '" + ssn + "'";
		String courseQuery = "select code from Course where code = '" + code + "'";
		
		
		try {
			ResultSet studentResult = stmt2.executeQuery(studentQuery);
			ResultSet courseResult = stmt3.executeQuery(courseQuery);
			if(!studentResult.next()) {
				System.out.println("Student doesn't exists");
			}
			if(!courseResult.next()) {
				System.out.println("Course doesn't exists");
			}
		} catch (SQLException e) {
			System.out.println("contineus on with method");
		}
		// also to try catch for if student is already registered toa course
		
		try {
			stmt.setString(1, ssn);
			stmt.setString(2, code);
			stmt.setString(3, year);
			stmt.setString(4, sem);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Error registering student");
		}
		stmt.close();
		
	}
	
	
	// Method checkReg(conn, studentSSN)
		// return all courses student registered (show course code, year, semester)
	public void checkReg(Connection conn, Scanner scan)throws SQLException, IOException {
		Statement stmt = conn.createStatement();
		System.out.println("Enter ssn of student to check their registration: ");
		scan.useDelimiter(System.lineSeparator());
		String ssn = scan.next();
		String query = "Select code, year, semester from Registered Where ssn = '" + ssn + "'";	
		try {
			ResultSet result = stmt.executeQuery(query);
			if (!result.next()) {
				System.out.println("Student does not exist");
			}
			String code = "";
			String year = "";
			String sem = "";
			while (result.next()){
				code = result.getString(1);
				year = result.getString(2);
				sem = result.getString(3);
				System.out.println("course code: " + code + " year: " + year + " semester: " + sem);		
			}
			result.close();
		} catch (SQLException e){
			System.out.println(e.getMessage());
		}
		stmt.close();
			
	}

	
	
	// Method uploadGrades(conn, code, year, semester)
		// execute 2 statements
		// first execute select statement to find students who registered that course into resultSet
		// use while loop to visit all students in resultSet
			// use different statement to execute update statement to update student's grade
	public void uploadGrade(Connection conn, Scanner scan) throws IOException, SQLException {
		Statement stmt = conn.createStatement();
		String code, year, sem;
		System.out.println("please enter course code: ");
		scan.useDelimiter(System.lineSeparator());
		code = scan.next();
		String query = "Select ssn from Registered where code = '" + code +"'";
		String courseQuery = "select code from Course where code = '" + code + "'";
		Statement stmt3 = conn.createStatement();
		try {
			ResultSet courseResult = stmt3.executeQuery(courseQuery);
			if (!courseResult.next()) {
				System.out.println("Course doesn't exist in the database");
			}
		} catch (SQLException exc) {
			
		}
		
			
		
		
		// get result set of student ssn of which are registered to course 
		try {
			
			//checks to see if result set is empty
			ResultSet result = stmt.executeQuery(query);
			if (!result.next()) {
				System.out.println("Course doesn't have students registered to it");
			}
			// loop through result set and enter grade for each student 
			while(result.next()) {
				String ssn = result.getString(1);
				Statement stmt2 = conn.createStatement();
				System.out.println("Enter letter grade for student with ssn = " + ssn);
				String grade = scan.next();
				String query2 = "Update Registered Set grade = '" + grade + "' where ssn = '" + ssn + "' and code = '" + code + "'" ;			
				
				// execute query to update the grade for each student
				try {
					stmt2.executeUpdate(query2);
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
				stmt2.close();
			}
			result.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		stmt.close();
	}
	
	
	

	

}
