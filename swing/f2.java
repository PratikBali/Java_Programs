import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class f2 extends JFrame implements ActionListener
{
	String rb,tf;
	JLabel l1;
	JButton b1;
	
	f2(String rb,String tf)
	{
		setTitle("Frame 2");
		setSize(400,400);
		setLocation(300,50);
		setLayout(new FlowLayout());		
		
		l1 = new JLabel(rb+" "+tf);
		b1 = new JButton("Show");
		
		add(l1);
		add(b1);

		b1.addActionListener(this);
	
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
			if(e.getSource()==b1)
			{
				new f1();
				dispose();
			}
	}
	

}

