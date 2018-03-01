
class s2_mkstrng
{
 public static void main(String args[])
 {
  byte a[] = {65, 66, 78, 89 };
  
  String s1 = new String(a);
  System.out.println(s1);

  String n = new String("Nilesh");
  String s2 = new String(n,2,2);
  System.out.println(s2);
 }
}
