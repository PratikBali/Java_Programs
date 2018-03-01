import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class add_user extends JFrame implements ItemListener,ActionListener
{
	JLabel lbl_new_user,lbl_new_pwd,lbl_ques,lbl_ans;
	JButton btn_save,btn_ext,btn_back;
	JTextField tf_new_user,tf_new_pwd,tf_ans;
	JComboBox cb;

	String sql;
	int flag=0;

	Connection cn=null;
	PreparedStatement ps;
	Statement stm;
	ResultSet rs;

	add_user()
	{
		setTitle("Swing with Database");
		setSize(500,250);
		setLocation(100,100);
		setLayout(null);

		cb=new JComboBox();

		btn_save = new JButton("Save");
		btn_back = new JButton("Back");
		btn_ext = new JButton("Exit");

		lbl_new_user = new JLabel("Enter New User Name     ");
		lbl_new_pwd = new JLabel("Enter New Password   ");
		lbl_ques = new JLabel("Question(Hint)   ");
		lbl_ans = new JLabel("Enter Answer     ");

		tf_new_user = new JTextField();
		tf_new_pwd = new JTextField();
		tf_ans = new JTextField();

		add(lbl_new_user);	add(lbl_new_pwd);	add(lbl_ques);	add(lbl_ans);
		add(tf_new_user);	add(tf_new_pwd);	add(tf_ans);
		add(btn_save);	add(btn_back);	add(btn_ext);
		cb.addItem("Select Question");
		cb.addItem("Fav Teacher");
		cb.addItem("Fav Bike");
		cb.addItem("Fav Car");
		add(cb);
		lbl_new_user.setBounds(10,10,200,20);
		lbl_new_pwd.setBounds(10,40,200,20);
		lbl_ques.setBounds(10,70,150,20);
		lbl_ans.setBounds(10,100,150,20);

		tf_new_user.setBounds(230,10,200,20);
		tf_new_pwd.setBounds(230,40,200,20);
		cb.setBounds(230,70,200,20);
		tf_ans.setBounds(230,100,200,20);

		btn_save.setBounds(10,140,100,30);
		btn_back.setBounds(120,140,100,30);
		btn_ext.setBounds(230,140,100,30);

		btn_save.addActionListener(this);
		btn_back.addActionListener(this);
		btn_ext.addActionListener(this);

		cb.addItemListener(this);

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

	public void itemStateChanged(ItemEvent e)
	{

	}

	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==btn_ext)
			System.exit(0);

			if(e.getSource()==btn_save)
			{
				if(tf_new_user.getText().length()==0 || tf_new_pwd.getText().length()==0)
					{
						JOptionPane.showMessageDialog(null,"All Fields Are Necessory");
						if(tf_new_user.getText().length()==0)
							JOptionPane.showMessageDialog(null,"Please Enter Username","Error",JOptionPane.ERROR_MESSAGE);
						if(tf_new_pwd.getText().length()==0)
							JOptionPane.showMessageDialog(null,"Please Enter Password","Error",JOptionPane.ERROR_MESSAGE);
					}
				else
				{
					String id = tf_new_user.getText();
					String pwd = tf_new_pwd.getText();
					String itm = cb.getSelectedItem().toString();
					String ans = tf_ans.getText();

					sql = "insert into mylogin values('"+id+"','"+pwd+"','"+itm+"','"+ans+"')";
					ps = cn.prepareStatement(sql);
					ps.execute();
					ps.close();
					JOptionPane.showMessageDialog(null,"User Added successfully");
				}
			}
		}
		catch(SQLException ex)
		{	System.out.println("Exception Occurs");
		}

	}

	public static void main(String a[])
	{
		new add_user();
	}
}

