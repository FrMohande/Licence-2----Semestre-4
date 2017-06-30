#include <stdio.h>
#include "mcu_readl.h"
#include "mcu_macros.h"

int main(void) {
	int ligne[MAXLINE], i;
	i = 0;
	while(readl(ligne))
		i++;
	putchar('0'+i);
	putchar('\n') ;
	return 0;
}