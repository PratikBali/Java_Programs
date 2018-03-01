import java.awt.*;
import java.awt.event.*;

class frame6 extends Frame implements ActionListener
{
Button b1;
TextField t1;
Label l1;
frame6()
	{
		super("first frame");
		setSize(230,200);
		setLocation(10,10);
		setLayout(null);//setLayout(new FlowLayout());
			   
		t1=new TextField(20);
		add(t1);
		l1=new Label("Enter your name : ");
		add(l1);
		b1=new Button("show");
		add(b1);
		l1.setBounds(10,40,100,20);
		t1.setBounds(120,40,90,20);
		b1.setBounds(55,70,50,20);
			
		b1.addActionListener(this);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		setVisible(true);
	}
	
    public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
            new myframe(t1.getText());
			dispose();
		}     
	}

    public static void main(String args[])
    { 
        new frame6();
    }
}

class myframe extends Frame implements ActionListener
{	
	Button b2;
	Label l2;
	myframe(String name)
	{
		super("childframe");
		setSize(200,200);
		setLocation(210,210);
		setLayout(null);//ew FlowLayout());
		setBackground(Color.PINK);
		l2=new Label("Welcome " + name);
		add(l2);
		b2=new Button("back");
		add(b2);
		l2.setBounds(20,40,120,20);
		b2.setBounds(150,40,40,20);
		b2.addActionListener(this);

		addWindowListener(new WindowAdapter()
		{
		  public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		setVisible(true);
        }
		
		public void actionPerformed(ActionEvent e)
        {             
			if(e.getSource()==b2)
            {  
				new frame6();
				dispose();
 		    }    
        }
}