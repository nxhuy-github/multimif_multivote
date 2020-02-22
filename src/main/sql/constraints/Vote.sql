
-- Script de contraintes de la table Vote

ALTER TABLE Vote
  ADD PRIMARY KEY (idVote); -- id table

ALTER TABLE Vote
ADD FOREIGN KEY (FK_idVoteTypeVote) REFERENCES VoteType(idVoteType) -- clé étrangère vers VoteType
  CHECK; -- vérifier les contraintes pour les lignes existantes

ALTER TABLE Vote
  ADD FOREIGN KEY (FK_idOwnerVote) REFERENCES Member(idMember) -- clé étrangère vers Member
  CHECK; -- vérifier les contraintes pour les lignes existantes

ALTER TABLE Vote
  ADD CONSTRAINT U_nameVote UNIQUE(nameVote) -- unicité nameVote
  CHECK; -- Vérifier les contraintes pour les lignes existantes

ALTER TABLE Vote
  ADD CONSTRAINT C_dateVote CHECK(endDateVote > startDateVote) -- cohérence des dates
  CHECK; -- Vérifier les contraintes pour les lignes existantes
