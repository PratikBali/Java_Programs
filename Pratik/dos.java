import java.io.*;
import java.sql.*;

class dos
{
	public static void main(String arg[])throws Exception
	{		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		Connection cn=null;
		PreparedStatement prstm;
		Statement stm=null;
		String sql,db;
		ResultSet rs=null;
		int flag=0;
		
		try
		{
			rs=stm.executeQuery("show databases");
			stm=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("\n\t Enter Database name : ");
		db=br.readLine();
		
		while(rs.next())
		{
			if(rs.getString(1).equals(db))
			{
				try
				{
					cn=DriverManager.getConnection("jdbc:mysql:///"+db+"","root","");
					System.out.println("\n Database already exists \n");
					//String createTable="create table pune(restaurants varchar(50), Hotels varchar(50)  )";
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		
		
		
		else
		{
			try
			{
				sql="create database "+db;
				prstm=cn.prepareStatement(sql);
				prstm.execute();
				prstm.close();
				System.out.println("\n\t ** Database created **:"); 

				String useDB="use "+db;
				prstm=cn.prepareStatement(useDB);
				prstm.execute();
				prstm.close();
				System.out.println("\n\t ** Database changed **:"); 
			}
			catch(SQLException e1)
			{ System.out.println(e1);  }
			
		}
		}
	}
}
