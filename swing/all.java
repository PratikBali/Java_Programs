import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class all extends JFrame
{
	JLabel l1;
	JTextField t1;
	JButton b1;
	TextArea ta;
	JCheckBox cb1,cb2;
	JRadioButton rb1,rb2;
	ButtonGroup bg1;
	JMenuBar mbr;	JMenu m1,m2;	JMenuItem i1,i2,i3,i4; 
	JComboBox c1;
	
	all()
	{
		setTitle("All Controls");
		setSize(600,300);
		setLocation(100,100);
		setLayout(null);

		l1 = new JLabel ("I am label");
		add(l1);
		l1.setBounds(50,50,200,20);	
		
		t1 = new JTextField ("Welcome");
		add(t1);
		t1.setBounds(120,50,200,20);	
		
		b1 = new JButton("Button");
		add(b1);
		b1.setBounds(130,90,100,20);	
		
		ta = new TextArea();
		add(ta);
		ta.setBounds(340,50,200,140);	
		
		cb1 = new JCheckBox("Pen",true);
		add(cb1);
		cb1.setBounds(50,130,50,20);	
		
		cb2 = new JCheckBox("Pencil",false);
		add(cb2);
		cb2.setBounds(110,130,70,20);	
		
		bg1 = new ButtonGroup ();
			rb1 = new JRadioButton ("Page",true);
			rb2 = new JRadioButton ("Note",false);
		bg1.add(rb1);
		bg1.add(rb2);
			add(rb1);
			add(rb2);
		rb1.setBounds(180,130,70,20);	
		rb2.setBounds(250,130,70,20);
		
		mbr = new JMenuBar();
			m1 = new JMenu ("File"); 		m2 = new JMenu ("Edit"); 
		i1 = new JMenuItem ("Open");
		i2 = new JMenuItem ("Close");
		i3 = new JMenuItem ("Copy");
		i4 = new JMenuItem ("Paste");
			add(mbr);
			m1.add(i1);	m1.add(i2);	m2.add(i3);	m2.add(i4);
			mbr.add(m1);	mbr.add(m2);
		mbr.setBounds(0,0,600,20);	
		
		c1 = new JComboBox ();
			add(c1);
			c1.addItem("FYBCS");		c1.addItem("SYBCS");		c1.addItem("TYBCS");
		c1.setBounds(130,170,100,20);	



		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
		
	public static void main(String a[])
	{
		new all();
	}
}