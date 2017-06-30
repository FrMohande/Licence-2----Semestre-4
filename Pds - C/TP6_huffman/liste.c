#include "liste.h"

liste_t freelist = 0 ;

void construirecellule
(liste_t tmp, noeud_m parnoeud)
{
	tmp = malloc(sizeof(struct cell_m));
	tmp -> noeud = parnoeud;
	tmp -> next = NULL ;
	inserer(&freelist, tmp) ;
	return ;
}
