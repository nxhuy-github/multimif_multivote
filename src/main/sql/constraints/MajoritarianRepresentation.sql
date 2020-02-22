
-- Script de contraintes de la table MajoritarianRepresentation

ALTER TABLE MajoritarianRepresentation
  ADD PRIMARY KEY (idMajoritarianRepresentation); -- id table

ALTER TABLE MajoritarianRepresentation
ADD FOREIGN KEY (FK_idVoteMajoritarianRepresentation) REFERENCES Vote(idVote) -- clé étrangère vers Vote
  CHECK; -- vérifier les contraintes pour les lignes existantes
