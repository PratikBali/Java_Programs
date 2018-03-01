import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class child extends JFrame implements ActionListener
{
	JTextField t1;
	JButton b1;
	String s;
	
	child(String s)
	{
		super("Multi Frame : child Frame");
		setSize(400,400);
		setLocation(400,200);
		setLayout(new FlowLayout());

		t1=new JTextField("Welcome "+s);
		b1=new JButton("Back");
		
		add(t1);
		add(b1);
			b1.addActionListener(this);
	
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				new parent(); 
				dispose();
			}
		});
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==b1)
		{
			new parent();
			dispose();
		}
	}
}
