
import java.io.*;
import javax.servlet.*;
import javax.sql.rowset.serial.SerialException;

public class Second_Servlet implements Servlet{

    static
{
    System.out.println(" SecondServlet.calss file is loading ");
}

    public Second_Servlet()
    {
        System.out.println("Second Servlet object is instantiated .....");
    }

    public void init (ServletConfig config) throws SerialException
    {
        System.out.println("Second servlet is initilized successfull ..... ");
    }

    public ServletConfig getServletConfig()
    {
        return null;

    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
    {
            System.out.println("Servlet request processing logic is starting ......");
    }

    public String getServletInfo()
    {
        return null;

    }
    public void destroy(){
        System.out.println("Servlet logic is Successfully executed Successfully ");
    }

}