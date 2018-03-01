import java.sql.*;

class dos3
{
	public static void main(String a[])
	{
		int cnt=0;
		Connection cn;
		Statement stm;
		ResultSet rs;
		try
		{
			cn = DriverManager.getConnection("jdbc:mysql:///temp","root","");
			stm = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

			rs= stm.executeQuery("Select * from mytable");
			while(rs.next())
			{
				System.out.println("\n\t"+rs.getString(1)+"\t");
				System.out.println(rs.getString("name")+"\t");
				System.out.println(rs.getString(3));
				cnt++;
			}
			rs.close();
			System.out.println("\n\n\t *** Total No Of Records : "+cnt);
		}
		catch(Exception ex)
		{
				System.out.println(ex);
		}
	}
}
