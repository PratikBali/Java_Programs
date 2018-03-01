import java.io.*;

class info
{
  int r,s1,s2,s3,avg;
  String t;

  void get() throws Exception
  {
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
   System.out.print("\n\t Enter the Roll no. : ");
   r = Integer.parseInt(br.readLine());

   System.out.print("\n\t Enter the Name : ");
   t = br.readLine();

   System.out.print("\n\t Enter the Marks of three subject : ");
    s1 = Integer.parseInt(br.readLine());
    s2 = Integer.parseInt(br.readLine());
    s3 = Integer.parseInt(br.readLine());

    avg = (s1+s2+s3)/3;
  }

  void disp()
  {
   System.out.println("\t Roll No. => "+r);
   System.out.println("\t Name => "+t);
   System.out.println("\t Marks => "+s1+ " " +s2+ " " +s3);
   System.out.println("\t Average => "+avg+ "%");
  }
}

class student
{ 
 public static void main(String args[])throws Exception
 {
  int n=0,c=1,i,j,m,flag,k=0,b;
  info a[] =  new info[20];

  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  while(c!=6)
  {
  System.out.print("\n\t---------Menu----------- ");
  System.out.print("\n\t 1.INSERT");
  System.out.print("\n\t 2.SEARCH");
  System.out.print("\n\t 3.SORT BY AVARAGE");
  System.out.print("\n\t 4.Display");
  System.out.print("\n\t 5.DELETE");
  System.out.print("\n\t 6.EXIT");

  try
  {

  System.out.print("\n\t Enter the choice : ");
  c = Integer.parseInt(br.readLine());

  switch(c)
  {
   case 1 :   
              
      a[k] = new info();
      System.out.print("\n\t---- Enter the Info of "+(k+1)+ " Student -----");
      a[k].get();
      k++;
      break;

   case 2 :

     flag=0;
     System.out.print("\n\t Enter the Roll No. of Student : ");
     m = Integer.parseInt(br.readLine());

     for(i=0;i<k;i++)
     {
      if(a[i].r == m)
      {
       System.out.print("\n\t---- Info of Student : ----");
       a[i].disp();
       flag=1;
       break;
      }
     }

     if(flag==0)
      System.out.print("\n\t---- Info of Student Not found----");

     break;


   case 3 :
          info f;

          for(i=0;i<k;i++)
           for(j=0;j<k;j++)
            if(a[i].avg > a[j].avg)
            {
             f=a[i];
             a[i]=a[j];
             a[j]=f;
            }

          System.out.println("\n\t ---List of Sorted Student ---\n");
          for(i=0;i<k;i++)
           System.out.println("\t Roll No = "+a[i].r+"\tName = "+a[i].t+"\tAvarage = "+a[i].avg+"%");
        
          break;
        

    case 4 :

          for(i=0;i<k;i++)
           for(j=0;j<k;j++)
            if(a[i].r < a[j].r)
            {
             f=a[i];
             a[i]=a[j];
             a[j]=f;
            }

            for(i=0;i<k;i++)
            {
             System.out.println("\n\n\t *** Info. of "+(i+1)+" Student ***");
             a[i].disp();
            }

                  break;
           

    case 5 :  flag=0;
              int d;

         System.out.print("\n\t Enter the Roll No. to delete : ");
         d = Integer.parseInt(br.readLine());


         for(i=0;i<k;i++)
         {
          if(a[i].r == d)
          {
           System.out.print("\n\t---- Info of Student found ----");
           b=i;

           for(i=b;i<k;i++)
             a[i]=a[i+1];

             k--;

           System.out.print("\n\t---- Info of Student Deleted Successfully ----\n");

           flag=1;
           break;
          }
         }

        if(flag==0)
        System.out.print("\n\t---- Info of Student Not found----");

        break;

    case 6 :
       System.exit(0);

    default:
        System.out.print("\n\t----This is Not a Valid Choice ----");
  }  // EOF Switch

  }catch(Exception e){System.out.print("\n\t --- Exception Caught --- \n"+e+"\n");}
  }  // EOF Switch

 }
}
