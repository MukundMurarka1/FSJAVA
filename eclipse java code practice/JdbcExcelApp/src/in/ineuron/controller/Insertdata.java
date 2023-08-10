package in.ineuron.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insertdata {
	
	public static void main (String[] args ) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		String Excel_insert = "insert into room_booking.sheet1 values (?,?,?,?)";
	    String name = null;
	    String gender = null;
	    int num = 0;
	    String roomallot = null;
	    
	    String url =  "jdbc:Excel:///D:\\empty";
	    
	    
	    try {
	    	Scanner scan = new Scanner(System.in);
	    	System.out.print("enter the name of person : ");
	    	name = scan.next();
	    	System.out.print("enter the gender of the person : ");
	    	gender = scan.next();
	    	System.out.print("enter the mobile number : ");
	    	num= scan.nextInt();
	    	System.out.print("enter room allocate : ");
	    	roomallot = scan.next();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	    
	    
	    try {
	    	connection = DriverManager.getConnection(url);
	    	pstmt = connection.prepareStatement(roomallot);
	    	
	    	pstmt.setString(1, name);
	    	pstmt.setString(2, gender);
	    	pstmt.setInt(3, num);
	    	pstmt.setString(4, roomallot);
	    	
	    	int count = pstmt.executeUpdate();
	    	if(count == 0) {
	    		System.out.println("some error occur ");
	    	}else {
	    		System.out.println("data insert successfully ");
	    	}
	    	
	    }catch(SQLException se ) {
	    	se.printStackTrace();
	    }
	    
		
	}

}
