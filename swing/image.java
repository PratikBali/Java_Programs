import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class image extends JFrame
{
	ImageIcon img;
	JLabel lbl;

	image()
	{
		setTitle("Image Demo");
		setSize(810,500);
		setLocation(50,10);
		setLayout(null);
		//setResizable(false);
		
		img = new ImageIcon("Sunset.jpg");
		lbl = new JLabel(img);
		add(lbl);
		
		lbl.setBounds(50,50,385,425);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String a[])
	{
		new image();
	}
}

