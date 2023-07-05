package in.ineurin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtility {
	
	
	
	private JdbcUtility() {
		
	}
	
	static{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class loded successfully ....");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection jdbGetConnection() throws SQLException {
		
		
		Connection connection = DriverManager.getConnection(null);
		
		
		
		return null;
		
	}

}
