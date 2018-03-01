import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class oprSelect extends JFrame implements ActionListener
{
	JRadioButton rb1,rb2,rb3,rb4;
	ButtonGroup bg;
	JButton b1,b2,b3;
	int p,q,r;
	oprSelect(int a,int b)
	{
		super("Arithmatic oprSelects");
		setSize(400,100);
		setLocation(200,100);
		setLayout(new FlowLayout());

		p=a; q=b;

		bg=new ButtonGroup();

		rb1=new JRadioButton("Addition");
		rb2=new JRadioButton("Subtraction");
		rb3=new JRadioButton("Multiplication");
		rb4=new JRadioButton("Division");

		b1=new JButton("Submit");
		b2=new JButton("Back");
		b3=new JButton("Exit");

		bg.add(rb1);	bg.add(rb2);	bg.add(rb3);	bg.add(rb4);
		add(rb1);	add(rb2);	add(rb3);	add(rb4);
		add(b1);	add(b2);	add(b3);
	
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==b1)
		{
			if(rb1.isSelected())
				r=p+q;
			else if(rb2.isSelected())
				r=p-q;
			else if(rb3.isSelected())
				r=p*q;
			else if(rb4.isSelected())
				r=p/q;
				
			new operation(p,q,r);
			dispose();
		}
		else
		{
			new operation(p,q,r);
			dispose();
		}
	}
}
