package in.ineuron.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	
	private JdbcUtil(){
		
	}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loded successfully ...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getJdbcConnection() throws SQLException, IOException {
		
		FileInputStream fis = new FileInputStream("D:\\FSJAVA\\ecliplise code for practice\\CrudJdbcApp\\src\\in\\ineuron\\properties\\application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		
		
		Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
		System.out.println("Conection established Successfully ...");
		return connection;
		
	}
	
	
	public static void closeconnection (Connection connection , PreparedStatement pstmt, ResultSet resultset ) throws SQLException {
		if(connection !=null) {
			connection.close();
		}
		
		if(pstmt != null) {
			pstmt.close();
		}
		
		if(resultset != null) {
			resultset.close();
		}
	}


}
