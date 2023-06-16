package JdBCUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
	
	
	public JDBCUtils() {
		
	}
	static{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully ::");
			
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	public static Connection jdbcGetConnection() throws SQLException, IOException {
		
		FileInputStream fis = new FileInputStream("D:\\FSJAVA\\ecliplise code for practice\\JdbcClobOperation\\src\\in\\ineuron\\applicationproperties\\application.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		
		Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"),properties.getProperty("password"));
		System.out.println("Connection Established Successfully :: ");
		return connection;
		
	}
	
	public static void closeconnection (Connection connection, PreparedStatement pstmt, ResultSet resultset) throws SQLException {
		
		if(connection != null) {
			connection.close();
		}
		
		if(pstmt != null) {
			pstmt.close();
		}
		
		if(resultset != null ) {
			resultset.close();
		}
		
	}

	

}
