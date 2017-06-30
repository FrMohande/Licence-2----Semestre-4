#include <stdio.h>
#include "mcu_readl.h"
#include "mcu_macros.h"


int main(void) {
	int i, cpt, cpt2, ligne[MAXLINE], ligne2[MAXLINE], recopie;

	cpt = -1;
	recopie = 0;

	while((cpt2=readl(ligne2))) {
		if(cpt != cpt2){
			recopie = 1;
		}else {
			for(i=0;i<cpt2;i++){
				if(ligne[i]!=ligne2[i]){
					recopie = 1;
					break;
				}
			}				
		}


		if(recopie){
			for(i=0;i<cpt2;i++){
				putchar(ligne2[i]);
				ligne[i] = ligne2[i];
			}
			putchar('\n') ;
			recopie = 0;
		}
		cpt = cpt2;		
	}	
	return 0;
}