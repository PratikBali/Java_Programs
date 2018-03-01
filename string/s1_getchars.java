

/* void getchas (int sourcestart, int sourceend,string name, start index*/



class s1_getchars
{
 public static void main(String args[])
 {
  String s = "This is a demo of the getchars method.";
  char buf[] = new char[10];

  s.getChars(8,10,buf,3);
  System.out.println(buf);
 }
}
