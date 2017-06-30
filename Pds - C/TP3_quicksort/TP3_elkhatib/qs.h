#ifndef QS_H
#define QS_H


extern void quicksort(void *base, int nelem, int size, int(*compar)(const void *, const void *));
extern int compareInt(const void *elm1, const void *elm2);
extern int compareString(const void *elm1, const void *elm2);
extern int compareChar(const void *elm1, const void *elm2);

#endif
