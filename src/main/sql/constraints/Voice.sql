
-- Script de contraintes de la table Voice

ALTER TABLE Voice
  ADD PRIMARY KEY (idVoice); -- id table

ALTER TABLE Voice
ADD FOREIGN KEY (FK_idVoteVoice) REFERENCES Vote(idVote) -- clé étrangère vers Vote
  CHECK; -- vérifier les contraintes pour les lignes existantes

ALTER TABLE Voice
  ADD CONSTRAINT U_keyVoice UNIQUE(keyVoice) -- unicité keyVoice
  CHECK; -- Vérifier les contraintes pour les lignes existantes


ALTER TABLE Voice
  ADD CONSTRAINT U_idVoice UNIQUE(idVoice) -- unicité idVoice
  CHECK; -- Vérifier les contraintes pour les lignes existantes

ALTER TABLE Voice
  ADD CONSTRAINT C_turnVoice CHECK(turnVoice > 0) -- cohérence des tours
  CHECK; -- Vérifier les contraintes pour les lignes existantes
