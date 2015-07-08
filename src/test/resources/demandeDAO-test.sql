
insert into role (idrole, nom) VALUES (1, 'riverain');

insert into user (iduser, login, password, nom, prenom, idrole) VALUES (1, 'riverain', 'bidon', 'riverain', 'riverain', 1);

insert into demande (iddemande,date, adresse, titre, open, idrole) VALUES (1,'2015-05-12','adresse', 'titre',1,1);

insert into description (iddescription ,description, iduser, iddemande) VALUES (1,'description bidon', 1,1);

insert into paiement (idpaiement,date, montant, iduser, iddemande) VALUES (1,'2015-05-12', 135,1,1);
