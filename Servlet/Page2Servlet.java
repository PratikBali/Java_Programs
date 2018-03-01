import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Page2Servlet extends HttpServlet
 {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				
        int sum2=0;
				String values[]=request.getParameterValues("item");
				if(values!=null)
				{
					for(int i=0; i<values.length;i++)
					sum2+=Integer.parseInt(values[i]);
				}
        
        HttpSession session = request.getSession();
				int sum1 =((Integer)session.getAttribute("page1")).intValue();
				out.println("<html>");
				out.println("<title> Summary </title><body>");
				out.println("<b> Total of page 1 = " + sum1 + "\n <br>");
				out.println("<b> Total of page 2 = " + sum2 + "\n <br><br>");
		int total = sum1 + sum2;
				out.println("<b> Total Bill = " + total);
				out.println("</html></body>");
    }
}
