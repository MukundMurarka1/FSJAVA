package in.ineuron.operation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.util.JDBCUtil;

public class DeleteApp {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null ;
		
		try {
			connection = JDBCUtil.jdbcgetconnection();
			String deletQuery = "Delete from studentdetails where roll_no = ?";
			if(connection !=null) {
				pstmt = connection.prepareStatement(deletQuery);
				
			}
			if(pstmt != null ) {
				Scanner scan  =  new Scanner (System.in);
				System.out.println("enter the roll_no of student which you want to delete :: ");
				int roll =scan.nextInt();
				
				pstmt.setInt(1, roll);
				int row = pstmt.executeUpdate();
				System.out.println("number of records deleted :: "+row);
				
				System.out.println("see the list of remaining students ::  " );
				SelectApp select = new SelectApp();
				select.main(args);
				
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
