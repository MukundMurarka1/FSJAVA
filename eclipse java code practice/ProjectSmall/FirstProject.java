import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns="/reg")
public class FirstProject extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("The request type is :: " +request.getMethod());

        String username = request.getParameter("username");
        String useremail = request.getParameter("useremail");
        String useradd = request.getParameter("useraddress");
        String[] course = request.getParameterValues("courses");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>OUTPUT</title></head>");
        out.println("<body>");
        out.println("<h1>Student Ragistration Details </h1>");
        out.println("<center>");
        out.print("<table Border = '1'>");
        
        out.println("<tr><th>Name</th><td>"+username+"</td></tr>");
        out.println("<tr><th>User Email</th><td>"+useremail+"</td></tr>");
        out.println("<tr><th>Address</th><td>"+useradd+"</td></tr>");
        out.println("<tr><th>COURSES</th>");
        String data = "";
        for(String courses : course){
            data += courses+" ";
        }
        out.println("<td>"+data+"</td>");
        out.println("</tr>>");
        out.println("</table>");
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
}
