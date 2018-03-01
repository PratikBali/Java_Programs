import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class ComboListenerRemoveAdd extends JFrame implements ItemListener
{
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2;
	JComboBox cb1,cb2,cb3;

	Statement stm;
	ResultSet rs;
	Connection cn=null;
	String sql;

	ComboListenerRemoveAdd()
	{
		setTitle("DB connect ComboBox");
		setSize(300,400);
		setLocation(250,100);
		setLayout(null);
		
		l1 = new JLabel("Select Field");
		l2 = new JLabel("Select class");
		l3 = new JLabel("Select Roll No.");
		l4 = new JLabel("*** Data ***");
		l5 = new JLabel("Name ");
		l6 = new JLabel("Age ");
		
		cb1 = new JComboBox();
		cb2 = new JComboBox();
		cb3 = new JComboBox();

		t1= new JTextField();
		t2= new JTextField();
		t1.setEditable(false);
		t2.setEditable(false);

		add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);
		add(t1);add(t2);	
		add(cb1);add(cb2);add(cb3);
		
		l1.setBounds(20,20,100,20);
		l2.setBounds(20,60,100,20);
		l3.setBounds(20,100,100,20);
		l4.setBounds(100,140,100,20);
		l5.setBounds(20,180,100,20);
		l6.setBounds(20,220,100,20);
		
		cb1.setBounds(140,20,100,20);
		cb2.setBounds(140,60,100,20);
		cb3.setBounds(140,100,100,20);
		
		t1.setBounds(140,180,100,20);
		t2.setBounds(140,220,100,20);
				
		try
		{
			cn=DriverManager.getConnection("jdbc:mysql:///combo","root","987654321");
			stm=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

			rs=stm.executeQuery("select distinct field from demo");
			while(rs.next())
				cb1.addItem(rs.getString(1));

			rs=stm.executeQuery("select distinct class from demo");
			while(rs.next())
				cb2.addItem(rs.getString(1));

			rs=stm.executeQuery("select distinct roll from demo");
			while(rs.next())
				cb3.addItem(rs.getString(1));
		}	
		catch(Exception ex)
		{	ex.printStackTrace();
		}

		cb1.addItemListener(this);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		try
		{
			if(e.getSource()==cb1)
			{
				String sql;
				sql = ("select distinct field from demo where field="+(cb1.getSelectedItem().toString()));
				rs= stm.executeQuery(sql);
				rs.next();
				/*	cb2.addItem(rs.getString(2));
					cb2.addItemListener(this);
				if(e.getSource()==cb2)
				{
					if(cb2.getselectedindex()==0)
					{
						rs= stm.executeQuery("select distinct class from demo where class="+(cb2.getSelectedItem().toString()));
						rs.next();
					}
				}*/
			}		
		}
		catch(Exception ex)
		{	ex.printStackTrace();
		}
	}
	
	public static void main(String a[])
	{
		new ComboListenerRemoveAdd();
	}
}



