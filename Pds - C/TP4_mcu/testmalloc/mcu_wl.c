#include <stdio.h>
#include "mcu_readl.h"
#include "mcu_macros.h"
#include "mcu_affiche_entier.h"

void mcu_wl(void) {
	int ligne[MAXLINE], i, c;
	i = 0;
	while((c =readl(ligne))!=EOF){
		i++;
	}
	affiche_entier(i);
	putchar('\n') ;
}