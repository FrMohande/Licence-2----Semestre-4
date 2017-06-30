#include "monmalloc.h"

int
main
(void)
{
	void * tmp ;
	tmp = malloc(1000) ;
	free(tmp);

	return 0 ;
}
	
