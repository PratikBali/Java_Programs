// conversion of no.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class convert extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3,t4;
	JButton b1,b2,b3;
	
	convert()
	{
		setTitle("Conversion");
		setSize(400,400);
		setLocation(250,200);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		l1 = new JLabel("Enter  No:");
		l2 = new JLabel("Binary :");
		l3 = new JLabel("Octal :");
		l4 = new JLabel("HexaDecimal :");
			t1 = new JTextField(20);
			t2 = new JTextField(20);
			t3 = new JTextField(20);
			t4 = new JTextField(20);
		b1 = new JButton("Convert");
		b2 = new JButton("Clear");
		b3 = new JButton("Exit");
		
		add(l1);	add(l2);	add(l3);	add(l4);
		add(t1);	add(t2);	add(t3);	add(t4);
		add(b1);	add(b2);	add(b3);

		l1.setBounds(50,50,100,20);
		l2.setBounds(50,80,100,20);
		l3.setBounds(50,110,100,20);
		l4.setBounds(50,140,100,20);
			t1.setBounds(160,50,150,20);
			t2.setBounds(160,80,150,20);
			t3.setBounds(160,110,150,20);
			t4.setBounds(160,140,150,20);
		b1.setBounds(50,200,80,20);
		b2.setBounds(140,200,80,20);
		b3.setBounds(230,200,80,20);
		
		b1.setMnemonic('c');
		b2.setMnemonic('l');
		b3.setMnemonic('x');
		
		b1.setToolTipText("Convert");
		b2.setToolTipText("Clears each Field");
		b3.setToolTipText("Exit from Frame");
		
		t2.setEditable(false);
		t3.setEditable(false);
		t4.setEditable(false);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if (e.getSource()==b1)
			{
				if(t1.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Empty Field Occur Please Enter values in Integer");
					t1.requestFocus();
				}
				else
				{
					int n = Integer.parseInt(t1.getText());
					
					t2.setText(Integer.toString(n,2));
					t3.setText(Integer.toString(n,8));
					t4.setText(Integer.toString(n,16));
				}
			}
		}
		
		catch(NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(null,"You Entered String Please Enter values in Integer","Error",JOptionPane.ERROR_MESSAGE);
			t1.setText("");
			t1.requestFocus();
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

	
	public static void main(String a[])
	{
		new convert();
	}
}