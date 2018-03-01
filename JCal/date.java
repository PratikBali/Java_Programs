import java.text.*;
import java.util.*;

class date
{
	public static void main(String a[]) throws Exception
	{
		SimpleDateFormat f = new SimpleDateFormat("dd/MMM/yyyy");
		String dt = f.format(new java.util.Date());
		System.out.println("\n\t"+dt);
		
		Calendar c = Calendar.getInstance();
		c.setTime(f.parse(dt));
		c.add(Calendar.DATE, 7);
		dt = f.format(c.getTime());
		System.out.println("\n\t"+dt);
	}
}