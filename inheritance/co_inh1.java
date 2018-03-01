// inheritance _con_or
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

class co_inh1
{
 public static void main(String args[])
 {
  new clsB();
 }
}
