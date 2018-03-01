import java.awt.*;
import java.awt.event.*;

class frame3 extends Frame
{
	frame3()
	{
	
		setTitle("Use of Window Adapter in program to Close Frame"); // can use super("")
		setSize(500,500);
		setLocation(250,100);
		setVisible(true);
		
		addWindowListener(new WindowAdapter ()
		{	
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}

	

	public static void main(String a[])
	{
		new frame3();
	}
}
