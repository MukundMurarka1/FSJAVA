package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/color")
public class ColorName extends HttpServlet {
	private static final long serialVersionUID = 1L;

		@Override
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			PrintWriter write = response.getWriter();
			
			String color = request.getParameter("color");
			
			
			write.println("<body>");
			write.println("<center>");
			
			write.println("<h1 style='color:red; text-align:center'>Welcome to world of color </h1>");
			write.println("<form>");
			write.println("<table border='1' >");
			write.println("<tr>");
			write.println("<th>Color Name </th>");
			write.println("<td>");
			
			write.println("<input type='text' name ='color'>");
			write.println("</td>");
			
			write.println("</tr>");
			write.println("<tr>");
			write.println("<th>Submit </th>");
			write.println("<td>");
			write.println("<input type='submit' name='submit'>");
			write.println("</td>");
			write.println("</tr>");
			write.println("</table>");
			write.println("</form>");
			
			System.out.println(color);
			
			write.println("<div style='height:100px; width:100px; border:1px solid; background-color:"+color+"'>the new box </div>");
			write.println("</center>");
			write.println("</body>");
			write.close();
	}

}
