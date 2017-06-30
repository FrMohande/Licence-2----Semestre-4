#include "msutil.h"
#include "qs.h"

#define NMAXLINE 100
#define NMAXCHAR 125

int main(void){
	int texte[NMAXLINE][NMAXCHAR], n;
	n = fill(texte);
	afficher(texte,n);
}