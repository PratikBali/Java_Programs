import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class msgbox extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	
	msgbox()
	{
		setTitle("MsgBoxAll");
		setSize(232,300);
		setLocation(200,200);
		setLayout(new FlowLayout());
		setBackground(Color.RED);

		b1= new JButton("Simple Msg Box");
		b2= new JButton("Y/n Msg Box");
		b3= new JButton("Msg Box title");
		b4= new JButton("Warning Msg Box");
		b5= new JButton("User Input Msg Box");
		b6= new JButton("Question Msg Box");
		b7= new JButton("Error Msg Box");
		b8= new JButton("Exit Msg Box");

		add(b1);	add(b2);  	add(b3);	add(b4);  	add(b5);	add(b6);  	add(b7);  	add(b8);   

		b1.setMnemonic('S');
		b2.setMnemonic('Y');
		b3.setMnemonic('T');
		b4.setMnemonic('w');
		b5.setMnemonic('i');
		b6.setMnemonic('Q');
		b7.setMnemonic('E');
		b8.setMnemonic('x');
	
	b1.setToolTipText("Shows Simple Msg box");
	b2.setToolTipText("Shows Y/N Msg box");
	b3.setToolTipText("Shows Title Msg box");
	b4.setToolTipText("Shows Warning Msg box");
	b5.setToolTipText("Shows Input Msg box");
	b6.setToolTipText("Shows Question Msg box");
	b7.setToolTipText("Shows Eroor Msg box");
	b8.setToolTipText("Exit from Frame");
	
		b1.addActionListener(this);		
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);		
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			JOptionPane.showMessageDialog(null,"Simple Msg Box");
		}
		
		if(e.getSource()==b2)//yes no cancel
		{
			int ans = JOptionPane.showConfirmDialog(null,"Y/n Cancel Msg Box");
			
			if(ans==0)
			JOptionPane.showMessageDialog(null,"Yes button Clicked");
			
			if(ans==1)
			JOptionPane.showMessageDialog(null,"No button Clicked");

			if(ans==2)
			JOptionPane.showMessageDialog(null,"Cancel button Clicked");

		}

		if(e.getSource()==b3)//ok cancel
		{
			if(JOptionPane.showConfirmDialog(null,"Message","Msg Title",JOptionPane.OK_CANCEL_OPTION)==0)
			
			JOptionPane.showMessageDialog(null,"OK button Clicked");
			else			
			JOptionPane.showMessageDialog(null,"Cancel button Clicked");
		}
		
		if(e.getSource()==b4)
		{
			JOptionPane.showMessageDialog(null,"Please try Again","Invalid Password",JOptionPane.WARNING_MESSAGE);
		}
		
		if(e.getSource()==b5)//input
		{
			String s = JOptionPane.showInputDialog(null,"Enter Some text : ");
			if(s != null)
			JOptionPane.showMessageDialog(null,"Your text : "+s);
			else
			JOptionPane.showMessageDialog(null,"Cancel button Clicked");
		}
		
		if(e.getSource()==b6)//que
		{
			Object option[] = {"Yes, Please", "No, Thanks", "No"};
			int n = JOptionPane.showOptionDialog(null,"Want Ice Cream","Question",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[2]);
		}
		
		if(e.getSource()==b7)
		{
			JOptionPane.showMessageDialog(null,"Please try Again","Invalid Password",JOptionPane.ERROR_MESSAGE);
		}

		if(e.getSource()==b8)
		{
			System.exit(0);
		}

	}

	
	public static void main(String a[])
	{
		new msgbox();
	}
}