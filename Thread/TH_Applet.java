import java.awt.*;
import java.applet.*;

//<applet code=TH_Applet width=1200 height=400></applet>

public class TH_Applet extends Applet implements Runnable
{
	Thread p,r,a,t,i,k;
	int cnt=0;
	int x,y,x1,y1,x2,y2,x3,y3,x4,y4,x5,y5,x6,y6;
	
	public void init()
	{
			x=20;y=300;	
			x1=100;y1=350;	
			x1=300;y1=350;	
			x1=500;y1=350;	
			x1=700;y1=350;	
			x1=900;y1=350;	

			p = new Thread(this,"P");
			r = new Thread(this,"R");
			a = new Thread(this,"A");
			t = new Thread(this,"T");
			i = new Thread(this,"I");
			k = new Thread(this,"K");
			
			p.start();
			r.start();
			a.start();
			t.start();
			i.start();
			k.start();
	}
	
	public void run()
	{
		try
		{
			if(p.getName().equals("P"))
			{
				for(;;)
				{
					cnt++;
					if(cnt<50)
					{
						x=x;
						y=y-5;
						Thread.sleep(50);
					}
					repaint();
					if(cnt>50 && cnt<70)
					{
						x=x+5;
						y=y;
						Thread.sleep(50);
					}
					
					if(cnt>70 && cnt<90)
					{
						x=x;
						y=y+5;
						Thread.sleep(50);
					}
					
					if(cnt>90 && cnt<110)
					{
						x=x-5;
						y=y;
						Thread.sleep(50);
					}
					
				}
			}
			if(r.getName().equals("R"))
			{
				for(;;)
				{
					cnt++;
					if(cnt<50)
					{
						x1=x1;
						y1=y1-5;
						Thread.sleep(50);
					}
					repaint();
				}
			}
			if(a.getName().equals("A"))
			{
				for(;;)
				{
					cnt++;
					if(cnt<50)
					{
						x2=x2;
						y2=y2-5;
						Thread.sleep(50);
					}
					repaint();
				}
			}
			if(t.getName().equals("T"))
			{
				for(;;)
				{
					cnt++;
					if(cnt<50)
					{
						x3=x3;
						y3=y3-5;
						Thread.sleep(50);
					}
					repaint();
				}
			}
			if(i.getName().equals("I"))
			{
				for(;;)
				{
					cnt++;
					if(cnt<50)
					{
						x4=x4;
						y4=y4-5;
						Thread.sleep(50);
					}
					repaint();
				}
			}
			if(k.getName().equals("K"))
			{
				for(;;)
				{
					cnt++;
					if(cnt<50)
					{
						x5=x5;
						y5=y5-5;
						Thread.sleep(50);
					}
					repaint();
				}
			}

		}
		catch(Exception ex)
		{}
	}
	
	public void paint (Graphics g)
	{
		
	}
	public void update (Graphics g)
	{
		g.setColor(Color.RED);
		g.fillOval(x,y,35,35);
		g.fillOval(x1,y1,35,35);
		g.fillOval(x2,y2,35,35);
		g.fillOval(x3,y3,35,35);
		g.fillOval(x4,y4,35,35);
		g.fillOval(x5,y5,35,35);
	}
}