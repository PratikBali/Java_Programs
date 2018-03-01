import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class log3 extends JFrame implements ActionListener
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

		l_id=new JLabel(" user name");	   txt_id=new JTextField();
		l_que=new JLabel("question");	           cmb=new JComboBox();
		l_ans=new JLabel("answer");	           txt_ans=new JTextField();
		b_rec=new JButton("recover");        b_back=new JButton("back");    
		b_ext=new JButton("exit");	

		cmb.addItem("select que");	cmb.addItem("first school");
		cmb.addItem("first clg");	cmb.addItem("fav teacher");
		cmb.addItem("fav food");	cmb.addItem("bst friend");
		cmb.addItem("fav player");	cmb.addItem("fav game");
		cmb.addItem("logo");

		add(l_id);	add(l_que);	add(l_ans);
		add(txt_id);	add(cmb);	add(txt_ans);
		add(b_rec);	add(b_ext);	add(b_back);

		l_id.setBounds(50,50,100,20);		txt_id.setBounds(160,50,200,20);
		l_que.setBounds(50,80,100,20);		cmb.setBounds(160,80,200,20);
		l_ans.setBounds(50,110,100,20);		txt_ans.setBounds(160,110,200,20);
		b_rec.setBounds(50,170,100,40);		b_back.setBounds(160,170,100,40);		b_ext.setBounds(270,170,100,40);
	
		b_rec.addActionListener(this);    b_ext.addActionListener(this);

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
		int flag=0;
		try
		{
			//recover
			if(e.getSource()==b_rec)
			{
				if(txt_id.getText().length()==0 ||cmb.getSelectedIndex()==0|| txt_ans.getText().length()==0 )
				{
					JOptionPane.showMessageDialog(null,"all field necessory!!!!"); 
					txt_id.requestFocus();
					if(txt_id.getText().length()==0)       txt_id.requestFocus();	
					else if(cmb.getSelectedIndex()==0)	cmb.requestFocus();
					else if(txt_ans.getText().length()==0 )	txt_ans.requestFocus();
				}
				
				stm=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				rs=stm.executeQuery("select * from  mylogin");
				id=txt_id.getText();
				q=cmb.getSelectedItem().toString();
				a=txt_ans.getText();
				
				while(rs.next())
				{
					if(rs.getString(1).equals(id) && rs.getString(3).equals(q)&& rs.getString(4).equals(a))
					{ 
						flag=1;
						JOptionPane.showMessageDialog(null,"Your password is = \t " +rs.getString(2));		
					}
				}
				
				if(flag==1)
				JOptionPane.showMessageDialog(null," account recover successfully recovered");
				else 		
				JOptionPane.showMessageDialog(null," invalid entries");
				rs.close();
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
		new log3();
	}
}
