package in.ineuron.callable;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import in.ineuron.utils.JdbcUtility;

public class CallableStatementApp {

	public static void main(String[] args) {
		Connection connection = null;
		CallableStatement cstmt = null;
		Scanner scan = null;
		Integer id = null;
		
		String storedProcedureCall ="{call p_get_producr_details(?,?,?,?)}";
		
		try {
			connection  = JdbcUtility.getJdbcConnection();
			if (connection != null) {
				cstmt = connection.prepareCall(storedProcedureCall);
			}
			
			scan = new Scanner(System.in);
			if(scan != null) {
				System.out.print("Enter the product id :: ");
				id= scan.nextInt();
				
			}
			//setting the value .....
			if(cstmt != null) {
				cstmt.setInt(1, id);	
			}
			//Setting the data types of output values
			if(cstmt != null) {
				cstmt.registerOutParameter(2, Types.VARCHAR);
				cstmt.registerOutParameter(3, Types.INTEGER);
				cstmt.registerOutParameter(4, Types.INTEGER);
			}
			
			//execute the query ....
			if(cstmt != null) {
				cstmt.execute();
			}
			
			if(cstmt != null) {
				System.out.println("Product id is :: "+cstmt.getString(2));
				System.out.println("Product cost is :: "+cstmt.getInt(3));
				System.out.println("Product quantity is :: "+cstmt.getInt(4));
			}
			
			
			
			
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
		}
		
		
		

	}

}
