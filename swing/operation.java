import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class operation extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JButton b1,b2,b3;
	int x,y,z;
	
	operation(int a, int b, int c)
	{
		
		super("Arithmatic Operations");
		setSize(300,200);
		setLocation(200,100);
		setLayout(new FlowLayout());
		
			x=a;	y=b;	z=c;
		l1=new JLabel("Number 1");
		l2=new JLabel("Number 2");
		l3=new JLabel("Answer");
		
		t1=new JTextField(""+a,20);
		t2=new JTextField(""+b,20);
		t3=new JTextField(""+c,20);
		t1.selectAll();
		t2.selectAll();
		t3.setEditable(false);

		b1=new JButton("Operation");
		b2=new JButton("Clear");
		b3=new JButton("Exit");
		
		add(l1);	add(t1);	add(l2);	add(t2);	add(l3);	add(t3);
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
			x=Integer.parseInt(t1.getText());
			y=Integer.parseInt(t2.getText());
			new oprSelect(x,y);
			dispose();
		}
		if (e.getSource()==b2)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
		}
		if(e.getSource()==b3)
		{
			System.exit(0);
		}
	}
	
	public static void main(String a[])
	{
		new operation(0,0,0);
	}
}
