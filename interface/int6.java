// Interface + abstract class + Multilevel Inheritance

interface aaa
{
  void disp1();			
} 

class clsA implements aaa
{
  public void disp1()		// Interface aaaa method
  {
   System.out.println("\n\t Interface1 Method ");
  }
  void disp2()		
  {
   System.out.println("\n\t clsA");
  }
}

class clsB extends clsA implements aaa
{
// no nee d to define disp1() again .... 
 //bcoz it is already definrd in clsA
  public void disp1()		// Interface aaaa method
  {
   System.out.println("\n\t Overridden Method ");
  }
  void disp3()
  {
   System.out.println("\n\t clsB");
  }
}

class int6
{
 public static void main(String args[])
 {
	clsB obj = new clsB();
	obj.disp1();
	obj.disp2();	
	obj.disp3();	
 }
}