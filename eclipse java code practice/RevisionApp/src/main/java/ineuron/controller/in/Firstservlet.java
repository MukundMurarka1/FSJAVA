package ineuron.controller.in;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Firstservlet implements Servlet {
	
	static {
		System.out.println("FirstServlet.class file is loading.......");
	}

	public Firstservlet(){
		System.out.println("FirstServlet object is instantiated ......");
	}
	
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Servlet is initialized.......");
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Servlet request processing started ");
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}
