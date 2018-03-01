import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class sw1 extends JFrame implements ActionListener
{
   //1] declaration

  JLabel l1,l2,l3;
  JButton b1,b2,b3;
  JTextField t1,t2,t3;
  
  sw1()
  {
	setTitle("My First Project Frame");
	setSize(300,250);
	setLocation(200,200);
	setLayout(null);

	//2]MEMORY ALLOCATION

	b1= new JButton("Add");
	b2= new JButton("Clear");
	b3= new JButton("Exit");
	t1=new JTextField();
	t2=new JTextField();
	t3=new JTextField();
	l1=new JLabel("Enter 1st no    : ");
	l2=new JLabel("Enter 2st no    : ");
	l3=new JLabel("Additon of 2 no : ");

	//3] ADD COMPONENTS TO FRAME/APPLET

	add(t1); 	add(t2);	add(t3);
	add(l1);	add(l2);	add(l3);
	add(b1);	add(b2);  	add(b3);     

	b1.setMnemonic('A');
	b2.setMnemonic('C');
	b3.setMnemonic('x');
		
	t1.setToolTipText("Enter only Digit");
	b1.setToolTipText("Performs Addition");
	b2.setToolTipText("Performs Clear All TextField");
	b3.setToolTipText("Exit From Window");
		
	//4]SETBOUNDS TO EACH COMPONENT

	l1.setBounds(50,50,100,20);		
	t1.setBounds(160,50,100,20);
	
	l2.setBounds(50,80,100,20);		
	t2.setBounds(160,80,100,20);
	
	l3.setBounds(50,110,100,20);		
	t3.setBounds(160,110,100,20);
	
	b1.setBounds(50,155,60,20);		
	b2.setBounds(120,155,60,20);
	b3.setBounds(190,155,60,20);
	
	//5] ADD LISTENER ON COMPONENTS

	b1.addActionListener(this);		
	b2.addActionListener(this);
	b3.addActionListener(this);
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==b1)
			{
				int a=Integer.parseInt(t1.getText());
				int b=Integer.parseInt(t2.getText());
				int c=a+b;
				t3.setText(Integer.toString(c));
			}
			
			if(e.getSource()==b2)
			{
				t1.setText("");		t2.setText("");		t3.setText(""); 
				t1.requestFocus();
			}

			if(e.getSource()==b3)
			{
				System.exit(0);
			}
		}
		
		catch(NumberFormatException ex)
		{
			t3.setText("Kai laka Bhava");
		}
	}

		public static void main(String a[])
		{
			new sw1();
		}
}

