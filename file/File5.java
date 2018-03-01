// Demonstrate File. 

import java.io.*; 
 
class File5
{ 
  static void p(String s) 
  { 
    System.out.println(s); 
  } 
 
  public static void main(String args[]) 
  { 
    File f1 = new File(args[0]); 
    p("File Name: " + f1.getName()); 
    p("Path: " + f1.getPath()); 
    p("Abs Path: " + f1.getAbsolutePath()); 
    p("Parent: " + f1.getParent()); 
    p(f1.exists() ? "It is exists" : "It is does not exist"); 
    p(f1.canWrite() ? "It is writeable" : "It is not writeable"); 
    p(f1.canRead() ? "It is readable" : "It is not readable"); 
    p("It is " + (f1.isDirectory() ? "a directory" : "not a directory"));  
    p(f1.isFile() ? "It is normal file" : "It might be a named pipe"); 
    p(f1.isAbsolute() ? "It is absolute" : "It is not absolute"); 
    p("File last modified: " + f1.lastModified()); 
    p("File size: " + f1.length() + " Bytes"); 
  } 
}