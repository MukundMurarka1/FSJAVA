import javax.servlet.*;
import javax.sql.rowset.serial.SerialException;

import java.io.*;

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

    public void service(ServletRequest request, servletResponse response) throws IOException, SerialException{

    }

    public string getServletInfo(){
        return null;

    }

    public void destroy(){

    }


    
}
