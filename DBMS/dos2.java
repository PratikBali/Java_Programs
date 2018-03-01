import java.io.*;
import java.sql.*;

class dos2
{
	public static void main(String arg[])throws Exception
	{
		String name;
		int roll,age,ch=0,flag=0;
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		Connection cn=null;
		PreparedStatement prstm;
		String sql;
		
		try
		{
		  cn=DriverManager.getConnection("jdbc:mysql:///temp","root","");
		}
		catch(Exception e)	{  e.printStackTrace();  }

		while(ch!=5)
		{
			System.out.println("\n\n\t  ****** Menu *****");
			System.out.println("\t 1] Insert :");	
			System.out.println("\t 2] Delete :");
			System.out.println("\t 3] Update :");
			System.out.println("\t 4] Display:");
			System.out.println("\t 5] Search:");
			System.out.println("\t 6] Exit:");
			System.out.println("\n\t Enter your choice:");
			ch=Integer.parseInt(br.readLine());

			switch(ch)
			{
				case 1://insert
					System.out.println("\n\t Enter the Roll no :"); roll=Integer.parseInt(br.readLine());
					System.out.println("\n\t Enter the Name :");    name=br.readLine();
					System.out.println("\n\t Enter the Age :"); age=Integer.parseInt(br.readLine());

					try
					{
						sql="insert into mytable values("+roll+",'"+name+"',"+age+")";
						prstm=cn.prepareStatement(sql);
						prstm.execute();	prstm.close();
						System.out.println("\n\t\t\t ******* Record Successfully Inserted ******\n\n"); 	
					}

					catch(SQLException e1)
					{
						System.out.println(e1);
					}
					break;
				
				case 2://Delete
					System.out.println("\n\t Enter the Roll no to Delete :");
					roll=Integer.parseInt(br.readLine());
				
					try
					{
						sql="delete from mytable where roll=("+roll+")";
						prstm=cn.prepareStatement(sql);
						prstm.execute();	prstm.close();
						System.out.println("\n\t\t\t ******* Record Successfully Deleted ********\n\n"); 	
					}

					catch(SQLException e1)
					{
						System.out.println(e1);
					}
					break;
					
				case 3://update
					System.out.println("\n\t Enter the Roll no to Update :");
						roll=Integer.parseInt(br.readLine());
					System.out.println("\n\t Enter the Name :");    
						name=br.readLine();
					System.out.println("\n\t Enter the Age :"); 
						age=Integer.parseInt(br.readLine());
					try
					{
						sql="update mytable set name='"+name+"',age="+age+ " where Roll="+roll;
						prstm=cn.prepareStatement(sql);
						prstm.execute();	prstm.close();
						System.out.println("\n\t\t\t ********** Record Successfully Updated ********\n\n"); 	
					}

					catch(SQLException e1)
					{
						System.out.println(e1);
					}
					break;
					
				case 4://display all
					int cnt=0;
					Statement stm;
					ResultSet rs;
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
					System.out.print("\n\n\t ***** Total no.of Records : \n"+cnt);
					break;

				case 5://search
					stm=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					rs=stm.executeQuery("select * from  mytable");
					System.out.println("Enter roll no to be search.");
					roll=Integer.parseInt(br.readLine());
					
					while(rs.next())
					{
						if(rs.getInt(1)==roll)
						{
							flag=1;
							System.out.println("\t Roll = "+rs.getString(1)+"\t");
							System.out.println("\t Name = "+rs.getString(2)+"\t");
							System.out.println("\t Age  = "+rs.getString(3));
						}
					}
					if(flag==1)
					System.out.println(" Found \n\n");
					else
					System.out.println("\n Not Found \n\n");
					rs.close();
					break;
					
				case 6:
					System.exit(0);
					break;
			}//switch
		}//while
	}//main
}//class
