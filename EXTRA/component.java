import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class component extends JFrame implements ItemListener
{
	JPanel p1,p2,p3,p4,p5;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JCheckBox cb[] = new JCheckBox[6];
	JRadioButton r1,r2,r3,r4,r5;
	ButtonGroup b1,b2;
	JTextField t1,t2,t3,t4;
	

	component()
	{
		setTitle("JCheckBox and JRadioButton");
		setSize(400,450);
		setLocation(450,130);
		setLayout(null);
		
		//memory allocation
		l1 = new JLabel("Select Language You can Speak : ");
		l2 = new JLabel("Select Programming Language : ");
		l3 = new JLabel("Select Your Gender : ");
		l4 = new JLabel("Select Your Class : ");
		l5 = new JLabel("Selected Language : ");
		l6 = new JLabel("Programming Language: ");
		l7 = new JLabel("Selected Gender : ");
		l8 = new JLabel("Selected Class : ");
		
		cb[0] = new JCheckBox(" Marathi ",true);
		cb[1] = new JCheckBox(" Hindi ");
		cb[2] = new JCheckBox(" English ");
		cb[3] = new JCheckBox(" C ",true);
		cb[4] = new JCheckBox(" CPP ");
		cb[5] = new JCheckBox(" Java ");
		
		b1 = new ButtonGroup();
		r1 = new JRadioButton("Male",true);
		r2 = new JRadioButton("Female");
		
		b2 = new ButtonGroup();
		r3 = new JRadioButton("FYBCS",true);
		r4 = new JRadioButton("SYBCS");
		r5 = new JRadioButton("TYBCS");

		t1 = new JTextField(30);
		t2 = new JTextField(30);
		t3 = new JTextField(30);
		t4 = new JTextField(30);
	
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		
		// add component to frame 
			p1.add(l1);
			p1.add(cb[0]);
			p1.add(cb[1]);
			p1.add(cb[2]);
			add(p1);
			p1.setBounds(10,10,250,50);
		p2.add(l2);
		p2.add(cb[3]);
		p2.add(cb[4]);
		p2.add(cb[5]);
		add(p2);
		p2.setBounds(20,80,220,50);
			b1.add(r1);
			b1.add(r2);
			p3.add(l3);
			p3.add(r1);
			p3.add(r2);
			add(p3);
			p3.setBounds(10,140,300,30);
		b2.add(r3);
		b2.add(r4);
		b2.add(r5);
		p4.add(l4);
		p4.add(r3);
		p4.add(r4);
		p4.add(r5);
		add(p4);
		p4.setBounds(20,180,350,30);
			p5.add(l5);
			p5.add(t1);
			p5.add(l6);
			p5.add(t2);
			p5.add(l7);
			p5.add(t3);
			p5.add(l8);
			p5.add(t4);
	
			p5.setBounds(10,220,350,200);
			add(p5);
			
		// add Listener
		for(int i=0;i<5;i++)
		{
			cb[i].addItemListener(this);
		}
		r1.addItemListener(this);
		r2.addItemListener(this);
		r3.addItemListener(this);
		r4.addItemListener(this);
		r5.addItemListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		String m1,m2;
		m1 = "Bol Ki bhava ";
		m2 = " Your Prog. Lang. = ";
		
		for(int i=0;i<3;i++)
		{
			if (cb[i].isSelected())
			m1 += ""+cb[i].getText();
		}t1.setText(m1);
		
		for (int i=3;i<6;i++)
		{
			if(cb[i].isSelected())
			m2 += ""+cb[i].getText();
		}t2.setText(m2);
		
		if(r1.isSelected())
		{
			t3.setText("Your Gender = "+r1.getText());
		}
		else
		t3.setText("Your Gender = "+r2.getText());
		
		if(r3.isSelected())
		{
			t4.setText("Your Class ="+r3.getText());
		}
		else
				if(r4.isSelected())
		{
			t4.setText("Your Class ="+r4.getText());
		}
		else

		t4.setText("Your gender ="+r5.getText());
	}
	
	public static void main(String a[])
	{
		new component();
	}
}