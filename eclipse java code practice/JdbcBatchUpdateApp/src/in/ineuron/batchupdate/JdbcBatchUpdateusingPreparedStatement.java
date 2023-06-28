package in.ineuron.batchupdate;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.*;

import JdBCUtil.JDBCUtils;


public class JdbcBatchUpdateusingPreparedStatement {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultset = null;
		
		String pname = null;
		Integer pprice = null ;
		Integer quantity = null;
		
		String insertdata = "insert into product(`pname`,`price`,`quantity`) values(?,?,?)";
		
		try {
			connection = JDBCUtils.jdbcGetConnection();
			
			if(connection != null) {
				pstmt = connection.prepareStatement(insertdata);
			}
			if(pstmt != null) {
				Scanner scan = new Scanner (System.in);
				while(true){
					System.out.println("Enter the name of product :: ");
					pname = scan.next();
					
					System.out.println("Enter the price of product :: ");
					pprice = scan.nextInt();
					
					System.out.println("Enter the price of product :: ");
					quantity = scan.nextInt();
					
					pstmt.setString(1, pname);
					pstmt.setInt(2, pprice);
					pstmt.setInt(3, quantity);
					
					pstmt.addBatch();
					
					System.out.print("Do you want to insert more details [yes/ No] ::");
					String option  =  scan.next();
					
					if(option.equalsIgnoreCase("no")) {
						break;
					}	
				}
				
				pstmt.executeBatch();
				System.out.println("record inserted successfully ...");
			}
			
		}catch(SQLException | IOException se ) {
			se.printStackTrace();
		}catch(Exception e ) {
			e.printStackTrace();
		}finally {
			try{
				JDBCUtils.closeconnection(connection, pstmt, resultset);
			}catch(SQLException se) {
				se.printStackTrace();
			}

	}
	}
}
