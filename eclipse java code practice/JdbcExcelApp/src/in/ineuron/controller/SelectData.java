package in.ineuron.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectData {
	private static final String EXCEL_FILE = "select * from room_booking.sheet1";
	public static void main(String[] args) {
		
		
		Connection connection = null;
		PreparedStatement pstmt =  null;
		ResultSet resultset = null;
		
		String url =  "jdbc:Excel:///D:\\empty";
		
		
		
		try{
			connection = DriverManager.getConnection(url);
			pstmt = connection.prepareStatement(EXCEL_FILE);
			
			resultset = pstmt.executeQuery();
			
			while(resultset.next()) {
				System.out.println(resultset.getString(1)+"\t"+ resultset.getString(2)+"\t"+resultset.getInt(3)+"\t"+resultset.getString(4));
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e ) {
			e.printStackTrace();
		}

	}

}
