// inheritance

//1) multilevel inh

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

class clsC extends clsB
{
 void disp3()
 {
  disp2();
  System.out.println("\n\t I am in class C ");
 }
}

class inhe2
{
 public static void main(String args[])
 {
  clsC obj = new clsC();
  obj.disp3();
 }
}
