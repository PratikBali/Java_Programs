
class NewThread implements Runnable
{
    String name;
    Thread t;

    NewThread(String threadName)
    {
        name = threadName;
        t = new Thread(this,name);
        System.out.println("\n\t\t New Thread : " + t);
        t.start();
    }

    public void run()
    {
        try
        {
            for(int i = 5; i > 0; i--)
            {
                System.out.println("\n\t\t " + name + ":" + i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException ex){}
        System.out.println("\n\t*****************  "+ name + "Exited ***************** ");
    }
}

class TH_Three
{
    public static void main(String a[])
    {
        new NewThread("One");
        new NewThread("Two");
        new NewThread("Three");
        try
         {
                 Thread.sleep(1000);
         }
         catch(InterruptedException ex){}
         System.out.println("\n\t *****************  Main Thread Exited******************** ");
     }
}

