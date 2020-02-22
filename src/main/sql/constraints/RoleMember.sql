
-- Script de contraintes de la table RoleMember

ALTER TABLE RoleMember
  ADD PRIMARY KEY (idRoleMember); -- idRoleMember table
ALTER TABLE RoleMember
  ADD CONSTRAINT U_RoleMember UNIQUE(roleRoleMember) -- unicité roleRoleMember
  CHECK; -- Vérifier les contraintes pour les lignes existantes

