package in.ineuron.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class ServletDataBase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection connection = null;
	
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully ......");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		System.out.println();
	}
	
	public void init() throws ServletException
	{
		String url = getInitParameter("url");
		String username = getInitParameter("username");
		String password= getInitParameter("password");
		
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		try {
			connection = DriverManager.getConnection(url,username,password);
			if(connection != null) {
			
			System.out.println("Connection established succesfully .......");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ResultSet resultset = null;
		
		String query = "select * from studentdetails";
		
		try {
			Statement stmt = connection.createStatement();
			
			System.out.println("Statement created successfully ........");
			
			resultset = stmt.executeQuery(query);
			
			System.out.println("First_Name/Last_name/Roll_no/Address/Mobile_number");
			
			while(resultset.next()) {
				
				String firstname= resultset.getString(1);
				String lastname = resultset.getString(2);
				String rollno = resultset.getString(3);
				String address = resultset.getString(4);
				String mobileno = resultset.getString(5);
				
				System.out.println(firstname+ "/t" +lastname+ "/t" +rollno+ "/t" +address+ "/t" + mobileno);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
