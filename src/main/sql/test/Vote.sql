	
-- Script de création de Vote

INSERT INTO RoleMember ( --  idRoleMember,
  roleRoleMember
)
VALUES
  ('ROLE_ADMIN5'),
  ('ROLE_USER6');

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
  ('admin6@mail.com', 'AdminPassword', 'Admin', parsedatetime('31/05/1988 01:06:40','dd/MM/yyyy HH:mm:ss'), '19 Rue Dupont Pierre, 42330 Saint-Galmier', 1,TRUE);

INSERT INTO VoteType(
    nameVoteType ,
  turnCountVoteType
)
  VALUES
  ('Test TypeVote2',1);

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
  'Test vote en cours1',
  'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse malesuada efficitur scelerisque. Vivamus non mi vel velit consequat condimentum ac eget sapien. Aenean non hendrerit massa. Suspendisse convallis arcu ut mi imperdiet viverra fusce.',
  1, --Public
  parsedatetime('01/01/2017 01:00:00','dd/MM/yyyy HH:mm:ss'), -- 01/01/2017
  parsedatetime('01/01/2020 01:00:00','dd/MM/yyyy HH:mm:ss'), -- 01/01/2020
  1),

  ( --Vote public fini
  1, --Déclaration statique
  1, --Déclaration statique
  'Test vote fini',
  'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse malesuada efficitur scelerisque. Vivamus non mi vel velit consequat condimentum ac eget sapien. Aenean non hendrerit massa. Suspendisse convallis arcu ut mi imperdiet viverra fusce.',
  1, --Public
  parsedatetime('01/01/2017 01:06:40','dd/MM/yyyy HH:mm:ss'), -- 01/01/2017
  parsedatetime('02/01/2017 01:06:40','dd/MM/yyyy HH:mm:ss'), -- 02/01/2017
  1
  ),

  ( --Vote public non commencé
  1, --Déclaration statique
  1, --Déclaration statique
  'Test vote non commencé',
  'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse malesuada efficitur scelerisque. Vivamus non mi vel velit consequat condimentum ac eget sapien. Aenean non hendrerit massa. Suspendisse convallis arcu ut mi imperdiet viverra fusce.',
  1, --Public
  parsedatetime('01/01/2020 01:06:40','dd/MM/yyyy HH:mm:ss'), -- 01/01/2020
  parsedatetime('02/01/2020 01:06:40','dd/MM/yyyy HH:mm:ss'), -- 02/01/2020
  1
  );
