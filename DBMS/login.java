import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class login extends JFrame implements ActionListener
{
	JLabel lbl_user,lbl_pass;
	JButton btn_log,btn_ext;
	JTextField tf_user;
	JPasswordField pass;

	JMenu menu;
	JMenuItem add_user,frgt;
	JMenuBar mbr;
 
	String sql;
	int flag=0;

	Connection cn=null;
	PreparedStatement ps;
	Statement stm;
	ResultSet rs;
	
	login()
	{
		setTitle("Swing with Database");
		setSize(350,200);
		setLocation(100,100);
		setLayout(null);

		btn_log = new JButton("Login");
		btn_ext = new JButton("Exit");
			lbl_user = new JLabel("Enter Username      : ");
			lbl_pass = new JLabel("Enter Password   : ");
		tf_user = new JTextField();
		pass = new JPasswordField();

		add(lbl_user);add(lbl_pass);add(tf_user);add(pass);add(btn_log);add(btn_ext);

		mbr=new JMenuBar();
		menu = new JMenu("MENU");
		add_user=new JMenuItem("Add User");
		frgt=new JMenuItem("Forgot Password");
		add(mbr);
		menu.add(add_user);
		menu.add(frgt);
		mbr.add(menu);
		mbr.setBounds(0,0,400,20);


		lbl_user.setBounds(10,30,150,20);	tf_user.setBounds(180,30,150,20);
		lbl_pass.setBounds(10,60,150,20); pass.setBounds(180,60,150,20);
		
		btn_log.setBounds(10,110,140,20); btn_ext.setBounds(180,110,140,20);
		
		btn_log.addActionListener(this);
		btn_ext.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		try
		{	cn = DriverManager.getConnection("jdbc:mysql:///temp","root","");
			stm = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}
		catch(Exception e)
		{e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==btn_ext)
			System.exit(0);

			if(tf_user.getText().length()==0 || pass.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"All Fields Are Necessory");
				if(tf_user.getText().length()==0)
					JOptionPane.showMessageDialog(null,"Please Enter Username","Error",JOptionPane.ERROR_MESSAGE);
				if(pass.getText().length()==0)
					JOptionPane.showMessageDialog(null,"Please Enter Password","Error",JOptionPane.ERROR_MESSAGE);
			}

			if(e.getSource()==btn_log)
			{
				rs= stm.executeQuery("Select * from mylogin");
				String user = tf_user.getText();				
				String pwd = pass.getText();				
				while(rs.next())
				{
					if(rs.getString(1).equals(user) && rs.getString(2).equals(pwd))
					{
						JOptionPane.showMessageDialog(null,"Login Successfull");
//						System.out.println("yes");
					}
					else
					JOptionPane.showMessageDialog(null,"Invalid Information","Error",JOptionPane.ERROR_MESSAGE);
//						System.out.println("No");
				}
			}

			if(e.getSource()==btn_ext)
			System.exit(0);
		}
		catch(SQLException ex)
		{	System.out.println("Exception Occurs");
		}
	}
	public static void main(String a[])
	{
		new login();
	}
}
