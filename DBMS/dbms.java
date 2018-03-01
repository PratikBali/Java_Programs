import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*; 

class dbms extends JFrame implements ActionListener
{
	String sql;
	Connection cn=null;
	PreparedStatement ps;
	Statement stm;
	ResultSet rs;
	
	dbms()
	{
		setTitle("Simple Database frame");
		setSize(500,500);
		setLocation(100,100);
		setLayout(null);
		
		try
		{cn = DriverManager.getConnection("jdbc:mysql:///temp","root","");
		 stm = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 rs= stm.executeQuery("Select * from mytable");
		}
		catch(Exception e)
		{e.printStackTrace();
		 JOptionPane.showMessageDialog(null,"Error","Error",JOptionPane.ERROR_MESSAGE);
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
		}
		catch(Exception ex)
		{	ex.printStackTrace();
		}
	}
	
	public static void main(String a[])
	{
		new dbms();
	}	
}