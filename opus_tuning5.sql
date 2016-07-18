BEGIN;
ALTER TABLE recrusimple.employeur ADD COLUMN phone_employeur character varying(20);
ALTER TABLE recrusimple.stagiaire ADD COLUMN phone_stagiaire character varying(20);

CREATE OR replace VIEW recrusimple.view_match 
AS 
  SELECT M.stagiaire_id AS stagiaireID, 
         US.last_name AS lastNameStudent, 
         US.first_name AS firstNameStudent,
	 US.administrative_user_id AS CIPStudent, 
         US.email_address AS emailStudent, 
         S.phone_stagiaire AS phoneStudent, 
         M.employeur_id AS employeurID, 
         E.phone_employeur AS phoneEmployeur, 
         UE.last_name AS lastNameEmployer, 
         UE.first_name AS firstNameEmployer, 
	 UE.administrative_user_id AS CIPEmployer, 
         UE.email_address AS emailEmployer
  FROM   recrusimple.match AS M
         left join recrusimple.stagiaire AS S 
                ON M.stagiaire_id = S.stagiaire_id 
         left join recrusimple.employeur AS E 
                ON M.employeur_id = E.employeur_id 
         left join public.users AS US 
                ON US.administrative_user_id = 
                   S.administrative_user_id 
         left join public.users AS UE 
                ON UE.administrative_user_id = 
                   E.administrative_user_id ;
 COMMIT;