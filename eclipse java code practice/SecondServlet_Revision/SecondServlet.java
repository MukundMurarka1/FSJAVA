
import java.io.*;
import javax.servlet.*;
public class SecondServlet implements Servlet{

    static
{
    System.out.println(" SecondServlet.calss file is loading ");
}

    public SecondServlet()
    {
        System.out.println("Second Servlet object is instantiated .....");
    }

    public void init(ServletConfig config) throws ServletException
    {
        System.out.println("Second servlet is initilized successfull ..... ");
    }

    public ServletConfig getServletConfig()
    {
        return null;

    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");  
        System.out.println("Servlet request processing logic is starting ......");

        PrintWriter write = response.getWriter();

        write.println("<html><head><title>OUTPUT</title></head>");
        write.println("<body>");
        write.println("<h1 style='color:red'><marquee> WELCOME TO ADVANCE JAVA COURSE </marquee></h1>");
        write.println("</body>");
        write.println("</html>");

        write.close();
    }


    public String getServletInfo()
    {
        return null;

    }
    public void destroy(){
        System.out.println("Servlet logic is Successfully executed Successfully ");
    }

}