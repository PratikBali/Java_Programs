import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class log1 extends JFrame implements ActionListener
{
	JTextField txt_id;
	JLabel l_id,l_pwd;
	JPasswordField pwd;
	JButton b_log,b_ext;

	Statement stm;
	ResultSet rs;
	Connection cn=null;
	PreparedStatement prstm;
	
	String id,pd;
	int flag=0;

	log1()
	{
		super(" logic screen");   	setSize(400,200);
		setLocation(200,150);		setLayout(null);

		l_id=new JLabel("login name");	 txt_id=new JTextField();
		l_pwd=new JLabel("password");     pwd=new JPasswordField();
				
		b_log=new JButton("login");       b_ext=new JButton("exit");	

		add(l_id);	add(l_pwd);	add(txt_id);	add(pwd);
		add(b_log);	add(b_ext);

		l_id.setBounds(50,50,100,20);	txt_id.setBounds(160,50,100,20);
		l_pwd.setBounds(50,80,100,20);  pwd.setBounds(160,80,100,20);
		b_log.setBounds(50,110,100,20);	 b_ext.setBounds(160,110,100,20);

		b_log.addActionListener(this);    b_ext.addActionListener(this);

		try
		{
			cn=DriverManager.getConnection("jdbc:mysql:///temp","root","");
			stm=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=stm.executeQuery("select * from  mylogin");
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try	
		{
			if(e.getSource()==b_log)
			{
				if(txt_id.getText().length()==0 || pwd.getText().length()==0 )
				{
					JOptionPane.showMessageDialog(null,"all field necessory!!!!"); 
					txt_id.requestFocus();
				}
				try
				{
					rs=stm.executeQuery("select *from mylogin");	
					id=txt_id.getText();
					pd=pwd.getText();
					while(rs.next())
					{
						if(rs.getString(1).equals(id) && rs.getString(2).equals(pd))
						{
							JOptionPane.showMessageDialog(null,"login successfull");
							txt_id.setText("");
							pwd.setText("");
							txt_id.requestFocus();
						}
						else
						JOptionPane.showMessageDialog(null," invalid password and user name");	
						 txt_id.setText("");
							pwd.setText("");
							txt_id.requestFocus();						
						
					}
					//rs.close();
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
			if(e.getSource()==b_ext)
			{
				System.exit(0);
			}
		}
		catch(Exception ec)
		{
			ec.printStackTrace();
		}
	}

	public static void main(String args[])
	{
		new log1();
	}
}
