
class eh6
{
 public static void main(String args[])
 {
  System.out.println("\n\t *** Program Starts ***");
  
  try
  {
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    int c=a/b;
  
    System.out.println("\n\t Division = "+c);
  }
  finally
  { 
    System.out.println("\n\t I am always Executed !!! ");  
  }
  
  System.out.println("\n\t *** Program Ends ***");
 }
}