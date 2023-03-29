package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/check")
public class RequestResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter write = response.getWriter();
		
		LocalDateTime date = LocalDateTime.now();
		int hour = date.getHour();
		
		System.out.println(hour);
		
		String msg ="";
		
		if(hour < 12) {
			msg += "Good Morning";
		}else if(hour <16) {
			msg += "Good AfterNoon";
		}else if(hour <20) {
			msg +="good Evening";
		}else {
			msg += "Good Night";
		}
		
		write.println("<h1 style='color:lightgreen; text-align:center'>Welcome to this time </h1>");
		write.println("<h1 style='color:blue; text-align:center'>The Current date and time is :: "+date+" </h1>");
		write.println("<h1 style='color:blue; text-align:center'>Greeting from the server :: "+msg+"</h1>");
		
		
		write.close();
	}

}
