package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname= request.getParameter("fname");
		String lname= request.getParameter("lname");
		String sroll= request.getParameter("rollno");
		String sadd= request.getParameter("add");
		String smbn= request.getParameter("mobileno");
		
		
		 String insertquery ="insert into studentdetails(`first_name`,`last_name`,`roll_no`,`address`,`mobile_no`) values(?,?,?,?,?)";
		
		PrintWriter write = response.getWriter();
		
		//load the driver 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("driver loaded successfully ");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  // create connection
		
		try ( Connection conn= DriverManager.getConnection("jdbc:mysql:///student","root","Mukund@1996");
				PreparedStatement stmt = conn.prepareStatement(insertquery)){
			
			System.out.println("connection established successfully ");
			
			stmt.setString(1,fname);
			stmt.setString(2, lname);
			stmt.setString(3,sroll);
			stmt.setString(4, sadd);
			stmt.setString(5, smbn);
			
			
			int row = stmt.executeUpdate();
			
			if(row == 0) {
				write.print("<h1>record not inserted</h1>");
			}else {
				write.print("<h1>Record inserted successfully </h1>");
			}
			
			
		} catch (SQLException se) {
			write.println(se.getMessage());
			
			se.printStackTrace();
		} catch (Exception e ) {
			write.println(e.getMessage());
			e.printStackTrace();
		}

		write.close();
		
	}

}
