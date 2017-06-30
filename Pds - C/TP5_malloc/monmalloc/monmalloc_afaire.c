#include "monmalloc_infra.h"
#include "monmalloc_afaire.h"
#include <stdio.h>
#include <stdlib.h>

void 
inserer
(liste_t *list, liste_t cell)  
{
	liste_t current, tmp;
	unsigned int tailleCell;
	current = *list;

	tailleCell = USS(cell);

	if(*list != NULL){
		for(;current->next; current = current->next){
			if(current->magicnumber != MAGICNUMBER)
				exit(EXIT_FAILURE);
			if(USS(current->next) >= tailleCell)
				break;
		}
		tmp = current->next;
		current->next = cell;
		cell->next = tmp;
	}else{
		*list = cell;
	}

}

liste_t 
extraire
(liste_t *list, unsigned int size ) 
{
	liste_t current, before;
	current = *list;

	if(*list != NULL){
		if(size <= USS(current)){
			if(current->magicnumber != MAGICNUMBER)
					exit(EXIT_FAILURE);
			*list = current->next;
			return current;
		}else{
			while(current->next) {
				before = current;
				current = current->next;
				if(current->magicnumber != MAGICNUMBER)
					exit(EXIT_FAILURE);
				if(size <= USS(current)){
					before->next = current->next;
					return current;
				}
			}
		}
	}
	return 0;
}