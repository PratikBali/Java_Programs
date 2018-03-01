// Inheritance
// 1) Single Inheritance
class clsA			// BC
{
 void disp1()
 {
   System.out.println("\n\t I am in Class A ");
 }
}
class clsB extends clsA		// DC
{
 void disp2()
 { 
//   disp1();
   System.out.println("\n\t I am in Class B ");
 }
}
class inh1
{
 public static void main(String args[])
 {
   clsB obj = new clsB();
   obj.disp1();
   obj.disp2();
 }
}