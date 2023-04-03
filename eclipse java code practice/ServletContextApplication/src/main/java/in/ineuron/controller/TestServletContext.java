package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter write = response.getWriter();
		
		write.println("<html><head><title>Context param</title></head>");
		write.println("<body>");
		write.println("<center>");
		write.println("<h1 style='color:green; text-align:center'>welcome to this database information page </h1>");
		write.println("<table>");
		write.println("<th> Context Name </th><th> Context Value </th>");
		
		ServletContext context = getServletContext();
		Enumeration<String> parameternames = context.getInitParameterNames();
		
		while(parameternames.hasMoreElements()) {
			String parametername = (String) parameternames.nextElement();
			String parametervalue = context.getInitParameter(parametername);
			
			write.println("<tr>");
			write.println("<td>" +parametername+ "</td><td>" +parametervalue+ "</td>");
			
			write.println("</tr>");
		}
		
		write.println("</table>");
		write.println("</center>");
		write.println("</body>");
		write.println("</html>");
		
		
		
		
		write.close();
	}

}
