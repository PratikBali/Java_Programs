import java.io.*;
import java.sql.*;

class dos2_disp
{
	public static void main(String arg[])
	{
		int cnt=0;
		Connection cn;
		Statement stm;
		ResultSet rs;
		try
		{
		cn=DriverManager.getConnection("jdbc:mysql:///temp","root","");
		stm=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs=stm.executeQuery("select * from  mytable");
		while(rs.next())
		{
			System.out.print("\n\t"+rs.getString(1)+"\t");
			System.out.print(rs.getString("name")+"\t");
			System.out.print(rs.getString("age"));
			cnt++;
		}
		rs.close();
		System.out.println("\n\n\t ***** Total no.of Records :\n"+cnt);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
}
