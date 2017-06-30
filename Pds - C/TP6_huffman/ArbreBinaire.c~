#include "ArbreBinaire.h"
#include <stdio.h>
#include <stdlib.h>



static 
arbrebinaire_t 
AllocationNoeudBinaire
(float frequence, char lettre)
{
	arbrebinaire_t tmp ;
	tmp = (arbrebinaire_t)malloc(sizeof(struct noeud_m)) ;
	tmp -> filsgauche = NULL ;
	tmp -> filsdroit  = NULL ;
	tmp -> suivant = NULL;
	tmp -> code[0] = '\0';
	tmp -> length = 0 ;
	tmp -> letter = lettre;
	tmp -> frequency = frequence;
	return tmp ;
}

arbrebinaire_t 
CreerNoeud
(float frequence, char lettre )
{
       return AllocationNoeudBinaire(frequence, lettre) ;
}

int
EstVide
(arbrebinaire_t n)
{
	return n == NULL ;
}


float 
FrequenceNoeud
(arbrebinaire_t n) 
{
	return (*n).frequency ;
}

char 
LettreNoeud
(arbrebinaire_t n) 
{
	return (*n).letter ;
}

/* ajouter au noeud permier argument, le noeud second argument
   \`a gauche si char=='g' et \`a droite si char =='d' */
void 
AjouterAuNoeud
(arbrebinaire_t pere,arbrebinaire_t fils,char goud) 
{
	
   switch(goud)
      {
      case 'g' : {
         pere->filsgauche = fils ;
         return ;
      }
      case 'd' : {
         pere->filsdroit = fils ;
         return ;
      }	
      default : {
         printf("Error last argument should be d or g\n");
         exit(1) ;
      }
      }
   return ;
}

/* ajoute en fils gauche au noeud premier argumentle noeud second
   argument.

   CU: le fils gauche doit être vide
   Si il existe deja un noeud non vide a gauche, produit une erreur
*/
void
AjouterFilsGauche
(arbrebinaire_t pere,arbrebinaire_t fils) {
   if (!EstVide(pere->filsgauche))
      {
         printf("Error: Il y a un fils gauche\n");
         exit(FILSEXISTANT) ;
      }
   AjouterAuNoeud(pere,fils,'g');
}

/* ajoute en fils droit au noeud premier argumentle noeud second
   argument.

   CU: le fils droit doit être vide
   Si il existe deja un noeud non vide a droite, produit une erreur.
*/
void
AjouterFilsDroit
(arbrebinaire_t pere,arbrebinaire_t fils) {
   if (!EstVide(pere->filsdroit))
      {
         printf("Error: Il y a un fils droit\n");
         exit(FILSEXISTANT) ;
      }
   AjouterAuNoeud(pere,fils,'d');
}

/* remplace le fils gauche du noeud premier argument par le noeud
   second argument.
*/
void
RemplacerFilsGauche
(arbrebinaire_t pere, arbrebinaire_t fils) {
      AjouterAuNoeud(pere,fils,'g');
}

/* remplace le fils droit du noeud premier argument par le noeud
   second argument.
*/
void
RemplacerFilsDroit
(arbrebinaire_t pere, arbrebinaire_t fils) {
   AjouterAuNoeud(pere,fils,'d');
}

/* retourne le fils gauche (resp. droit) du premier argument 
   si char =='g' (resp. 'd') */
arbrebinaire_t
Descendre
(arbrebinaire_t n,char goud)
{
	switch(goud)
	{
	case 'd' : return n->filsdroit ;
	case 'g' : return n->filsgauche ;
	default : {
		printf("Error last argument should be d or g\n");
		exit(BADARGUMENT) ;
		return NULL ;
	} 
	}
	return NULL ;
}

/* retourne le fils gauche du noeud premier argument 
 * CU: n ne doit pas être vide
 */
arbrebinaire_t
FilsGauche(arbrebinaire_t n)
{
   return Descendre(n,'g');
}

/* retourne le fils droit du noeud premier argument 
 * CU: n ne doit pas être vide
 */
arbrebinaire_t
FilsDroit(arbrebinaire_t n)
{
   return Descendre(n,'d');
}


int
EstFeuille
(arbrebinaire_t a)
{
   if (EstVide(a))
      { 
         printf("Error: Le noeud est vide\n");
         exit(ARBREVIDE) ;
      }
   return (EstVide(Descendre(a,'g')) && EstVide(Descendre(a,'d')));
}

arbrebinaire_t
fusion(arbrebinaire_t a, arbrebinaire_t b){
	arbrebinaire_t tmp ;
	float fa, fb;
	fa = FrequenceNoeud(a);
	fb = FrequenceNoeud(b);
	tmp =  CreerNoeud((fa + fb), -1);
	AjouterFilsGauche(tmp, a);
	AjouterFilsDroit(tmp, b);
	return tmp;
}

void 
inserer
(arbrebinaire_t *list, arbrebinaire_t cell)  
{
	arbrebinaire_t current, tmp;
	float freqCell;
	char currentChar ;
	current = *list;
	currentChar = LettreNoeud(cell);
	freqCell = FrequenceNoeud(cell);

	if(*list != NULL ){
		for(;current->suivant; current = current->suivant){
			if(LettreNoeud(current->suivant) > currentChar)
				if(FrequenceNoeud(current->suivant) >= freqCell)
					break;
		}
		tmp = current->suivant;
		current->suivant = cell;
		cell->suivant = tmp;
	}else{
		*list = cell;
	}

}

arbrebinaire_t
extraireEnTete
(arbrebinaire_t *list) 
{
	arbrebinaire_t current, before;
	current = *list;

	if(*list != NULL){
		*list = current->suivant;
		return current;
	}
	return 0;
}





