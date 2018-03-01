import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*; 

class swing extends JFrame implements ActionListener
{
	swing()
	{
		setTitle("Simple Swing Frame");
		setSize(500,500);
		setLocation(100,100);
		setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		
	}
	
	public static void main(String a[])
	{
		new swing();
	}	
}