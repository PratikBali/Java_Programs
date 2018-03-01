import java.applet.*;
import java.awt.*;
import java.awt.event.*;

// <applet code = "applet21" width = 500 height = 500></applet>

public class applet21 extends Applet implements ActionListener
{
	// Declaration
	List l1,l2;
	Button b1,b2,b3,b4,b5,b6,b7,b8;
	TextField t;
	
	public void init()
	{
		setLayout(null);
		
		// Allocating Memory
		l1 = new List(15,true);			//list box 
		l2 = new List(15,true);			
		b1 = new Button("> 1");			//Buttons
		b2 = new Button("< 2");			
		b3 = new Button(">> 3");
		b4 = new Button("<< 4");
		b5 = new Button("Add 5");
		b6 = new Button("Rem 6");
		b7 = new Button("Add 7");
		b8 = new Button("Rem 8");
		t = new TextField(30);			//TextField
		
		// Add to Applet
		add(l1); add(l2); //list
		add(b1); add(b2);; add(b3); add(b4); add(b5); add(b6); add(b7); add(b8);	//button
		add(t);
		
		l1.add("IceCream"); 		
		l1.add("JellyBean");
		l1.add("Sandwich");			
		l1.add("KitKat");

		l2.add("Windows XP"); 		
		l2.add("Windows Vista");
		l2.add("Windows 7");			
		l2.add("Windows 8");
		
		// Set Bounds
		l1.setBounds(10,10,150,200);
		l2.setBounds(225,10,150,200);
		
		b1.setBounds(170,20,40,30);
		b2.setBounds(170,60,40,30);
		b3.setBounds(170,100,40,30);
		b4.setBounds(170,140,40,30);

		t.setBounds(120,230,150,30);
		
		b5.setBounds(10,270,40,30);
		b6.setBounds(70,270,50,30);
		b7.setBounds(230,270,40,30);
		b8.setBounds(275,270,50,30);
		
		// ADD Listener
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==b1)						// adding ListBox1 to listBox2
		{
			int i;
			String s[] = l1.getSelectedItems();
			if (s.length != 0)
			{
				for(i=0;i<s.length;i++)
				{
					l2.add(s[i]);
					l1.remove(s[i]);					
				}
			}
		}

		if (e.getSource()==b2)
		{
			int i;
			String s[] = l2.getSelectedItems();
			if (s.length != 0)
			{
				for(i=0;i<s.length;i++)
				{
					l2.remove(s[i]);
					l1.add(s[i]);					
				}
			}
		}
		
		if(e.getSource()==b3)
		{
			int i;
			String s[]=l1.getItems();
			if(s.length!=0)
			{
				for(i=0;i<s.length;i++)
				{
					l2.add(s[i]);
					l1.remove(s[i]);
				}
			}
		}
	
		if(e.getSource()==b4)
		{
			int i;
			String s[]=l2.getItems();
			if(s.length!=0)
			{
				for(i=0;i<s.length;i++)
				{
					l1.add(s[i]);
					l2.remove(s[i]);
				}
			}
		}

 String mesg=t.getText();
  if(e.getSource()==b5)
    {
      t.setText(mesg);        
      l1.add(mesg);
    }
  else
    {
      t.equals(l1);
     mesg=mesg +"It is already exit"+l1;
     showStatus(mesg);
    }

 String msg=t.getText();
  if(e.getSource()==b7)
   {
    t.setText(msg);        
    l2.add(msg);
   }


 if(e.getSource()==b6)
  {
   int i;
   String s[]=l1.getSelectedItems();
   if(s.length!=0)
    {
     for(i=0;i<s.length;i++)
      {
       l1.remove(s[i]);
      }
    }
  }
 
 
 if(e.getSource()==b8)
  {
   int i;
   String s[]=l2.getSelectedItems();
   if(s.length!=0)
    {
     for(i=0;i<s.length;i++)
      {
       l2.remove(s[i]);
       }
     }
   }

	
	}
}