// Multiple Inheritance
// working with 2 Interfaces

interface aaa
{
  void disp1();			
} 

interface bbb
{
  void disp2();			
} 

class clsA implements aaa,bbb
{
  public void disp1()		// Interface aaaa method
  {
   System.out.println("\n\t Interface1 Method ");
  }
  public void disp2()		// Interface bbb method
  {
   System.out.println("\n\t Interface2 Method");
  }
  void disp3()
  {
   System.out.println("\n\t clsA");
  }
}

class int3
{
 public static void main(String args[])
 {
	clsA obj = new clsA();
	obj.disp1();
	obj.disp2();	
	obj.disp3();	
 }
}