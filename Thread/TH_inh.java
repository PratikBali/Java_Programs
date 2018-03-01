
class ChildThread extends Thread
{
    ChildThread()
    {
        super("Demo Thread");
        System.out.println("\n\t\t main Child Thread : " + this);
        start();
    }

    public void run()
    {
        try
        {
            for(int i = 5; i > 0; i--)
            {
                System.out.println("\n\t\t Child Thread : " + i);
                Thread.sleep(500);
            }
        }
        catch(InterruptedException ex){}
        System.out.println("\n\t **************** Exiting Child Thread  ***************** ");
    }
}

class TH_inh
{
    public static void main(String a[])
    {
        new ChildThread();
        try
         {
             for(int i = 5; i > 0; i--)
             {
                 System.out.println("\n\t Main Thread : " + i);
                 Thread.sleep(1000);
             }
         }
         catch(InterruptedException ex){}
         System.out.println("\n\t ***************** Exiting Main Thread ******************** ");
     }
}

