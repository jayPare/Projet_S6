#Étape 1: éxécuter les lignes suivantes
ALTER TABLE public.users
ADD CONSTRAINT unique_administrative_user_id UNIQUE (administrative_user_id);

DROP VIEW IF EXISTS recrusimple.release_stagiaire;

ALTER TABLE recrusimple.Employeur
DROP CONSTRAINT IF EXISTS fk_employeur_user_id;
ALTER TABLE recrusimple.Employeur
DROP CONSTRAINT IF EXISTS FK_Employeur_administrative_user_id;

ALTER TABLE recrusimple.Stagiaire
DROP CONSTRAINT IF EXISTS fk_stagiaire_user_id;
ALTER TABLE recrusimple.Stagiaire
DROP CONSTRAINT IF EXISTS FK_Stagiaire_administrative_user_id;

ALTER TABLE recrusimple.Employeur
ALTER user_id TYPE TEXT;

ALTER TABLE recrusimple.Employeur
RENAME user_id TO administrative_user_id;

ALTER TABLE recrusimple.Stagiaire
ALTER user_id TYPE TEXT;

ALTER TABLE recrusimple.Stagiaire
RENAME user_id TO administrative_user_id;

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
  WHERE users.administrative_user_id = stagiaire.administrative_user_id 
  AND stagiaire.departement_id = departement.departement_id 
  AND concept_competence_stagiaire.stagiaire_id = stagiaire.stagiaire_id 
  AND concept.concept_id = concept_competence_stagiaire.concept_id 
  AND concept.concept_id = concept_interet_stagiaire.concept_id 
  AND concept_interet_stagiaire.stagiaire_id = stagiaire.stagiaire_id;

--Étape 2: s'assurer que les champs "administrative_user_id" des records des tables 
--Employeur et Stagiaire réfèrent des cip valides de la table users

--Étape 3: éxécuter les 2 lignes suivantes
--ALTER TABLE recrusimple.Employeur ADD CONSTRAINT FK_Employeur_administrative_user_id FOREIGN KEY (administrative_user_id) REFERENCES public.users(administrative_user_id);
--ALTER TABLE recrusimple.Stagiaire ADD CONSTRAINT FK_Stagiaire_administrative_user_id FOREIGN KEY (administrative_user_id) REFERENCES public.users(administrative_user_id);
