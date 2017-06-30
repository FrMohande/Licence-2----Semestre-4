#include <stdlib.h>
#include <stdio.h>
#include "intermezzo.h"

#define NAME_LENGTH 50
#define NATIONNALITY_LENGTH 30
#define DATE_LENGTH	4
#define ISNOTVIR(c) (c != ',')
#define ISNOTFIN(c) ((c != EOF)&&(c != '\n'))
#define TABSIZE 778

int ConstruireTableaux(struct Nomine_s *tN){
	int index ;
	index = 0 ;
	while(construireNomine(tN+index) != EOF && index < TABSIZE)
		index++;

	return index ;
}

int construireNomine(struct Nomine_s * tN){
	enum {DATE, DOMAIN, NAME, DAY, MONTH, YEAR, NATION, GENDER} current_champ = 0;
	int c, index ;
	index = 0;
	(*tN).date = 0;
	(*tN).day = 0;
	(*tN).month = 0;
	(*tN).year = 0;
	c = getchar();
	while(ISNOTFIN(c)){
		switch(current_champ){
			case DATE :
				if(ISNOTVIR(c)){
					(*tN).date *= 10;
					(*tN).date += c - '0';
				}else{
					current_champ++;
				}
				break;

			case DOMAIN :
				if(ISNOTVIR(c))
					(*tN).domaine = c - '0';
				else{
					current_champ++;
				}
				break;

			case NAME :
				if(ISNOTVIR(c) && (index < NAME_LENGTH)){
					(*tN).name[index] = c;
					index++;
				}else{
					if(index >= NAME_LENGTH){
						/* permet de passer tous les caractères jusqu'à la prochaine virgule 
							pour éviter de récupérer toutes les lettres restantes dans le champ jour */
						while(ISNOTVIR(getchar())){};
						index = NAME_LENGTH -1 ;
					}
					(*tN).name[index] = '\0';
					current_champ++;
					index = 0;
				}
				break;

			case DAY :
				if(ISNOTVIR(c)){
					(*tN).day *= 10;
					(*tN).day += c - '0';
				}else{
					current_champ++;
				}
				break;

			case MONTH :
				if(ISNOTVIR(c)){
					(*tN).month *= 10;
					(*tN).month += c - '0';
				}else{
					current_champ++;
				}
				break;

			case YEAR :
				if(ISNOTVIR(c)){
					(*tN).year *= 10;
					(*tN).year += c - '0';
				}else{
					current_champ++;
				}
				break;
		
			case NATION :
				if(ISNOTVIR(c) && (index < NATIONNALITY_LENGTH)){
					(*tN).nationnality[index] = c;
					index++;
				}else{
					if(index >= NATIONNALITY_LENGTH){
						while(ISNOTVIR(getchar())){};
						index = NATIONNALITY_LENGTH -1;
					}
					(*tN).nationnality[index] = '\0';
					current_champ++;
					index = 0;
				}
				break;

			case GENDER :
				if(ISNOTVIR(c))
					(*tN).gender = c;
					current_champ++;
				break;

			default :
				;
		}
		c = getchar();
	}
	return c ;
}



void afficherNomine(struct Nomine_s n){
	printf("%d,", n.date);
	printf("%d,", n.domaine);
	printf("%s,", n.name);
	printf("%d,", n.day);
	printf("%d,", n.month);
	printf("%d,", n.year);
	printf("%s,", n.nationnality);
	printf("%c\n", n.gender);
}

void affiche_entier(int n) {
	if (n < 0) {
        putchar('-');
        n = -n;
    }
    if (n / 10 != 0)
        affiche_entier(n / 10);
    putchar((n % 10) + '0');
}

int CompareNomineParDateDeNaissance(struct Nomine_s *p1, struct Nomine_s *p2){
	if((*p1).year == (*p2).year){
		if((*p1).month == (*p2).month){
			if((*p1).day == (*p2).day)
				return 0;
			else
				return ((*p1).day>(*p2).day)?1:-1;
		}else
			return ((*p1).month>(*p2).month)?1:-1;
	}

	return ((*p1).year>(*p2).year)?1:-1;

}