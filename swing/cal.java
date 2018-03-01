// Swing Program to Show Arithmatic Operation with all validation

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class cal extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3;
	JButton b1,b2,b3,b4,b5,b6;
	
	cal()
	{
		super("Simple cals");
		setSize(335,270);
		setLocation(300,100);
		setLayout(null);
		
		l1 = new JLabel("Enter 1st No.  :");
		l2 = new JLabel("Enter 2nd No.  :");
		l3 = new JLabel("Answer is :");
			t1 = new JTextField(20);
			t2 = new JTextField(20);
			t3 = new JTextField(20);
		b1 = new JButton("+");
		b2 = new JButton("Clear");
		b3 = new JButton("Exit");
		b4 = new JButton("-");
		b5 = new JButton("*");
		b6 = new JButton("/");
		
		add(l1);	add(l2);	add(l3);
		add(t1);	add(t2);	add(t3);
		add(b1);	add(b2);	add(b3);	add(b4);	add(b5);	add(b6);

		l1.setBounds(50,50,100,20);
		l2.setBounds(50,80,100,20);
		l3.setBounds(50,110,100,20);
			t1.setBounds(160,50,120,20);
			t2.setBounds(160,80,120,20);
			t3.setBounds(160,110,120,20);
		b1.setBounds(50,150,50,20);
		b4.setBounds(110,150,50,20);
		b5.setBounds(170,150,50,20);
		b6.setBounds(230,150,50,20);
		b2.setBounds(50,180,110,20);
		b3.setBounds(170,180,110,20);
			
		l4 = new JLabel("Simple Calulator with all Validation");
		add(l4);
		l4.setBounds(70,15,300,20);

		t3.setEditable(false);
		
		b1.setToolTipText("addition");
		b2.setToolTipText("Clears each Field");
		b3.setToolTipText("Exit from Frame");
		
		b4.setToolTipText("Subtraction");
		b5.setToolTipText("Multiplication");
		b6.setToolTipText("Division");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		
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
			
			if(e.getSource()==b4)
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
					c = a-b;
					if(c<0)
					{
						JOptionPane.showMessageDialog(null,"Answer Must be Positive 2nd No. is Greater");	
						t2.setText("");
						t3.setText("");
						t2.requestFocus();

					}
					else
					
					
					t3.setText(""+c);
		//			t3.setText(Integer.toString(c));
				}
			}
			
			if(e.getSource()==b5)
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
					c = a*b;
					if(c<=0)
					{
						JOptionPane.showMessageDialog(null,"Answer Must be Positive");	
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t1.requestFocus();
					}
					else

					t3.setText(""+c);
		//			t3.setText(Integer.toString(c));
				}
			}

			if(e.getSource()==b6)
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
					double a,b,c;
					a = Double.parseDouble(t1.getText());
					b = Double.parseDouble(t2.getText());
					c = a/b;
					if(b==0)
					{
						JOptionPane.showMessageDialog(null,"Divide by Zero","Error",JOptionPane.ERROR_MESSAGE);
						if(b==0)
						t2.requestFocus();
					}
					else
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
		new cal();
	}
}
