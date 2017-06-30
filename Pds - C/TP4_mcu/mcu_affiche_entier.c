#include <stdio.h>

void affiche_entier(int n) {
	if (n < 0) {
        putchar('-');
        n = -n;
    }
    if (n / 10 != 0)
        affiche_entier(n / 10);
    putchar((n % 10) + '0');
}
