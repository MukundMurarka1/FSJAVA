package in.inuron.javaUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbcutility {
	
	private jdbcutility(){
		
	}
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver calss loaded successfully .....");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public  static Connection getJdbcConnection() throws IOException, SQLException {
		
		FileInputStream fis = new FileInputStream("D:\\FSJAVA\\ecliplise code for practice\\JDBCUpdatebleApp\\src\\in\\ineuron\\application\\application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"), properties.getProperty("password"));
		System.out.println("Connection established successfully .....");
		return connection;
	}
	
	public static void closeConnection(Connection connection, Statement stmt, ResultSet resultset) throws SQLException {
		if(connection != null) {
			connection.close();
		}
		
		if(stmt !=null) {
			stmt.close();	
		}
		
		if(resultset != null) {
			resultset.close();
		}
		
	}

}
