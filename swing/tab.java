import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class tab extends JFrame implements ActionListener
{
	JTabbedPane tp;
	JButton b;

	tab()
	{
		setTitle("Tabbed Pane Demo");
		setSize(400,150);
		setLocation(250,200);
		setLayout(new FlowLayout());
	
		tp = new JTabbedPane();
		tp.addTab("Cities", new cityPanel());
		tp.addTab("Color", new colorPanel());
		tp.addTab("Flavour", new flavorPanel());
		add(tp);
		
		b=new JButton("New Frame");
		add(b);
		b.addActionListener(this);		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b)
		{
			new xyz();
			dispose();
		}
	}
	
	public static void main(String a[])
	{
		new tab();
	}
}


class xyz extends JFrame implements ActionListener
{
	JButton bb;
	xyz()
	{
		setTitle("My Simple Frame");
		setSize(200,200);
		setLocation(400,200);
		setLayout(new FlowLayout());
		
		bb=new JButton("back");
		add(bb);
		bb.addActionListener(this);		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bb)
		{
			new tab();
		}
	}
}

class cityPanel extends JPanel implements ActionListener
{
	JButton Btn_NY,Btn_HK,Btn_Lndn,Btn_TO;
	cityPanel()
	{
		Btn_NY = new JButton("New York");
		Btn_HK = new JButton("Hong Kong");
		Btn_Lndn = new JButton("London");
		Btn_TO = new JButton("Tokyo");
		
		add(Btn_NY);	add(Btn_HK);	add(Btn_Lndn);	add(Btn_TO);
		
		Btn_NY.addActionListener(this);
		Btn_HK.addActionListener(this);
		Btn_Lndn.addActionListener(this);
		Btn_TO.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(null,e.getActionCommand()+" City Selected");
	}
}

class colorPanel extends JPanel implements ItemListener
{
	JCheckBox r,g,b;
	
	colorPanel()
	{
		r = new JCheckBox("Red");
		g = new JCheckBox("Green");
		b = new JCheckBox("Blue");
	
		add(r);	add(g);	add(b);
		
		r.addItemListener(this);
		g.addItemListener(this);
		b.addItemListener(this);

	}
	
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource()==r)
		{
			if(r.isSelected()==true)
			JOptionPane.showMessageDialog(null,"Red Color Checked");
			else
			JOptionPane.showMessageDialog(null,"Red Color UnChecked");
		}
		
		if(e.getSource()==g)
		{
			if(g.isSelected()==true)
			JOptionPane.showMessageDialog(null,"Green Color Checked");
			else
			JOptionPane.showMessageDialog(null,"Green Color UnChecked");
		}

		if(e.getSource()==b)
		{
			if(b.isSelected()==true)
			JOptionPane.showMessageDialog(null,"Blue Color Checked");
			else
			JOptionPane.showMessageDialog(null,"Blue Color UnChecked");
		}
		
	}

}

class flavorPanel extends JPanel implements ItemListener
{
	JComboBox cb;
	
	flavorPanel()
	{
		cb = new JComboBox();
		cb.addItem("<select Flavours>");
		cb.addItem("IceCream");
		cb.addItem("Coco");
		cb.addItem("Butter");
		add(cb);
		
		cb.addItemListener(this);
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		if(cb.getSelectedIndex()==0)
		{
			JOptionPane.showMessageDialog(null,"Please Select Flavour");
		}

		if(cb.getSelectedIndex()==1)
		{
			JOptionPane.showMessageDialog(null,"IceCream Selected");
		}

		if(cb.getSelectedIndex()==2)
		{
			JOptionPane.showMessageDialog(null,"Coco Selected");
		}
		
		if(cb.getSelectedIndex()==3)
		{
			JOptionPane.showMessageDialog(null,"Butter Selected");
		}
		
	}

}
