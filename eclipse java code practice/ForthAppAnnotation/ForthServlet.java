import javax.servlet.*;
import java.io.*;
import javax.servlet.annotation.*;


@WebServlet(urlPatterns="/test", loadOnStartup=10)
public class ForthServlet implements Servlet{

    static
    {
        System.out.println("Forth Servlet .class file is loading .....");
    }

    public ForthServlet(){
        System.out.println("Forth Servlet object instantiation.......");
    }

    public void init(ServletConfig config) throws ServletException {

        System.out.println("Forth Servlet object is instantiated successfully ");

    }

    public ServletConfig getServletConfig(){
        return null;

    }

    public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");

        PrintWriter write = response.getWriter();

        write.println("<html><head><title> OUTPUT</title><head>");
        write.println("<body>");
        write.println("<h1 style='color:red'><marquee>Working of thi servlet with Annotation...</marquee></h1>");
        write.println("</body>");
        write.println("</html>>");

        write.close();
    }

    public String getServletInfo(){
        return null;

    }

    public void destroy(){
        System.out.println("Servlet deinstatntiation is succcessfull ........");

    }


    
}
