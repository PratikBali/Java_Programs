import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class combo extends JFrame implements ItemListener,ActionListener
{
	JComboBox cb1;
	JTextField t1;
	JButton b1,b2;
	List l1;

	combo()
	{
		setTitle("Combo Box ");
		setSize(400,400);
		setLocation(250,200);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cb1 = new JComboBox();
		t1 = new JTextField(20);
		b1 = new JButton("ADD");
		b2 = new JButton("Remove");
		l1 = new List();
		
		add(cb1); add(t1); add(b1); add(b2); add(l1);
		cb1.addItem("<Select>");
		cb1.addItem("A");
		cb1.addItem("B");
		cb1.addItem("C");
		cb1.addItem("D");
		
		cb1.setBounds(20,20,100,20);
		t1.setBounds(140,20,200,20);
		b1.setBounds(20,60,100,20);
		b2.setBounds(20,90,100,20);
		l1.setBounds(140,60,200,200);
		
		cb1.addItemListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource()==cb1)
		{
			if(cb1.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(null,"Please Select item","Warning",JOptionPane.WARNING_MESSAGE);
				t1.setText("");
				t1.requestFocus();
			}
			else
			t1.setText(cb1.getSelectedItem().toString()+" is at Index "+cb1.getSelectedIndex());
		
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(t1.getText().length()<=0)
			{
			JOptionPane.showMessageDialog(null,"Empty TextField","Error",JOptionPane.ERROR_MESSAGE);
			}
			else
			l1.add(t1.getText());
			t1.setText("");
			t1.requestFocus();
		}
		
		if(e.getSource()==b2)
		{
			
		}
	}
	
	public static void main(String a[])
	{
		new combo();
	}
}
