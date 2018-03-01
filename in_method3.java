import java.util.*;

// javap java.util.Scanner

class in_method3
{
  public static void main(String args[])
  {
   Scanner s = new Scanner(System.in);

   System.out.print("\n\t Enter two Numbers = ");
   int a = s.nextInt();
   int b = s.nextInt();

   System.out.println("\n\t Addition = "+(a+b));
  }
}
