import java.net.*;
import java.io.*;
import java.util.*;

class ChatFromClient
{
	public static void main(String a[])throws Exception
	{
		Socket s = new Socket("localhost",1000);
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

		InputStream is = s.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		OutputStream os = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		System.out.println("Enter Msg , Type over to stop");

		while (true)
		{
			System.out.println("Client ... ");
			String s1=br.readLine();
			dos.writeUTF(s1);
			if(s1.equals("over") || s1.equals("OVER"))
			{
				System.out.println("\n\t Chatting Terminated");
				break;
			}				

			String s2=dis.readUTF();
			if(s2.equals("over") || s2.equals("OVER"))
			{
				System.out.println("\n\t Chatting Terminated");
				break;
			}	
			else
				System.out.println("Server ... "+s2);
		}//while
	}//main
}//class