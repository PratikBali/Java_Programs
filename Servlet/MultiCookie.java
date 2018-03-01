import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MultiCookie extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
		String data  = request.getParameter("hobby");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");

        Cookie cookies[] = request.getCookies();
		if(cookies!=null)
		{
			for (int i = 0; i < cookies.length; i++)
			if(cookies[i].getValue().equals(data))
			{
				out.println("Cookies exists for : " + data);
				return;
			}
		}

		Cookie c = new Cookie("hobby",data);
		response.addCookie(c);
		out.println("Cookies added for Hobbies : " + data);
		out.println("</body> </html>");
   }
}
