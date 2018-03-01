// Read the File
import java.io.*;
class File2
{
 public static void main(String args[]) throws Exception
 {
  int i;
  FileInputStream fin;

   fin = new FileInputStream(args[0]);

  // read characters until EOF is encountered
  do
  { 
    i = fin.read();

    if(i != -1)
     System.out.print((char) i);

   } while(i != -1);

  fin.close();
 }
}
