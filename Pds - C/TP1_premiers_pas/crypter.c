#include <stdio.h>

int main (void) {
  /*exercice : return 7; */ 
  /*exercice : return 256;*/
  
  	/*exercice 14 : */ 
	/*putchar(getchar());*/
  
  char c;

  while (1) {
    c = getchar();
    if (c != EOF) 
    	putchar(c ^ '*');
    else
    	break;
  }
}
