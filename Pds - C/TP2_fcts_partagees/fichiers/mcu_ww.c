#include <stdio.h>
#include "mcu_affiche_entier.h"

#define OUT 0
#define IN  1
#define ISCAR(c) (((c>='0') && (c<='9')) || ((c>='A') && (c<='Z')) || ((c>='a')&&(c<='z')))


int main(void) {
	char c ;
	int etat = OUT, nb_mots = 0 ;

	while((c=getchar()) != EOF) {
		switch(etat) {
			case IN :
				if(ISCAR(c)) 
					etat = OUT;
			break;

			case OUT :
				if(!ISCAR(c)) {
					etat = IN ;
					nb_mots++;
				}
			break;

			default :
			;
		}
	}

	affiche_entier(nb_mots);
	putchar('\n') ;
	return 0;
}
