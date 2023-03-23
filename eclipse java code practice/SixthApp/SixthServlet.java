import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(urlPatterns="/text")
public class SixthServlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // System.out.println("The Request method type is :: == GET");
        // String username = request.getParameter("username");
        // System.out.println("the user nameof the user is :  "+username);

        doProcess(request, response);

    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // System.out.println("The Request method type is :: == POST");

        // String username = request.getParameter("username");
        // System.out.println("the user nameof the user is :  "+username);

        doProcess(request, response);

    }

    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("The Request method type is :: == " +request.getMethod());
        String username = request.getParameter("username");
        System.out.println("the user nameof the user is :  "+username);
    }
}
