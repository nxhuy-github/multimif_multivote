
-- Script de création de VoiceVoteOption

INSERT INTO RoleMember ( --  idRoleMember,
  roleRoleMember
)
VALUES
  ('ROLE_ADMIN3'),
  ('ROLE_USER4');

INSERT INTO Member ( --  idMember,
                     mailMember,
                     passwordMember,
                     nameMember,
                     birthdayMember,
                     addressMember,
                     FK_idRoleMember,
                     enabledMember
)
VALUES
  ('admin5@mail.com', 'AdminPassword', 'Admin', parsedatetime('23/02/1987 01:00:00','dd/MM/yyyy HH:mm:ss'), '19 Rue Dupont Pierre, 42330 Saint-Galmier', 1, TRUE);

INSERT INTO VoteType(
  nameVoteType ,
  turnCountVoteType
)
VALUES
  ('Test TypeVote',1);

INSERT INTO Vote (
  -- idVote ,
  FK_idVoteTypeVote ,
  FK_idOwnerVote ,
  nameVote ,
  descriptionVote ,
  isPublicVote ,
  startDateVote ,
  endDateVote  ,
  currentTurnVote
)
VALUES ( -- Vote public en cours
         1, --Déclaration statique
         1, --Déclaration statique
         'Test vote en cours',
         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse malesuada efficitur scelerisque. Vivamus non mi vel velit consequat condimentum ac eget sapien. Aenean non hendrerit massa. Suspendisse convallis arcu ut mi imperdiet viverra fusce.',
         1, --Public
         parsedatetime('01/01/2017 01:00:00','dd/MM/yyyy HH:mm:ss'), -- 01/01/2017
         parsedatetime('01/01/2020 01:00:00','dd/MM/yyyy HH:mm:ss'), -- 01/01/2020
         1);

INSERT INTO VoteOption(
  FK_idVoteVoteOption,
  nameVoteOption ,
  descriptionVoteOption ,
  currentTurnVoteOption )
VALUES
  (1,
   'Choix 1',
   'Description Choix 1',
   1),
  (1,
   'Choix 2',
   'Description Choix 2',
   1),
  (1,
   'Choix 3',
   'Description Choix 3',
   1),
  (1,
   'Choix 4',
   'Description Choix 4',
   1);

INSERT INTO Voice(
  FK_idVoteVoice ,
  keyVoice,
  turnVoice
)
    VALUES (1,'Kikou1', 1 ),
      (1,'Kikou2', 1),
      (1,'Kikou3', 1),
      (1,'Kikou4', 1);

INSERT INTO VoiceVoteOption(
  FK_IDVOICEVOICEVOTEOPTION  ,
  FK_idVoteOptionVoiceVoteOption ,
  dataVoiceVoteOption
)
    VALUES (1,1,'data_1'),
    (2,1,'data_2'),
    (3,2,'data_3'),
    (4,4,'data_4');
