import java.util.*;
import java.io.*;

class ass2
{
	public static void main(String a[]) throws Exception
	{
		LinkedList l1 = new LinkedList();
		l1.add("Red");
		l1.add("Blue");
		l1.add("Yellow");
		l1.add("Orange");

		ListIterator it =l1.listIterator();
		System.out.println("\n Content of List \n");

		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		System.out.println("\n Content of List in Reverse : \n");

		while(it.hasPrevious())
		{
			System.out.println(it.previous());
		}

		LinkedList l2=new LinkedList();
		l2.add("Pink");
		l2.add("Green");

		int i=l1.indexOf("Yellow");
		l1.addAll(i,l2);

		System.out.println("\nContent of New List:\n");
		System.out.println(l1);
	}
}
