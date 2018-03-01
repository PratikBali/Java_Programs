import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class admission extends JFrame implements ActionListener
{
	//1] declaration 
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JButton b1,b2,b3,b4;
	JTextField t1,t2,t3,t4,t5,t6;
	JPanel pn;
	JComboBox cb1;

	admission()
  {
		super("Admissionission system");
		setSize(460,500);
		setLocation(100,100);
		setVisible(true);
		setLayout(null);	
		
		//2] memory allocation 
		l1=new JLabel("Marks of sub 1");
		l2=new JLabel("Marks of sub 2");
		l3=new JLabel("Marks of sub 3");
		l4=new JLabel("Total marks");
		l5=new JLabel("Percentage");
		l6=new JLabel("CET marks");
		l7=new JLabel("Select cast");
		l8=new JLabel("Out of 200"); 
		
    t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField("%");
		t6=new JTextField();

		b1=new JButton("Total");
		b2=new JButton("Clear");
		b3=new JButton("Exit");
		b4=new JButton("Submit");

		pn=new JPanel();
		cb1=new JComboBox();

		//3] add components on frame
		add(l1);	add(l2);	add(l3);	add(l4);	add(l5);	
		add(t1);	add(t2);	add(t3);	add(t4);	add(t5);
		add(b1);	add(b2);	add(b3); 
		add(pn);

		// on panel
		pn.add(l6);	pn.add(l7);	pn.add(l8);
		pn.add(t6);	pn.add(b4);	pn.add(cb1);

		cb1.addItem("<Select caste>");
		cb1.addItem("OBC");
		cb1.addItem("SC");
		cb1.addItem("NT");
		cb1.addItem("OPEN");	
	
		pn.setLayout(null);	
		pn.setBackground(Color.RED);

		//4] setbounds 
		l1.setBounds(40,50,120,20);
		l2.setBounds(40,80,120,20);
		l3.setBounds(40,110,120,20);
		l4.setBounds(40,140,120,20);
		l5.setBounds(40,170,120,20);
	
		t1.setBounds(150,50,120,20);
		t2.setBounds(150,80,120,20);
		t3.setBounds(150,110,120,20);
		t4.setBounds(150,140,120,20);
		t5.setBounds(150,170,120,20);
		
		b1.setBounds(280,50,120,40);
		b2.setBounds(280,100,120,40);
		b3.setBounds(280,150,120,40);
		
		pn.setBounds(30,240,390,200);	
		l6.setBounds(10,10,120,20); 	t6.setBounds(120,10,120,20);	l8.setBounds(260,10,120,20);
		l7.setBounds(10,40,120,20);    cb1.setBounds(120,40,120,20);	 b4.setBounds(250,40,120,20);	

		//5] addlistener
		b1.addActionListener(this);	b1.setMnemonic('T');
		b2.addActionListener(this);	b2.setMnemonic('C');
		b3.addActionListener(this);	b3.setMnemonic('X');
		b4.addActionListener(this);	b4.setMnemonic('S');

		t4.setEditable(false);     
		t5.setEditable(false);	
		t1.requestFocus();
		pn.setVisible(false);

		valid(t1);	valid(t2);	valid(t3);	valid(t6);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
	
	void valid(final JTextField tt)
	{
		tt.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				if(tt.getText().length()<3 && e.getKeyChar()>='0' && e.getKeyChar()<='9')

				super.keyTyped(e);    // optional

				else
				{
					e.consume();		// diascard the event
					Toolkit tk=Toolkit.getDefaultToolkit();
					tk.beep();	// raise the sound
				}
      }
		});
	}
	
	public void actionPerformed(ActionEvent e)
  {
		int p;
		if(e.getSource()==b1)
		{
			if(t1.getText().length()==0 || t2.getText().length()==0 || t3.getText().length()==0)
				JOptionPane.showMessageDialog(null,"All Fields Necessory !");
				t1.requestFocus();
			if(t1.getText().length()==0)
				t1.requestFocus();
			else if(t2.getText().length()==0)
				t2.requestFocus();
			else if(t3.getText().length()==0)
				t3.requestFocus();
			
			else
			{
				int a,b,c,d;
				a=Integer.parseInt(t1.getText());
				b=Integer.parseInt(t2.getText());
				c=Integer.parseInt(t3.getText());
				
				if(a<0 || a>100)
				{
						JOptionPane.showMessageDialog(null,"Subject 1 Marks Should be 0 to 100","Warning",JOptionPane.WARNING_MESSAGE);
						t1.setText("");						
						t1.requestFocus();		
				}
				else if(b<0 || b>100)
				{
						JOptionPane.showMessageDialog(null,"Subject 2 Marks Should be 0 to 100","Warning",JOptionPane.WARNING_MESSAGE);
						t2.setText("");						
						t2.requestFocus();		
				}
				else if(c<0 || c>100)
				{
						JOptionPane.showMessageDialog(null,"Subject 3 Marks Should be 0 to 100","Warning",JOptionPane.WARNING_MESSAGE);
						t3.setText("");						
						t3.requestFocus();		
				}
				else 
				{
					d=a+b+c;
					t4.setText(""+d);
					p=d/3;
					t5.setText(""+p+"%");
					if(p>=50)
					{
						pn.setVisible(true);
						JOptionPane.showMessageDialog(null,"Congrats You are Eligible for CET Exam !");
						t6.requestFocus();		
					}
					if(p>=40 && p<50)
					{
						pn.setVisible(true);
						JOptionPane.showMessageDialog(null,"Congrats ! You are Passed But Not Qualify !","Warning",JOptionPane.WARNING_MESSAGE);
						t6.requestFocus();		
					}
					if(p<40)
					{
						pn.setVisible(true);
						JOptionPane.showMessageDialog(null,"You are Failed in Board Exam","Error",JOptionPane.ERROR_MESSAGE);
						t6.requestFocus();		
					}
				}
			}
		}

		if(e.getSource()==b2)
		{	
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			cb1.setSelectedIndex(0);
			t1.requestFocus();
			pn.setVisible(false);
		}

		if(e.getSource()==b3)
		{
			 System.exit(0);
		}

		if(e.getSource()==b4)
		{
			if(t6.getText().length()==0 || cb1.getSelectedIndex()==0)                
			{			
				JOptionPane.showMessageDialog(null,"All Fields Must be Required!!!!");
				if(t6.getText().length()==0)
				t6.requestFocus();
				else
				cb1.requestFocus();
			}
			else if(Integer.parseInt(t6.getText())>200)
			JOptionPane.showMessageDialog(null,"CET marks must be bellow of 200!!!!","Invalid input!!",JOptionPane.WARNING_MESSAGE); 
			else
			{
				int m=Integer.parseInt(t6.getText());
				if((m>=160 && cb1.getSelectedIndex()==1)|| 
						(m>=170 && cb1.getSelectedIndex()==2)||
							(m>=180 && cb1.getSelectedIndex()==3)||
								(m>=190 && cb1.getSelectedIndex()==4))
					JOptionPane.showMessageDialog(null,"You are allowed for Admission!!!!");
						else
					JOptionPane.showMessageDialog(null,"You are not allowed for Admission!!!!","Error",JOptionPane.WARNING_MESSAGE);
			
			}
		}
	}

	public static void main(String args[])
  {
		new admission();
  }
}


