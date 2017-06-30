#ifndef INTERMEZZO_H
#define INTERMEZZO_H

#define NAME_LENGTH 50
#define NATIONNALITY_LENGTH 30
#define DATE_LENGTH	4



struct Nomine_s
{
    int date;
    int domaine;
    char name[NAME_LENGTH];
    int day;
    int month;
    int year;
    char nationnality[NATIONNALITY_LENGTH];
    char gender;
};


int ConstruireTableaux(struct Nomine_s *) ;
void afficherNomine(struct Nomine_s n);
int CompareNomineParDateDeNaissance(struct Nomine_s *, struct Nomine_s *);

#endif