import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class srt extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Jai Maharashtra</title>");
        out.println("</head>");
        out.println("<body bgcolor=red>");
        out.println("<h1>Jai Maharashtra!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
