import java.awt.*;
import java.awt.event.*;

class frame5 extends Frame implements ActionListener
{
Button b1;
frame5()
{
	super("first frame");
	setSize(200,200);
	setLocation(10,10);
	setLayout(new FlowLayout());
           
	
	b1=new Button("new frame");
	add(b1);
		
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
                  new myframe();
		dispose();
 }         }

    public static void main(String args[])
           {
                  new frame5();
          }
 }

class myframe extends Frame implements ActionListener
{	
	Button b2;
	myframe()

	{
		super("childframe");
	setSize(200,200);
	setLocation(210,210);
	setLayout(new FlowLayout());
	setBackground(Color.PINK);
	b2=new Button("back");
	add(b2);
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
			new frame5();
				dispose();
 		      }    
           }

}


