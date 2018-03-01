
// Simple try-catch block

class EH1
{
 public static void main(String args[])
 {
  int a=0,b=0,c;
  System.out.println("\n\t *** Program start ***");

  try
  {
   a= Integer.parseInt(args[0]);
   b= Integer.parseInt(args[1]);
   c= a/b;
   System.out.println("\n\t Division = "+c);
  }
  catch(Exception e)
  {
   System.out.println("\n\t *** Exception Caught *** \n\t "+e);
  }

  System.out.println("\n\t *** Program End ***");
 }
}
