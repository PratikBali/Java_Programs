
class s6_changeCase
{
 public static void main(String args[])
 {
  String s = "This is a Java Test.";

  System.out.println("\n\t Original: " + s);

  String upper = s.toUpperCase();
  String lower = s.toLowerCase();

  System.out.println("\n\t Uppercase: " + upper);
  System.out.println("\n\t Lowercase: " + lower);
 }
}
