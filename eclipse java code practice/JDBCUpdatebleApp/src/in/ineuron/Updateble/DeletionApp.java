
package in.ineuron.Updateble;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.inuron.javaUtil.jdbcutility;

public class DeletionApp {

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
			System.out.println("Record before doing Delete operation ");
			System.out.println("id\tName\tAge\tAddress");
			while (resultset.next()) {
				System.out.println(resultset.getInt(1)+" \t "+resultset.getString(2)+"\t"+ resultset.getInt(3)+"\t"+resultset.getString(4));
			}
			
			//performing delete operation using resultset.
			System.out.println();
			resultset.last(); // take the cursor to the last row 
			resultset.deleteRow(); //delete the row on which the cursor lies currently
			resultset.beforeFirst();// take the cursor before last row ....
			
			System.out.println("Record after deletion  ::: ");
			
			resultset.beforeFirst();//take the cursor before first record 
			System.out.println("id\tName\tAge\tAddress");
			while (resultset.next()) {
				resultset.refreshRow();
				System.out.println(resultset.getInt(1)+" \t "+resultset.getString(2)+"\t"+ resultset.getInt(3)+"\t"+resultset.getString(4));
			}
			
			
		}
		
	} catch (IOException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	}

}