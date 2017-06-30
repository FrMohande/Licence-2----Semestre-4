#include <stdlib.h>

#define TABSIZE 1000

void randTab(int tab[]){
	int i;
	for(i=0;i<TABSIZE;i++){
		tab[i] = rand();
	}
}

void afficher_tableau(int tab[], int size){
	int i;
	for(i=0;i<size;i++){
		printf("%d\n", tab[i]);
	}
}