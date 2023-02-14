package in.ineuron.Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


public class DemoFilter implements Filter {
	
	static {
		System.out.println("Demofilter .class file is loaded ");
	}
	public DemoFilter(){
		System.out.println("DemoFilter Object file is instantiated..........");
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("DemoFilter Object  file is initialized ");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter write = response.getWriter();
		write.print("<h1> This Line is added by demo Filter before processing the request ...........</h1>");
		chain.doFilter(request, response);
		write.print("<h1> This Line is added by demo filetr after processing the request............</h1>");
	}
	public void destroy() {
		
		System.out.println("Demo Filter Object is destroy  ");
	}


}
