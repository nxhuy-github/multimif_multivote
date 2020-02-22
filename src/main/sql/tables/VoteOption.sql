
-- Script de création de la table VoteOption

CREATE TABLE VoteOption (
  idVoteOption BIGINT AUTO_INCREMENT NOT NULL,
  FK_idVoteVoteOption BIGINT NOT NULL,
  nameVoteOption VARCHAR(20) NOT NULL,
  descriptionVoteOption VARCHAR(400) NOT NULL,
  currentTurnVoteOption TINYINT NOT NULL
);
