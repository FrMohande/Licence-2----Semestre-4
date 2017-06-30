-- Question 1 a
SELECT dossard,nom FROM coureurs;

-- Question 1 b
SELECT dossard,nom FROM coureurs ORDER BY dossard ASC;

-- Question 1 c
SELECT dossard,nom FROM coureurs ORDER BY equipe ASC,nom ASC;

-- Question 1 d
SELECT dossard,nom,taille FROM coureurs ORDER BY taille ASC;

-- Question 1 e
SELECT nom,dossard FROM coureurs WHERE equipe = 'LavePlusBlanc';

-- Question 1 f
SELECT coureurs.nom,coureurs.dossard FROM coureurs WHERE equipe = 'LavePlusBlanc';

-- Question 1 g
SELECT nom,taille,equipe FROM coureurs WHERE taille <= 180;

-- Question 1 h
SELECT nom,taille,equipe FROM coureurs WHERE taille <= 180 ORDER BY taille ASC;

-- Question 1 i
SELECT couleur FROM equipes;

-- Question 2 a
SELECT nom || ' appartient à l''équipe ' || equipe FROM coureurs;

-- Question 2 b
SELECT nom || ' appartient à l''équipe ' || equipe AS appartenance FROM coureurs;

-- Question 2 c
SELECT upper(nom) AS nom_maj,char_length(nom) AS lg FROM coureurs;

-- Question 2 d
SELECT upper(nom) AS nom_maj,char_length(nom) AS lg FROM coureurs ORDER BY lg ASC;
SELECT upper(nom) AS nom_maj,char_length(nom) AS lg FROM coureurs ORDER BY char_length(nom);

-- Question 2 e
SELECT dossard,initcap(nom) AS nom,substr(upper(equipe),0,4) AS equipe FROM coureurs;

-- Question 3 a
SELECT nom FROM coureurs WHERE nom LIKE 'a%';

-- Question 3 b
SELECT nom FROM coureurs WHERE nom LIKE '%er%';

-- Question 3 c
SELECT nom FROM coureurs WHERE nom LIKE '_____';

-- Question  3 d
SELECT nom FROM coureurs WHERE nom LIKE '%a__';

-- Question  3 e
SELECT nom FROM coureurs WHERE nom LIKE '%a__%';

-- Question 4 a
SELECT (taille / 100) AS tailleCm FROM coureurs;

-- Question 4 b
SELECT CAST((taille / 100.0) AS VARCHAR(4)) AS tailleCm FROM coureurs;

-- Question 5 a
SELECT * FROM coureurs,equipes;

-- Question 5 b
SELECT * FROM coureurs,equipes WHERE coureurs.equipe = equipes.nom;

-- Question 5 c
SELECT coureurs.dossard,coureurs.nom,equipes.nom,equipes.couleur FROM coureurs,equipes WHERE coureurs.equipe = equipes.nom;

-- Question 5 d
SELECT coureurs.nom,equipes.directeur FROM coureurs,equipes WHERE coureurs.equipe = equipes.nom;

-- Question 5 e
SELECT coureurs.nom,coureurs.dossard FROM coureurs,equipes WHERE equipes.directeur = 'Ralph';

-- Question 5 f
SELECT equipes.directeur FROM equipes,coureurs WHERE coureurs.nom = 'alphonse';

-- Question 6 a
INSERT INTO equipes(nom,couleur,directeur) VALUES('LesNinjas','noir','Matt');

-- Question 6 b
INSERT INTO coureurs(dossard,nom,equipe,taille) VALUES(658,'Amphinobi','LesNinjas',150);
INSERT INTO coureurs(dossard,nom,equipe,taille) VALUES(291,'Ninjask','LesNinjas',80);

-- Question 7 a
INSERT INTO equipes(couleur,nom) VALUES('orange','Nouvelle Équipe');
SELECT * FROM equipes WHERE directeur IS NULL;

-- Question 7 b
SELECT * FROM equipes WHERE directeur IS NOT NULL;

-- Question 8 a
UPDATE coureurs SET taille = taille - 1 WHERE equipe = 'PicsouBank';

-- Question 8 b
UPDATE equipes SET directeur = 'Jean' WHERE directeur IS NULL;

-- Question 9
CREATE TABLE etape (
  dossard int,
  arriver time,
  PRIMARY KEY (dossard)
);
INSERT INTO etape(dossard,arriver) VALUES(1,'17:05:02');
INSERT INTO etape(dossard,arriver) VALUES(2,'16:50:42');
INSERT INTO etape(dossard,arriver) VALUES(3,'17:08:47');
INSERT INTO etape(dossard,arriver) VALUES(4,'17:05:34');
INSERT INTO etape(dossard,arriver) VALUES(5,'16:58:13');
INSERT INTO etape(dossard,arriver) VALUES(6,'16:59:27');
INSERT INTO etape(dossard,arriver) VALUES(7,'17:03:52');
INSERT INTO etape(dossard,arriver) VALUES(291,'16:40:12');
INSERT INTO etape(dossard,arriver) VALUES(658,'16:40:12');

-- Question 10 a
SELECT coureurs.dossard,coureurs.nom,etape.arriver FROM coureurs,etape WHERE coureurs.dossard = etape.dossard ORDER BY etape.arriver ASC

-- Question 10 b
SELECT coureurs.dossard,coureurs.nom,etape.arriver FROM coureurs,etape WHERE coureurs.dossard = etape.dossard AND etape.arriver < '17:00:00' ORDER BY etape.arriver ASC

-- Question 10 c
SELECT coureurs.dossard,coureurs.nom,coureurs.equipe,equipes.couleur,etape.arriver FROM coureurs,equipes,etape WHERE coureurs.equipe = equipes.nom AND coureurs.dossard = etape.dossard ORDER BY etape.arriver ASC
