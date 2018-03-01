import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class simple extends JFrame
{
	simple()
	{
		setTitle("Swing with Database");
		setSize(500,500);
		setLocation(100,100);
		setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String a[])
	{
		new simple();
	}
}




/*
if(tf_roll.getText().length()==0 || tf_name.getText().length()==0 || tf_age.getText().length()==0)
						{
							JOptionPane.showMessageDialog(null,"All Fields Are Necessory");
							if(tf_roll.getText().length()==0)
								JOptionPane.showMessageDialog(null,"Please Insert Roll No.");
							if(tf_name.getText().length()==0)
								JOptionPane.showMessageDialog(null,"Please Insert Name");
							if(tf_age.getText().length()==0)
								JOptionPane.showMessageDialog(null,"Please Insert Age");
						}
*/
