package in.ineuron.Clobopr;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import JdBCUtil.JDBCUtils;


public class ClobInsert {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultset = null;
		
		String name = null;
		String pdfLoc = null;
		String insertdata = "insert into cities(`name`,`history`) values(?,?)";
		
		try {
			connection = JDBCUtils.jdbcGetConnection();
			
			if(connection != null) {
				pstmt = connection.prepareStatement(insertdata);
			}
			if(pstmt != null) {
				Scanner scan = new Scanner (System.in);
				if(scan != null) {
					System.out.println("Enter the name of student :: ");
					name = scan.next();
					
					System.out.println("Enter the location pdf :: ");
					pdfLoc = scan.next();
					
					System.out.println(pdfLoc);
					
					pstmt.setString(1, name);
					pstmt.setCharacterStream(2, new FileReader(new File(pdfLoc)));
					
					int rowcount = pstmt.executeUpdate();
					if(rowcount !=0 ) {
						System.out.println("data inserted Successfully ::  ");
					}
					
					
					
				}
			}
			
		}catch(SQLException | IOException se ) {
			se.printStackTrace();
		}catch(Exception e ) {
			e.printStackTrace();
		}finally {
			try{
				JDBCUtils.closeconnection(connection, pstmt, resultset);
			}catch(SQLException se) {
				se.printStackTrace();
			}

	}
	}
}
