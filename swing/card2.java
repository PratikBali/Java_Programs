// Card Layout
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

//<applet code=card2 width=450 height=200></applet>

public class card2 extends Applet implements ActionListener
{
	Checkbox w8,wt,sol,mac;
	Panel pn1;
	CardLayout card;
	Button win,other;
	public void init()
	{
		win = new Button("Windows");
		other = new Button("Other");
		
		add(win); add(other);
		
		card = new CardLayout();
		pn1 = new Panel();
		pn1.setLayout(card); // set PanelaLayout to CardLayout
		
		w8 = new Checkbox("Windows 8",null,true);
		wt = new Checkbox("Windows NT");
		sol = new Checkbox("Solaris");
		mac = new Checkbox("MacOS");
		
		Panel p1 = new Panel();
		p1.setBackground(Color.PINK);
		p1.add(w8);
		p1.add(wt);
		
		Panel p2 = new Panel();
		p2.setBackground(Color.RED);
		p2.add(sol);
		p2.add(mac);

		pn1.add(p1, "p1");
		pn1.add(p2, "p2");
		add(pn1);
		
		win.addActionListener(this);
		other.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==win)
			card.show(pn1, "p1");
			else
				card.show(pn1, "p2");
	}
}