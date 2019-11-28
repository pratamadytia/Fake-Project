#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

	int a, harga[21], ha1, all=0;
	char pass[15], nama[21][16], na1[16];

	do{
		printf("Input Password : ");
		scanf("%s", &pass); fflush(stdin);
	}
	while (strcmp(pass, "drugstore")!=0);

	do {
		a=0;
		system("cls");
		printf("\t\t\tDrugstore Application\n");
		if(a!=0){
			printf("\nNo.Name Print");
			for(int i=1; i<=a; i++){
				printf("%-3d%-18d%d", i, nama[i], harga[i] );
			}
		}
		
		printf("\n\nMenu");
		printf("\n====");
		printf("\n\n1. Add Drug to List");
		printf("\n2. Remove Drug from List"); 
		printf("\n3. Exit");

		do{
			printf("\n\nChoose Menu : ");
			scanf("%d", &a); fflush(stdin);
			}
		while (a<1 || a>3);

		if(a==1){

			do{
				printf("Input drug's name [5..15] : ");
				scanf("%s",&na1);fflush(stdin);
			}
			while(strlen(na1)<5||strlen(na1)>15);

			do{
				printf("Input drug's price [10..1000] : ");
				scanf("%d",&ha1);fflush(stdin);
			}
			while(ha1<10|| ha1>15);

			if(all==0){

				all++;
				strcpy(nama[all],na1);
				harga[all] = ha1;
				printf("Drug sucessfully added\n");
			}

			else if(all!=0){

				for(int i = 1;i<=all;i++)
				{
					if(strcmp(na1,nama[i])==0)
					{
						harga[all] = ha1;
						printf("Drug is already listed, Updating price...\n");
						i = 2 * all;
					}
					else if(strcmp(na1,nama[i])!=0 && i==all)
					{
						if(all<=20)
						{
							all++;
							strcpy(nama[all],na1);
							harga[all] = ha1;
							printf("Drug sucessfully added\n");
							i = 2 * all;
						}
						else
						{
							printf("Reached maximum drug list\n");
						}
					}
				}
			}
		}

			getchar();

		if(a==2){
			if(all==0){
				printf("no data");
				getchar();
			}
			else{
				printf("Input drug's name that you want to remove : ");
				scanf("%s",&na1);fflush(stdin);
				for(int i=1;i<=all;i++)
				{
					if(strcmpi(na1,nama[i])==0)
					{
						for(int j=i;j<=all;j++)
						{
							strcpy(nama[j],nama[j+1]);
							harga[j] = harga[j+1];
						}
						all--;
					}
					else if(strcmpi(na1,nama[i])==0 && i==all)
					{
						printf("No drug founded");
						getchar();
					}
				}
			}
		}
	}
		while(a!=3);












	
getchar();
return 0;
}