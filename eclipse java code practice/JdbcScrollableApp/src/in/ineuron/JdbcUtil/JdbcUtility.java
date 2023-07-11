package in.ineuron.JdbcUtil;

import java.sql.Connection;

public class JdbcUtility {
	
	private JdbcUtility() {
		
	}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded successfully ....");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection jdbcgetConnection() {
		return null;
	}

}
