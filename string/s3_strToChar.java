import java.io.*;

class s3_strToChar
  {
    public static void main(String arg[]) throws Exception
       {
        int l,cnt=0;
        String s;
		char ch;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the string = ");
        s=br.readLine();

        l=s.length();

        for(int i=0;i<l;i++)
		{
         ch = s.charAt(i);
		 if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
		  cnt++;
		}
		
        System.out.print("Total Number of Vowels = "+cnt);		
       }
  }
