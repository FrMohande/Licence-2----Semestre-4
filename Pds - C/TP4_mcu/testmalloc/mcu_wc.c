#include <stdio.h>
#include "mcu_affiche_entier.h"

void mcu_wc(void) {
	int nb_car = 0 ;

	while(getchar() != EOF) {
		nb_car++;
	}

	affiche_entier(nb_car);
	putchar('\n') ;
}