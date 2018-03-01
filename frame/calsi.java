import java.awt.*;
import java.awt.event.*;

class calsi extends Frame 
{
	TextField t;
	Button b[];
	
	calsi()
	{
		super ("Calsi");
		setSize(300,400);
		setLocation(350,150);
		
		setLayout(null);
		
		t = new TextField(70);
		
		b = new Button[17];

		for(int i=0;i<=9;i++)
		{
			b[i] = new Button(i);
		}
		
		b[10]=new Button("+");
		b[11]=new Button("-");
		b[12]=new Button("*");
		b[13]=new Button("/");
		b[14]=new Button("=");
		b[15]=new Button("Clear");
		b[16]=new Button("Exit");

		for(int i=0;i<17;i++)
		 {add(b[i]);}
	}
	
	public static void main(String a[])
	{
		new calsi();
	}

}