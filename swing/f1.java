import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class f1 extends JFrame implements ActionListener
{
	JLabel l1;
	JTextField t1;
	JRadioButton rb1,rb2;
	ButtonGroup bg;
	JButton b1;

	f1()
	{
		setTitle("Frame 1");
		setSize(350,400);
		setLocation(250,100);
		setLayout(new FlowLayout());
		
		l1 = new JLabel("Enter Your Name ");
		t1 = new JTextField(20);
		rb1 = new JRadioButton("Hi");
		rb2 = new JRadioButton("Hello");
		bg = new ButtonGroup();
		b1 = new JButton("Show");
		
		add(l1);
		add(t1);
		add(rb1);
		add(rb2);
		bg.add(rb1);
		bg.add(rb2);
		add(b1);
		
		b1.addActionListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
			if(e.getSource()==b1)
			{	
				if(rb1.isSelected()==true)
				{
					new f2(rb1.getText(),t1.getText());
					dispose();
				}
				else if(rb2.isSelected()==true)
				{
					new f2(rb2.getText(),t1.getText());
					dispose();
				}
			}
	}
	
	
	public static void main(String a[])
	{
		new f1();
	}
}

