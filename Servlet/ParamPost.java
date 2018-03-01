import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ParamPost extends GenericServlet
{
    public void service(ServletRequest request, ServletResponse response)
    throws IOException, ServletException
    {
			  PrintWriter out = response.getWriter();
      	Enumeration e = request.getParameterNames();
				while(e.hasMoreElements())
				{
					String pname = (String)e.nextElement();
					out.print("Parameter Name : " +pname+ " => ");
					String pvalue = request.getParameter(pname);
					out.print("Parameter Value : " +pvalue+ " <br><br> ");
				}
        out.close();
    }
}
