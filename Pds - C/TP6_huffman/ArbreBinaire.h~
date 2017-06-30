#ifndef ARBREBINAIRE_H
#define ARBREBINAIRE_H

#define FILSEXISTANT 1 
#define BADARGUMENT 2
#define ARBREVIDE 3

typedef struct noeud_m * arbrebinaire_t ;


struct noeud_m
{
	float frequency;
	int length;
	char code[20];
	int letter;
	arbrebinaire_t  filsgauche ;
	arbrebinaire_t  filsdroit ;
	arbrebinaire_t  suivant;
} ;


/* cr\'ee un arbre vide */
arbrebinaire_t CreerArbreVide(void) ;

/* cr\'ee une feuille avec une valeur associ\'ee */
arbrebinaire_t CreerNoeud(float, char) ;

/* pr\'edicat de test qu'un noeud est vide */
int EstVide (noeud_m);

char LettreNoeud(arbrebinaire_t);

/* pr\'edicat de test qu'un noeud est une feuille.  

   CU: le noeud ne doit pas être vide, sinon produit une erreur. */
int EstFeuille (arbrebinaire_t);

/* retourne la valeur associ\'e au noeud pass\'e en param\`etre.

   CU: le noeud ne doit pas \^etre vide */
float FrequenceNoeud(arbrebinaire_t) ;

/* ajoute en fils gauche au noeud premier argument le noeud second
   argument.

   CU: le fils gauche doit \^etre vide, sinon produit une erreur
*/
void AjouterFilsGauche(arbrebinaire_t,arbrebinaire_t) ;

/* ajoute en fils droit au noeud premier argumentle noeud second
   argument.

   CU: le fils droit doit \^etre vide sinon produit une erreur
*/
void AjouterFilsDroit(arbrebinaire_t,arbrebinaire_t) ;

/* remplace le fils gauche du noeud premier argument par le noeud
   second argument.
*/
void RemplacerFilsGauche(arbrebinaire_t,arbrebinaire_t) ;

/* remplace le fils droit du noeud premier argument par le noeud
   second argument.
*/
void RemplacerFilsDroit(arbrebinaire_t,arbrebinaire_t) ;

/* retourne le fils gauche du noeud premier argument */
arbrebinaire_t FilsGauche(arbrebinaire_t);

/* retourne le fils droit du noeud premier argument */
arbrebinaire_t FilsDroit(arbrebinaire_t);

arbrebinaire_t fusion(arbrebinaire_t, arbrebinaire_t);

arbrebinaire_t extraireEnTete (arbrebinaire_t *);
void inserer (arbrebinaire_t *, arbrebinaire_t ) ;

#endif
