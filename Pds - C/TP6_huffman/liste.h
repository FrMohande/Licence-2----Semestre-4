#ifndef LISTE_H
#define LISTE_H
#include <stdio.h>
#include <stdlib.h>
#include "ArbreBinaire.h"

#define USS(c) (FrequenceNoeud(((c)->noeud)))
#define LETTER(c) (LettreNoeud((c)->noeud))

struct cell_m
{
       	noeud_m noeud ;
        struct cell_m * next ;
} ;

typedef struct cell_m *liste_t ;

void construirecellule (liste_t tmp, noeud_m parnoeud);
void inserer (liste_t *list, liste_t cell);
liste_t extraireEnTete (liste_t *list) ;

#endif
