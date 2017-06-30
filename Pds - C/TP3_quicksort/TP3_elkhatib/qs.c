void quicksort(void *base, int nelem, int size, int(*compar)(const void *, const void *)){
	if(nelem>1){
		int indice ;
		indice = partitionnement(base, nelem, size, compar);
		quicksort(base, indice, size, compar);
		quicksort((char*)base+((indice+1)*size), (nelem-indice)-1, size, compar);
	}
}

int partitionnement(void *tab, int nelem, int size, int(*compar)(const void *, const void *)){
	int indice, i;
	indice = 0;
	for(i=1;i<nelem;i++){	
		if(compar((char*)tab, (char*)(tab+(i*size))) > 0){
			indice++;
			swap((char*)(tab+(i*size)), (char*)(tab+(indice*size)), size);
		}
	}
	swap((char*)tab, (char*)(tab+(indice*size)), size);
	return indice;
}

void swap(void * d1 , void * d2 , int size) {
	int i ;
	unsigned char tmp;
	for(i=0;i<size;i++){
		tmp = *((unsigned char*)d1+i);
		*((unsigned char*)d1+i) = *((unsigned char*)d2+i);
		*((unsigned char*)d2+i) = tmp;
	}
}

int compareInt(const void *elm1, const void *elm2){
	if(*((int*)elm1) == *((int*)elm2)){
		return 0;
	}
	return ((*((int*)elm1))>(*((int*)elm2))?1:-1);
}

int compareString(const void *elm1, const void *elm2){
	int i,n;
	i = 0;
	while((n = compareChar((char*)elm1+i,(char*)elm2+i)) == 0 && *((char*)elm1+i) != '\0' && *((char*)elm2+i) != '\0'){
		i++;
	}

	if(n != 0){
		if(*((char*)elm1+i) != '\0' && *((char*)elm2+i) != '\0'){
			return n;
		}else{
			if(*((char*)elm1+i) == '\0')
				return -1;
			else
				return 1;
		}
	}
	return n;
}

int compareChar(const void *elm1, const void *elm2){
	if(*((char*)elm1) == *((char*)elm2)){
		return 0;
	}
	return ((*((char*)elm1))>(*((char*)elm2))?1:-1);
}
