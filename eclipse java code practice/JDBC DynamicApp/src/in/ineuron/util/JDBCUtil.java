
package in.ineuron.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBCUtil {
	
	private JDBCUtil() {
		
	}
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loading and ragistration Successfully .......");
		}catch(ClassNotFoundException cef) {
			cef.printStackTrace();
		}
		
	}
	public static Connection jdbcgetconnection() throws SQLException, IOException {
		
		//Take the data from the properties file 
		FileInputStream fis = new FileInputStream("D:\\FSJAVA\\ecliplise code for practice\\JDBC DynamicApp\\apllication.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		
		String url = properties.getProperty("url");
		String user=properties.getProperty("user");
		String password = properties.getProperty("password");
		
		Connection connection = DriverManager.getConnection(url,user,password);
		System.out.println("Connection established successfuly....");
		return connection;	
	}
	public static void  cleanup(Connection connection, Statement statement, ResultSet resultset) throws SQLException{
		if(connection !=null) {
			connection.close();
		}
		if(statement !=null ) {
			statement.close();
		}
		if(resultset != null ) {
			resultset.close();
		}
	}

}
