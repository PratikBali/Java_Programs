// database connectivity with operation buttons like add , delete ,update

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*; 

class swingSQL extends JFrame implements ActionListener,ItemListener
{
	JButton btn_clr,btn_ins,btn_upd,btn_del,btn_srch,btn_first,btn_next,btn_prev,btn_last,btn_pn_srch,btn_pn_hide;
	JLabel lbl_roll,lbl_name,lbl_age;
	JTextField tf_roll,tf_name,tf_age,tf_srch;
	JRadioButton rb1,rb2;
	ButtonGroup bg;
	List lst;
	JPanel pn;
	
	String sql;
	int flag=0;
	Connection cn=null;
	PreparedStatement ps;
	Statement stm;
	ResultSet rs;

	swingSQL()
	{
		setTitle("Swing with Database with buttons like add , delete ,update");
		setSize(480,480);
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
			btn_pn_srch = new JButton("Search Panel");
			btn_pn_hide = new JButton("Hide Panel");
		
		lbl_roll = new JLabel("Roll No.     ");
		lbl_name = new JLabel("Name No.    ");
		lbl_age = new JLabel("Age No.      ");

		tf_roll = new JTextField();
		tf_name = new JTextField();
		tf_age = new JTextField();
		
		// work on panel
		pn = new JPanel();
			rb1 = new JRadioButton("By Name",true);
			rb2 = new JRadioButton("By Roll No.");
			bg = new ButtonGroup();
			tf_srch = new JTextField();
			lst = new List();
		add(pn);
		pn.add(tf_srch);
		pn.add(lst);
			pn.add(rb1);
			pn.add(rb2);
			bg.add(rb1);
			bg.add(rb2);
		pn.setLayout(null);	
		pn.setBackground(Color.RED);
			pn.setBounds(10,220,430,200);	
		rb1.setBounds(10,10,100,20);	
		rb2.setBounds(120,10,100,20);	
		tf_srch.setBounds(10,40,350,20);
		lst.setBounds(10,70,350,100);
			pn.setVisible(false);

		add(lbl_roll);add(lbl_name);add(lbl_age);
		add(tf_roll);add(tf_name);add(tf_age);
		add(btn_clr);add(btn_ins);add(btn_upd);add(btn_del);add(btn_srch);
			add(btn_first);add(btn_last);add(btn_prev);add(btn_next);
		add(btn_pn_srch);add(btn_pn_hide);

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
		btn_prev.setBounds(120,190,100,20);
		btn_next.setBounds(230,190,100,20);
		btn_last.setBounds(340,190,100,20);
			btn_pn_srch.setBounds(120,150,150,20);
			btn_pn_hide.setBounds(280,150,100,20);

		
		btn_clr.addActionListener(this);
		btn_ins.addActionListener(this);
		btn_upd.addActionListener(this);
		btn_del.addActionListener(this);
		btn_srch.addActionListener(this);
			btn_first.addActionListener(this);
		btn_next.addActionListener(this);
		btn_prev.addActionListener(this);
		btn_last.addActionListener(this);
			btn_pn_srch.addActionListener(this);
			btn_pn_hide.addActionListener(this);
			lst.addItemListener(this);
			rb1.addItemListener(this);
			rb2.addItemListener(this);
		
		try
		{cn = DriverManager.getConnection("jdbc:mysql:///temp","root","");
		 stm = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		 rs= stm.executeQuery("Select * from mytable");
		 rs.first();
		 display();
		}
		catch(Exception e)
		{e.printStackTrace();
		}
		
		valid(tf_roll);
		valid(tf_age);

		tf_srch.addKeyListener(new KeyAdapter()
		{	public void keyPressed(KeyEvent e)
			{	if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{	try
					{	lst.clear();
						rs=stm.executeQuery("select * from mytable where name like '%"+tf_srch.getText()+"%'");
						while(rs.next())
						lst.addItem(rs.getString(2));
					}	
					catch(Exception ex)
					{ex.printStackTrace();
					}
				}
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	public void itemStateChanged(ItemEvent e)
	{
		try
		{

		}
		catch(Exception ex)
		{	ex.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(rb1.isSelected())
			{
				tf_srch.requestFocus();
				try
				{ 
					rs=stm.executeQuery("select * from mytable where name like'%"+tf_srch.getText()+"%'");
					rs.next();
					tf_roll.setText(rs.getString(1));
					tf_name.setText(rs.getString(2));
					tf_age.setText(rs.getString(3));
				}
				catch(Exception e2)
				{
				  e2.printStackTrace();
				}
			}


			if(rb2.isSelected())
			{
				tf_srch.requestFocus();
				tf_srch.setText("");
				try
				{ 
					sql="select * from mytable where roll="+tf_srch.getText();
					rs=stm.executeQuery(sql);
					rs.next();
					tf_roll.setText(rs.getString(1));
					tf_name.setText(rs.getString(2));
					tf_age.setText(rs.getString(3));
				}
				catch(Exception e3)
				{
					e3.printStackTrace();
				}
			}

			if(e.getSource()==btn_pn_srch)
			{	pn.setVisible(true);
			
			}
			if(e.getSource()==btn_pn_hide)
			{	pn.setVisible(false);
			
			}
			if(e.getSource()==btn_ins)
			{try
				{if(tf_roll.getText().length()==0 || tf_name.getText().length()==0 || tf_age.getText().length()==0)
					{
						JOptionPane.showMessageDialog(null,"All Fields Are Necessory");
						if(tf_roll.getText().length()==0)
							tf_roll.requestFocus();
						else if(tf_name.getText().length()==0)
							tf_name.requestFocus();
						else if(tf_age.getText().length()==0)
							tf_age.requestFocus();
					}
					
					else
					{	sql = "insert into mytable values("+tf_roll.getText()+",'"+tf_name.getText()+"',"+tf_age.getText()+")";
						ps = cn.prepareStatement(sql);
						ps.execute();
						ps.close();
						refresh();
						JOptionPane.showMessageDialog(null,"Record Inserted Successfully");
										tf_roll.setText("");
						tf_name.setText("");
						tf_age.setText("");
						tf_roll.requestFocus();
					}
				}
				catch(Exception ex)
				{ JOptionPane.showMessageDialog(null,"Roll No. already exist","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			if(e.getSource()==btn_clr)
			{
				tf_roll.setText("");
				tf_name.setText("");
				tf_age.setText("");
				tf_roll.requestFocus();
			}
			if(e.getSource()==btn_del)
			{	
				if(JOptionPane.showConfirmDialog(null,"Are you Really want to delete this record ?","Please Confirm",JOptionPane.OK_CANCEL_OPTION)==0)
				{
					sql = "delete from mytable where roll="+tf_roll.getText()+"";
					ps = cn.prepareStatement(sql);
					ps.execute();
					ps.close();
					refresh();
					JOptionPane.showMessageDialog(null,"Record Deleted Successfully");		
				}
			}
			if(e.getSource()==btn_upd)
			{
				if(tf_roll.getText().length()==0 || tf_name.getText().length()==0 || tf_age.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"All Fields Are Necessory");
					if(tf_roll.getText().length()==0)
						tf_roll.requestFocus();
					else if(tf_name.getText().length()==0)
						tf_name.requestFocus();
					else if(tf_age.getText().length()==0)
						tf_age.requestFocus();
				}
				
				else
				{
					sql = "update mytable set name='"+tf_name.getText()+"', age="+tf_age.getText()+" where roll="+tf_roll.getText();
					ps = cn.prepareStatement(sql);
					ps.execute();
					ps.close();
					refresh();
					JOptionPane.showMessageDialog(null,"Record Updated Successfully");
				}
			}
			if(e.getSource()==btn_srch)
			{	
				stm = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
				{
				JOptionPane.showMessageDialog(this,"It is Last Record");
				rs.last();
				}
				display();
			}

			if(e.getSource()==btn_prev)
			{rs.previous();
				if(rs.isBeforeFirst())
				{
				JOptionPane.showMessageDialog(this,"It is First Record");
				rs.first();
				}
				 display();
			}
		}
		catch(SQLException ex)
		{	ex.printStackTrace();
		}
		
	}
	
	void valid(final JTextField tt)
	{
		tt.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				if(tt.getText().length()<5 && e.getKeyChar()>='0' && e.getKeyChar()<='9')

				super.keyTyped(e);    // optional

				else
				{
					e.consume();		// diascard the event
					Toolkit tk=Toolkit.getDefaultToolkit();
					tk.beep();	// raise the sound
				}
            }
		});
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
		
		public static void main(String a[])
		{
			new swingSQL();
		}	
	}