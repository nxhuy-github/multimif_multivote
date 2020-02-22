
-- Script de création de la table Member

CREATE TABLE Member (
  idMember BIGINT AUTO_INCREMENT NOT NULL,
  mailMember VARCHAR(40) NOT NULL,
  passwordMember VARCHAR(40) NOT NULL,
  nameMember VARCHAR(40) NOT NULL,
  birthdayMember TIMESTAMP NOT NULL,
  addressMember VARCHAR(100) NOT NULL,
  enabledMember TINYINT NOT NULL DEFAULT 1,
  FK_idRoleMember BIGINT NOT NULL
);
