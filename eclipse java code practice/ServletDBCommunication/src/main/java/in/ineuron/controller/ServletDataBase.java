package in.ineuron.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
		
	}

}
