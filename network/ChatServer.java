import java.net.*;
import java.io.*;

class ChatServer
{
	static DatagramSocket ds;
	static DatagramPacket dp;
	static  int sport = 120; cport = 130;
	public staticvoid main(String a[])
	{
		Sysrtem.out.println("From Transmit side : ");
		byte buf[] = new byte[1024];
		ds = new DatagramSocket(sport);
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		InteAddress net = InetAddresss.getByname("vision25");
		while (true)
		{
			System.out.println("\n\t Enter Msg : ");
			String str = br.readLine();
			buf = str.getBytes();
			ds.send(new DatagramPacket(buf,str.length(),net,cport));
			if(str.equals("over"))
			break;
		}
	}
}