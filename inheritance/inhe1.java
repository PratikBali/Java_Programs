// inheritance

//1) single inh

class clsA
{
 void disp1()
 {
  System.out.println("\n\t I am in class A ");
 }
}

class clsB extends clsA
{
 void disp2()
 {
  disp1();
  System.out.println("\n\t I am in class B ");
 }
}

class inhe1
{
 public static void main(String args[])
 {
  clsB obj = new clsB();
  obj.disp2();
 }
}
