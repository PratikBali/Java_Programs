import java.util.*;
import java.io.*;

class DispSort
{
	public static void main(String a[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		TreeSet = new TreeSet();
		System.out.print("Enter value of n :");
		int n=Integer.parseInt(br.readLine());

		for(int i=0;i<n;i++)
		{
			System.out.print("Enter Elements : ");
			int e = Integer.parseInt(br.readLine());
			if(s.contains(e))
			{
				System.out.print("Duplicate entry is not allowed");
				i--;
			}
			else
			s.add(e);
		}
		System.out.println("List of Sorted Integers : \n");

		Iterator iter=s.iterator();

		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		System.out.println();
	}
}
