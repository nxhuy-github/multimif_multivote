
-- Script de création de la table MajoritarianRepresentation

CREATE TABLE MajoritarianRepresentation (
  idMajoritarianRepresentation BIGINT AUTO_INCREMENT NOT NULL,
  FK_idVoteMajoritarianRepresentation BIGINT NOT NULL
);
