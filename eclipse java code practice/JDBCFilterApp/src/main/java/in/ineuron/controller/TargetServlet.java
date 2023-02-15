package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		PrintWriter write = response.getWriter();
		
		write.print("first name :- "+fname+ "last name:- "+lname+ "roll no :- "+sroll+ "Address :- "+sadd+ "mobile no :- "+smbn);
	}

}
