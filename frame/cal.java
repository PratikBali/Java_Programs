import java.awt.*;
import java.awt.event.*;

class cal extends Frame  implements ActionListener
{
	//1] declaration
	TextField t;
	Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
	
	int a,b,c;
	String op;
	cal()
	{
		super ("Calsi");
		setSize(400,500);
		setLocation(350,150);
		
		setLayout(null);
								//2] memory allocation
		                                         t = new TextField();
b1 = new Button("1");	b2 = new Button("2");	b3 = new Button("3");	b10=new Button("+");
b4 = new Button("4");	b5 = new Button("5");   b6 = new Button("6");	b11=new Button("-");
b7 = new Button("7");	b8 = new Button("8");	b9 = new Button("9");	b12=new Button("*");
b0 = new Button("0");		    b14=new Button("=");	   b13=new Button("/");		
	b15=new Button("Clear");		b16=new Button("Exit");
        
				//3] add component on frame
add(b0);	add(b1);	add(b2);	add(b3);	add(b4);	add(b5);	add(b6);	add(b7);	add(b8);	add(b9);	add(b10);	add(b11);
add(b12);	add(b13);	add(b14);	add(b15);	add(b16);	add(t);
		
				//4] set bounds on all components
																									t.setBounds(60,50,190,25);
		
b1.setBounds(60,80,40,20);		b2.setBounds(110,80,40,20);			b3.setBounds(160,80,40,20);		b10.setBounds(210,80,40,20);
b4.setBounds(60,110,40,20);		b5.setBounds(110,110,40,20);	
b6.setBounds(160,110,40,20);	        b11.setBounds(210,110,40,20);
b7.setBounds(60,140,40,20);		b8.setBounds(110,140,40,20);		
b9.setBounds(160,140,40,20);		b12.setBounds(210,140,40,20);
b0.setBounds(60,170,40,20);  		b14.setBounds(110,170,90,20);			b13.setBounds(210,170,40,20);		b15.setBounds(60,200,90,20);				b16.setBounds(160,200,90,20);
							
		//5] add listener on component
		
b1.addActionListener(this); 	b2.addActionListener(this);			b3.addActionListener(this);	b10.addActionListener(this);
b4.addActionListener(this);	b5.addActionListener(this);			b6.addActionListener(this); 	b11.addActionListener(this);
b7.addActionListener(this);	b8.addActionListener(this);			b9.addActionListener(this); 	b12.addActionListener(this); 
b0.addActionListener(this);     b14.addActionListener(this);					b13.addActionListener(this);	b15.addActionListener(this);					b16.addActionListener(this);

		
		addWindowListener(new WindowAdapter()
		{
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
			}
			});
	setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b15)
		{
			t.setText("");
		}
		
					if(e.getSource()==b1)
					{
						if(t.getText().length()==0)
						t.setText("1");
					else
						 {	
							 t.setText(t.getText()+"1");
						 }
					}
					

					if(e.getSource()==b2)
					{
						if(t.getText().length()==0)
						t.setText("2");
					else
						 {	
							 t.setText(t.getText()+"2");
						 }
					}
					

					if(e.getSource()==b3)
					{
						if(t.getText().length()==0)
						t.setText("3");
					else
						 {	
							 t.setText(t.getText()+"3");
						 }
					}
					

					if(e.getSource()==b4)
					{
						if(t.getText().length()==0)
						t.setText("4");
					else
						 {	
							 t.setText(t.getText()+"4");
						 }
					}

					
					if(e.getSource()==b5)
					{
						if(t.getText().length()==0)
						t.setText("5");
					else
						 {	
							 t.setText(t.getText()+"5");
						 }
					}
					
					
					if(e.getSource()==b6)
					{
						if(t.getText().length()==0)
						t.setText("6");
					else
						 {	
							 t.setText(t.getText()+"6");
						 }
					}
					

					if(e.getSource()==b7)
					{
						if(t.getText().length()==0)
						t.setText("7");
					else
						 {	
							 t.setText(t.getText()+"7");
						 }
					}
					

					if(e.getSource()==b8)
					{
						if(t.getText().length()==0)
						t.setText("8");
					else
						 {	
							 t.setText(t.getText()+"8");
						 }
					}
					

					if(e.getSource()==b9)
					{
						if(t.getText().length()==0)
						t.setText("9");
					else
						 {	
							 t.setText(t.getText()+"9");
						 }
					}

					
					if(e.getSource()==b0)
					{
						if(t.getText().length()==0)
						t.setText("0");
					else
						 {	
							 t.setText(t.getText()+"0");
						 }
					}

		
		if(e.getSource()==b16)
			{
				System.exit(0);
			}
		if(e.getSource()==b10)
			{
				a=Integer.parseInt(t.getText());
				op="+";
				t.setText("");
			}
		if(e.getSource()==b11)
			{
				a=Integer.parseInt(t.getText());
				op="-";
				t.setText("");
			}
		if(e.getSource()==b12)
			{
				a=Integer.parseInt(t.getText());
				op="*";
				t.setText("");
			}
		if(e.getSource()==b13)
			{
				a=Integer.parseInt(t.getText());
				op="/";
				t.setText("");
		    }
			
			b=Integer.parseInt(t.getText());
					
					if(op.equals("+"))
					c=a+b;
					t.setText(Integer.toString(c));
				
					if(op.equals("-"))
					c=a-b;
					t.setText(Integer.toString(c));
					
					if(op.equals("*"))
					c=a*b;
					t.setText(Integer.toString(c));
					
					if(op.equals("/"))
					c=a/b;
					t.setText(Integer.toString(c));
				
      		/*if(e.getSource()==b14)
		      {
			     t.setText(Integer.toString(c));
			  } */
	}
	
	public static void main(String a[])
	{
		new cal();
	}
}
