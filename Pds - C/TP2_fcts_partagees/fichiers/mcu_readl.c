#include <stdio.h>
#include "mcu_macros.h"

int readl(int line[]) {
	int cpt ;
	char car ;

	cpt = 0 ;
	while(1) {
		car = getchar() ;
		if (cpt < MAXLINE) {
			if (car != EOF && car != '\n') {
				line[cpt] = car;
			} else {
				break;
			}
			cpt++;
		}else {
			exit(LINETOOLONG);
		}	
	}

	if (car = '\n') {
		return cpt ;
	} else {
		return EOF;
	}

}