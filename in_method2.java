import java.io.*;

class in_method2
{
 public static void main(String args[]) throws Exception
 {
  int n;
  DataInputStream in = new DataInputStream(System.in);

  System.out.print("\n\t Enter the Number = ");
  n = Integer.parseInt(in.readLine());

  System.out.println("\n\t Your Number = "+n);
 }
}

