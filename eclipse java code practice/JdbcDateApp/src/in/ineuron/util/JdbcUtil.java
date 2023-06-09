package in.ineuron.util;

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
	static{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		
		
	}
	
	public static Connection jdbcgetconnection() throws SQLException, IOException   {
	
	FileInputStream fis = new FileInputStream("D:\\FSJAVA\\ecliplise code for practice\\JdbcDateApp\\src\\in\\ineuron\\properties\\application.properties");
	Properties properties = new Properties();
	properties.load(fis);
	
	Connection connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
	System.out.println("Connection Established successfully .....");
	return null;
	}
	
	public static void closeConnection(Connection connection, Statement stmt, ResultSet resultset) throws SQLException {
		if(connection != null) {
			connection.close();
		}
		if(stmt != null) {
			stmt.close();
		}
		if(resultset !=null) {
			resultset.close();
		}
		
	}
}
