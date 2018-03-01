import java.io.*;
import java.sql.*;

class dos
{
	public static void main(String arg[])throws Exception
	{
		
		int bid,roll,mid;
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		Connection cn=null;
		PreparedStatement prstm;
		String sql;
		
		try
		{
		  cn=DriverManager.getConnection("jdbc:mysql:///library","root","");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("\n\t Enter bill no :");
			roll=Integer.parseInt(br.readLine());
		System.out.println("\n\t Enter book id :");
			bid=Integer.parseInt(br.readLine());
		System.out.println("\n\t Enter member id :");
			mid=Integer.parseInt(br.readLine());
		
		try
		{
			sql="insert into test values("+roll+",'"+bid+"',"+mid+")";
			prstm=cn.prepareStatement(sql);
			prstm.execute();
			prstm.close();
			System.out.println("\n\t ** Record Successfully Inserted **:"); 	
		}
		catch(SQLException e1)
		{ System.out.println(e1);  }
				
	}
}
