#include <stdio.h>
#include "mcu_readl.h"
#include "mcu_macros.h"

int main(void) {
	int i, cpt, ligne[MAXLINE];
	while(cpt=readl(ligne)) {
		for(i=cpt-1;i>=0;i--){
			putchar(ligne[i]);
		}
		putchar('\n') ;
	}	
	return 0;
}