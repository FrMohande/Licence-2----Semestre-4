#ifndef PILE_H
#define PILE_H


struct elt_t {
	int val;
	struct elt_t * next ;
};

typedef struct elt_t * Pile_t;

extern int est_vide(Pile_t pile) ;

extern Pile_t push(Pile_t pile, int elt) ;

extern Pile_t pop(Pile_t pile,int* res) ;

extern void clean_pile(Pile_t pile);

#endif