
interface aaa
{
 void disp1();	
}


class clsA 
{
 void disp2()
 {
  System.out.println("\n\t clsA");
 }
}

class clsB extends clsA implements aaa
{
 public void disp1()
 {
  System.out.println("\n\t Interface method");
 }
  void disp3()
 {
  System.out.println("\n\t clsB");
 }
}

class int7
{
 public static void main(String args[])
 {
  clsB obj = new clsB();
  obj.disp1();
  obj.disp2();
  obj.disp3();
 }
}
