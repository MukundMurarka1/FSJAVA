package in.ineuron.operation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JDBCUtil;

public class UpdateApp {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		
		try {
			connection = JDBCUtil.jdbcgetconnection();
			String updateQuery = "update studentdetails set address = ? where roll_no = ?";
			if(connection != null ) {
				pstmt = connection.prepareStatement(updateQuery);
			}
			if(pstmt != null) {
				Scanner scan = new Scanner(System.in);
				
				System.out.println("Enter the roll_no of student which you want to change the address :: ");
				int roll_no = scan.nextInt();
				System.out.println("Enter the new address :: ");
				String address = scan.next();
				
				pstmt.setString(1, address);
				pstmt.setInt(2, roll_no);
				
				
				int updated_row = pstmt.executeUpdate();
				
				System.out.println("number of rows Updated :: "+updated_row);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
