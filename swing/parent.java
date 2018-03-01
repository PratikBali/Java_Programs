import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class parent extends JFrame implements ActionListener
{
	JTextField t1;
	JButton b1;
	
	parent()
	{
		super("Multi Frame : Parent Frame");
		setSize(400,400);
		setLocation(200,100);
		setLayout(new FlowLayout());

		t1=new JTextField(20);
		b1=new JButton("Click me");
		
		add(t1);
		add(b1);
		
		b1.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==b1)
		{
			new child(t1.getText());
			dispose();
		}
	}
	
	public static void main(String a[])
	{
		new parent();
	}
}
