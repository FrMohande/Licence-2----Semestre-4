#include <stdio.h>
#include "mcu_macros.h"
#include "mcu_fatal.h"

int readl(int line[]) {
	int cpt ;
	char car ;

	cpt = 0 ;
	while(1) {
		fatal((cpt==MAXLINE), "Texte trop grand\n",LINETOOLONG);
		car = getchar() ;
		if (car != EOF && car != '\n') {
			line[cpt] = car;
		} else {
			break;
		}
		cpt++;
	}

	if (car == '\n') {
		return cpt ;
	} else {
		return EOF;
	}

}