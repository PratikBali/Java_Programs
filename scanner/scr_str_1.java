
import java.io.*;
import java.util.Scanner;

class scr_str_1
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int i;
		double d;
		String word,line;
		
System.out.println("\n\t Enter int,double,word and String = ");	
		i = sc.nextInt();
		d = sc.nextDouble();
		word = sc.next();
		line = sc.nextLine();
		
		System.out.println("\n\t Your Output =>");
		System.out.println("Integer = "+i);
		System.out.println("Double = "+d);
		System.out.println("Word = "+word);
		System.out.println("Line = "+line);		
	}
}