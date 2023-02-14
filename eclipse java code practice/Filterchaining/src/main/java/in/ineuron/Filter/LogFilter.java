package in.ineuron.Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


public class LogFilter  implements Filter {
	private FilterConfig  config;
	
	static {
		System.out.println("Log.class file is loading ");
		
	}
	
	public  LogFilter() {
		System.out.println("Log Filter .class is instantiated .....");
	}
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	System.out.println("Log filter object is initialized ");
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter write = response.getWriter();
		write.print("<h1> this Line is added by  log filter before processing the request ........</h1>");
		
		ServletContext context = config.getServletContext();
		HttpServletRequest req = (HttpServletRequest) request; 
		context.log("A request.is coming form :: " +request.getRemoteHost()+" fro Url :: "+req.getRequestURI()+" at:: ");
		
		chain.doFilter(request, response);
		write.print("<h1> this Line is added by  log filter After processing the request ........</h1>");
	}
	
	
	public void destroy() {
		config=null;
		System.out.println("Log filter object is destroyed ");
	}

	
	
}
