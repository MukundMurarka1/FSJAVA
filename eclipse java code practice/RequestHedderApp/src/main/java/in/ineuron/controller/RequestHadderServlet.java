package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestHadderServlet
 */
@WebServlet("/test")
public class RequestHadderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter write = response.getWriter();
		write.println("<body>");
		write.println("<center>");
		
		write.println("<h1 style='color:red; text-align:center'> Request hadder Application </h1>");
		write.println("<table border='1'");
		write.println("<tr><th>Request Hadder</th><th>Request Value</th></tr>");
		
		
		
		Enumeration<String> headernames=request.getHeaderNames();
		while(headernames.hasMoreElements()) {
			write.println("<tr>");
			
			String header = (String) headernames.nextElement();
			String value = request.getHeader(header);
			
			write.println("<td>"+header+"</td>");
			write.println("<td>"+value+"</td>");
			write.println("</tr>");
		}
		write.println("</table");
		write.println("</center>");
		write.println("</body>");
		write.close();
	}

}
