import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Page1Servlet extends HttpServlet
 {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        int sum=0;
				String values[]=request.getParameterValues("item");
				if(values!=null)
				{
					for(int i=0; i<values.length;i++)
					sum+=Integer.parseInt(values[i]);
				}
        
        HttpSession session = reques
t.getSession(true);
				session.setAttribute("page1",sum);
				response.sendRedirect("page2.html");
    }
}
