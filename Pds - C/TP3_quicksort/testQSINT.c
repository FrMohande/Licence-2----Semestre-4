#include "qsint.h"
#include "init.h"

#define TABMAX 9


int main(void){
	int testTab[TABMAX] = {5,7,3,9,2,1,6,4,8};
	printf("TEST 1 - QUICKSORT D'ENTIERS\n");
	printf("Avant tri :\n");
	afficher_tableau(testTab,9);
	quicksort(testTab, TABMAX);
	printf("Après tri :\n");
	afficher_tableau(testTab,9);

	return 0;
}
