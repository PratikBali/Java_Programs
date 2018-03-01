import java.util.Scanner;
class scr_str_2
{public static void main(String args[])
	{	Scanner sc = new Scanner(System.in);
		int i;		double d;		String s;		
		System.out.println("\n\t Enter your Data = ");

		if(sc.hasNextInt())
		{
			i = sc.nextInt();
			System.out.println("\n\t Integer = "+i);
		}
		else if(sc.hasNextDouble())
		{
			d = sc.nextDouble();
			System.out.println("\n\t Double = "+d);
		}
		else if(sc.hasNextLine())
		{
			s = sc.nextLine();
			System.out.println("\n\t String = "+s);
		}
	}
}