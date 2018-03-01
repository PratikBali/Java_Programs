
/*
void getChars(int sourceStart,int sourceEnd,
                        char target[],int targetStart)
*/

class s4_getChars
{
 public static void main(String args[])
 {
  String s = "This is a demo of the getChars method.";
  char buf[] = new char[10];

  s.getChars(10,14,buf,3);
  System.out.println(buf);
 }
}
