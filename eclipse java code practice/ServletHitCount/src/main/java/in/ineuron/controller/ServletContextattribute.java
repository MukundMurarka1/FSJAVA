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

/**
 * Servlet implementation class ServletContextattribute
 */
@WebServlet("/printattribute")
public class ServletContextattribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
		@Override 
    	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			PrintWriter write = response.getWriter();
			
			ServletContext contxt = getServletContext();
			contxt.setAttribute("Name", "mukund");
			contxt.setAttribute("Password", "mukund123");
			
			write.println("<html><head><title>Attribute Data </title></head> ");
			write.println("<body>");
			write.println("<center>");
			write.println("<h1 style='color : red'> Welcome to this dynamic servlet Attribute  :--</h1>");
			
			write.println("<table border ='1'>");
			write.println("<tr><th>Attriute Name</th><th>Attriute Password </th></tr>");
			
			Enumeration<String> attributeNames = contxt.getAttributeNames();
			while(attributeNames.hasMoreElements()) {
				String attributenames = (String) attributeNames.nextElement();
				Object attributevalue = contxt.getAttribute(attributenames);
				write.println("<tr>");
				write.println("<td>"+attributenames+"</td>");
				write.println("<td>"+attributevalue+"</td>");
				write.println("</tr>");
			}
			write.println("</table>");
			write.println("</center>");
			write.println("</body>");
			write.println("</html>");
			write.close();
			
	}



}
