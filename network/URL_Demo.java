import java.net.*;

class URL_Demo
{
	public static void main(String a[]) throws Exception
	{
		URL myURL = new URL("http://www.oracle.com/technetwork/java/index.html");
		System.out.println("Protocol : " +myURL.getProtocol() );
		System.out.println("Port     : " + myURL.getPort());
		System.out.println("Host     : " + myURL.getHost());
		System.out.println("File     : " + myURL.getFile());
	}
}