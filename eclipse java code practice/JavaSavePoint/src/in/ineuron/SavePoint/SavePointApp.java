package in.ineuron.SavePoint;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import in.ineurin.util.JdbcUtility;

public class SavePointApp {

	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		ResultSet resutset = null;
		ResultSet rs = null;
		
		try {
			connection = JdbcUtility.jdbGetConnection();
			
			if(connection != null) {
				stmt = connection.createStatement();	
			}
			
			System.out.println("Operation begins ....");
			connection.setAutoCommit(false);
			
			stmt.executeUpdate("insert into Politician (`Name` ,`Party`) values('Modi', 'BJP')");
			stmt.executeUpdate("insert into Politician (`Name` ,`Party`) values('Amit sah', 'BJP')");
			
			Savepoint sp = connection.setSavepoint();
			stmt.executeUpdate("insert into Politician (`Name` ,`Party`) values('rahul', 'BJP')");
			System.out.println("OOp's something went worng :::::");
			connection.rollback(sp);
			System.out.println("Operation are rolled back to save point ");
			connection.commit();
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtility.cleanup(connection, stmt, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		

	}

}
