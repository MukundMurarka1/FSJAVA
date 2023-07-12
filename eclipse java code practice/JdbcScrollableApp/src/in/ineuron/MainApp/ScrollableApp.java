package in.ineuron.MainApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.ineuron.JdbcUtil.JdbcUtility;

public class ScrollableApp {

	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		ResultSet resultset = null;
		
		
		try {
			connection = JdbcUtility.jdbcgetConnection();
			String query = "select id, name, age,address from studentinfo";
			
			if(connection != null) {
				stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			}
			if(stmt != null) {
				resultset = stmt.executeQuery(query);
			}if(resultset != null) {
				System.out.println("Print the result in Forward direction .....");
				System.out.println("id\tName\tAge\tAddress");
				while(resultset.next()) {
					System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t" +resultset.getInt(3)+ "\t" +resultset.getString(4));
				}
			}
			System.out.println();
			System.out.println("Print the result in backward direction...");
			System.out.println("id\tName\tAge\tAddress");
			while(resultset.previous()) {
				System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t" +resultset.getInt(3)+ "\t" +resultset.getString(4));
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				JdbcUtility.getCloseconnection(connection, stmt, resultset);
				System.out.println("connection closed suuccessfullly :::::");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
