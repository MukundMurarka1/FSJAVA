package in.ineuron.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.jdbcUtil.JdbcUtil;

public class TransectionApp {
	
	

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultset = null;
		String query = "Select Name, balance from account_info";
		
		try {
			connection = JdbcUtil.jdbcgetConnection();
			if(connection != null ) {
				pstmt = connection.prepareStatement(query);
			}
			if(pstmt != null) {
				resultset = pstmt.executeQuery();
			}
			if(resultset !=null) {
				System.out.println("Name\tbalance");
				while(resultset.next()) {
					System.out.println(resultset.getString(1)+ "\t" + resultset.getInt(2));
				}
			}
			
			System.out.println("Transection begins ::::: ");
			connection.setAutoCommit(false);
			
			pstmt.executeUpdate("update account_info set balance= balance-50000 where Name = 'sachin'");
			pstmt.executeUpdate("update account_info set balance= balance+50000 where Name = 'Dhoni'");
			
			System.out.println("Can you please confirm the transcetion is successfully done or not [yes/no]");
			Scanner scan = new Scanner(System.in);
			String option = scan.next();
			
			if(option.equalsIgnoreCase("yes")){
				connection.commit();
			}
			else {
				connection.rollback();
			}
			
			
			System.out.println(" data after transection ....");
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			if(rs !=null) {
				System.out.println("Name\tbalance");
				while(rs.next()) {
					System.out.println(rs.getString(1)+ "\t" + rs.getInt(2));
				}
			}
			
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
