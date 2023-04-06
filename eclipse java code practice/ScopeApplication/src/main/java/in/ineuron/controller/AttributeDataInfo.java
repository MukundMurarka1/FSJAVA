package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/datainfo")
public class AttributeDataInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter write = response.getWriter();
		
		ServletContext context = getServletContext();
		context.setAttribute("name", "Mukund");
		context.setAttribute("Address", "Basopatti");
		
		write.println("<html><head><title>data information</title></head>");
		
		write.println("<body>");
		write.println("<center>");
		write.println("<h1 style='color:red'>Dynamic information in Application Scope is </h1>");
		write.println("<table Border='1'>");
		write.println("<tr><th> Attribute Names</th><th>Attribute Value </th></tr>");
		
		Enumeration<String> attributenames = context.getAttributeNames();
		while(attributenames.hasMoreElements()) {
			String attributename = (String) attributenames.nextElement();
			Object attributevalue = context.getAttribute(attributename);
			write.println("<tr>");
			write.println("<td>" +attributename+ "</td><td>" +attributevalue+ "</td>");
			write.println("</tr>");
			
		}
		write.println("</table>");
		write.println("</center>");
		write.println("</body>");
		write.println("</html>");
		write.close();
	}

}
