import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class ArithServlet extends HttpServlet
{
    public void service(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
      	PrintWriter pw = response.getWriter();
	
          String oper = request.getParameter("opt");

 	  int a = Integer.parseInt(request.getParameter("e"));
	  int b = Integer.parseInt(request.getParameter("p"));
	  
           if(oper.equals("add"))
         	  pw.println("Addition = "+(a+b) +"<br>");       
           if(oper.equals("sub"))
         	  pw.println("Subtraction = "+(a-b) +"<br>");       
           if(oper.equals("mul"))
         	  pw.println("Multiplication = "+(a*b) +"<br>");       
           if(oper.equals("div"))
         	  pw.println("Division = "+(a/b) +"<br>");       

	pw.close();
    }
}
