
public class Thread_Demo
{
    public static void main(String a[])
    {
        Thread t = Thread.currentThread();
        System.out.println("\n\nt Current Thread :  " + t);
        try
        {
            for(int n = 1; n <= 5; n++)
            {
                System.out.println("\n\t " + n);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException ex){}
    }
}
