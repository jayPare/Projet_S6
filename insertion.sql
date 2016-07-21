INSERT INTO public.users(administrative_user_id, last_name, first_name, email_address) VALUES ('abcd0001', 'Macia', 'Antoine', 'antoine.macia@usherbrooke.ca');
INSERT INTO public.users(administrative_user_id, last_name, first_name, email_address) VALUES ('abcd0002', 'DeGagné', 'Sébastien', 'sebastien.degagne@usherbrooke.ca');
INSERT INTO public.users(administrative_user_id, last_name, first_name, email_address) VALUES ('abcd0003', 'Paré', 'Jérémy', 'jeremy.pare@usherbrooke.ca');
INSERT INTO public.users(administrative_user_id, last_name, first_name, email_address) VALUES ('abcd0004', 'Huot', 'Laurent', 'laurent.huot@usherbrooke.ca');
INSERT INTO public.users(administrative_user_id, last_name, first_name, email_address) VALUES ('abcd0005', 'Lo Pinto', 'Tomas', 'tomas.lopinto@usherbrooke.ca');
INSERT INTO public.users(administrative_user_id, last_name, first_name, email_address) VALUES ('abcd0006', 'Courtemanche', 'Gabriel', 'gabriel.courtemanche@usherbrooke.ca');

INSERT INTO public.users(administrative_user_id, last_name, first_name, email_address) VALUES ('efgh0001', 'Amazon', 'Recruteur', 'recrutement@amazon.ca');
INSERT INTO public.users(administrative_user_id, last_name, first_name, email_address) VALUES ('efgh0002', 'Google', 'Recruteur', 'recrutement@google.ca');
INSERT INTO public.users(administrative_user_id, last_name, first_name, email_address) VALUES ('efgh0003', 'Genetec', 'Recruteur', 'recrutement@genetec.ca');
INSERT INTO public.users(administrative_user_id, last_name, first_name, email_address) VALUES ('efgh0004', 'Microsoft', 'Recruteur', 'recrutement@microsoft.ca');
INSERT INTO public.users(administrative_user_id, last_name, first_name, email_address) VALUES ('efgh0005', 'Facebook', 'Recruteur', 'recrutement@facebook.ca');
INSERT INTO public.users(administrative_user_id, last_name, first_name, email_address) VALUES ('efgh0006', 'Sherweb', 'Recruteur', 'recrutement@sherweb.ca');

INSERT INTO recrusimple.stagiaire(numero_stage, stagiaire_cv, administrative_user_id, departement_id, phone_stagiaire) VALUES (4, 'CV d''Antoine', 'abcd0001', 1, '819-235-4616');
INSERT INTO recrusimple.stagiaire(numero_stage, stagiaire_cv, administrative_user_id, departement_id, phone_stagiaire) VALUES (4, 'CV de Sebastien', 'abcd0002', 1, '819-235-4615');
INSERT INTO recrusimple.stagiaire(numero_stage, stagiaire_cv, administrative_user_id, departement_id, phone_stagiaire) VALUES (1, 'CV de Jeremy', 'abcd0003', 1, '819-235-4614');
INSERT INTO recrusimple.stagiaire(numero_stage, stagiaire_cv, administrative_user_id, departement_id, phone_stagiaire) VALUES (4, 'CV de Laurent', 'abcd0004', 1, '819-235-4613');
INSERT INTO recrusimple.stagiaire(numero_stage, stagiaire_cv, administrative_user_id, departement_id, phone_stagiaire) VALUES (4, 'CV de Tomas', 'abcd0005', 1, '819-235-4612');
INSERT INTO recrusimple.stagiaire(numero_stage, stagiaire_cv, administrative_user_id, departement_id, phone_stagiaire) VALUES (4, 'CV de Gabriel', 'abcd0006', 1, '819-235-4611');

INSERT INTO recrusimple.employeur(nom, domaine, lieu, sommaire, administrative_user_id, phone_employeur) VALUES ('Amazon Inc.', 'Web', 'Seattle (E-U)', 'Amazon.com, Inc. est une entreprise de commerce électronique américaine basée à Seattle. Sa spécialité la plus connue est la vente de livres, mais elle est diversifiée dans la vente de tous types de produits culturels : disques CD, musique en téléchargement, DVD, appareils photos numériques, informatique, etc', 'efgh0001', '514-200-0202');
INSERT INTO recrusimple.employeur(nom, domaine, lieu, sommaire, administrative_user_id, phone_employeur) VALUES ('Google', 'Web', 'Mountain View (E-U)', 'Google s''est donné comme mission « d''organiser l''information à l''échelle mondiale et de la rendre universellement accessible et utile »', 'efgh0002', '345-001-0567');
INSERT INTO recrusimple.employeur(nom, domaine, lieu, sommaire, administrative_user_id, phone_employeur) VALUES ('Genetec', 'Équipement de surveillance', 'Montreal (Canada)', 'Genetec is a Canadian provider of IP video surveillance, access control and license plate recognition solutions unified in a single platform, called Security Center; they also produce and provide security equipment such as their Synergis Master Controller.', 'efgh0003', '514-911-0911');
INSERT INTO recrusimple.employeur(nom, domaine, lieu, sommaire, administrative_user_id, phone_employeur) VALUES ('Microsoft', 'Logiciel et matériel informatique', 'Redmond (E-U)', 'Microsoft Corporation est une entreprise d''informatique et de micro-informatique multinationale américaine, fondée par Bill Gates et Paul Allen. Son activité principale consiste à développer et vendre des systèmes d’exploitation et des logiciels.', 'efgh0004', '600-500-4000');
INSERT INTO recrusimple.employeur(nom, domaine, lieu, sommaire, administrative_user_id, phone_employeur) VALUES ('Facebook', 'Web', 'Menlo Park (E-U)', 'Facebook est un réseau social en ligne qui permet à ses utilisateurs de publier des images, des photos, des vidéos, des fichiers et documents, d''échanger des messages, joindre et créer des groupes et d''utiliser une variété d''applications.', 'efgh0005', '255-366-4777'); 
INSERT INTO recrusimple.employeur(nom, domaine, lieu, sommaire, administrative_user_id, phone_employeur) VALUES ('Sherweb', 'Services cloud', 'Sherbrooke (Canada)', 'SherWeb, Inc. is an hosted service provider based in Sherbrooke, Quebec, Canada. The company also has an office in Montreal. SherWeb operates in the cloud computing industry and has been in business since 1998.', 'efgh0006', '433-333-3232');

DELETE FROM recrusimple.concept_competence_stagiaire;
DELETE FROM recrusimple.concept_interet_stagiaire;

INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (2, 1, 1);
INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (4, 1, 3);
INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (2, 1, 5);

INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (2, 2, 2);
INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (3, 2, 3);
INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (5, 2, 6);

INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (3, 3, 1);
INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (4, 3, 7);
INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (3, 3, 8);

INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (2, 4, 4);
INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (1, 4, 5);
INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (5, 4, 7);

INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (3, 5, 1);
INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (3, 5, 2);
INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (2, 5, 3);

INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (2, 6, 1);
INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (2, 6, 5);
INSERT INTO recrusimple.concept_competence_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (5, 6, 7);

INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (3, 1, 1);
INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (4, 1, 3);
INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (4, 1, 5);

INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (1, 2, 2);
INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (5, 2, 3);
INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (5, 2, 6);

INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (3, 3, 1);
INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (5, 3, 7);
INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (5, 3, 8);

INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (3, 4, 4);
INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (4, 4, 5);
INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (5, 4, 7);

INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (4, 5, 1);
INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (3, 5, 2);
INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (2, 5, 3);

INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (2, 6, 1);
INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (4, 6, 5);
INSERT INTO recrusimple.concept_interet_stagiaire(niveau_sur_5, stagiaire_id, concept_id) VALUES (5, 6, 7);

DELETE FROM recrusimple.employeur_interesse_par_stagiaire;
DELETE FROM recrusimple.stagiaire_interesse_par_employeur;
DELETE FROM recrusimple.match;

INSERT INTO recrusimple.employeur_interesse_par_stagiaire(stagiaire_id, employeur_id, interet) VALUES (2, 1, TRUE);
INSERT INTO recrusimple.stagiaire_interesse_par_employeur(stagiaire_id, employeur_id, interet) VALUES (2, 1, TRUE);
INSERT INTO recrusimple.employeur_interesse_par_stagiaire(stagiaire_id, employeur_id, interet) VALUES (2, 3, TRUE);
INSERT INTO recrusimple.stagiaire_interesse_par_employeur(stagiaire_id, employeur_id, interet) VALUES (2, 3, TRUE);
INSERT INTO recrusimple.employeur_interesse_par_stagiaire(stagiaire_id, employeur_id, interet) VALUES (3, 5, TRUE);
INSERT INTO recrusimple.stagiaire_interesse_par_employeur(stagiaire_id, employeur_id, interet) VALUES (3, 5, TRUE);
INSERT INTO recrusimple.employeur_interesse_par_stagiaire(stagiaire_id, employeur_id, interet) VALUES (3, 6, TRUE);
INSERT INTO recrusimple.stagiaire_interesse_par_employeur(stagiaire_id, employeur_id, interet) VALUES (3, 6, TRUE);
 