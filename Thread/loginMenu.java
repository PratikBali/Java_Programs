import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class loginMenu extends JFrame implements ActionListener
{
	JTextField txt_id;
	JLabel l_id,l_pwd;
	JPasswordField pwd;
	JButton b_log,b_ext;
	JMenuBar mbr;	JMenu m1;	JMenuItem i1,i2;
	
	Statement stm;
	ResultSet rs;
	Connection cn=null;
	PreparedStatement prstm;
	
	String id,pd;
	String sql;
	int flag=0;

	loginMenu()
	{
		super("Login Screen");   	setSize(400,200);
		setLocation(200,150);		setLayout(null);

		l_id=new JLabel("User name");	 txt_id=new JTextField();
		l_pwd=new JLabel("Password");     pwd=new JPasswordField();
				
		b_log=new JButton("Login");       b_ext=new JButton("Exit");	

		add(l_id);	add(l_pwd);	add(txt_id);	add(pwd);
		add(b_log);	add(b_ext);

		l_id.setBounds(50,50,100,20);	txt_id.setBounds(160,50,100,20);
		l_pwd.setBounds(50,80,100,20);  pwd.setBounds(160,80,100,20);
		b_log.setBounds(50,110,100,20);	 b_ext.setBounds(160,110,100,20);
		
		mbr = new JMenuBar();
			m1 = new JMenu ("Menu");
		i1 = new JMenuItem ("Add New User");
		i2 = new JMenuItem ("Recover Password");
			add(mbr);
		m1.add(i1);	m1.add(i2);
			mbr.add(m1);
		mbr.setBounds(0,0,600,20);	

		b_log.addActionListener(this);
		b_ext.addActionListener(this);
		i1.addActionListener(this);
		i2.addActionListener(this);

		try
		{
			cn=DriverManager.getConnection("jdbc:mysql:///library","root","");
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
			flag=0;
				if(txt_id.getText().length()==0 || pwd.getText().length()==0 )
				{
					JOptionPane.showMessageDialog(null,"All field Necessory!!!!"); 
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
						{flag=1;
							JOptionPane.showMessageDialog(null,"Login Successfull");
							txt_id.setText("");
							pwd.setText("");
							txt_id.requestFocus();
						}
					}
					if(flag==0)
					JOptionPane.showMessageDialog(null,"Invalid Username or Password","Error",JOptionPane.ERROR_MESSAGE);
					
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
			if(e.getSource()==i1)
			{
				new log2();
				dispose();
			}
			if(e.getSource()==i2)
			{
				new log3();
				dispose();
			}
		}
		catch(Exception ec)
		{
			ec.printStackTrace();
		}
	}

	public static void main(String args[])
	{
		new loginMenu();
	}
}

class log2 extends JFrame implements ActionListener
{
	JTextField txt_id,txt_ans;
	JLabel l_id,l_pwd,l_que,l_ans;
	JButton b_save,b_back,b_ext;
	JComboBox cmb;
	JPasswordField pwd;

	String id,pd,q,a;
	Statement stm;
	ResultSet rs;
	Connection cn=null;
	PreparedStatement prstm;
	String sql;
	log2()
	{
		super("Add New User ");   	setSize(350,280);
		setLocation(200,150);		       setLayout(null);

		l_id=new JLabel("New user name");	   txt_id=new JTextField();
		l_pwd=new JLabel("New password");        pwd=new JPasswordField();
		l_que=new JLabel("Question");	         cmb=new JComboBox();
		l_ans=new JLabel("Answer");	           txt_ans=new JTextField();

		b_save=new JButton("Save");        b_back=new JButton("Back");    
		b_ext=new JButton("Exit");	
		
		cmb.addItem("Select Question");	cmb.addItem("First school");
		cmb.addItem("First College");	cmb.addItem("Favourite Teacher");
		cmb.addItem("Favourite Food");	cmb.addItem("Best Friend");
		cmb.addItem("Favourite Player");	cmb.addItem("Favourite Game");
		cmb.addItem("Favourite Bike");

		add(l_id);	add(l_pwd);	add(l_que);	add(l_ans);
		add(txt_id);	add(pwd);	add(cmb);	add(txt_ans);
		add(b_save);	add(b_ext);	add(b_back);

		l_id.setBounds(50,50,100,20);	txt_id.setBounds(160,50,120,20);
		l_pwd.setBounds(50,80,100,20);     pwd.setBounds(160,80,120,20);
		l_que.setBounds(50,110,100,20);	   cmb.setBounds(160,110,120,20);
		l_ans.setBounds(50,140,100,20);   txt_ans.setBounds(160,140,120,20);
		b_save.setBounds(50,170,70,20);	 b_back.setBounds(130,170,70,20);
		b_ext.setBounds(210,170,70,20);
		
		b_save.addActionListener(this);    b_ext.addActionListener(this);	b_back.addActionListener(this);

		try
		{
			cn=DriverManager.getConnection("jdbc:mysql:///library","root","");
			stm=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=stm.executeQuery("select * from  mylogin");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		try	
		{
			if(e.getSource()==b_save)
			{
				if(txt_id.getText().length()==0 || pwd.getText().length()==0 ||	cmb.getSelectedIndex()==0|| txt_ans.getText().length()==0 )
				{
					JOptionPane.showMessageDialog(null,"All Field Necessory!!!!","Error",JOptionPane.ERROR_MESSAGE); 
					txt_id.requestFocus();
					if(txt_id.getText().length()==0)       txt_id.requestFocus();	
					else if(pwd.getText().length()==0)	pwd.requestFocus();
					else if(cmb.getSelectedIndex()==0)	cmb.requestFocus();
					else if(txt_ans.getText().length()==0 )	txt_ans.requestFocus();
				}
				id=txt_id.getText();
				pd=pwd.getText();
				q=cmb.getSelectedItem().toString();
				a=txt_ans.getText();
					
				sql="insert into mylogin values('"+id+"','"+pd+"','"+q+"','"+a+"')";
				prstm=cn.prepareStatement(sql);
				prstm.execute();	prstm.close();
				JOptionPane.showMessageDialog(null,"Record Successfully Inserted");
			}
			
			if(e.getSource()==b_ext)
			{
				System.exit(0);
			}
			
			if(e.getSource()==b_back)
			{
				new loginMenu();
				dispose();
			}
	
		}
		
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}
}


class log3 extends JFrame implements ActionListener
{
	JTextField txt_id,txt_ans;
	JLabel l_id,l_que,l_ans;
	JButton b_rec,b_back,b_ext;
	JComboBox cmb;
	
	String id,q,a;
	Statement stm;
	ResultSet rs;
	Connection cn=null;
	PreparedStatement prstm;
	String sql;

	log3()
	{
		super(" Recover Password ");   	setSize(450,300);
		setLocation(200,150);		       setLayout(null);

		l_id=new JLabel("User Name");	   txt_id=new JTextField();
		l_que=new JLabel("Question");	           cmb=new JComboBox();
		l_ans=new JLabel("Answer");	           txt_ans=new JTextField();
		b_rec=new JButton("Recover");        b_back=new JButton("Back");    
		b_ext=new JButton("Exit");	

		cmb.addItem("Select Question");	cmb.addItem("First school");
		cmb.addItem("First College");	cmb.addItem("Favourite Teacher");
		cmb.addItem("Favourite Food");	cmb.addItem("Best Friend");
		cmb.addItem("Favourite Player");	cmb.addItem("Favourite Game");
		cmb.addItem("Favourite Bike");

		add(l_id);	add(l_que);	add(l_ans);
		add(txt_id);	add(cmb);	add(txt_ans);
		add(b_rec);	add(b_ext);	add(b_back);

		l_id.setBounds(50,50,100,20);		txt_id.setBounds(160,50,200,20);
		l_que.setBounds(50,80,100,20);		cmb.setBounds(160,80,200,20);
		l_ans.setBounds(50,110,100,20);		txt_ans.setBounds(160,110,200,20);
		b_rec.setBounds(50,170,100,40);		b_back.setBounds(160,170,100,40);		b_ext.setBounds(270,170,100,40);
	
		b_rec.addActionListener(this);    b_ext.addActionListener(this);	 b_back.addActionListener(this);

		try
		{
			cn=DriverManager.getConnection("jdbc:mysql:///library","root","");
			stm=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=stm.executeQuery("select * from  mylogin");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		int flag=0;
		try
		{
			//recover
			if(e.getSource()==b_rec)
			{
				if(txt_id.getText().length()==0 ||cmb.getSelectedIndex()==0|| txt_ans.getText().length()==0 )
				{
					JOptionPane.showMessageDialog(null,"All field Necessory!!!!"); 
					txt_id.requestFocus();
					if(txt_id.getText().length()==0)
					txt_id.requestFocus();
					else if(cmb.getSelectedIndex()==0)
					cmb.requestFocus();
					else if(txt_ans.getText().length()==0)
					txt_ans.requestFocus();
				}
				
				stm=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				rs=stm.executeQuery("select * from  mylogin");
				id=txt_id.getText();
				q=cmb.getSelectedItem().toString();
				a=txt_ans.getText();
				rs.beforeFirst();
				
				while(rs.next())
				{
					if(rs.getString(1).equals(id) && rs.getString(3).equals(q) && rs.getString(4).equals(a))
					{ 
						flag=1;
						JOptionPane.showMessageDialog(null,"Your Password is = \t " +rs.getString(2));		
						break;
					}
					System.out.println("\n\n"+rs.getString(1)+"="+id+ "\n"+rs.getString(3)+"="+q+ "\n"+rs.getString(4)+"="+a);

					}
				
				if(flag==0)
					JOptionPane.showMessageDialog(null," Invalid Information");
				
				rs.close();
				
			}

			if(e.getSource()==b_ext)
			{
				System.exit(0);
			}
			
			if(e.getSource()==b_back)
			{
				new loginMenu();
				dispose();
			}
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}		
	}
}