import java.io.*;

class numsorting
{
 public static void main(String args[]) throws Exception
 {
   int i,j,n;
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

   System.out.print("\n How many Number you want ? : ");
   n = Integer.parseInt(br.readLine());

   int num[] = new int[n];

   System.out.println("\n\n Enter "+n+" Elements : ");
   for(i=0;i<n;i++)
    num[i]=Integer.parseInt(br.readLine());

   System.out.print("\n\n Array Elements are : ");
   for(i=0;i<n;i++)
     System.out.print(" "+num[i]);    

   System.out.println("\n");

   for(i=0;i<n;i++)
   {
    for(j=i+1;j<n;j++)
     if(num[i] > num[j])
     {
        int temp = num[i];
        num[i] = num[j];
	num[j] = temp;
     }
   }

   System.out.print(" Sorted List is : ");
   for(i=0;i<n;i++)
    System.out.print(" "+num[i]);

   System.out.println("\n");
 }
}
