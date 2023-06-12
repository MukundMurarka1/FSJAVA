package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JdbcUtil;

public class DateInsert {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultset = null;
		String insertquery = "insert into user(`sname`,`sdb`,`sdom`) values (?,?,?);";
		
		try {
			connection = JdbcUtil.jdbcgetconnection();
			System.out.println("Connection established successfully ....");
			if(connection  != null) {
				pstmt = connection.prepareStatement(null);
			}
			if(pstmt !=null ) {
				Scanner scan = new Scanner(System.in);
				System.out.print("enter the name of student :: ");
				String sname =  scan.next();
				System.out.print("enter the Date of birth of student ::" );
				String sdob = scan.next();
				System.out.print("enter date of marriage of student :: ");
				String sdom = scan.next();
				
				//converison of date into 
				
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
			
		}catch(IOException ie ) {
			ie.printStackTrace();
		}
		
		

	}

}
