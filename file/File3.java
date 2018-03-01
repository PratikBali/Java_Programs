// Copy the File

import java.io.*;
class File3
{
 public static void main(String args[]) throws IOException
 {
  int i;
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
}
