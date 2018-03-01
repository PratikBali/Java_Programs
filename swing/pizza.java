import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class pizza extends JFrame implements ItemListener,ActionListener
{
	JComboBox cb_pizza;
	JLabel lbl_price,lbl_qnt,lbl_tot,lbl_tot_col;
	JTextField tf_price,tf_qnt,tf_tot,tf_tot_col;
	List lst;
	JButton btn_tot,btn_clr,btn_ext;

	pizza()
	{
		setTitle("My Pizza hut");
		setSize(400,450);
		setLocation(250,120);
		setBackground(Color.RED);
		setLayout(null);
		
		cb_pizza = new JComboBox();
		lst = new List();
		
		lbl_price = new JLabel("Price");
		lbl_qnt = new JLabel("Quantity");
		lbl_tot = new JLabel("Total");
		lbl_tot_col = new JLabel("Total Collection");
		
		tf_price = new JTextField(20);
		tf_qnt = new JTextField(20);
		tf_tot = new JTextField(20);
		tf_tot_col = new JTextField(20);
		
		btn_tot = new JButton("Total");
		btn_clr = new JButton("Clear");
		btn_ext = new JButton("Exit");

		btn_tot.setMnemonic('t');
		btn_clr.setMnemonic('c');
		btn_ext.setMnemonic('x');
		
		cb_pizza.addItem("<select Pizza>");
		cb_pizza.addItem("Veg Pizza");
		cb_pizza.addItem("Masala Pizza");
		cb_pizza.addItem("Baramati Pizza");
		cb_pizza.addItem("Simple Pizza");
		
		lst.add("Description");
		lst.add("-----------------");
		
		add(cb_pizza);
		add(lst);
		add(lbl_price);	add(lbl_qnt);	add(lbl_tot);	add(lbl_tot_col);
		add(tf_price);	add(tf_qnt);	add(tf_tot);	add(tf_tot_col);
		add(btn_tot);	add(btn_clr);	add(btn_ext);
		
		tf_price.setEditable(false);
		tf_tot.setEditable(false);
		tf_tot_col.setEditable(false);
		
		cb_pizza.setBounds(20,20,130,20);
		lst.setBounds(20,190,150,200);
		
		lbl_price.setBounds(170,20,100,20);
		lbl_qnt.setBounds(170,50,100,20);
		lbl_tot.setBounds(170,80,100,20);
		lbl_tot_col.setBounds(240,190,100,40);
		
		tf_price.setBounds(240,20,100,20);
		tf_qnt.setBounds(240,50,100,20);
		tf_tot.setBounds(240,80,100,20);
		tf_tot_col.setBounds(240,230,100,20);
		
		btn_tot.setBounds(20,140,100,30);
		btn_clr.setBounds(130,140,100,30);
		btn_ext.setBounds(240,140,100,30);
		
		cb_pizza.addItemListener(this);
		btn_tot.addActionListener(this);
		btn_clr.addActionListener(this);
		btn_ext.addActionListener(this);
		
		valid(tf_qnt);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void valid(final JTextField tt)
	{
		tt.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				if(tt.getText().length()<3 && e.getKeyChar()>='0' && e.getKeyChar()<='9')
				super.keyTyped(e);    // optional
				else
				{
					e.consume();		// discard the event
					Toolkit tk=Toolkit.getDefaultToolkit();;
					tk.beep();	// raise the sound
				}
            }
		});
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource()==cb_pizza)
		{
			if(cb_pizza.getSelectedIndex()==0)
			{
				tf_price.setText("");
				tf_qnt.setText("");
				tf_tot.setText("");
			}
			if(cb_pizza.getSelectedIndex()==1)				tf_price.setText("100");
			if(cb_pizza.getSelectedIndex()==2)				tf_price.setText("150");
			if(cb_pizza.getSelectedIndex()==3)				tf_price.setText("300");
			if(cb_pizza.getSelectedIndex()==4)				tf_price.setText("600");

			tf_qnt.requestFocus();
		}
	}
	
	int a,b,c,tot=0;
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btn_tot)
		{
			try
			{ 
				if(tf_price.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"You Must Select Pizza");
					cb_pizza.requestFocus();
				}
				else if(tf_qnt.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Please Give Quantity");
					tf_qnt.requestFocus();
				}
				{
					
					a=Integer.parseInt(tf_price.getText());
					b=Integer.parseInt(tf_qnt.getText());
					c=a*b;
					
					tf_tot.setText(""+c);
					lst.add(""+c);
					
					tot = tot+c;
					tf_tot_col.setText(""+tot);
				}
			}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(null,"Please Give valid Inputs","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(e.getSource()==btn_clr)
		{
			cb_pizza.setSelectedIndex(0);
			tf_price.setText("");
			tf_qnt.setText("");
			tf_tot.setText("");
		}
		
		if(e.getSource()==btn_ext)
		{
			System.exit(0);
		}
	}
	
	public static void main(String a[])
	{
		new pizza();
	}
}
