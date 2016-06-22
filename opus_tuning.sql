------------------------------------------------------------
-- Table: Stagiaire
------------------------------------------------------------
CREATE TABLE public.Stagiaire(
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
CREATE TABLE public.Concept(
    concept_id  SERIAL NOT NULL ,
    concept_nom VARCHAR (25)  ,
    CONSTRAINT prk_constraint_Concept PRIMARY KEY (concept_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Departement
------------------------------------------------------------
CREATE TABLE public.Departement(
    departement_id  SERIAL NOT NULL ,
    departement_nom VARCHAR (25)  ,
    CONSTRAINT prk_constraint_Departement PRIMARY KEY (departement_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: concept_competence_stagiaire
------------------------------------------------------------
CREATE TABLE public.concept_competence_stagiaire(
    niveau_sur_5 INT   ,
    stagiaire_id INT  NOT NULL ,
    concept_id   INT  NOT NULL ,
    CONSTRAINT prk_constraint_concept_competence_stagiaire PRIMARY KEY (stagiaire_id,concept_id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: concept_interet_stagiaire
------------------------------------------------------------
CREATE TABLE public.concept_interet_stagiaire(
    niveau_sur_5 INT   ,
    stagiaire_id INT  NOT NULL ,
    concept_id   INT  NOT NULL ,
    CONSTRAINT prk_constraint_concept_interet_stagiaire PRIMARY KEY (concept_id,stagiaire_id)
)WITHOUT OIDS;



ALTER TABLE public.Stagiaire ADD CONSTRAINT FK_Stagiaire_user_id FOREIGN KEY (user_id) REFERENCES public.users(user_id);
ALTER TABLE public.Stagiaire ADD CONSTRAINT FK_Stagiaire_departement_id FOREIGN KEY (departement_id) REFERENCES public.Departement(departement_id);
ALTER TABLE public.concept_competence_stagiaire ADD CONSTRAINT FK_concept_competence_stagiaire_stagiaire_id FOREIGN KEY (stagiaire_id) REFERENCES public.Stagiaire(stagiaire_id);
ALTER TABLE public.concept_competence_stagiaire ADD CONSTRAINT FK_concept_competence_stagiaire_concept_id FOREIGN KEY (concept_id) REFERENCES public.Concept(concept_id);
ALTER TABLE public.concept_interet_stagiaire ADD CONSTRAINT FK_concept_interet_stagiaire_concept_id FOREIGN KEY (concept_id) REFERENCES public.Concept(concept_id);
ALTER TABLE public.concept_interet_stagiaire ADD CONSTRAINT FK_concept_interet_stagiaire_stagiaire_id FOREIGN KEY (stagiaire_id) REFERENCES public.Stagiaire(stagiaire_id);

INSERT INTO public.Departement(departement_nom) VALUES ('GENIE INFORMATIQUE');
INSERT INTO public.Departement(departement_nom) VALUES ('GENIE ELECTRIQUE');


INSERT INTO public.Concept(concept_nom) VALUES ('Programmation web');
INSERT INTO public.Concept(concept_nom) VALUES ('Bases de données');
INSERT INTO public.Concept(concept_nom) VALUES ('Gestion de projet');
INSERT INTO public.Concept(concept_nom) VALUES ('Analyse');
INSERT INTO public.Concept(concept_nom) VALUES ('Méthodologie agile');
INSERT INTO public.Concept(concept_nom) VALUES ('MVC');
INSERT INTO public.Concept(concept_nom) VALUES ('Design de jeux vidéo');
INSERT INTO public.Concept(concept_nom) VALUES ('Réseaux');

INSERT INTO public.stagiaire(numero_stage, stagiaire_CV, user_id, departement_id) VALUES (4, 'CV', 1, 1);

INSERT INTO public.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (1, 1, 1);
INSERT INTO public.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (3, 1, 3);
INSERT INTO public.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (5, 1, 5);
INSERT INTO public.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (4, 1, 1);
INSERT INTO public.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (4, 1, 3);
INSERT INTO public.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (5, 1, 5);

  ------------------------------------------------------------
-- Vue: User
------------------------------------------------------------
CREATE OR REPLACE VIEW public.release AS 
 SELECT
    users.first_name,
    users.last_name,
    departement.departement_nom,
    stagiaire.numero_stage,
	stagiaire.stagiaire_id,
    concept.concept_nom,
    concept_competence_stagiaire.niveau_sur_5 AS niveau_sur_5_competence,
    concept_interet_stagiaire.niveau_sur_5 AS niveau_sur_5_interet
   FROM users,
    departement,
    stagiaire,
    concept,
    concept_competence_stagiaire,
    concept_interet_stagiaire
  WHERE users.user_id = stagiaire.user_id 
  AND stagiaire.departement_id = departement.departement_id 
  AND concept_competence_stagiaire.stagiaire_id = stagiaire.stagiaire_id 
  AND concept.concept_id = concept_competence_stagiaire.concept_id 
  AND concept.concept_id = concept_interet_stagiaire.concept_id 
  AND concept_interet_stagiaire.stagiaire_id = stagiaire.stagiaire_id;

  ------------------------------------------------------------
-- Vue: Recruteur
------------------------------------------------------------
CREATE TABLE public.recruteur
(
  recruteur_id SERIAL NOT NULL,
  entreprise_sommaire VARCHAR (2000) ,
  entreprise_nature VARCHAR (2000) ,
  entreprise_fonction VARCHAR (2000) ,
  entreprise_technologies VARCHAR (2000) ,
  entreprise_exigences VARCHAR (2000) ,
  CONSTRAINT prk_constraint_recruteur PRIMARY KEY (recruteur_id)
)

INSERT INTO public.Recruteur(recruteur_id, entreprise_sommaire, entreprise_nature, entreprise_fonction, entreprise_technologies, entreprise_exigences) VALUES (0,'sommaire','nature','fonction','technologies','exigences');

