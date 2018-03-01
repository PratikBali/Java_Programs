import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.text.*;
import java.awt.event.*;

class BillTable extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JButton b1,b2,b3,b4;
	JTable tab;
	DefaultTableModel mdl;

	Object colHead[] = {"Item ID","Item Name","Item Price"};
	Object data[][]={{"","Total Bill = ",new Integer(0)}};
	
	JScrollPane sp;
	int i=0,j;

	BillTable()
	{
		setTitle("Bill Table ");
		setSize(470,500);
		setLocation(100,100);
		setLayout(null);
		
		l1 = new JLabel("Item ID");
		l2 = new JLabel("Item Name");
		l3 = new JLabel("Item Price");
		
		t1 = new JTextField("item id");
		t1.selectAll();
		t2 = new JTextField(20);
		t2.setToolTipText("Enter Item Name");
		t3 = new JTextField(20);
		valid(t3);
	
		b1 = new JButton("Total");
		b2 = new JButton("Print");
		b3 = new JButton("Clear");
		b4 = new JButton("Exit");

		b1.setMnemonic('t');
		b2.setMnemonic('p');
		b3.setMnemonic('c');
		b4.setMnemonic('x');

		b1.setToolTipText("Total bill");
		b2.setToolTipText("Prints The Bill");
		b3.setToolTipText("Clears Each Field");
		b4.setToolTipText("Exit");
		
		add(l1);	add(l2);	add(l3);
		add(t1);	add(t2);	add(t3);
		add(b1);	add(b2);	add(b3);	add(b4);
		
		l1.setBounds(30,30,100,20);		t1.setBounds(140,30,100,20);
		l2.setBounds(30,60,100,20);		t2.setBounds(140,60,100,20);
		l3.setBounds(30,90,100,20);		t3.setBounds(140,90,100,20);
		b1.setBounds(40,120,90,20);		b2.setBounds(140,120,90,20);
		b3.setBounds(240,120,90,20);		b4.setBounds(340,120,90,20);
		
		b1.addActionListener(this);		b2.addActionListener(this);
		b3.addActionListener(this);		b4.addActionListener(this);
		
		mdl = new DefaultTableModel(data,colHead);
		
		tab = new JTable(mdl)
		{
			public Class getColumnClass(int Column)
			{
				switch(Column)
				{
					case 0: return String.class;
					case 1: return String.class;
					default: return Integer.class;
				}
			}
		};

// Resize the Column
		DefaultTableColumnModel colModel = (DefaultTableColumnModel)tab.getColumnModel();
		TableColumn col = colModel.getColumn(0);
		
		col = colModel.getColumn(0); col.setPreferredWidth(50);
		col = colModel.getColumn(1); col.setPreferredWidth(240);
		col = colModel.getColumn(2); col.setPreferredWidth(100);
		
		sp = new JScrollPane(tab);
		add(sp);
		sp.setBounds(30,150,400,300);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void valid(final JTextField tt)
	{
		tt.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
				if(tt.getText().length()<6 && e.getKeyChar()>='0' && e.getKeyChar()<='9')

				super.keyTyped(e);    // optional

				else
				{
					e.consume();		// diascard the event
					Toolkit tk=Toolkit.getDefaultToolkit();
					tk.beep();	// raise the sound
				}
            }
		});
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(t1.getText().length()==0 || t2.getText().length()==0 || t3.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null,"All Fields Are Necessory");
				if(t1.getText().length()==0)
				{t1.selectAll();t1.requestFocus();}
				if(t2.getText().length()==0)
				{t2.requestFocus();}
				if(t3.getText().length()==0)
				{t3.requestFocus();}
			}
		
			else
			{
// To get The Total value
				int row = mdl.getRowCount();
				int tot_val = Integer.parseInt((mdl.getValueAt(row-1,2)).toString());

				row = mdl.getRowCount();
				mdl.setValueAt(t1.getText(),row-1,0);
				mdl.setValueAt(t2.getText(),row-1,1);
				mdl.setValueAt(t3.getText(),row-1,2);

				tot_val = tot_val + Integer.parseInt(t3.getText());
				
				t1.setText(null);
				t2.setText("");
				t3.setText("");
				t1.requestFocus();

				mdl.addRow(colHead);
				row = mdl.getRowCount();
				mdl.setValueAt("",row-1,0);
				mdl.setValueAt("Total Bill",row-1,1);
				mdl.setValueAt(tot_val,row-1,2);
			}
		}
	
	
		if(e.getSource()==b2)
		{
			try
			{
				MessageFormat header = new MessageFormat("MY First bill Table");
				MessageFormat footer = new MessageFormat("page{0,number,integer}");
				
				tab.print(JTable.PrintMode.NORMAL,header,footer);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		if(e.getSource()==b3)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t1.requestFocus();
		}
		
		if(e.getSource()==b4)
		{
			System.exit(0);
		}

	
	}
	public static void main(String a[])
	{
		new BillTable();
	}
}

