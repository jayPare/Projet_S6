--Script SQL pour le release 3
--N.B. le script opus_tuning2.sql doit avoir été exécuté avant celui-ci

ALTER TABLE recrusimple.Employeur
ADD taches       VARCHAR (2000);

------------------------------------------------------------
-- Table: concept_employeur
------------------------------------------------------------
CREATE TABLE recrusimple.concept_employeur(
	concept_id   INT  NOT NULL ,
	employeur_id INT  NOT NULL ,
	CONSTRAINT prk_constraint_concept_employeur PRIMARY KEY (concept_id,employeur_id)
)WITHOUT OIDS;

------------------------------------------------------------
-- Table: stagiaire_interesse_par_employeur
------------------------------------------------------------
CREATE TABLE recrusimple.stagiaire_interesse_par_employeur(
	stagiaire_id INT  NOT NULL ,
	employeur_id INT  NOT NULL ,
	interet      BOOL   ,
	CONSTRAINT prk_constraint_stagiaire_interesse_par_employeur PRIMARY KEY (stagiaire_id,employeur_id)
)WITHOUT OIDS;

------------------------------------------------------------
-- Table: employeur_interesse_par_stagiaire
------------------------------------------------------------
CREATE TABLE recrusimple.employeur_interesse_par_stagiaire(
	stagiaire_id INT  NOT NULL ,
	employeur_id INT  NOT NULL ,
	interet      BOOL   ,
	CONSTRAINT prk_constraint_employeur_interesse_par_stagiaire PRIMARY KEY (stagiaire_id,employeur_id)
)WITHOUT OIDS;

------------------------------------------------------------
-- Table: match
------------------------------------------------------------
CREATE TABLE recrusimple.match(
	stagiaire_id INT  NOT NULL ,
	employeur_id INT  NOT NULL ,
	CONSTRAINT prk_constraint_match PRIMARY KEY (stagiaire_id,employeur_id)
)WITHOUT OIDS;

ALTER TABLE recrusimple.concept_employeur ADD CONSTRAINT FK_concept_employeur_concept_id FOREIGN KEY (concept_id) REFERENCES recrusimple.Concept(concept_id);
ALTER TABLE recrusimple.concept_employeur ADD CONSTRAINT FK_concept_employeur_employeur_id FOREIGN KEY (employeur_id) REFERENCES recrusimple.Employeur(employeur_id);
ALTER TABLE recrusimple.stagiaire_interesse_par_employeur ADD CONSTRAINT FK_stagiaire_interesse_par_employeur_stagiaire_id FOREIGN KEY (stagiaire_id) REFERENCES recrusimple.Stagiaire(stagiaire_id);
ALTER TABLE recrusimple.stagiaire_interesse_par_employeur ADD CONSTRAINT FK_stagiaire_interesse_par_employeur_employeur_id FOREIGN KEY (employeur_id) REFERENCES recrusimple.Employeur(employeur_id);
ALTER TABLE recrusimple.employeur_interesse_par_stagiaire ADD CONSTRAINT FK_employeur_interesse_par_stagiaire_stagiaire_id FOREIGN KEY (stagiaire_id) REFERENCES recrusimple.Stagiaire(stagiaire_id);
ALTER TABLE recrusimple.employeur_interesse_par_stagiaire ADD CONSTRAINT FK_employeur_interesse_par_stagiaire_employeur_id FOREIGN KEY (employeur_id) REFERENCES recrusimple.Employeur(employeur_id);
ALTER TABLE recrusimple.match ADD CONSTRAINT FK_match_stagiaire_id FOREIGN KEY (stagiaire_id) REFERENCES recrusimple.Stagiaire(stagiaire_id);
ALTER TABLE recrusimple.match ADD CONSTRAINT FK_match_employeur_id FOREIGN KEY (employeur_id) REFERENCES recrusimple.Employeur(employeur_id);

CREATE OR REPLACE FUNCTION verifier_match_stagiaire()
RETURNS "trigger" AS
$BODY_1$
BEGIN

	IF (SELECT EXISTS(SELECT 1 FROM recrusimple.employeur_interesse_par_stagiaire WHERE 
		stagiaire_id = NEW.stagiaire_id AND
		employeur_id = NEW.employeur_id AND
		interet = TRUE)) AND NEW.interet = TRUE THEN
		INSERT INTO recrusimple.match(stagiaire_id, employeur_id) SELECT NEW.stagiaire_id, NEW.employeur_id;
	END IF;

    RETURN null;
END;
$BODY_1$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_verifier_match_stagiaire
AFTER INSERT ON recrusimple.stagiaire_interesse_par_employeur
FOR EACH ROW
EXECUTE PROCEDURE verifier_match_stagiaire();

CREATE OR REPLACE FUNCTION verifier_match_employeur()
RETURNS "trigger" AS
$BODY_2$
BEGIN

	IF (SELECT EXISTS(SELECT 1 FROM recrusimple.stagiaire_interesse_par_employeur WHERE 
		stagiaire_id = NEW.stagiaire_id AND
		employeur_id = NEW.employeur_id AND
		interet = TRUE)) AND NEW.interet = TRUE THEN
		INSERT INTO recrusimple.match(stagiaire_id, employeur_id) SELECT NEW.stagiaire_id, NEW.employeur_id;
	END IF;

    RETURN null;
END;
$BODY_2$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_verifier_match_employeur
AFTER INSERT ON recrusimple.employeur_interesse_par_stagiaire
FOR EACH ROW
EXECUTE PROCEDURE verifier_match_employeur();
