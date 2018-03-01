import java.awt.*;
import java.awt.event.*;


class frame4 extends Frame implements ActionListener,ItemListener 
{
	// declaration
		Choice c;
		TextField t1,t2,t3;
		Label l1,l2,l3,l4;
		Button b1,b2,b3;
		
	frame4()
	{
		// frame properties
		setTitle("Pizza Information"); // can use super("")
		setSize(300,300);
		setLocation(350,150);
		setVisible(true);
	
			// allocating memory
			setLayout(null);
				//choice
			c = new Choice();
				//label
			l1 = new Label("Select Pizza Type");
			l2 = new Label("Prize");
			l3 = new Label("Quantity");
			l4 = new Label("total Bill");
				//text box
			t1=new TextField(20);		
			t2=new TextField(20);		
			t3=new TextField(20);	
				//buttons
			b1= new Button("Total");
			b2= new Button("Clear");
			b3= new Button("Exit");
			
			//add components to frame
			add(c); add(l1); add(l2); add(l3); add(l4);
			add(t1); add(t2); add(t3);
			add(b1); add(b2); add(b3);
			
			//add choices
			c.add("Select Pizza"); 	
			c.add("Veg Pizza");
			c.add("Masala Pizza");			
			c.add("Kolhapuri Pizza");
			
			
			t1.setEnabled(false);
			t3.setEnabled(false);
			
			//setting Boundry
			l1.setBounds(10,40,70,20);
			l2.setBounds(10,70,70,20);
			l3.setBounds(10,100,70,20);
			l4.setBounds(10,130,70,20);

			c.setBounds(120,40,140,20);
			t1.setBounds(120,70,140,20);
			t2.setBounds(120,100,140,20);
			t3.setBounds(120,130,140,20);

			b1.setBounds(50,170,40,20);
			b2.setBounds(100,170,40,20);
			b3.setBounds(150,170,40,20);
			
			//adding Listener
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			c.addItemListener(this);
			
			addWindowListener(new WindowAdapter ()
			{	
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});
	
	}
	// adding methods
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			try
			{ int a,b,c;
				a=Integer.parseInt(t1.getText());
				b=Integer.parseInt(t2.getText());
				c=a*b;
				t3.setText(Integer.toString(c));
			}
			catch(Exception ex)
			{
				t3.setText("Please Enter Valid Input");
			}
		}
		
		if(e.getSource()==b2)
		{
			c.select(0);
			t1.setText("");
			t2.setText("");
			t3.setText("");
		}
		
		if(e.getSource()==b3)
		{
			System.exit(0);
		}
	}
	public void itemStateChanged(ItemEvent e)
	{
		if(c.getSelectedIndex()==0)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
		}
		if(c.getSelectedIndex()==1)
		{
			t1.setText("100");
		}
		if(c.getSelectedIndex()==2)
		{
			t1.setText("150");
		}
		if(c.getSelectedIndex()==3)
		{
			t1.setText("300");
		}
	}


	

	public static void main(String a[])
	{
		new frame4();
	}
}
