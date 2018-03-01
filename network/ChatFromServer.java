import java.net.*;
import java.io.*;
import java.util.*;

class ChatFromServer
{
	public static void main(String a[])throws Exception
	{
		ServerSocket ss = new ServerSocket(1000);
		System.out.println("Server Started, Waiting for Client - ");
		String str;
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

		Socket s = ss.accept();
		System.out.println("Client Connected");
		System.out.println("Enter Msg , Type over to stop");
		
		InputStream is = s.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		
		while (true)
		{
			str = dis.readUTF();
			if(str.equals("over") || str.equals("OVER"))
			{
				System.out.println("\n\t Chatting Terminated");
				break;
			}
			System.out.println("Client : "+str);
			System.out.println("Server : ");
			String s1=br.readLine();
			dos.writeUTF(s1);
			if(str.equals("over") || str.equals("OVER"))
			{
				System.out.println("\n\t Chatting Terminated");
				break;
			}				
		}//while
	}//main
}//class