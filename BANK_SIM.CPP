#include<conio.h>
#include<stdio.h>

main()
{
 int ch,tamt=0,wamt,amt;

 do
 {
  printf("\n\n\t *** Welcome to National Bank ***");
  printf("\n\t 1. Insert Money");
  printf("\n\t 2. Withdrawl Money");
  printf("\n\t 3. Exit");
  printf("\n\n\t Enter your choice : ");
  scanf("%d",&ch);

	switch(ch)
	{
	 case 1:
		printf("\n\t Enter the total Amount to Insert: ");
		scanf("%d",&amt);
		tamt = tamt+amt;
		printf("\n\t Remaining Balance is : %d",tamt);
		break;
	 case 2:
		printf("\n\t Enter the total Amount to Withdrawl : ");
		scanf("%d",&wamt);

		if((tamt-wamt)<500)
		 printf("\n\n\t *** Low Balance ***");
		else
		 tamt = tamt-wamt;

		printf("\n\t Remaining Balance is : %d",tamt);
		break;
	 case 3:
		printf("\n\n\t Press any key to Exit ...");
		break;
	 default:
		printf("\n\n\t This is NOT a Valid Choice ...");
	}
  }while (ch !=3);
 getch();
}
