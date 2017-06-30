#include <stdio.h>
#include "mcu_affiche_entier.h"

int main(void) {
	char c ;
	int nb_car = 0 ;

	while((c=getchar()) != EOF) {
		nb_car++;
	}

	affiche_entier(nb_car);
	putchar('\n') ;
	return 0;
}