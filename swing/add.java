// Swing Program to Show addition with all validation

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class add extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JButton b1,b2,b3;
	
	add()
	{
		super("Simple adds");
		setSize(300,270);
		setLocation(300,100);
		setLayout(null);
		
		l1 = new JLabel("Enter 1st No. :");
		l2 = new JLabel("Enter 2nd No. :");
		l3 = new JLabel("Addition is :");
			t1 = new JTextField(20);
			t2 = new JTextField(20);
			t3 = new JTextField(20);
		b1 = new JButton("Add");
		b2 = new JButton("Clear");
		b3 = new JButton("Exit");
		
		add(l1);	add(l2);	add(l3);
		add(t1);	add(t2);	add(t3);
		add(b1);	add(b2);	add(b3);

		l1.setBounds(50,50,100,20);
		l2.setBounds(50,80,100,20);
		l3.setBounds(50,110,100,20);
			t1.setBounds(160,50,100,20);
			t2.setBounds(160,80,100,20);
			t3.setBounds(160,110,100,20);
		b1.setBounds(50,150,65,20);
		b2.setBounds(125,150,65,20);
		b3.setBounds(195,150,65,20);
		
		b1.setMnemonic('a');
		b2.setMnemonic('c');
		b3.setMnemonic('x');
		
		b1.setToolTipText("Add 2 no. from t1 and t2");
		b2.setToolTipText("Clears each Field");
		b3.setToolTipText("Exit from Frame");
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==b1)
			{
				if(t1.getText().length()==0 || t2.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Empty Field Occur Please Enter values in Integer");
					if(t1.getText().length()==0)
					t1.requestFocus();
					else if(t2.getText().length()==0)
					t2.requestFocus();
				}
				else
				{
					int a,b,c;
					a = Integer.parseInt(t1.getText());
					b = Integer.parseInt(t2.getText());
					c = a+b;
					
					t3.setText(""+c);
		//			t3.setText(Integer.toString(c));
				}
			}
			if(e.getSource()==b2)
			{
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t1.requestFocus();
			}
			if(e.getSource()==b3)
			{
				System.exit(0);
			}
		
		}
		

		catch(NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(null,"You Entered String Please Enter values in Integer","Error",JOptionPane.ERROR_MESSAGE);
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t1.requestFocus();
		
		}
		
	}
	
	public static void main(String a[])
	{
		new add();
	}
}
