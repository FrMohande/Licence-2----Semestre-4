CFLAGS= -Wall -ansi -pedantic
TEST19= echo "la vie est belle, est-ce vrai." | 

.PHONY: clean

all: mcu_test mcu_wc mcu_ww mcu_rev mcu_wl mcu_remove_comments mcu_uniq

mcu_test : mcu_affiche_entier.o mcu_fatal.o mcu_readl.o mcu_test.o
	gcc  -o mcu_test mcu_affiche_entier.o mcu_fatal.o mcu_readl.o mcu_test.o $(CFLAGS)
	
mcu_affiche_entier.o : mcu_affiche_entier.c
	gcc -c mcu_affiche_entier.c $(CFLAGS)

mcu_test.o : mcu_test.c
	gcc -c mcu_test.c $(CFLAGS)

mcu_fatal.o : mcu_fatal.c
	gcc -c mcu_fatal.c $(CFLAGS)

mcu_readl.o : mcu_readl.c
	gcc -c mcu_readl.c $(CFLAGS)

mcu_wc.o : mcu_wc.c
	gcc -c mcu_wc.c $(CFLAGS)

mcu_wc : mcu_wc.o mcu_affiche_entier.o
	gcc -o mcu_wc mcu_wc.o mcu_affiche_entier.o $(CFLAGS)

mcu_ww.o : mcu_ww.c
	gcc -c mcu_ww.c $(CFLAGS)

mcu_ww : mcu_ww.o mcu_affiche_entier.o
	gcc -o mcu_ww mcu_ww.o mcu_affiche_entier.o $(CFLAGS)

mcu_wl.o : mcu_wl.c
	gcc -c mcu_wl.c $(CFLAGS)

mcu_wl : mcu_wl.o mcu_readl.o
	gcc -o mcu_wl mcu_wl.o mcu_readl.o $(CFLAGS)

mcu_rev.o : mcu_rev.c
	gcc -c mcu_rev.c $(CFLAGS)

mcu_rev : mcu_rev.o mcu_readl.o
	gcc -o mcu_rev mcu_rev.o mcu_readl.o $(CFLAGS)

mcu_remove_comments.o : mcu_remove_comments.c
	gcc -c mcu_remove_comments.c $(CFLAGS)

mcu_remove_comments : mcu_remove_comments.o
	gcc -o mcu_remove_comments mcu_remove_comments.o $(CFLAGS)

mcu_uniq.o : mcu_uniq.c
	gcc -c mcu_uniq.c $(CFLAGS)

mcu_uniq : mcu_uniq.o mcu_readl.o
	gcc -o mcu_uniq mcu_uniq.o mcu_readl.o $(CFLAGS)

clean:
	rm -f *.o *~ 
fclean:
	rm -f mcu_test mcu_wc mcu_uniq mcu_readl mcu_wl mcu_ww mcu_rev mcu_remove_comments mcu_fatal

test: all
	@echo -----------Exercice 17-----------
	@echo Utilisation du fichier test_commentaires.c pour la fonction mcu_remove_comments
	@echo test_commentaires.c :
	cat test_commentaires.c
	@echo ---------------------------------
	(./mcu_remove_comments < test_commentaires.c) > test.c
	@echo ---------------------------------
	@echo test.c :
	cat test.c
	@echo -----------Exercice 18----------- 
	./mcu_test < mcu_test.c ; echo "le code de retour est $?"
	@echo -----------Exercice 19-----------
	$(TEST19) ./mcu_wc
	$(TEST19) ./mcu_ww
	@echo -----------Exercice 20-----------
	$(TEST20p)
	cat test_wlrev.txt
	./mcu_wl < test_wlrev.txt
	./mcu_rev < test_wlrev.txt
	@echo -----------Exercice 21-----------
	@echo Utilisation du fichier test_uniq.txt pour le filtre mcu_uniq
	cat test_uniq.txt
	sort test_uniq.txt | ./mcu_uniq 
	@echo Veuillez remonter pour avoir les resultats des tests :];