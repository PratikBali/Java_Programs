<html>
<head>
<title> even number program in jsp<title></head>
<body>
<center><h1>
<%
String oper = request.getParameter("opt");

 	  int a = Integer.parseInt(request.getParameter("t1"));
	  int b = Integer.parseInt(request.getParameter("t2"));
	  
           if(oper.equals("add"))
         	  out.println("Addition = "+(a+b) +"<br>");       
           if(oper.equals("sub"))
         	  out.println("Subtraction = "+(a-b) +"<br>");       
           if(oper.equals("mult"))
         	  out.println("Multiplication = "+(a*b) +"<br>");       
           if(oper.equals("div"))
         	  out.println("Division = "+(a/b) +"<br>");       

%>
</center>
</body>
</html>
