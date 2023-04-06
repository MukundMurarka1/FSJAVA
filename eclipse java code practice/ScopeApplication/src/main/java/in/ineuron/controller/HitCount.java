package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/count")
public class HitCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter write =  response.getWriter();
		
		ServletContext context = getServletContext();
		Integer count = (Integer) context.getAttribute("hitcount");
		
		if(count == null ) {
			count = 1;
		}
		else {
			count++;
		}
		
		context.setAttribute("hitcount", count);
		
		write.println("<h1>The number of hit count is  :: "+count+"</h1>");
		
		write.close();
	}

}
