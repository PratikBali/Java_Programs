
// Interface methods can not have body

interface aaa
{
 void disp1();	
}

class clsA implements aaa
{
 public void disp1()	// Interface aaa method
 {
  System.out.println("\n\t Interface method");
 }
 void disp2()
 {
  System.out.println("\n\t clsA");
 }
}

class clsB extends clsA implements aaa
{
 void disp3()
 {
  System.out.println("\n\t clsB");
 }
}

class clsC extends clsB
{
 void disp4()
 {
  System.out.println("\n\t clsC");
 }
}

class int8
{
 public static void main(String args[])
 {
  clsB obj1 = new clsB();
  clsC obj2 = new clsC();
  obj1.disp1();
  obj1.disp2(); 
  obj1.disp3(); 
  obj2.disp4(); 
 }
}
