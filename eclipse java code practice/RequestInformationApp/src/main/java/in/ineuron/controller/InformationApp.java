package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reqinfo/ineuron/*")
public class InformationApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	PrintWriter write =  response.getWriter();
	write.println("<h1> Request url :: "+request.getRequestURI()+"</h1>");
	write.println("<h1> Context path :: "+request.getContextPath()+"</h1>");
	write.println("<h1>Servlet Path :: "+request.getServletPath()+"</h1>");
	write.println("<h1> Path Information :: "+request.getPathInfo()+"</h1>");
	write.println("<h1> Request Ip Address :: "+request.getRemoteAddr()+"</h1>");
	
	write.println("<h1> Query String :: "+request.getQueryString()+"</h1>");
	}

}
