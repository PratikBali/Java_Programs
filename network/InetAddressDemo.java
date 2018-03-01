// InetAddress class Demo
import java.net.*;
public class InetAddressDemo
{
	public static void main(String a[])
	{
		try
		{
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("Local Host's Address : "+address);

			address = InetAddress.getByName("www.google.com");
			System.out.println("Googles Address : "+address);
			
			InetAddress AllAddress[] = InetAddress.getAllByName("www.google.com");
			
			for (int i=0; i<AllAddress.length; i++)
			System.out.println("Address :  "+(i+1)+" : " +AllAddress[i]);

		}
		catch(Exception ex)
		{
		ex.printStackTrace();
		}
	}
}