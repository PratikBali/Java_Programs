import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*; 

class DispRecord extends JFrame implements ItemListener
{
	JComboBox cb;
	JLabel lbl_roll,lbl_name,lbl_age;
	JTextField tf_name,tf_age;
	
	String sql;
	Connection cn=null;
	Statement stm;
	ResultSet rs;
	
	DispRecord()
	{
		setTitle("Display record using JComboBox");
		setSize(270,200);
		setLocation(100,100);
		setLayout(null);
		
		cb = new JComboBox();
		lbl_roll = new JLabel("Select Roll No.");
		lbl_name = new JLabel("Name ");
		lbl_age = new JLabel("Age");
		tf_name = new JTextField();
		tf_age = new JTextField();
		
		add(cb); add(lbl_roll);	add(lbl_name);	add(lbl_age);	add(tf_name);	add(tf_age);
		tf_name.setEditable(false);
		tf_age.setEditable(false);		

		lbl_roll.setBounds(20,20,100,20);
		lbl_name.setBounds(20,60,100,20);
		lbl_age.setBounds(20,100,100,20);
		cb.setBounds(140,20,100,20);
		tf_name.setBounds(140,60,100,20);
		tf_age.setBounds(140,100,100,20);
		
		try
		{cn = DriverManager.getConnection("jdbc:mysql:///temp","root","");
		 stm = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 rs= stm.executeQuery("Select * from mytable order by roll");
		 	while(rs.next())
			cb.addItem(rs.getString(1).toString());
		}
		catch(Exception e)
		{e.printStackTrace();
		 JOptionPane.showMessageDialog(null,"Error","Error",JOptionPane.ERROR_MESSAGE);
		}

		cb.addItemListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void itemStateChanged(ItemEvent e)
	{
		sql = "select * from mytable where roll="+cb.getSelectedItem().toString();
		try
		{
			rs = stm.executeQuery(sql);
			rs.next();
			tf_name.setText(rs.getString(2));
			tf_age.setText(rs.getString(3));
		}
		catch(SQLException ex)
		{	ex.printStackTrace();
		}
	}
	
	public static void main(String a[])
	{
		new DispRecord();
	}	
}