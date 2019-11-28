#include<stdio.h>
#include<string.h>

int totalRice=0;

struct Rice{
	char nama[50];
	int stock;
	int harga;
}list[100];

int main(){
	int menu;
	int totalIncome=0;
	
	FILE *load;
	load = fopen("Rice.txt", "r");

	if(load != NULL){
		while(!feof(load)){
			fscanf(load,"%[^#]#%d#%d\n", &list[totalRice].nama, &list[totalRice].stock, &list[totalRice].harga);
			 totalRice++;
		}
}
	do{
		do{
			
			
		printf("\n\n\n\n\n\n\n\n\n\n\n\n\n");
		printf("No. Rice Name             Stock                        Price\n");
		for(int i=0;i<totalRice;i++){
			printf("%-2d. %-22s%-28dRp.%d,-\n",i+1,list[i].nama, list[i].stock, list[i].harga);
		}
		printf("Total Income : Rp.%d,- ",totalIncome);
		printf("\n\nGROSIRAN RICE SHOP\n");
		printf("=================\n");
		printf("1. Add new rice\n2. Sell rice\n3. Sort rice by price ascending\n4. Save and exit\n\n");
		printf("Enter your choice : ");
		scanf("%d", &menu);fflush(stdin);
		}while(menu<1 || menu>4);
	

	switch(menu){
	case 1:
		char nama[50];
		int stock, harga;

		printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		printf("Input rice name [5..15] : ");
		scanf("%s",&nama);fflush(stdin);
		printf("Input rice stock [1..10] : ");
		scanf("%d", &stock);fflush(stdin);
		printf("Input rice price [1000..10000]: ");
		scanf("%d", &harga);fflush(stdin);
		printf("Succesfully added new rice : %s\n", nama);

		strcpy(list[totalRice].nama,nama);
		list[totalRice].stock=stock;
		list[totalRice].harga=harga;
		totalRice++;
		
		getchar();
		break;

	case 2 :{
		int Income = 0;
		for(int i=0;i<totalRice;i++){
			Income += list[i].harga * list[i].stock;
			list[i].stock=0;
		}
		printf("You have sold all rice and gained Rp.%d,-",Income);
		totalIncome+=Income;

		getchar();
		break;
	}
	case 3 :
		for(int i=0;i<totalRice;i++){
			for(int j=0;j<totalRice;j++){
				if(list[i].harga<list[j].harga){
					Rice temp;
					temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}

		break;
		getchar();
		}

	FILE *save;
	save = fopen("Rice.txt", "w");
	for(int i=0;i<totalRice;i++){
		fprintf(save,"%s#%d#%d\n", list[i].nama, list[i].stock, list[i].harga);
		}
	}while(menu!=4);
	
	return 0;
}
