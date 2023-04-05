package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewPorject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("The implementation class name of servlet class is ");
		
		PrintWriter write = response.getWriter();
		write.println("<html><head><title> welcome to my project</title></head>");
		ServletConfig config = getServletConfig();
		ServletContext context = getServletContext();
		System.out.println("The config object class name :: " +config.getClass());
		System.out.println("The context object class name is :: "+context.getClass());
		System.out.println("The request object class name is :: "+request.getClass());
		System.out.println("The response object class name is :: "+response.getClass());
	}

}
