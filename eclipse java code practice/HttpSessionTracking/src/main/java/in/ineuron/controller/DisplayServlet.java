package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet3")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String smobile = request.getParameter("smobile");
		String semail = request.getParameter("semail");
		
		HttpSession session = request.getSession(false);
		session.setAttribute("smobile", smobile);
		session.setAttribute("semail", semail);
		
		PrintWriter writer =  response.getWriter();
		
		writer.println("<html><head><title>Output</title></head>");
		writer.println("<body bgcolor='lightgreen'>");
		writer.println("<h1 style='color:red; text-align:center;'>Registration Details...</h1>");
		writer.println("<center>");
		writer.println("<table border='1'>");
		writer.println("<tr><th>NAME</th><th>VALUE</th></tr>");
		Enumeration<String> attributeNames = session.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String attributeName = (String) attributeNames.nextElement();
			Object attributeValue = session.getAttribute(attributeName);
			writer.println("<tr><td>" + attributeName + "</td><td>" + attributeValue + "</td></tr>");

		}
		writer.println("</table>");
		writer.println("</center>");
		writer.println("</body>");
		writer.println("</html>");
		System.out.println("Session id used is :: "+request.getRequestedSessionId());
		writer.close();

		
	}

}
