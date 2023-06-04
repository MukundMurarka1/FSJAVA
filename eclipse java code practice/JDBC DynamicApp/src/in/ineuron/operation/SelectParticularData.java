package in.ineuron.operation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JDBCUtil;

public class SelectParticularData {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultset = null;
		
		
			try {
				connection =  JDBCUtil.jdbcgetconnection();
				System.out.println("Connecton established successfully ....");
				String sqlSelectQuery ="select * from studentdetails where roll_no = ?";
				if(connection != null) {
					pstmt = connection.prepareStatement(sqlSelectQuery);
				}
				if(pstmt!=null) {
					
					Scanner scan = new Scanner (System.in);
					System.out.println("Enter the roll no of student which you want to fetch the detail ::");
					
					int roll_no = scan.nextInt();
					pstmt.setInt(1, roll_no);
					resultset = pstmt.executeQuery();
				}if(resultset!=null) {
					if(resultset.next()) {
						System.out.println("First_name\tLast_Name\tRoll_no\t\tAddress\t\tMobile_no");
						System.out.println(resultset.getString(1)+" \t "+resultset.getString(2)+" \t "+resultset.getInt(3)+" \t "+resultset.getString(4)+" \t "+resultset.getString(5));
					}else {
						System.out.println("Record is not available for the given roll no .....");
					}
				}
				
				
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(IOException io) {
				io.printStackTrace();
			}catch(Exception ex) {
				ex.printStackTrace();
			}finally {
				try {
					JDBCUtil.cleanup(connection, pstmt, resultset);
					System.out.println("Closing the connection.....");
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
		
		
		
		

	}

}
