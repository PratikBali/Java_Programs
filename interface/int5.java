// Interface + abstract class + Multilevel Inheritance

interface aaa
{
  void disp1();			
} 

abstract class clsA implements aaa
{
  void disp2()		
  {
   System.out.println("\n\t clsA");
  }
}

class clsB extends clsA
{
  public void disp1()		// Interface aaaa method
  {
   System.out.println("\n\t Interface1 Method ");
  }
  void disp3()
  {
   System.out.println("\n\t clsB");
  }
}

class int5
{
 public static void main(String args[])
 {
	clsB obj = new clsB();
	obj.disp1();
	obj.disp2();	
	obj.disp3();	
 }
}