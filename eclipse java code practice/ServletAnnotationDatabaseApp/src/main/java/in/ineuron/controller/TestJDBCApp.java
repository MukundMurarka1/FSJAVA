package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "/test" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql:///student"), 
				@WebInitParam(name = "username", value = "root"), 
				@WebInitParam(name = "password", value = "root123")
		},loadOnStartup = 10)
public class TestJDBCApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection connection = null; 
	
	static{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loded successfully .......");
		}catch(ClassNotFoundException ce){
			
			ce.printStackTrace();
			
		}
	}
	
	@Override
	public void init() throws ServletException{
		
		
		String url = getInitParameter("url");
		String username = getInitParameter("username");
		String password = getInitParameter("password");
		
		System.out.println( url+ "" + username+ " " +password);
		
		try {
			connection = DriverManager.getConnection(url,username,password);
			if(connection != null) {
			System.out.println("connection established successfully.....");
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
		
	}
	
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		
		
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String roll = request.getParameter("rollno");
		String address  = request.getParameter("address");
		String mobile = request.getParameter("mobileno");
		
		String insertquery = "insert into studentdetails(first_name, last_name, roll_no, address, mobile_no ) values(?,?,?,?,?)";
		
		try {
			if(connection != null) 
			{
				pstmt = connection.prepareStatement(insertquery);
				System.out.println("connection established successfully.....");
				PrintWriter write = response.getWriter();
				if(pstmt != null) {
					pstmt.setString(1, fname);
					pstmt.setString(2, lname);
					pstmt.setString(3, roll);
					pstmt.setString(4, address);
					pstmt.setString(5, mobile );
					
					int row = pstmt.executeUpdate();
					
					if(row == 1 ) {
						write.println("<h1 style='color:red; text-align:center'>Ragistration Successfully </h1>");
												
					}else {
						write.println("<h1 style='color:red;text-align:center'>some error occured </h1>");
					}
					
				}
				
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
		
	}

	@Override
	public void destroy(){
		try {
			if(connection != null) {
				connection.close();
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
	}
	
}

