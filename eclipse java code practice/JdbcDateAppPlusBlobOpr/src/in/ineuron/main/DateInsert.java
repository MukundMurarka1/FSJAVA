package in.ineuron.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class DateInsert {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultset = null;
		
		java.sql.Date stdob = null;
		java.sql.Date stdom = null;
		
		String insertquery = "insert into user(`sname`,`sdob`,`sdom`) values (?,?,?);";
		String imageInsertQuery = "insert into information (`sname`,`image`) values(?,?)";
		
		try {
			connection = JdbcUtil.jdbcgetconnection();
			System.out.println("Connection established successfully ....");
			if(connection  != null) {
				pstmt = connection.prepareStatement(imageInsertQuery);
			}
			if(pstmt != null ) {
//				Scanner scan = new Scanner(System.in);
//				System.out.print("enter the name of student :: ");
//				String sname =  scan.next();
//				System.out.print("enter the Date of birth of student in dd-MM-yyyy format ::" );
//				String sdob = scan.next();
//				System.out.print("enter date of marriage of student in yyyy-MM-dd format :: ");
//				String sdom = scan.next();
//				
//				//converison of date into java.util.date
//				if(sdob != null) {
//				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//				java.util.Date sttdob = sdf.parse(sdom);
//				
//				long datevalue = sttdob.getTime();
//				 stdob = new java.sql.Date(datevalue);
//				}
//				if(sdom !=null) {
//				//conversion of date into java.sql.date
//				stdom = java.sql.Date.valueOf(sdom);	
//				}
//				pstmt.setString(1, sname);
//				pstmt.setDate(2,stdob);
//				pstmt.setDate(3, stdom);
				
				
				//image insertion code 
				
				Scanner scan = new Scanner(System.in);
				System.out.println("enter the name of student :: ");
				String sname = scan.next();
				
				System.out.println("Enter the loction of image");
				String imgloc = scan.next();
				
				FileInputStream fis = new FileInputStream(imgloc);
				
				pstmt.setString(1, sname);
				pstmt.setBinaryStream(2, fis);
				
				
				int rowaffected = pstmt.executeUpdate();
				if(rowaffected != 0) {
					System.out.println("data inserted successfully ::"+rowaffected);
					
				}
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
			
		}catch(IOException ie ) {
			ie.printStackTrace();
		}
		finally {
			try{
				JdbcUtil.closeConnection(connection, pstmt, resultset);
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}

}
