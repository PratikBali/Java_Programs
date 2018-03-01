import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class log2 extends JFrame implements ActionListener
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
		super(" new user ");   	setSize(350,280);
		setLocation(200,150);		       setLayout(null);

		l_id=new JLabel("New user name");	   txt_id=new JTextField();
		l_pwd=new JLabel("New password");        pwd=new JPasswordField();
		l_que=new JLabel("Question");	         cmb=new JComboBox();
		l_ans=new JLabel("Answer");	           txt_ans=new JTextField();

		b_save=new JButton("Save");        b_back=new JButton("Back");    
		b_ext=new JButton("Exit");	
		
		cmb.addItem("select que");	cmb.addItem("first school");
		cmb.addItem("first clg");	cmb.addItem("fav teacher");
		cmb.addItem("fav food");	cmb.addItem("bst friend");
		cmb.addItem("fav player");	cmb.addItem("fav game");
		cmb.addItem("logo");

		add(l_id);	add(l_pwd);	add(l_que);	add(l_ans);
		add(txt_id);	add(pwd);	add(cmb);	add(txt_ans);
		add(b_save);	add(b_ext);	add(b_back);

		l_id.setBounds(50,50,100,20);	txt_id.setBounds(160,50,120,20);
		l_pwd.setBounds(50,80,100,20);     pwd.setBounds(160,80,120,20);
		l_que.setBounds(50,110,100,20);	   cmb.setBounds(160,110,120,20);
		l_ans.setBounds(50,140,100,20);   txt_ans.setBounds(160,140,120,20);
		b_save.setBounds(50,170,70,20);	 b_back.setBounds(130,170,70,20);
		 b_ext.setBounds(210,170,70,20);
		
		b_save.addActionListener(this);    b_ext.addActionListener(this);

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
		
			if(e.getSource()==b_save)
			{
				if(txt_id.getText().length()==0 || pwd.getText().length()==0 ||	cmb.getSelectedIndex()==0|| txt_ans.getText().length()==0 )
				{
					JOptionPane.showMessageDialog(null,"all field necessory!!!!","error",JOptionPane.ERROR_MESSAGE); 
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
				JOptionPane.showMessageDialog(null,"**** record successfully inserted:*****");
			}
			
			if(e.getSource()==b_ext)
			{
				System.exit(0);
			}
		}
		
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}

	public static void main(String args[])
	{
		new log2();
	}
}