package in.ineuron.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.util.JdbcUtil;

public class DateInsert {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultset = null;
		String insertquery = "insert into user(`sname`,`sdb`,`sdom`) values (?,?,?);";
		
		try {
			connection = JdbcUtil.jdbcgetconnection();
			System.out.println("Connection established successfully ....");
			if(connection  != null) {
				pstmt = connection.prepareStatement(null);
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
			
		}catch(IOException ie ) {
			ie.printStackTrace();
		}
		
		

	}

}
