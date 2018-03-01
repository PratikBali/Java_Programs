// inheritance

//1) Hierarchical inh

class clsA
{
 int a=10;
}

class clsB extends clsA
{
 void disp()
 {
  System.out.println("\n\t Square = "+(a*a));
 }
}

class clsC extends clsA
{
 void disp()
 {
  System.out.println("\n\t Cube = "+(a*a*a));
 }
}

class inhe3
{
 public static void main(String args[])
 {
  clsB obj1 = new clsB();
  obj1.disp();
 
  clsC obj2 = new clsC();
  obj2.disp();
 }
}
