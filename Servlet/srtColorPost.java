import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class srtColorPost extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
				String color = request.getParameter("ColorPost");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<B> The SelectedColor is : ");
        out.println(color);
        out.close();
    }
}
