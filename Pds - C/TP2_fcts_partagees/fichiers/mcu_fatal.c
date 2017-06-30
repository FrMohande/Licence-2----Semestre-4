#include <stdio.h>


void fatal(int assert, const char message[], int status) {
	if (assert > 0) {
		int index ;
		char c ;

		index = 0 ;
		c = message[index] ;
		while (c != NULL) {
			putc(c, stderr);
			index++;
			c = message[index];
		}
		exit(status);
	}
}