// Assignment

import java.io.*;
class File33
{
 public static void main(String args[]) throws IOException
 {
  int i;
  
  if(args.length==2)
  {
  FileInputStream fin = new FileInputStream(args[0]);
  FileOutputStream fout= new FileOutputStream(args[1]);
   do
   {
    i = fin.read();

    if(i != -1)
      fout.write(i);

   } while(i != -1);

  System.out.println("\n\t File Copied Successfully ...");
  fin.close();
  fout.close();  
  }
  else if(args.length==3)
  {
  FileInputStream fin1 = new FileInputStream(args[0]);
  FileInputStream fin2 = new FileInputStream(args[1]);
  FileOutputStream fout= new FileOutputStream(args[2]);
   do
   {
    i = fin1.read();

    if(i != -1)
      fout.write(i);

   } while(i != -1);
  fin1.close();
  fout.close();  
  
  fout= new FileOutputStream(args[2],true);
   do
   {
    i = fin2.read();

    if(i != -1)
      fout.write(i);

   } while(i != -1);
  fin2.close();
  fout.close();  
  }
 }
}
