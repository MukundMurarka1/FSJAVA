
package in.ineuron.Updateble;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.inuron.javaUtil.jdbcutility;

public class updatebleApp {

	public static void main(String[] args) {
		
		Connection connection = null;
		Statement stmt = null;
		ResultSet resultset = null;
		
		String query ="select id, name, age,address from studentinfo";
		
		
	 try {
		connection = jdbcutility.getJdbcConnection();
		
		if(connection != null ) {
			stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		}
		if(stmt != null) {
			
			resultset = stmt.executeQuery(query);
				
		}
		if(resultset != null) {
			System.out.println("Record before doing update operation ");
			System.out.println();
			while (resultset.next()) {
				System.out.println(resultset.getInt(1)+" \t "+);
			}
		}
		
	} catch (IOException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	}

}
