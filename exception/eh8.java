
// User Defined Exceptions

class AgeInvalid extends Exception
{
 public String toString()
 {
   return "\n\t *** Age must be > 0 ***";
 }
}

class eh8
{
 public static void main(String args[])
 {
   try
   {
    int age = Integer.parseInt(args[0]);  
	
	if(age>0)
      System.out.println("\n\t Your Age = "+age);
	else
	  throw new AgeInvalid();   
   }
   catch(AgeInvalid e)
   {
    System.out.println(e);      
   }
   catch(Exception e)
   {
    System.out.println("\n\t *** System Exception Caught ***\n\t"+e);   
   }
 }
}
