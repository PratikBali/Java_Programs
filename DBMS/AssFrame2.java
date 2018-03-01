import java.awt.*;
import java.awt.event.*;

class AssFrame2 extends Frame implements ActionListener
{
 // 1) Declaration
 int a,c,d;
 String op;
 TextField t1;
 Button b[];
 
 AssFrame2()
 {
  super("Calculator");
  setSize(500,500);
  setLocation(300,200);
  
  setLayout(null);
  
  // 2) Memory Allocation
  t1 = new TextField(20);
  b = new Button[17];
  
  for(int i=0;i<10;i++)
  {
   b[i] = new Button(""+i);
  } 
 
   b[10] = new Button("=");    
   b[11] = new Button("+");
   b[12] = new Button("-");  
   b[13] = new Button("*");
   b[14] = new Button("/");
   b[15] = new Button("Clear");
   b[16] = new Button("Exit");
   
   // 3) Add components to Frame
   add(b[0]);   add(b[1]);   add(b[2]);   add(b[3]);
   add(b[4]);   add(b[5]);   add(b[6]);   add(b[7]);
   add(b[8]);   add(b[9]);   add(b[10]);   add(b[11]);
   add(b[12]);   add(b[13]);   add(b[14]);   add(b[15]);
   add(b[16]);   add(t1); 
  
  // 4) Set Bounds to each component
  t1.setBounds(30,50,110,20);
  b[1].setBounds(30,80,20,20);
  b[2].setBounds(60,80,20,20);    
  b[3].setBounds(90,80,20,20); 
  
  b[4].setBounds(30,110,20,20);
  b[5].setBounds(60,110,20,20);    
  b[6].setBounds(90,110,20,20);
  
  
  b[7].setBounds(30,140,20,20);
  b[8].setBounds(60,140,20,20); 
  b[9].setBounds(90,140,20,20);    
 
  b[0].setBounds(30,170,20,20);
  b[10].setBounds(60,170,50,20);
  b[14].setBounds(120,170,20,20);    
  
  b[11].setBounds(120,80,20,20);
  b[12].setBounds(120,110,20,20);    
  b[13].setBounds(120,140,20,20);
 
  b[15].setBounds(30,200,50,20);     
  b[16].setBounds(90,200,50,20);     
 
  // 5) Add Listeners to components
  for(int i=0;i<17;i++)
  {
   b[i].addActionListener(this);
  }
 
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
  if(e.getSource()==b[0])
  {
   if(t1.getText().length()==0)
    t1.setText("0");
   else
    t1.setText(t1.getText()+"0");
  }
  if(e.getSource()==b[1])
  {
   if(t1.getText().length()==0)
    t1.setText("1");
   else
    t1.setText(t1.getText()+"1");
  }
  if(e.getSource()==b[2])
  {
   if(t1.getText().length()==0)
    t1.setText("2");
   else
    t1.setText(t1.getText()+"2");
  }
  if(e.getSource()==b[3])
  {
   if(t1.getText().length()==0)
    t1.setText("3");
   else
    t1.setText(t1.getText()+"3");
  }
  if(e.getSource()==b[4])
  {
   if(t1.getText().length()==0)
    t1.setText("4");
   else
    t1.setText(t1.getText()+"4");
  }
  if(e.getSource()==b[5])
  {
   if(t1.getText().length()==0)
    t1.setText("5");
   else
    t1.setText(t1.getText()+"5");
  }
  if(e.getSource()==b[6])
  {
   if(t1.getText().length()==0)
    t1.setText("6");
   else
    t1.setText(t1.getText()+"6");
  }
  if(e.getSource()==b[7])
  {
   if(t1.getText().length()==0)
    t1.setText("7");
   else
    t1.setText(t1.getText()+"7");
  }
  if(e.getSource()==b[8])
  {
   if(t1.getText().length()==0)
    t1.setText("8");
   else
    t1.setText(t1.getText()+"8");
  }
  if(e.getSource()==b[9])
  {
   if(t1.getText().length()==0)
    t1.setText("9");
   else
    t1.setText(t1.getText()+"9");
  }
  if(e.getSource()==b[10])
  {
   c = Integer.parseInt(t1.getText());
   if(op.equals("+"))
   {
    d=a+c;
    t1.setText(""+d);
   }
   else if(op.equals("-"))
   {
    d=a-c;
    t1.setText(""+d);
   }
   else if(op.equals("*"))
   {
    d=a*c;
    t1.setText(""+d);
   }
   else if(op.equals("/"))
   {
    d=a/c;
    t1.setText(""+d);
   }
  }
  if(e.getSource()==b[11])
  {
   a = Integer.parseInt(t1.getText());
   op = "+";
   t1.setText("");
  }
  if(e.getSource()==b[12])
  {
   a = Integer.parseInt(t1.getText());
   op = "-";
   t1.setText("");
  }
  if(e.getSource()==b[13])
  {
   a = Integer.parseInt(t1.getText());
   op = "*";
   t1.setText("");
  }
  if(e.getSource()==b[14])
  {
   a = Integer.parseInt(t1.getText());
   op = "/";
   t1.setText("");
  }
  if(e.getSource()==b[15])
  {
   t1.setText(""); 
  }
  if(e.getSource()==b[16])
  {
   System.exit(0);
  }
 }
 
 public static void main(String args[])
 {
  new AssFrame2();
 }
} 