package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("DispController Servlet. class file is loading .......");
	}
	
	public DispController(){
		System.out.println("DispController object is instantiated ........");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter write = response.getWriter();
		write.println("<html><head><title>Disp Controller </title></head>");
		write.println("<body>");
		write.println("<center>");
		
		write.println("<h1 style='color:red; text-align:center'>this is disp controller page</h1>");
		write.println("<table Border='1'>");
		
		write.println("<th>Context Name</th> <th>context value </th>");
		
		
		ServletContext context = getServletContext();
		Enumeration<String> parameternames = context.getInitParameterNames();
		
		while( parameternames.hasMoreElements()) {
			String parameter = (String) parameternames.nextElement();
			String value= context.getInitParameter(parameter);
			
			write.println("<tr>");
			write.println("<td>" +parameter+ "</td><td>" +value+"</td>");
			write.println("</tr>");
		} 
		write.println("</table>");
		write.println("</center>");
		write.println("</body>");
		write.println("</html>");

		write.close();

	}

}
