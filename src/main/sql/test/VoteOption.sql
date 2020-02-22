
-- Script création de VoteOption

INSERT INTO RoleMember ( --  idRoleMember,
  roleRoleMember
)
VALUES
  ('ROLE_ADMIN7'),
  ('ROLE_USER8');

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
  ('admin7@mail.com', 'AdminPassword', 'Admin', parsedatetime('23/02/1987 01:00:00','dd/MM/yyyy HH:mm:ss'), '19 Rue Dupont Pierre, 42330 Saint-Galmier', 1,TRUE);

INSERT INTO VoteType(
  nameVoteType ,
  turnCountVoteType
)
VALUES
  ('Test TypeVote1',1);

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
         'Test vote en cours2',
         'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse malesuada efficitur scelerisque. Vivamus non mi vel velit consequat condimentum ac eget sapien. Aenean non hendrerit massa. Suspendisse convallis arcu ut mi imperdiet viverra fusce.',
         1, --Public
         parsedatetime('01/01/2017 01:00:00','dd/MM/yyyy HH:mm:ss'), -- 01/01/2017
         parsedatetime('01/01/2020 01:00:00','dd/MM/yyyy HH:mm:ss'), -- 01/01/2020
         1);

INSERT INTO VoteOption(
  FK_idVoteVoteOption ,
  nameVoteOption ,
  descriptionVoteOption ,
  currentTurnVoteOption )
VALUES
(1,
'Choix 11',
'Description Choix 11',
1),
(1,
'Choix 21',
'Description Choix 21',
1),
(1,
'Choix 31',
'Description Choix 31',
1),
(1,
'Choix 41',
'Description Choix 41',
1);
