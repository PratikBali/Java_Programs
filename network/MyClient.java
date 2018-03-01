import java.net.*;

public class MyClient
{
	public static void main(String a[])throws Exception
	{
		InetAddress address = InetAddress.getByName("localhost");
		Socket s = new Socket(address, 4444);
		System.out.println("Address    : " +s.getInetAddress());
		System.out.println("Port       : " +s.getPort());
		System.out.println("Local Port : " +s.getLocalPort());
		s.close();
	}
}