import java.awt.*;
import javax.swing.*;

class MyFrame extends JFrame
{

	MyFrame()
	{
		setTitle("My Simple Frame");
		setSize(400,400);
		setLocation(250,200);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String a[])
	{
		new MyFrame();
	}
}
