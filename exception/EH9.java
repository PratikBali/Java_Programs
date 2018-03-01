
 // User defined Exceptions

class SmallNoException extends Exception
{
 public String toString()
 {
  return "\n\t *** Age is < 5 ***";
 } 
}

class ProperNoException extends Exception
{
 public String toString()
 {
  return " \n\t *** Age > 5 and Age < 10 *** ";
 } 
}

class GreaterNoException extends Exception
{
 public String toString()
 {
  return "\n\t *** Age is > 10 ***";
 } 
}

class EH9
{
 public static void main(String args[])
 {
   int age = Integer.parseInt(args[0]);

  try
  {
  
   if(age<5)
     throw new SmallNoException();
   else if(age>5 && age<=10) 
     throw new ProperNoException();
   else if(age>10)
     throw new GreaterNoException();
   else 
     System.out.println("\n\t Invalid input ");
  }
 
  catch(SmallNoException e)
  { 
   System.out.println(e);
  }
  
  catch(GreaterNoException e)
  { 
   System.out.println(e);
  } 
  
  catch(ProperNoException e)
  {
   System.out.println(e);
   int fact=1;
   for(int i=age;i>1;i--)
    fact=i*fact;
   System.out.println("\n\t Factorial = "+fact); 
  }

  catch(Exception e)
  {
   System.out.println("\n\t *** System Exception Caught *** \n\n\t"+e); 
  }
 }
}
