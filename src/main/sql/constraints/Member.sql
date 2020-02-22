
-- Script de contraintes de la table Member

ALTER TABLE Member
  ADD PRIMARY KEY (idMember); -- id table

ALTER TABLE Member
  ADD FOREIGN KEY (FK_idRoleMember) REFERENCES RoleMember(idRoleMember) -- clé étrangère vers RoleMember
  CHECK; -- vérifier les contraintes pour les lignes existantes

ALTER TABLE Member
  ADD CONSTRAINT U_mailMember UNIQUE(mailMember) -- unicité mailMember
  CHECK; -- Vérifier les contraintes pour les lignes existantes

ALTER TABLE Member
  ADD CONSTRAINT C_birthdayMember CHECK(birthdayMember < CURRENT_TIMESTAMP) -- cohérence de la date
  CHECK; -- Vérifier les contraintes pour les lignes existantes
