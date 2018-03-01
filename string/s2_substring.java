// Construct string from subset of char array.

class s2_substring
{
 public static void main(String args[])
 {
  byte a[] = {65, 66, 67, 68, 69, 70 };

  String s1 = new String(a);
  System.out.println(s1);

  String s2 = new String(a, 2, 3);
  System.out.println(s2);
 }
}
