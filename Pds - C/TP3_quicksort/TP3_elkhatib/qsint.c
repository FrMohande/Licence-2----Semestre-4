void quicksort(int *tab, unsigned int nelem){
	if(nelem>1){
		int indice ;
		indice = partitionnement(tab, nelem);
		quicksort(tab, indice);
		quicksort(tab+indice+1, ((nelem-indice)-1));
	}
}

int partitionnement(int *tab, unsigned int nelem){
	int pivot, indice, i;
	pivot = tab[0];
	indice = 0;
	for(i=1;i<nelem;i++){
		if(pivot > tab[i]){
			indice++;
			swap(tab+i, tab+indice);
		}
	}
	swap(tab, tab+indice);
	return indice;
}

void swap(int *elm1, int *elm2){
	int temp = *elm1;
	*elm1 = *elm2;
	*elm2 = temp;
}