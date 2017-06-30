/* ceci est un commentaire */

/* voici un exemple de macro */
#define VAL 2
/* nous \'etudierons les macros plus en d\'etails par la suite */

/* ici on inclut un fichier d'ent\^ete se trouvant dans le
   r\'epertoire /usr/include (pour linux) */
#include <stdio.h>

extern int variable_definie_ailleur ;

/* un exemple ou il n'est pas possible de s\'eparer
   d\'eclaration et d\'efinition */
const int variable_de_classe_externe_constante = 1;

int variable_de_classe_externe ;

int
main
(void)
{ 
  /* ceci est un commentaire 
     sur plusieurs lignes */

  char variable_de_classe_automatique ;

  variable_de_classe_automatique = 'A' ;
  variable_de_classe_externe = VAL ;

  /* un exemple d'appel de fonctions */
  printf("Hello wold\n");
  /* nous reviendrons plus tard sur les fonctions */

  /* un exemple de conversion explicite */
  return 
    variable_de_classe_automatique
    + variable_definie_ailleur 
    + variable_de_classe_externe 
    + variable_de_classe_externe_constante ;
} 
