// Using directories. 

import java.io.File; 
 
class File6
{ 
  public static void main(String args[]) 
  { 
    int fc=0,dc=0;
    String dirname=args[0];	
    File f1 = new File(dirname); 
 
    if (f1.isDirectory()) 
    { 
      System.out.println("Directory of " + dirname); 
      String s[] = f1.list(); 
 
      for (int i=0; i < s.length; i++) 
      { 
        File f = new File(dirname + "/" + s[i]); 
        if (f.isDirectory()) 
         {
          System.out.println(s[i] + " is a directory"); 
          dc++;
         } 
        else 
         {
          System.out.println(s[i] + " is a file"); 
          fc++;
         }
      }
      System.out.println("\n\t Total Number of Directories = "+dc); 	 
      System.out.println("\n\t Total Number of Files = "+fc); 	 
    } 
    else 
      System.out.println(dirname + " is not a directory"); 
  } 
}