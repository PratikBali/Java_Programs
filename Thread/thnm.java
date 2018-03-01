import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*<applet code="thnm" width=1000 height =1000></applet>*/

public class thnm extends Applet 
{
Thread t1,t2,t3,t4,t5;
int cnt=0;
int x,y,x1,y1,x2,y2,x3,x4,y3,y4;

public void init()
{
  x=10; y=300;  
  x1=200; y1=300;
  x2=400; y2=300;
  x3=600; y3=300;
  x4=800; y4=300;
  
  t1=new Thread("P");
  t2=new Thread("A");
  t3=new Thread("N");
  t4=new Thread("O");
  t5=new Thread("J");
  
  t1.start();
  t2.start();
  t3.start();
  t4.start();
  t5.start();
  

}

public void paint(Graphics g)
 {
 update(g);
 }

public void update(Graphics g)
{
try
   {
    for(;;)
	{
	  if(t1.getName().equals("P"))
	 {
	      cnt++;
	    if(cnt<50)
	    {
	     y=y-10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x,y,20,20);		 
		}
		 if(cnt>50 && cnt<70)
	    {
	     x=x+10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x,y,20,20);		 
		}
		 if(cnt>70 && cnt<90)
	    {
	     y=y+10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x,y,20,20);		 
		} 
		
		if(cnt>90 && cnt<110)
	    {
	     x=x-10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x,y,20,20);		 
		}
		}
	
	if(t2.getName().equals("A"))
	{ 
    	cnt++;
	    if(cnt<40)
	    {
	     y1=y1-10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x1,y1,20,20);		 
		}
		 if(cnt>40 && cnt<60)
	    {
	     x1=x1+10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x1,y1,20,20);		 
		}
		 if(cnt>60 && cnt<80)
	    {
	     y1=y1+10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x1,y1,20,20);		 
		} 
		
		if(cnt>80 && cnt<100)
	    {
	     x1=x1-10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x1,y1,20,20);		 
		}
		
		if(cnt>100 && cnt<120)
	    {
	     x1=x1+10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x1,y1,20,20);		 
		}
		
		if(cnt>120 && cnt<140)
	    {
	     y1=y1+10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x1,y1,20,20);		 
		}
	  }				
	  
  if(t3.getName().equals("N"))
	 {
	      cnt++;
	    if(cnt<40)
	    {
	     y2=y2-10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x2,y2,20,20);		 
		}
		 if(cnt>40 && cnt<75)
	    {
	     x2=x2+10;
		 y2=y2+10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x2,y2,20,20);		 
		}
		 if(cnt>75 && cnt<110)
	    {
	     y2=y2-10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x2,y2,20,20);		 
		} 
		}
	

  if(t4.getName().equals("O"))
	 {
	      cnt++;
	    if(cnt<40)
	    {
	     y3=y3-10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x3,y3,20,20);		 
		}
		 if(cnt>40 && cnt<70)
	    {
	     x3=x3+10;
		 Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x3,y3,20,20);		 
		}
		 if(cnt>70 && cnt<110)
	    {
	     y3=y3+10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x3,y3,20,20);		 
		}

       if(cnt>110 && cnt<140)
	    {
		 x3=x3-10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x3,y3,20,20);		 
		}		
		}
	


	if(t5.getName().equals("J"))
	 {
	      cnt++;
	    if(cnt<20)
	    {
	     y4=y4+10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x4,y4,20,20);		 
		}
		 if(cnt>20 && cnt<40)
	    {
	     x4=x4+10;
		 Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x4,y4,20,20);		 
		}
		 if(cnt>40 && cnt<80)
	    {
	     y4=y4-10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x4,y4,20,20);		 
		}

       if(cnt>80 && cnt<100)
	    {
		 x4=x4-10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x4,y4,20,20);		 
		}		
		
      if(cnt>100 && cnt<140)
	    {
		 x4=x4+10;
         Thread.sleep(10);
		g.setColor(Color.RED);
		g.fillOval(x4,y4,20,20);		 
		}		
		
		
		}
	}
 }
 catch(Exception e)
 {}
}
}