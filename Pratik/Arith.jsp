<html>
<head><title></title></head>
<body>
<center><h1 > 

<%
    String oper = request.getParameter("opt");

 	int a = Integer.parseInt(request.getParameter("e"));
	int b = Integer.parseInt(request.getParameter("p"));
	  
    if(oper.equals("add"))
        out.println("Addition = "+(a+b) +"<br>");       
    if(oper.equals("sub"))
		out.println("Subtraction = "+(a-b) +"<br>");       
    if(oper.equals("mul"))
		out.println("Multiplication = "+(a*b) +"<br>");       
    if(oper.equals("div"))
        out.println("Division = "+(a/b) +"<br>");      
%>

</form>
</body>
</html>
