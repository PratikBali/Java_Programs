import java.applet.*;
import java.awt.*;
import javax.swing.*;

//<applet code=box1 width=450 height=200></applet>

public class box1 extends Applet
{
	public void init()
	{
		Panel jpv = new Panel();
		jpv.setLayout(new BoxLayout(jpv, BoxLayout.Y_AXIS));
		jpv.setBackground(Color.RED);
		
		for (int i=0;i<5;i++)
			jpv.add(new Button(""+i));
			
		Panel jph = new Panel ();
		jph.setLayout(new BoxLayout(jph, BoxLayout.X_AXIS));
		jph.setBackground(Color.GREEN);
		
		for (int i=0;i<5;i++)
			jph.add(new Button(""+i));
		
		add(BorderLayout.EAST, jpv);
		add(BorderLayout.SOUTH, jph);
		
	}
}