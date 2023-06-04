package in.ineuron.operation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JDBCUtil;

public class insertApp {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JDBCUtil.jdbcgetconnection();
			System.out.println("conection stablished successfully........");
			
			//insert query 
			String insertQuery = "insert into studentdetails (`first_name`,`last_name`,`roll_no`,`address`,`mobile_no`) values(?,?,?,?,?)";
			
			if(con != null) {
				pstmt = con.prepareStatement(insertQuery);	
			}
			
			//use precompiled query......
			if(pstmt != null) {
				
				
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter the first name :: ");
				String fname = scan.next();
				System.out.println("Enter the last name ::");
				String lname = scan.next();
				System.out.println("enter thr roll no ::");
				int roll = scan.nextInt();
				System.out.println("Enter the address of the student ::");
				String address = scan.next();
				System.out.println("Enter  mobile number of the student ::");
				String mobile  =scan.next();
				
				pstmt.setString(1,fname);
				pstmt.setString(2, lname);
				pstmt.setInt(3, roll);
				pstmt.setString(4, address);
				pstmt.setString(5, mobile);
				
				//execute the query.....
				System.out.println(insertQuery);
				int row = pstmt.executeUpdate();
				System.out.println("number of affected row ::"+row);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				JDBCUtil.cleanup(con, pstmt, null);
				System.out.println("All connection noe closed ....");
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		

	}

}
