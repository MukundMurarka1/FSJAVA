package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("Target Servlet .class file is loading...... ");
	}
	
	public TestServlet(){
		System.out.println("Test Servlet object is instantiated .......");
	}

	public void init() throws ServletException{
		System.out.println(" Test Servlet Object is inititalized ..........");
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter write =  response.getWriter();
		write.print("<h1> **********Welcone to this test servlet page *************</h1>");
	}
	
	public void distroy() {
		System.out.println("Test Servlet Object is destroy");
	}
	

}
