class clsA
{
 int a=11;
}

class clsB extends clsA
{
 int a=22;
 clsB(int a)
 {
  System.out.println("\n\t Para. a = "+a);   
  System.out.println("\n\t Local a = "+this.a);
  System.out.println("\n\t Global a = "+super.a);
 }
}

class in_con3
{
 public static void main(String args[])
 {
  int a=33;
  new clsB(a);
 }
}
