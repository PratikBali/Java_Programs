class NegNumber extends Exception
{
 public String toString()
 {
  return "\n\t *** Number must be > 0  ***";
 }
}

class eh
{
 public static void main(String args[])
 {
    int a=0,b=0,c;
	try
	{
		a= Integer.parseInt(args[0]); 
		b= Integer.parseInt(args[1]); 
		
		if(b>0)
		{
		  c = a/b;	
          System.out.println("\n\t Division = "+c);	
		}
		else
		{
		  throw new NegNumber();
		}		
	}
	catch(NegNumber e)
	{
     System.out.println(e);		
	}
	catch(ArithmeticException e)
	{
     System.out.println("\n\t *** Cannot divide by Zero ***");	
	}
	catch(NumberFormatException e)
	{
     System.out.println("\n\t *** Invalid Input ***");	
	}
	catch(ArrayIndexOutOfBoundsException e)
	{
     System.out.println("\n\t *** Invalid Number of Arguments ***");	
	}
 }
}
