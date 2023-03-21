import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns="/disp")
public class FifthAppAnnotation extends GenericServlet
{

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
    {
        PrintWriter write = response.getWriter();

        write.println("<h1 style='color:blue;'>Generic servlet is easy in comparison to normal servlet</h1>");

        write.close();
    }
}