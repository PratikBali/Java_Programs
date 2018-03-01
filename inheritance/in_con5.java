// super() method
// call to super must be first statement in constructor

class clsA
{
 clsA()
 {
  System.out.println("\n\t I am in clsA");
 }

 clsA(int a)
 {
  System.out.println("\n\t Addition = "+(a+a));
 }
}

class clsB extends clsA
{
 clsB()
 { 
  super(5);
  System.out.println("\n\t I am in clsB");
 }
}

class in_con5
{
 public static void main(String args[])
 {
  new clsB();
 }
}
