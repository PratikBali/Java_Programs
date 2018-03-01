import java.net.*;

class URL_Demo2
{
	public static void main(String a[]) throws Exception
	{
		URL myURL = new URL("https://www.facebook.com/cnpratik");
		System.out.println("Protocol : " +myURL.getProtocol() );
		System.out.println("Port     : " + myURL.getPort());
		System.out.println("Host     : " + myURL.getHost());
		System.out.println("File     : " + myURL.getFile());
	}
}