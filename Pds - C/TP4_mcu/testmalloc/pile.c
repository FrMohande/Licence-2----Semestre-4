#include "pile.h"
#include <stdio.h>
#include "monmalloc.h"

int est_vide(Pile_t pile) {
	return pile == NULL ;
}

Pile_t push(Pile_t pile, int elt) {
	Pile_t res ;
	res = (Pile_t) malloc(sizeof(struct elt_t)) ;
	res->val = elt ;
	res->next=pile ;
	return res ;
}

Pile_t pop(Pile_t pile,int* res) {
	/* pile non vide */
	Pile_t tmp;
	tmp = pile->next ;
	if(res != NULL) {
		*res = pile->val ;
	}
	free(pile) ;
	return tmp;
}
void clean_pile(Pile_t pile) {
	int tmp ;
	if(!est_vide(pile))
		pile=pop(pile,&tmp) ;
}
