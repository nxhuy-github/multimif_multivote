
-- Script de création de la table Vote

CREATE TABLE Vote (
  idVote BIGINT AUTO_INCREMENT NOT NULL,
  FK_idVoteTypeVote TINYINT NOT NULL,
  FK_idOwnerVote BIGINT NOT NULL,
  nameVote VARCHAR(40) NOT NULL,
  descriptionVote VARCHAR(400) NOT NULL,
  isPublicVote TINYINT NOT NULL,
  startDateVote TIMESTAMP NOT NULL,
  endDateVote TIMESTAMP NOT NULL,
  currentTurnVote TINYINT NOT NULL
);
