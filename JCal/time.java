import java.text.*;
import java.util.*;

class time
{
	public static void main(String a[]) throws Exception
	{
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.set(2014, 0, 0); // date 1
		c2.set(2014, 0, 1); // date 2

		long ms1 = c1.getTimeInMillis();
		long ms2 = c2.getTimeInMillis();
		long diff = ms2 - ms1;
		long diff_Sec = diff / 1000;
		long diff_Min = diff / (60 * 1000);
		long diff_Hr = diff / (60 * 60 * 1000);
		long diff_Day = diff / (24 * 60 * 60 * 1000);
		
		System.out.println("\n\t Time in MilliSeconds : "+ diff +" millisec.");
		System.out.println("\n\t Time in Seconds      : "+ diff_Sec +" seconds.");
		System.out.println("\n\t Time in Minutes      : "+ diff_Min +" minutes.");
		System.out.println("\n\t Time in Hours        : "+ diff_Hr +" hours");
		System.out.println("\n\t Time in Days         : "+ (diff_Day) +" days.");
	}
}