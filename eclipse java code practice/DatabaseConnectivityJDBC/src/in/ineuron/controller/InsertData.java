package in.ineuron.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class InsertData {

	public static void main(String[] args) throws  SQLException {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("..........insert data into database ......");
		Connection connection = null;
		ResultSet resultset = null;
		Statement stmt = null;
		
		
		//load the driver 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Driver loaded succsessfully ........");
		
		String url = "jdbc:mysql:///student";
		String username="root";
		String password = "Mukund@1996";
		
		//create connection 
		connection = DriverManager.getConnection(url,username,password);
		System.out.println("Connection Established Successfully........ ");
		stmt = connection.createStatement();
		
		System.out.println("The implementation class name is ::  "+connection.getClass().getName());
		
		// create Statement 
		//Insert Data into database 
		System.out.println("Enter the details you want to add in database ");
		
		System.out.println("Enter the first name pf student  ");		
		String sfname = scan.next();
		
    	System.out.println("Enter the Last name pf student  ");
		String slname  =  scan.next();
		
		System.out.println("Enter the roll no pf student  ");
		int  srollno = scan.nextInt();
		
    	System.out.println("Enter the address pf student  ");
		String saddrss = scan.next();
		
		System.out.println("Enter the mobile no  pf student  ");
		int smobileno = scan.nextInt();
		
		String query =String.format("insert into studentdetails(`first_name`,`last_name`,`roll_no`,`address`,`mobile_no`) values('%s','%s',%d,'%s',%d)",sfname,slname,srollno,saddrss,smobileno) ;
		System.out.println(query);
		
		int row = stmt.executeUpdate(query);
		System.out.println("number of rows affected :: "+row);
		System.out.println(" =============data inserted successfully======== ");
		System.out.println("=======================================");
		
		
		System.out.println("Now updated database is ...........");
		String selectquery = "select * from studentdetails";
		resultset = stmt.executeQuery(selectquery);
    	System.out.println("First Name\tLast Name\tRolll no\tAddress\tMobile no");
		
		while(resultset.next()) {
			String sfirstname  = resultset.getString(1);
			String slastname = resultset.getString(2);
			Integer srolno = resultset.getInt(3);
			String sadress =  resultset.getString(4);
			Integer smobile = resultset.getInt(5);
			System.out.println(sfirstname+"\t\t"+slastname+"\t\t"+srolno+"\t\t"+sadress+"\t\t"+smobile);
		}
		
		
		// Update result in Database 
		System.out.println("Enter roll no of student which you want to update ");
		int roll = scan.nextInt();
		System.out.println("Enter new Address of student which you want to update ");
		String sadd = scan.next();		
		String updateQuery = "UPDATE studentdetails set address = '"+sadd+"' where roll_no= '"+roll+"'";
		System.out.println(updateQuery);
		int rowupdated= stmt.executeUpdate(updateQuery);
		
		 resultset = stmt.executeQuery(selectquery);
		 System.out.println("First Name\tLast Name\tRoll no\tAddress\tMobile no");
			
		 while(resultset.next()) {
				String sfirstname  = resultset.getString(1);
				String slastname = resultset.getString(2);
				Integer srolno = resultset.getInt(3);
				String sadress =  resultset.getString(4);
				Integer smobile = resultset.getInt(5);
				System.out.println(sfirstname+"\t\t"+slastname+"\t\t"+srolno+"\t\t"+sadress+"\t\t"+smobile);
			}
		 System.out.println(".......Data updated successfully........");
		 System.out.println();
		 
		 
		 
		 //Delete data From dataBase
		 System.out.println("Enter roll no of student which you want to delete ");
		 int delroll = scan.nextInt();
		 
		 String delquery = "delete from studentdetails where roll_no = '"+delroll+"' ";
		 int delrow= stmt.executeUpdate(delquery);
		 resultset = stmt.executeQuery(selectquery);
		 System.out.println("First Name\tLast Name\tRoll no\tAddress\tMobile no");
		 while(resultset.next()) {
				String sfirstname  = resultset.getString(1);
				String slastname = resultset.getString(2);
				Integer srolno = resultset.getInt(3);
				String sadress =  resultset.getString(4);
				Integer smobile = resultset.getInt(5);
				System.out.println(sfirstname+"\t\t"+slastname+"\t\t"+srolno+"\t\t"+sadress+"\t\t"+smobile);
			}
		 
		 System.out.println("......Data deleted successfully.........");
		 System.out.println();
		
		
		stmt.close();
		connection.close();
		scan.close();
		System.out.println("Resources are closed .........");
		
				
		
		
		
		
		

	}

}
