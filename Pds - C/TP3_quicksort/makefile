CFLAGS= -Wall -ansi -pedantic

.PHONY: clean fclean

all: qsint_tst test clean fclean

init.o : init.c
	gcc -c init.c $(CFLAGS)

qs.o : qs.c
	gcc -c qs.c $(CFLAGS)

qsint.o : qsint.c
	gcc -c qsint.c $(CFLAGS)

intermezzo.o : intermezzo.c
	gcc -c intermezzo.c $(CFLAGS)

testQS.o : testQS.c
	gcc -c testQS.c $(CFLAGS)

testINTERMEZZO.o : testINTERMEZZO.c
	gcc -c testINTERMEZZO.c $(CFLAGS)

testQSINT.o : testQSINT.c
	gcc -c testQSINT.c $(CFLAGS)

testQSINT : testQSINT.o qsint.o
	gcc -o testQSINT testQSINT.o qsint.o $(CFLAGS)

testQS : testQS.o qs.o
	gcc -o testQS testQS.o qs.o $(CFLAGS)

msutil.o : msutil.c
	gcc -c msutil.c $(CFLAGS)

msort : msort.o msutil.o
	gcc -o msort testQSINT.o qs.o $(CFLAGS)

testINTERMEZZO : testINTERMEZZO.o
	gcc -o testINTERMEZZO testINTERMEZZO.o $(CFLAGS)

clean:
	rm -f *.o *~ 

qsint_tst: testQSINT
	./testQSINT

fclean:
	rm -f testQSINT testQS msort testINTERMEZZO

test: testQS msort
	./testQS
	man liste.txt
	./msort < liste.txt
	
testI: testINTERMEZZO
	./testINTERMEZZO