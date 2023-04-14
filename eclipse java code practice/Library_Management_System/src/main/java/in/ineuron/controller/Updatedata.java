package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		urlPatterns = { "/update" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql:///student"), 
				@WebInitParam(name = "username", value = "root"), 
				@WebInitParam(name = "password", value = "root123")
		},loadOnStartup = 10)
public class Updatedata extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection =  null;
	PreparedStatement pstmt = null;
	
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void init() throws ServletException{
		
		
		
		String ur1 = getInitParameter("url");
		String username = getInitParameter("username");
		String password = getInitParameter("password");
		
		try {
			connection = DriverManager.getConnection(ur1,username, password );
			if(connection != null) {
				System.out.println("connection Established successfully....");
			}
		}catch(SQLException se) {
		
			se.printStackTrace();
		}
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 PrintWriter write =  response.getWriter();	
	 
	 
	}

}