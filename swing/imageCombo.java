import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class imageCombo extends JFrame implements ItemListener
{
	JLabel lbl;
	JComboBox cb;

	imageCombo()
	{
		setTitle("imageCombo Demo");
		setSize(700,600);
		setLocation(50,10);
		setLayout(null);
		//setResizable(false);
		
		lbl = new JLabel(new ImageIcon("Blue hills.jpg"));
		
		add(lbl);
		
		cb = new JComboBox();
		cb.addItem("Blue hills");
		cb.addItem("Water lilies");
		cb.addItem("Sunset");
		cb.addItem("Winter");
		add(cb);
		
		lbl.setBounds(50,50,600,500);
		cb.setBounds(10,10,100,20);
		
		cb.addItemListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void itemStateChanged(ItemEvent e)
	{
			if (cb.getSelectedIndex()==0)
				lbl.setIcon(new ImageIcon("Blue hills.jpg"));
			if (cb.getSelectedIndex()==1)
				lbl.setIcon(new ImageIcon("Water lilies.jpg"));
			if (cb.getSelectedIndex()==2)
				lbl.setIcon(new ImageIcon("Sunset.jpg"));
			if (cb.getSelectedIndex()==3)
				lbl.setIcon(new ImageIcon("Winter.jpg"));
	}
	
	public static void main(String a[])
	{
		new imageCombo();
	}
}

