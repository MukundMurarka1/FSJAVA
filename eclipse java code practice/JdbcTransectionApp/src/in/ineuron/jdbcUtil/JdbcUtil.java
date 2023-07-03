package in.ineuron.jdbcUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	
	
	
	private JdbcUtil() {
		
	}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded succesfully...");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection jdbcgetConnection() throws IOException, SQLException {
		
		FileInputStream fis = new FileInputStream("D:\\FSJAVA\\ecliplise code for practice\\JdbcTransectionApp\\src\\in\\ineuron\\properties\\application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
		System.out.println("Connectio established succcessfully ...");
		return connection;
		
	}
	
	public static void cleanUpConnection (Connection connection, Statement stmt, ResultSet resultset ) throws SQLException {
		
		if(connection != null) {
			connection.close();
		}
		
		if(stmt != null) {
			stmt.close();
		}
		
		if(resultset != null) {
			resultset.close();
		}
	}

}
