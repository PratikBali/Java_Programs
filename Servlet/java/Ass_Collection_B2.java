
import java.util.*;
import java.io.*;

class Ass_Collection_B2 
{

   public static void main(String args[]) throws Exception
  {
   // crreate a linlList
 String data;
int n;
    LinkedList lst1= new LinkedList();
    LinkedList lst2= new LinkedList();
    LinkedList lst3= new LinkedList();
    LinkedList lst4= new LinkedList();
    LinkedList lst5= new LinkedList();
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("\n Enter How many elemnrs for List 1 ");
n = Integer.parseInt(br.readLine());

for(int i=0;i<n;i++)
{
   System.out.println("Enter the item :");
  data = br.readLine();
  if(lst1.contains(data))
{
System.out.println("Duplicate Entrty Is Not alowed");
i--;
}
else
{
lst1.add(data);
}
}

System.out.println("\n Enter How many elemnrs for List 2 ");
n = Integer.parseInt(br.readLine());

for(int i=0;i<n;i++)
{
   System.out.println("Enter the item :");
  data = br.readLine();
  if(lst2.contains(data))
{
System.out.println("Duplicate Entrty Is Not alowed");
i--;
}
else
{
lst2.add(data);
}
}


System.out.println("First List is : "+lst1);
System.out.println("Second List is : "+lst2);

 //  Union

 for(int i=0;i<lst1.size();i++) 
     lst3.add(lst1.get(i));

 for(int i=0;i<lst2.size();i++) 
{
  if(!lst1.contains(lst2.get(i)))
     lst3.add(lst2.get(i));
 }

System.out.println("Union of two List is "+lst3);

// intersection

for(int i=0;i<lst2.size();i++) 
{
  if(!lst1.contains(lst2.get(i)))
     lst4.add(lst2.get(i));
 }

System.out.println("InterSection of two List is "+lst4);

// Combine list

if(lst1.size()==lst2.size())
{
for(int i=0;i<lst1.size();i++) 
{
 
     lst5.add(lst1.get(i)+" "+lst2.get(i));
 }
System.out.println("\n Combined List is "+lst5);
 }
else
{
System.out.println("Size not same");
}

System.out.println("Combined list of two list "+lst5);
}
}
