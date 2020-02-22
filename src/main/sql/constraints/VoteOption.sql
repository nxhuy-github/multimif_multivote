
-- Script de contraintes de la table VoteOption

ALTER TABLE VoteOption
  ADD PRIMARY KEY (idVoteOption); -- id table

ALTER TABLE VoteOption
ADD FOREIGN KEY (FK_idVoteVoteOption) REFERENCES Vote(idVote) -- clé étrangère vers Vote
  CHECK; -- vérifier les contraintes pour les lignes existante

ALTER TABLE VoteOption
  ADD CONSTRAINT U_nameVoteOption UNIQUE(nameVoteOption) -- unicité nameVoteOption
  CHECK; -- Vérifier les contraintes pour les lignes existantes

ALTER TABLE VoteOption
  ADD CONSTRAINT C_currentTurnVoteOption CHECK(currentTurnVoteOption > 0) -- cohérence des tours
  CHECK; -- Vérifier les contraintes pour les lignes existantes
