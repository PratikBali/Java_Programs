import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class stud3 extends JFrame implements ActionListener
{
  //1)Declaration
  JLabel l1,l2,l3,l4;
  JTextField t1,t2,t3,t4;
  JButton b1,b2,b3;
  JRadioButton rb1,rb2,rb3;
  ButtonGroup g1;
  
  Connection cn=null;
  PreparedStatement prstm;
  String sql;
  ResultSet rs;
  Statement stm;
 
stud3()
{
   //2) Memory Allocation
   super("DB Connection");
   setSize(650,300);
   setLocation(200,300);
   setLayout(null);
  
   l1=new JLabel("Roll No:");
   l2=new JLabel("Name:");
   l3=new JLabel("Age:");
   l4=new JLabel("student Database");
   
   Font f=new Font("Arial",Font.BOLD,20);
   l4.setFont(f);
  
   rb1=new JRadioButton("By roll");
   rb2=new JRadioButton("By Name");
   rb3=new JRadioButton("By Age");
   g1=new ButtonGroup();
   
   t1=new JTextField();
   t2=new JTextField();
   t3=new JTextField();
   t4=new JTextField();
   
   b1=new JButton("Search");
   b2=new JButton("CLEAR");
   b3=new JButton("EXIT");
   
   b1.setMnemonic('S');
   b2.setMnemonic('C');
   b3.setMnemonic('E');
  
    
  //3)Add component on frame   
   add(l1);  add(l2);  add(l3);
   add(t1);  add(t2);  add(t3);
   add(b1);  add(b2);  add(b3); 
    add(t4); 
   add(rb1); add(rb2); add(rb3);
   g1.add(rb1); g1.add(rb2); g1.add(rb3);  
   //4)SetBounds
   l1.setBounds(50,50,100,20);  
   t1.setBounds(160,50,100,20);
   
   
   l2.setBounds(50,80,100,20);
   t2.setBounds(160,80,100,20);
  
   l3.setBounds(50,110,100,20);
   t3.setBounds(160,110,100,20);
   
   l4.setBounds(250,20,200,20);
   t4.setBounds(50,170,280,20);
   
   rb1.setBounds(50,140,100,20);
   rb2.setBounds(160,140,100,20);
   rb3.setBounds(280,140,100,20);
   
   b1.setBounds(50,200,100,20);
   b2.setBounds(160,200,100,20);
   b3.setBounds(280,200,100,20);
  
  
   text_Validator(t1); 
   text_Validator(t3); 
	
   try
   {
     cn=DriverManager.getConnection("jdbc:mysql:///temp","root","");
	 stm=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	 rs=stm.executeQuery("Select * from mytable order by roll");
   }
	
    catch(Exception e)
	{
	 e.printStackTrace();
	} 
	
	t4.addKeyListener(new KeyAdapter()
	{
	 public void keyPressed(KeyEvent e)
	 {
	   if(e.getKeyChar()==KeyEvent.VK_ENTER)
	    {
		 try
		 {
		rs=stm.executeQuery("select * from mytable where Name like'%"+t4.getText()+"%'");
		while(rs.next())
		t1.setText(rs.getString(1));
		t2.setText(rs.getString(2));
		t3.setText(rs.getString(3));
		}
		catch(Exception e1)
		{
		 e1.printStackTrace();
		}
	  }
	  }
    });
	
	
   //5)Add ActionListener
   b1.addActionListener(this);
   b2.addActionListener(this);
   b3.addActionListener(this);
   
   
   setVisible(true);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
  
  
void text_Validator(final JTextField t2)
{
    t2.addKeyListener(new KeyAdapter()
   {
     public void keyTyped(KeyEvent e)
      {
         if(t2.getText().length()<3 && e.getKeyChar()>='0' && e.getKeyChar()<='9')
	        super.keyTyped(e);
	     else
	     {
	       e.consume();
	       Toolkit tk=Toolkit.getDefaultToolkit();
	       tk.beep();
	     }  
      }
	});
}
	
public void actionPerformed(ActionEvent e)
{
  try
    {	  
     if(e.getSource()==b1)
       {
	     if(rb1.isSelected())
		 {
		  t4.requestFocus();
		   try
	      { 
		  t4.requestFocus();
	     sql="Select * From mytable Where roll='"+t4.getText()+"'";
	
         rs=stm.executeQuery(sql);
         rs.next();
         t1.setText(rs.getString(1));
	     t2.setText(rs.getString(2));
	     t3.setText(rs.getString(3));
	      }
	   catch(Exception e2)
	   {
	      e2.printStackTrace();
	    }
		 }


 if(rb2.isSelected())
		 {
		  try
	      { 
	     sql="Select * From mytable Where Name='"+t4.getText()+"'";
	
         rs=stm.executeQuery(sql);
         rs.next();
         t1.setText(rs.getString(1));
	     t2.setText(rs.getString(2));
	     t3.setText(rs.getString(3));
	      }
	   catch(Exception e3)
	   {
	      e3.printStackTrace();
	    }
		 }


		  if(rb3.isSelected())
		 {
		  try
	      { 
	     sql="Select * From mytable Where Age='"+t4.getText()+"'";
	
         rs=stm.executeQuery(sql);
         rs.next();
         t1.setText(rs.getString(1));
	     t2.setText(rs.getString(2));
	     t3.setText(rs.getString(3));
	      }
	   catch(Exception e3)
	   {
	      e3.printStackTrace();
	    }
		 }

        }
       
     if(e.getSource()==b2)
      {
         t1.setText("");
         t2.setText("");
         t3.setText("");
		 t4.setText("");
      }		
	   
	   if(e.getSource()==b3)
	  {
	     System.exit(0);
	     
	   }
  	 }
	 
    catch(Exception e1)
    {
	   e1.printStackTrace();
	}
}
	
	
public void refresh()
{
  try
   {
     rs=stm.executeQuery("Select * from mytable order by roll");
	 rs.next();
	 display();
     prstm.close();
   }
  catch(Exception e2)
   {
	   e2.printStackTrace();
   }
}
	
public void display()
{
  try
   {
     t1.setText(rs.getString(1));
	 t2.setText(rs.getString(2));
	 t3.setText(rs.getString(3));
   }
  catch(Exception e3)
   {
     e3.printStackTrace();
   }
}
  
public static void main(String args[])
{
  new stud3(); 
}
}