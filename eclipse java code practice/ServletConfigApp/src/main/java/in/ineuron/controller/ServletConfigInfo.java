package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter write = response.getWriter();
		
		response.setContentType("text/html");
		
		write.println("<center><h1 style='color:red;text-align:center'>Initialization of Parameter </h1></center></hr>");
		write.println("<table Border='1' align=center>");
		write.println("<tr><th>Parameter names</th><th>Parameter value</th></tr>");
		
		
		Enumeration<String> parameternames= getInitParameterNames();
		while(parameternames.hasMoreElements()) {
			String parameter = (String) parameternames.nextElement();
			String value = getInitParameter(parameter);
			
			write.println("<tr><td>" +parameter+"</td><td>" +value+ "</td></tr>");
		}
		
		write.println("</table>");
		write.close();
		
	}

}
