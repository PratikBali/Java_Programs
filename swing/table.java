import java.awt.*;
import javax.swing.*;

public class table extends JFrame
{
	table()
	{
		setTitle("Table Demo");
		setSize(200,200);
		setLocation(250,200);
	
		String col[] = {"Name","Phone","Fax"};
		String data[][] = {
							{"apj","555","999"},{"apj","555","999"},
							{"apj","555","999"},{"apj","555","999"},
							{"apj","555","999"},{"apj","555","999"},
							{"apj","555","999"},{"apj","555","999"},
							{"apj","555","999"},{"apj","555","999"},
							{"apj","555","999"},{"apj","555","999"},
							{"apj","555","999"},{"apj","555","999"},
		};
		
		JTable tbl = new JTable(data,col);
		add(tbl);
		tbl.setEnabled(false);
		
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane sp = new JScrollPane(tbl,v,h);
		add(sp);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String a[])
	{
		new table();
	}
}
