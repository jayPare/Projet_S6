CREATE SCHEMA IF NOT EXISTS recrusimple;

------------------------------------------------------------
-- Table: Stagiaire
------------------------------------------------------------
CREATE TABLE recrusimple.Stagiaire(
    stagiaire_id   SERIAL NOT NULL ,
    numero_stage   INT   ,
    stagiaire_CV   VARCHAR (2000)   ,
    user_id        INT   ,
    departement_id INT   ,
    CONSTRAINT prk_constraint_Stagiaire PRIMARY KEY (stagiaire_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Concept
------------------------------------------------------------
CREATE TABLE recrusimple.Concept(
    concept_id  SERIAL NOT NULL ,
    concept_nom VARCHAR (25)  ,
    CONSTRAINT prk_constraint_Concept PRIMARY KEY (concept_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Departement
------------------------------------------------------------
CREATE TABLE recrusimple.Departement(
    departement_id  SERIAL NOT NULL ,
    departement_nom VARCHAR (25)  ,
    CONSTRAINT prk_constraint_Departement PRIMARY KEY (departement_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: concept_competence_stagiaire
------------------------------------------------------------
CREATE TABLE recrusimple.concept_competence_stagiaire(
    niveau_sur_5 INT   ,
    stagiaire_id INT  NOT NULL ,
    concept_id   INT  NOT NULL ,
    CONSTRAINT prk_constraint_concept_competence_stagiaire PRIMARY KEY (stagiaire_id,concept_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: concept_interet_stagiaire
------------------------------------------------------------
CREATE TABLE recrusimple.concept_interet_stagiaire(
    niveau_sur_5 INT   ,
    stagiaire_id INT  NOT NULL ,
    concept_id   INT  NOT NULL ,
    CONSTRAINT prk_constraint_concept_interet_stagiaire PRIMARY KEY (concept_id,stagiaire_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Employeur
------------------------------------------------------------
CREATE TABLE recrusimple.Employeur(
	employeur_id SERIAL NOT NULL ,
	nom          VARCHAR (50)  ,
	domaine      VARCHAR (50)  ,
	lieu         VARCHAR (50)  ,
	sommaire     VARCHAR (2000)   ,
	user_id      INT   ,
	CONSTRAINT prk_constraint_Employeur PRIMARY KEY (employeur_id)
)WITHOUT OIDS;


ALTER TABLE recrusimple.Stagiaire ADD CONSTRAINT FK_Stagiaire_user_id FOREIGN KEY (user_id) REFERENCES public.users(user_id);
ALTER TABLE recrusimple.Stagiaire ADD CONSTRAINT FK_Stagiaire_departement_id FOREIGN KEY (departement_id) REFERENCES recrusimple.Departement(departement_id);
ALTER TABLE recrusimple.concept_competence_stagiaire ADD CONSTRAINT FK_concept_competence_stagiaire_stagiaire_id FOREIGN KEY (stagiaire_id) REFERENCES recrusimple.Stagiaire(stagiaire_id);
ALTER TABLE recrusimple.concept_competence_stagiaire ADD CONSTRAINT FK_concept_competence_stagiaire_concept_id FOREIGN KEY (concept_id) REFERENCES recrusimple.Concept(concept_id);
ALTER TABLE recrusimple.concept_interet_stagiaire ADD CONSTRAINT FK_concept_interet_stagiaire_concept_id FOREIGN KEY (concept_id) REFERENCES recrusimple.Concept(concept_id);
ALTER TABLE recrusimple.concept_interet_stagiaire ADD CONSTRAINT FK_concept_interet_stagiaire_stagiaire_id FOREIGN KEY (stagiaire_id) REFERENCES recrusimple.Stagiaire(stagiaire_id);
ALTER TABLE recrusimple.Employeur ADD CONSTRAINT FK_Employeur_user_id FOREIGN KEY (user_id) REFERENCES public.users(user_id);

INSERT INTO recrusimple.Departement(departement_nom) VALUES ('GENIE INFORMATIQUE');
INSERT INTO recrusimple.Departement(departement_nom) VALUES ('GENIE ELECTRIQUE');


INSERT INTO recrusimple.Concept(concept_nom) VALUES ('Programmation web');
INSERT INTO recrusimple.Concept(concept_nom) VALUES ('Bases de données');
INSERT INTO recrusimple.Concept(concept_nom) VALUES ('Gestion de projet');
INSERT INTO recrusimple.Concept(concept_nom) VALUES ('Analyse');
INSERT INTO recrusimple.Concept(concept_nom) VALUES ('Méthodologie agile');
INSERT INTO recrusimple.Concept(concept_nom) VALUES ('MVC');
INSERT INTO recrusimple.Concept(concept_nom) VALUES ('Design de jeux vidéo');
INSERT INTO recrusimple.Concept(concept_nom) VALUES ('Réseaux');

INSERT INTO recrusimple.stagiaire(numero_stage, stagiaire_CV, user_id, departement_id) VALUES (4, 'CV', 1, 1);

INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (1, 1, 1);
INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (3, 1, 3);
INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (5, 1, 5);
INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (4, 1, 1);
INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (4, 1, 3);
INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (5, 1, 5);

INSERT INTO recrusimple.employeur(nom, domaine, lieu, sommaire, user_id) VALUES ('Genetec', 'Équipement de surveillance', 'Ville Saint-Laurent', 'Description de Genetec', 1);

CREATE OR REPLACE VIEW recrusimple.release_stagiaire AS 
 SELECT
    users.first_name,
    users.last_name,
    departement.departement_nom,
    stagiaire.numero_stage,
	stagiaire.stagiaire_id,
    concept.concept_nom,
    concept_competence_stagiaire.niveau_sur_5 AS niveau_sur_5_competence,
    concept_interet_stagiaire.niveau_sur_5 AS niveau_sur_5_interet
   FROM public.users,
    recrusimple.departement,
    recrusimple.stagiaire,
    recrusimple.concept,
    recrusimple.concept_competence_stagiaire,
    recrusimple.concept_interet_stagiaire
  WHERE users.user_id = stagiaire.user_id 
  AND stagiaire.departement_id = departement.departement_id 
  AND concept_competence_stagiaire.stagiaire_id = stagiaire.stagiaire_id 
  AND concept.concept_id = concept_competence_stagiaire.concept_id 
  AND concept.concept_id = concept_interet_stagiaire.concept_id 
  AND concept_interet_stagiaire.stagiaire_id = stagiaire.stagiaire_id;

CREATE OR REPLACE VIEW recrusimple.release_employeur AS
SELECT
	employeur.nom,
	employeur.domaine,
	employeur.lieu,
	employeur.sommaire
	FROM recrusimple.employeur
