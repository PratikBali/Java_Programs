import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class DBconnect extends JFrame implements ItemListener
{
	JLabel l1,l2,l3;
	JTextField t1,t2;
	JComboBox cb;

	Statement stm;
	ResultSet rs;
	Connection cn=null;
	String sql;

	DBconnect()
	{
		setTitle("DB connect ComboBox");
		setSize(300,200);
		setLocation(250,200);
		setLayout(null);
		
		l1 = new JLabel("Roll No. ");
		l2 = new JLabel("Name ");
		l3 = new JLabel("Age ");
		
		cb = new JComboBox();

		t1= new JTextField();
		t2= new JTextField();
		t1.setEditable(false);
		t2.setEditable(false);

		add(l1);add(l2);add(l3);
		add(t1);add(t2);	
		add(cb);
		
		l1.setBounds(20,20,100,20);
		l2.setBounds(20,60,100,20);
		l3.setBounds(20,100,100,20);
		cb.setBounds(140,20,100,20);
		t1.setBounds(140,60,100,20);
		t2.setBounds(140,100,100,20);
				
		try
		{
			cn=DriverManager.getConnection("jdbc:mysql:///temp","root","987654321");
			stm=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=stm.executeQuery("select * from  mytable order by roll");
			while(rs.next())
				cb.addItem(rs.getString(1).toString());
		}	
		catch(Exception ex)
		{	ex.printStackTrace();
		}

		cb.addItemListener(this);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		try
		{
			if(e.getSource()==cb)
			{
				rs= stm.executeQuery("select * from mytable where roll="+(cb.getSelectedItem().toString()));
				rs.next();
				t1.setText(rs.getString(2));
				t2.setText(rs.getString(3));
			}
		}
		catch(Exception ex)
		{	ex.printStackTrace();
		}
	}
	
	public static void main(String a[])
	{
		new DBconnect();
	}
}

