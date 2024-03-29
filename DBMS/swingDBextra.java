import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class swingDBextra extends JFrame implements ActionListener
{
	JButton btn_clr,btn_ins,btn_upd,btn_del,btn_srch,btn_first,btn_next,btn_prev,btn_last;
	JLabel lbl_roll,lbl_name,lbl_age;
	JTextField tf_roll,tf_name,tf_age;

	String sql;
	int flag=0;

	Connection cn=null;
	PreparedStatement ps;
	Statement stm;
	ResultSet rs;

	swingDBextra()
	{
		setTitle("Swing with Database");
		setSize(500,500);
		setLocation(100,100);
		setLayout(null);

		btn_clr = new JButton("Clear");
		btn_ins = new JButton("Insert");
		btn_upd = new JButton("Update");
		btn_del = new JButton("Delete");
		btn_srch = new JButton("Search");

		btn_first = new JButton("First");
		btn_next = new JButton("Next");
		btn_prev = new JButton("Prev");
		btn_last = new JButton("Last");

		lbl_roll = new JLabel("Enter Roll No.      : ");
		lbl_name = new JLabel("Enter Name No.   : ");
		lbl_age = new JLabel("Enter Age No.      : ");

		tf_roll = new JTextField();
		tf_name = new JTextField();
		tf_age = new JTextField();

		add(lbl_roll);add(lbl_name);add(lbl_age);
		add(tf_roll);add(tf_name);add(tf_age);
		add(btn_clr);add(btn_ins);add(btn_upd);add(btn_del);add(btn_srch);
		add(btn_first);add(btn_last);add(btn_prev);add(btn_next);

		lbl_roll.setBounds(10,10,150,20);
		lbl_name.setBounds(10,40,150,20);
		lbl_age.setBounds(10,70,150,20);

		tf_roll.setBounds(230,10,210,20);
		tf_name.setBounds(230,40,210,20);
		tf_age.setBounds(230,70,210,20);

		btn_clr.setBounds(10,110,100,20);
		btn_ins.setBounds(120,110,100,20);
		btn_upd.setBounds(230,110,100,20);
		btn_del.setBounds(340,110,100,20);
		btn_srch.setBounds(10,150,100,20);

		btn_first.setBounds(10,190,100,20);
		btn_next.setBounds(120,190,100,20);
		btn_prev.setBounds(230,190,100,20);
		btn_last.setBounds(340,190,100,20);

		btn_clr.addActionListener(this);
		btn_ins.addActionListener(this);
		btn_upd.addActionListener(this);
		btn_del.addActionListener(this);
		btn_srch.addActionListener(this);

		btn_first.addActionListener(this);
		btn_next.addActionListener(this);
		btn_prev.addActionListener(this);
		btn_last.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		try
		{	cn = DriverManager.getConnection("jdbc:mysql:///temp","root","");
			stm = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs= stm.executeQuery("Select * from mytable");
			rs.first();
			display();
		}
		catch(Exception e)
		{e.printStackTrace();
		}
	}

public void display()
{
	try
	{
		tf_roll.setText(rs.getString(1));
		tf_name.setText(rs.getString(2));
		tf_age.setText(rs.getString(3));
	}
	catch(Exception ex)
	{	ex.printStackTrace();
	}
}

public void refresh()
{
	try
	{
		rs = stm.executeQuery("select * from mytable order by roll");
		rs.next();
		display();
		ps.close();
	}
	catch(Exception ex)
	{	ex.printStackTrace();
	}
	
}

	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==btn_first)
			{rs.first();
			 display();
			}

				if(e.getSource()==btn_last)
				{rs.last();
				 display();
				}

				if(e.getSource()==btn_next)
				{rs.next();
					if(rs.isAfterLast())
					rs.last();
					display();
				}

				if(e.getSource()==btn_prev)
				{rs.previous();
					if(rs.isBeforeFirst())
					 rs.first();
					 display();
				}

				if(e.getSource()==btn_srch)
				{	
					rs= stm.executeQuery("Select * from mytable");
					int rl = Integer.parseInt(tf_roll.getText());				
					while(rs.next())
					{
						if(rs.getInt(1)==rl)
						{
							flag=1;
							JOptionPane.showMessageDialog(null,"Roll No : "+rs.getString(1)+" Name : "+rs.getString(2)+" Age : "+rs.getString(3));
						}
					}
					if(flag==1)
					JOptionPane.showMessageDialog(null,"Record Found");
					else
					JOptionPane.showMessageDialog(null,"Record Not Found");
					rs.close();
				}

				if(e.getSource()==btn_clr)
				{
					tf_roll.setText("");
					tf_name.setText("");
					tf_age.setText("");
					tf_roll.requestFocus();
				}

				if(e.getSource()==btn_ins)
				{
					sql = "insert into mytable values("+tf_roll.getText()+",'"+tf_name.getText()+"',"+tf_age.getText()+")";
					ps = cn.prepareStatement(sql);
					ps.execute();
					ps.close();
					JOptionPane.showMessageDialog(null,"Record Inserted Successfully");
					refresh();
				}

				if(e.getSource()==btn_del)
				{	
					sql = "delete from mytable where roll="+tf_roll.getText()+"";
					ps = cn.prepareStatement(sql);
					ps.execute();
					ps.close();
					JOptionPane.showMessageDialog(null,"Record Deleted Successfully");
				}

				if(e.getSource()==btn_upd)
				{
					sql = "update mytable set name='"+tf_name.getText()+"' where roll="+tf_roll.getText();
					ps = cn.prepareStatement(sql);
					ps.execute();
					ps.close();
					JOptionPane.showMessageDialog(null,"Record Updated Successfully");
					refresh();	
				}
		}
		catch(SQLException ex)
		{	System.out.println("Exception Occurs");
		}
	} 

	public static void main(String a[])
	{
		new swingDBextra();
	}
}




