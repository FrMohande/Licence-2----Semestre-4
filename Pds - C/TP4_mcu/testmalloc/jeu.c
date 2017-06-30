#include <stdio.h>
#include <stdlib.h>
#include "jeu.h"
#include "monmalloc.h"
#define MAX_LETTERS 4			

int cmp(const void* a, const void* b)
{
    return strcmp(*((char**) a), *((char**) b));
}

void CreeMatriceAdjacence(MatriceAdjacence_t mat){
	int i, j;
	for(i=0; i<TAILLE_DICO; i++){
		for(j=0;j<TAILLE_DICO;j++){
			mat[i][j] = successeurs(dico[i],dico[j]);
		}
	}
}

int successeurs(const char* a, const char* b){
	int i, nbDiff =0;
	for(i=0;i<MAX_LETTERS;i++){
		if(*(a+i) != *(b+i)){
			nbDiff++;
		}
	}
	return ((nbDiff==1)?1:0);
}

int ConvertionMotIndice(char *mot, char *dico_trie[TAILLE_DICO]){
	int i;
	i = 0;
	while(mot[i]!='\0') i++;
	if(i == MAX_LETTERS){
		i = 0;
		while(i<TAILLE_DICO) {
			if(!strcmp(mot,dico_trie[i]))
				return i;
			i++;
		}
	}
	return -1;
}

void aff(Pile_t pile){
	int res;
	if(!est_vide(pile)){
		aff(pop(pile,&res)) ;
		printf("%s -> ", dico[res]);
	}
}


int Chemin(int sommetcourant, int sommetdestination, MatriceAdjacence_t mat, Pile_t *parcours, int dejaparcouru[TAILLE_DICO]){
	int i;
	if(!dejaparcouru[sommetcourant]){
		dejaparcouru[sommetcourant] = 1;
		*parcours = push(*parcours, i);
	}
	if(sommetdestination == sommetcourant)
		return 1;
	for(i = 0; i<TAILLE_DICO; i++){
		if(!dejaparcouru[i]){
			if(mat[sommetcourant][i]){
				dejaparcouru[i] = 1;
				*parcours = push(*parcours, i);
				if(!Chemin(i, sommetdestination, mat, parcours, dejaparcouru)){
					*parcours = pop(*parcours, NULL);
					continue;
				}
				break;
			}
		}
	}
}


int main (int argc, char**argv){
	if(argc >=3){
		if(ConvertionMotIndice(argv[1],dico) != -1 && ConvertionMotIndice(argv[2],dico) != -1){
			int i, j;
			MatriceAdjacence_t mat ;
			Pile_t mapile ;
			int djp[TAILLE_DICO] = {0};
			qsort((void*)dico, TAILLE_DICO, MAX_LETTERS, cmp);
			CreeMatriceAdjacence(mat);
			Chemin(ConvertionMotIndice("lion", dico),  ConvertionMotIndice("peur",dico), mat, &mapile, djp);
			aff(mapile);
			printf("fin de l'affichage du chemin\n");
		}else{
			printf("Les deux mots en parametre sont soit trop longs, soit inexistants dans le dictionnaire.\n");
			printf("Vous devez imperativement lancer le programme avec 2 mots de 4 lettres du dictionnaire, pour continuer.\n");
			exit(EXIT_FAILURE);
		}
	}else {
		printf("Vous devez imperativement lancer le programme avec 2 mots de 4 lettres du dictionnaire, pour continuer.\n");
		exit(EXIT_FAILURE);
	}
	return 0;
}
