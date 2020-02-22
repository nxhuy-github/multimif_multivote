
-- Script de contraintes de la table VoteType

ALTER TABLE VoteType
  ADD PRIMARY KEY (idVoteType); -- id table

ALTER TABLE VoteType
  ADD CONSTRAINT U_nameVoteType UNIQUE(nameVoteType) -- unicité nameVoteType
  CHECK; -- Vérifier les contraintes pour les lignes existantes

ALTER TABLE VoteType
  ADD CONSTRAINT C_turnCountVoteType CHECK(turnCountVoteType > 0) -- cohérence des tours
  CHECK; -- Vérifier les contraintes pour les lignes existantes
