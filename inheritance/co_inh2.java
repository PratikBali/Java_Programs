// 2)inheritance + con_or
class clsA
{
 clsA()
 {
  System.out.println("\n\t I am in class A");
 }
}

class clsB extends clsA
{
 clsB()
 {
  System.out.println("\n\t I am in class B");
 }
}

class clsC extends clsB
{
 clsC()
 {
  System.out.println("\n\t I am in class C");
 }
}

class co_inh2
{
 public static void main(String args[])
 {
  new clsC();
 }
}
