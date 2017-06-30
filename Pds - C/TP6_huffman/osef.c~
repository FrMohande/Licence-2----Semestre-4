#include "osef.h"
#define BUFF_SIZE 20

int main(int argc, char *argv[]){
	FILE * fp ;
	int i ;
	freq_t monfreq ;
	fp = fopen(argv[1], "r");
	frequence(monfreq, fp);
	for(i=0;i<256;i++)
		printf("%c -> %f\n", i, monfreq[i]);
	construction(monfreq);
	/*doubleprint(argv[1]);*/
	fclose(fp);
	return 0;
}

void doubleprint(char *file){
	FILE * fp ;
	char buffer ;
	size_t current ;
	fp = fopen(file, "r");
	if(fp == NULL) return ;
	while(1){
		current = fread(&buffer, sizeof(char), 1, fp);
		printf("%c", buffer);
		if(current != 1) break;
	}

	rewind(fp);

	while(1){
		current = fread(&buffer, sizeof(char), 1, fp);
		printf("%c", buffer);
		if(current != 1) break;
	}

	fclose(fp);
}

void frequence(freq_t t, FILE * fp) {
	int occ[1<<8] = {0};
	char buffer[BUFF_SIZE] ;
	int size, i , filesize;

	if(fp == NULL) return;
	filesize = 0;
	while(1){
		size = fread(buffer, sizeof(char), BUFF_SIZE, fp);
		printf(" Taille du block : %d\n", size);
		filesize += size;
		for(i = 0; i < BUFF_SIZE ; i++)
			occ[(buffer[i])]++;
		if(size != BUFF_SIZE) break;
	}

	for(i=0;i<256;i++){
		t[i] = (float)occ[i] / filesize;
	}
}

arbrebinaire_t construction(freq_t frequences){
	int i, cpt;
	arbrebinaire_t liste, tmpnoeud, tmpnoeud2;

	for(i=0,cpt=0;i<256;i++){
		if(frequences[i]>0){
			cpt++;
			tmpnoeud = CreerNoeud(frequences[i], i);
			printf("lettre : %c, frequence : %f \n", i, frequences[i]);
			inserer(&liste, tmpnoeud);
		}
	}

	for(i=0;i<cpt;i++){
		tmpnoeud = extraireEnTete(&liste);
		printf("lettre : %c, frequence : %f \n", LettreNoeud(tmpnoeud), FrequenceNoeud(tmpnoeud));
	}
	if(!cpt) return 0;
	/*while(liste->suivant != NULL){
		tmpnoeud = extraireEnTete(&liste);
		tmpnoeud2 = extraireEnTete(&liste);
		tmpnoeud = fusion(tmpnoeud, tmpnoeud2);
		inserer(&liste, tmpnoeud);
	}*/
	return liste;
			
}
