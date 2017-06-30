#ifndef JEU_H
#define JEU_H
#include "dico4lettres.h"
#include "pile.h"

typedef int MatriceAdjacence_t[TAILLE_DICO][TAILLE_DICO];
extern void CreeMatriceAdjacence(MatriceAdjacence_t mat);
extern int ConvertionMotIndice(char *mot, char *dico_trie[TAILLE_DICO]);



extern int Chemin(int sommetcourant, int sommetdestination, MatriceAdjacence_t mat, Pile_t *parcours, int dejaparcouru[TAILLE_DICO]);

#endif
