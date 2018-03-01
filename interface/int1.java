
// Interface
// interface methods cannot have body

interface aaa
{
  int a=10;				// constant or final
  void disp1();			// all methods are abstract
} 

class clsA implements aaa
{
  public void disp1()
  {
   System.out.println("\n\t Interface Method and A = "+a);
  }
  void disp2()
  {
   System.out.println("\n\t clsA");
  }
}

class int1 
{
 public static void main(String args[])
 {
	clsA obj = new clsA();
	obj.disp1();
	obj.disp2();	
 }
}