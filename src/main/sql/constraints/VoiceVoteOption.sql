
-- Script de contraintes de la table VoiceVoteOption

ALTER TABLE VoiceVoteOption
  ADD PRIMARY KEY (FK_idVoiceVoiceVoteOption, FK_idVoteOptionVoiceVoteOption); -- id table

ALTER TABLE VoiceVoteOption
ADD FOREIGN KEY (FK_idVoiceVoiceVoteOption) REFERENCES Voice(idVoice) -- clé étrangère vers Vote
  CHECK; -- vérifier les contraintes pour les lignes existantes

ALTER TABLE VoiceVoteOption
ADD FOREIGN KEY (FK_idVoteOptionVoiceVoteOption) REFERENCES VoteOption(idVoteOption) -- clé étrangère vers Member
  CHECK; -- vérifier les contraintes pour les lignes existantes

