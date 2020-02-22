
-- Script de création de la table Voice

CREATE TABLE Voice (
  idVoice BIGINT AUTO_INCREMENT NOT NULL,
  keyVoice VARCHAR(100) NOT NULL,
  FK_idVoteVoice BIGINT NOT NULL,
  turnVoice TINYINT NOT NULL
);
