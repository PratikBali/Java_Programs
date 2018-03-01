
class eh7
{
 public static void main(String args[])
 {
   try
   {
    int age = Integer.parseInt(args[0]);  
	
	if(age>0)
      System.out.println("\n\t Your Age = "+age);
	else
	  throw new NumberFormatException();   
   }
   catch(NumberFormatException e)
   {
      System.out.println("\n\t *** Invalid Input ***");   
   }
 }
}
