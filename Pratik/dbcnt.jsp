<%@ page import="java.sql.*"%>
<%
Connection cn=null;
Statement stmt=null;
ResultSet rs=null;
%>
<html>
<body>
<center><h1>
<% 
cn=DriverManager.getConnection("jdbc:mysql:///stud","root","");
stmt=cn.createStatement();
rs=stmt.executeQuery("select * from mytable");
		out.print("<table border=1>");		
				out.print("<tr><td> roll no </td><td> name </td><td> age </td></tr>");	
					while(rs.next())
						{			
								out.print("<tr><td>");
							  out.println(rs.getString(1));
								out.println("</td>");	

								out.print("<td>");
							  out.println(rs.getString(2));
								out.println("</td>");	

								out.print("<td>");
							  out.println(rs.getString(3));
								out.println("</td></tr>");	

						}
					out.print("<table>");
		rs.close();
%></h1>
</center>
</body>
</html>
