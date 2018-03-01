<html>
<head><title> JAI MAHARASHTRA</title></head>
<body>
<center><h1 > Your Selected Item is

<%
    String oper[] = request.getParameterValues("item");
	if(oper!=null)
	{
		for(int i=0; i<oper.length; i++)
		{
			out.println("<br>" +oper[i]+"<b>");
		}
	}
	else
	out.println("<b> None");
%>

</body>
</html>
