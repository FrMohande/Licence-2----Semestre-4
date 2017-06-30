-- Question 1.1
ALTER TABLE "login"."voies" ADD PRIMARY KEY ("code_commune","code_voie");
ALTER TABLE "login"."adresses" ADD PRIMARY KEY ("code_commune","code_voie","numero");
ALTER TABLE "login"."communes" ADD PRIMARY KEY ("code_commune");

-- Question 1.2
ALTER TABLE "login"."adresses" ADD FOREIGN KEY ("code_commune","code_voie") REFERENCES "login"."voies"("code_commune","code_voie");
ALTER TABLE "login"."adresses" ADD FOREIGN KEY ("code_commune") REFERENCES "login"."communes"("code_commune");
ALTER TABLE "login"."voies" ADD FOREIGN KEY ("code_commune") REFERENCES "login"."communes"("code_commune");

-- Question 1.3
SELECT code_voie,nom_voie FROM voies WHERE code_commune = '59009';
SELECT code_voie,numero FROM adresses WHERE code_voie = '2120' AND code_commune = '59009';
SELECT nom_voie,numero FROM adresses WHERE code_voie = '2120' AND code_commune = '59009';
SELECT count(*) FROM adresses WHERE code_voie = '2120' AND code_commune = '59009';
SELECT code_voie,count(numero) FROM adresses WHERE code_commune = '59009' GROUP BY code_voie;
SELECT code_voie,nom_voie FROM adresses,communes WHERE nom_commune = 'Lille' AND adresses.code_commune = communes.code_commune GROUP BY code_voie,nom_voie;
SELECT nom_commune FROM adresses,communes WHERE nom_voie = 'Avenue Paul Langevin' AND adresses.code_commune = communes.code_commune;
SELECT nom_commune FROM adresses,communes WHERE nom_voie = 'Avenue Paul Langevin' AND adresses.numero = '12' AND adresses.code_commune = communes.code_commune;
