import java.net.*;
import java.io.*;

public class MyServer
{
	public static void main(String a[])throws Exception
	{
		ServerSocket ss = new ServerSocket(4444);
		System.out.println("Server Started");
		Socket s = ss.accept();
	}
}