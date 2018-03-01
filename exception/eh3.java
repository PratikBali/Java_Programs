
class eh3
{
 public static void main(String args[])
 {
   int a[] = {10,20,30,40,50,60,70,80};
   int b[] = {2,4,0,8,0};
   
   for(int i=0;i<a.length;i++)
   {
	try
	{
		int c = a[i]/b[i];	
        System.out.println("\n\t Division = "+c);	
	}
	catch(ArithmeticException e)
	{
     System.out.println("\n\t *** Cannot divide by Zero ***");	
	}
	catch(ArrayIndexOutOfBoundsException e)
	{
     System.out.println("\n\t *** Invalid Number of Arguments ***");	
	}
   }
 }
}
