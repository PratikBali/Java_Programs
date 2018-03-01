// this() method
// call to this must be first statement in constructor

class clsA
{
 clsA()
 {
  // this(5);    //call to Para. con_or
  System.out.println("\n\t I am in Def. Con_or");
 }
 
 clsA(int a)
 {
  this();
  System.out.println("\n\t Addition = "+(a+a));
 }
}

class in_con4
{
 public static void main(String args[])
 {
  new clsA(5);
 }
}
