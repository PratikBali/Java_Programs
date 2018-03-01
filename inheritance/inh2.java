// Inheritance
// 2) Multilevel Inheritance
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
   System.out.println("\n\t I am in Class B ");
 }
}

class clsC extends clsB		// DC
{
 void disp3()
 { 
   System.out.println("\n\t I am in Class C ");
 }
}

class inh2
{
 public static void main(String args[])
 {
   clsC obj = new clsC();
   obj.disp1();
   obj.disp2();
   obj.disp3();
 }
}