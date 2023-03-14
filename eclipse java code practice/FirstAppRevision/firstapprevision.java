
import java.io.*;
import javax.servlet.*;
public class firstapprevision implements Servlet
{

    static
    {
        System.out.println("firstApp Servlet .class file is loading is loading ......");
    }
    firstapprevision()
    {
        System.out.println("firstApp Servlet object is instantiation successfull  ......");
    }

    // For Servlet initialization container call this method automatically 

    public void init(ServletConfig config) throws ServletException
    {
            System.out.println(" first app servlet is initializaton........ ");
    }

    public ServletConfig getServletConfig()
    {
               return null; 
    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
    {
            System.out.println("Servlet request processing ......");

    }

    public String getServletInfo()
    {
            return null;
    }

    public void destroy()
    {
            System.out.println("Servlet is destroyed after performing all the logic.........");
    }

}