// Simple Swing Program to Show Controls and add listener on Single Button

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class control extends JFrame implements ActionListener
{
	JLabel l1;
	JTextField t1;
	JButton b1;
	
	control()
	{
		super("Simple Controls");
		setSize(500,500);
		setLocation(300,100);
		setLayout(new FlowLayout());
		
		l1 = new JLabel("Enter your Name");
		t1 = new JTextField("Pratik",20);
		b1 = new JButton("Click");
		
		add(l1);
		add(t1);
		add(b1);
		
		b1.addActionListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			t1.setText("Button Clicked");
		}
	}
	
	public static void main(String a[])
	{
		new control();
	}
}
