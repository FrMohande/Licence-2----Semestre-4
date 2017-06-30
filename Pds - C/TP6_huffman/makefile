PAR= -ansi -pedantic 

.PHONY: clean

all: test

osef : osef.o osef.o ArbreBinaire.o
	gcc $(PAR) -o $@ $^

ArbreBinaire.o: ArbreBinaire.c
	gcc $(PAR) -c $^


osef.o: osef.c
	gcc $(PAR) -c $^

clean:
	-rm monmalloc*.o monmalloc_essai

test: osef
	./osef toto.txt
