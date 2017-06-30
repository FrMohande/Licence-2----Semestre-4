#include <stdio.h>
#define IN 1
#define OUT 2

int main(void) {
	int etat = OUT;
	int c, c2 ;


	while((c=getchar())!=EOF) {
		switch(etat) {
			case IN :
				if(c=='*'){
					c2=getchar();
					if(c2=='/')
						etat = OUT;
				}
			break;

			case OUT :
				if(c=='/'){
					c2= getchar();
					if(c2 == '*') {
						etat = IN;
					}else{
						putchar(c);
						putchar(c2);					
					}
				}else{
					putchar(c);
				}
			break;

			default: ;
		}	
	}

	return 0;
}