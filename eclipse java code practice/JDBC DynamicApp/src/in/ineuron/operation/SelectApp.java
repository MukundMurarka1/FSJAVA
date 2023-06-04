package in.ineuron.operation;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.ineuron.util.JDBCUtil;

public class SelectApp {

	public static void main(String[] args) {
		Connection connection  = null;
		Statement stmt = null;
		ResultSet resultset = null;
		
		String selectquery = "select * from studentdetails";
		
		try {
			connection = JDBCUtil.jdbcgetconnection();
			
			if(connection != null) {
				stmt = connection.createStatement();
			}
			if(stmt != null) {
				resultset = stmt.executeQuery(selectquery);
			}
			
			if(resultset != null ) {
				
					System.out.printf("%-2s%14s%12s%15s%15s","First Name ","Last Name","Roll no","Address","Mobile no");
					System.out.println();
					while (resultset.next()) {
						System.out.printf("%2s%15s%12d%15s%15s", resultset.getString(1), resultset.getString(2),
								resultset.getInt(3), resultset.getString(4), resultset.getString(5));
						System.out.println();
				}
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				JDBCUtil.cleanup(connection, stmt, resultset);
				System.out.println("Closing the connection......");
			}catch(SQLException se) {
				se.printStackTrace();
				
			}
			
		}
		
		

	}

}
