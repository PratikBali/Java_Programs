import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class radio_btn extends JFrame implements ActionListener
{
	JTextField tf;
	JRadioButton rb1,rb2,rb3;
	ButtonGroup bg;
	

	radio_btn()
	{
		setTitle("RadioButton Demo");
		setSize(200,130);
		setLocation(250,200);
		setLayout(null);
		
		tf = new JTextField("welcome",20);
		add(tf);
		tf.selectAll();
		
		rb1=new JRadioButton("A",true);
		rb2=new JRadioButton("B");
		rb3=new JRadioButton("C");
		add(rb1);
		add(rb2);
		add(rb3);
		rb1.addActionListener(this);
		rb2.addActionListener(this);
		rb3.addActionListener(this);
		
		bg = new ButtonGroup();
		 bg.add(rb1);
		 bg.add(rb2);
		 bg.add(rb3);
		 
		rb1.setBounds(20,20,40,20);
		rb2.setBounds(70,20,40,20);
		rb3.setBounds(120,20,40,20);
		tf.setBounds(20,50,150,20);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		tf.setText(e.getActionCommand()+" Selected");
		
		tf.requestFocus();
	}
	
	public static void main(String a[])
	{
		new radio_btn();
	}
}


