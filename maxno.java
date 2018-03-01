import java.io.*;

class maxno
{
 public static void main(String args[]) throws Exception
 {
   int n,max=0;
   BufferedReader br = new BufferedReader(new InputStreamReader (System.in));

   System.out.print("\n\n Enter the size of Array : ");
   n = Integer.parseInt(br.readLine());

   int num[] = new int[n];

   System.out.print("\n\n Enter the "+n+" Elements of Array : ");
   for(int i=0;i<n;i++)
     num[i]=Integer.parseInt(br.readLine());    

   max=num[0];

   for(int i=0;i<n;i++)
    if(num[i]>max)
     max=num[i];

   System.out.print("\n\n Maximun Number is : "+max);
 }
}
