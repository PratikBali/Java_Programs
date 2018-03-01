// Open the File in Append Mode

import java.io.*;

class File4
{	
 public static void main(String args[]) throws Exception
 {              
  String str="";
  FileOutputStream out;
  PrintStream p; 
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  try
  {
   out = new FileOutputStream(args[0],true);  // "true" for append mode

   // Connect print stream to the output stream
   p = new PrintStream(out);

   System.out.println("Enter lines of text. (Enter 'stop' to quit.)\n");

   while(!str.equals("stop"))
   {
    p.println (str);
    str = br.readLine();
   } 

   p.close();
  }
  catch (Exception e)
  {
   System.err.println ("Error writing to file");
  }
 }
}
