<%@ page import="java.sql.*" %>
<html>
<head><title> DBMS connection </title></head>
<body>
<% 
	Connection cn=null;
	ResultSet rs=null;
	Statement stm=null;
	cn = DriverManager.getConnection("jdbc:mysql:///temp","root","");
	stm = cn.createStatement();
	rs = stm.executeQuery("select * from mytable");
	out.println("<table border=1>")
	out.println("<tr><td> Roll no </td> <td> Name </td></tr>");
	while(rs.next())
	{
		out.println("<tr><td>");
		out.println(rs.getString(1));
		out.println("</td>");

		out.println("<td>");
		out.println(rs.getString(2));
		out.println("</td></tr>");
	}
	out.println("</table>");
	rs.close();
%>
</body>
</html>