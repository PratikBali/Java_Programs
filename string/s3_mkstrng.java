import java.io.*;

class s3_mkstrng
{
 public static void main(String args[]) throws Exception
 {
  int l,cnt=0;
  String s;
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
  System.out.println("\n\t Enter the string :");
  s = br.readLine();

  l = s.length();

  for(int i=0;i<l;i++)
  {
   if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u')
   {
    System.out.println(s.charAt(i));
    cnt++;
   }
  }
  System.out.println("\n\t Total no. of vowels  = "+cnt);
 }
}
