
-- Script de contraintes de la table VoteOption

ALTER TABLE MemberVote
  ADD PRIMARY KEY (FK_idVoteMemberVote, FK_idMemberMemberVote); -- id table

ALTER TABLE MemberVote
ADD FOREIGN KEY (FK_idVoteMemberVote) REFERENCES Vote(idVote) -- clé étrangère vers Vote
  CHECK; -- vérifier les contraintes pour les lignes existantes

ALTER TABLE MemberVote
ADD FOREIGN KEY (FK_idMemberMemberVote) REFERENCES Member(idMember) -- clé étrangère vers Member
  CHECK; -- vérifier les contraintes pour les lignes existantes

ALTER TABLE MemberVote
  ADD CONSTRAINT U_idVoteidMemberMemberVote UNIQUE(FK_idVoteMemberVote, FK_idMemberMemberVote) -- unicité idVote,idMember
  CHECK; -- Vérifier les contraintes pour les lignes existantes

ALTER TABLE MemberVote
  ADD CONSTRAINT C_currentTurnMemberVote CHECK(currentTurnMemberVote > 0) -- cohérence des tours
  CHECK; -- Vérifier les contraintes pour les lignes existantes
