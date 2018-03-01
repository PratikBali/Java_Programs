
class ChildThread implements Runnable
{
    Thread t;
    ChildThread()
    {
        t = new Thread(this,"Demo Thread");
        System.out.println("\n\t\t main Child Thread : " + t);
        t.start();
    }

    public void run()
    {
        try
        {
            for(int i = 5; i > 0; i--)
            {
                System.out.println("\n\t\t Child Thread : " + i);
                Thread.sleep(2000);
            }
        }
        catch(InterruptedException ex){}
        System.out.println("\n\t **************** Exiting Child Thread  ***************** ");
    }
}

class TH3_Child
{
    public static void main(String a[])
    {
        new ChildThread();
        try
         {
             for(int i = 5; i > 0; i--)
             {        
                 System.out.println("\n\t Main Thread : " + i);
                 Thread.sleep(500);
             }
         }
         catch(InterruptedException ex){}
         System.out.println("\n\t ***************** Exiting Main Thread ******************** ");
     }
}

