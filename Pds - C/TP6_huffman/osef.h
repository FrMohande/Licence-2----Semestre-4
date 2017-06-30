#ifndef OSEF_H
#define OSEF_H
#include <stdio.h>
#include "ArbreBinaire.h"

typedef float freq_t[1<<8] ;
void frequence(freq_t, FILE *) ;
void doubleprint(char *file);
arbrebinaire_t construction(freq_t);
#endif
