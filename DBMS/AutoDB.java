import java.io.*;
import java.sql.*;

class AutoDB
{
	public static void main(String arg[])throws Exception
	{
		String DBname;
		int flag=0,cnt=0;
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			
		Connection cn=null;
		ResultSet rs;
		Statement stm;
		String sql;

		try
		{
			//cn=DriverManager.getConnection("jdbc:mysql:///AutoCreate","root","");
			stm=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=stm.executeQuery("show databases");
			
			while(rs.next())
			{
				System.out.print("\n\t"+rs.getString(1)+"\t");
				cnt++;
			}
			rs.close();
			//cn.close();
		
			System.out.print("\n\n\t ***** Total no.of Records : \n"+cnt);
		}
		catch(Exception e)	{  e.printStackTrace();  }
	}
}