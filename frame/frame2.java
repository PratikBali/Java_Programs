import java.awt.*;
import java.awt.event.*;

class frame2 extends Frame implements WindowListener
{
	frame2()
	{
	
		setTitle("Use of Window Listener to Close program"); // can use super("")
		setSize(500,500);
		setLocation(250,100);
		setVisible(true);
		
		addWindowListener(this);
	}

	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	public void windowClosed(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}

	public static void main(String a[])
	{
		new frame2();
	}
}
