#include "qs.h"

#define TABMAX 9
#define TAILLEMAX 15

int main(void){
	int i ;
	int testTab[TABMAX] = {5,7,3,9,2,1,6,4,8};
	printf("TEST 2 - QUICKSORT GENERIQUE POUR ENTIERS\n");
	printf("Avant tri :\n");
	afficher_tableau(testTab,9);
	quicksort((void*)testTab,TABSIZE, sizeof(int), compareInt)
	printf("Après tri :\n");
	afficher_tableau(testTab,9);

	printf("TEST 3 - QUICKSORT GENERIQUE POUR CARACTERES\n");
	char testTab2[TABMAX] = {'o', 'l', 'a', 'e', '0', 'c', '3' ,'x', 'k'};
	printf("Avant tri :\n");
	for(i=0;i<TABMAX; i++){
		printf("%c\n", testTab2[i]);
	}
	quicksort((void*)testTab2,TABSIZE, sizeof(char), compareChar)
	printf("Après tri :\n");
	for(i=0;i<TABMAX; i++){
		printf("%c\n", testTab2[i]);
	}

	printf("TEST 4 - QUICKSORT GENERIQUE POUR CHAINES DE CARACTERES\n");
	char testTab3[TABMAX][TAILLEMAX] = {"Makanko sappo", "Kamehameha", "Buku Jutsu", "Genki Dama", "Death Ball", "Masenko", "Taiyoken" ,"Kikoho", "Garrick Cannon"};
	printf("Avant tri :\n");
	for(i=0;i<TABMAX; i++){
		printf("%s\n", testTab3[i]);
	}
	quicksort((void*)testTab3, TABSIZE, TAILLEMAX, compareString)
	printf("Après tri :\n");
	for(i=0;i<TABMAX; i++){
		printf("%s\n", testTab3[i]);
	}

	return 0;
}
