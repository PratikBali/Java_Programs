// all buttons performs operation
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class ValueInsert extends JFrame implements ActionListener
{
	JButton btn_ins;
	JLabel lbl_roll,lbl_name,lbl_age;
	JTextField tf_roll,tf_name,tf_age;

	String sql;
	int flag=0;

	Connection cn=null;
	PreparedStatement ps;
	Statement stm;
	ResultSet rs;


	
	ValueInsert()
	{
		setTitle("Insert value through frame");
		setSize(500,500);
		setLocation(100,100);
		setLayout(null);

		btn_ins = new JButton("Insert");
		
		lbl_roll = new JLabel("Enter Roll No.      : ");
		lbl_name = new JLabel("Enter Name No.   : ");
		lbl_age = new JLabel("Enter Age No.      : ");

		tf_roll = new JTextField();
		tf_name = new JTextField();
		tf_age = new JTextField();

		add(lbl_roll);add(lbl_name);add(lbl_age);
		add(tf_roll);add(tf_name);add(tf_age);
		add(btn_ins);;

		lbl_roll.setBounds(10,10,150,20);
		lbl_name.setBounds(10,40,150,20);
		lbl_age.setBounds(10,70,150,20);

		tf_roll.setBounds(230,10,210,20);
		tf_name.setBounds(230,40,210,20);
		tf_age.setBounds(230,70,210,20);

		btn_ins.setBounds(120,110,100,20);

		btn_ins.addActionListener(this);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		try
		{cn = DriverManager.getConnection("jdbc:mysql:///library","root","");
		}
		catch(Exception e)
		{e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		try
		{

				if(e.getSource()==btn_ins)
				{
					sql = "insert into test values("+tf_roll.getText()+",'"+tf_name.getText()+"',"+tf_age.getText()+")";
					ps = cn.prepareStatement(sql);
					ps.execute();
					ps.close();
					JOptionPane.showMessageDialog(null,"Record Inserted Successfully");
				}


		}
		catch(SQLException ex)
		{	ex.printStackTrace();
		}
	} 

	public static void main(String a[])
	{
		new ValueInsert();
	}
}
