import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class srtColor extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
				String color = request.getParameter("Color");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<B> The SelectedColor is : ");
        out.println(color);
        out.close();
    }
}
