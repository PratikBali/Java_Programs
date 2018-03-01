<%@ page language="java" import="java.util.*" %>
<html>
<head><title> Even No. Program in JSP </title></head>
<body>
<h1> List of Even No. = <br>

<%
for(int i=0; i<=100; i++)
{
	if((i%2)==0)
	{
		out.print(Integer.toString(i));
		out.print(" ");
	}
}
%>

</body>
</html>
