#include "intermezzo.h"
#define MAXTAB 778

int main(void){
	int n, i, r;
	struct Nomine_s nomTab[MAXTAB];
	n = ConstruireTableaux(nomTab);
	for(i=0;i<n;i++){
		afficherNomine(nomTab[i]);
	}
	printf("Fin du test de recupération et d'affichage des nominés, le nombre de nominés est de %d\n", n);
	printf("test de comparaison entre les dates de naissance des deux nominés suivants :\n");
	
	afficherNomine(nomTab[n-3],nomTab[n-1]);

	r = CompareNomineParDateDeNaissance(nomTab+n-3,nomTab+n-1);
	printf("%d\n", r);