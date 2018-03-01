
// Nested try-catch block

class eh4
{
 public static void main(String args[])
 {  int a=0,b=0,c;
    System.out.println("\n\t *** Program Start ***");
	try
	{
	  	try
		{
			a= Integer.parseInt(args[0]); 
			b= Integer.parseInt(args[1]); 
			c = a/b;	
			System.out.println("\n\t Division = "+c);	
		}
		catch(ArithmeticException e)
		{
		System.out.println("\n\t *** Inner Catch ***");	
		System.out.println("\n\t *** Cannot divide by Zero ***");	
		}
	}
	catch(NumberFormatException e)
	{
	 System.out.println("\n\t *** Outer Catch ***");	
     System.out.println("\n\t *** Invalid Input ***");	
	}
	catch(ArrayIndexOutOfBoundsException e)
	{
		System.out.println("\n\t *** Outer Catch ***");	
		System.out.println("\n\t *** Invalid Number of Arguments ***");	
	}	
    System.out.println("\n\t *** Program End ***"); 
 }
}
	