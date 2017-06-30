#include "mcu_affiche_entier.h"
#include <stdio.h>

void affiche_hex(int entier){
	char carhex[6] = {'A','B','C','D','E','F'}	;
	int hextemp2 = entier % 16;
	
	if(hextemp2> 9)
		putchar(carhex[hextemp2-10]);
	else
		affiche_entier(hextemp2);
	

	if((entier / 16)>0)
		affiche_hex(entier/16);
	
}