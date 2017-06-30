#include <stdio.h>
#define LINETOOLONG 2
#define NMAXLINE 100
#define NMAXCHAR 125

int readl(int line[]) {
	int cpt ;
	char car ;

	cpt = 0 ;
	while(1) {
		car = getchar() ;
		if (cpt < NMAXCHAR) {
			if (car != EOF && car != '\n') {
				line[cpt] = car;
			} else {
				break;
			}
			cpt++;
		}else {
			exit(LINETOOLONG);
		}	
	}

	if (car = '\n') {
		return cpt ;
	} else {
		return EOF;
	}

}

int fill(int** texte){
	int cpt;
	cpt = 0;
	while(cpt < NMAXLINE && readl(texte[cpt])){
		cpt++;
	}
	
	return cpt +1;
}

void afficher(int** texte, int size){
	int i ;	
	for(i = 0; i<size;i++){
		printf("%s", texte[i]);	
	}
}
