import java.sql.*;

class dos4
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
					System.out.println("\t Enter the Roll to Search : ");
					roll = Integer.parseInt(br.readLine());

				if(rs.getInt(1)==roll)
				{
					System.out.println("\n\t"+rs.getString(1)+"\t");
					System.out.println(rs.getString("name")+"\t");
					System.out.println(rs.getString(3));
				}
				else
				{
					System.out.println("Recrd Not found");
				}
			
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
