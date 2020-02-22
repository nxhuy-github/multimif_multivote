-- Script de création de Member


INSERT INTO RoleMember ( --  idRoleMember,
  roleRoleMember
)
VALUES
  ('ROLE_ADMIN1'),
  ('ROLE_USER2');

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
    ('user1@mail.com', 'User1Password', 'User 1', parsedatetime('31/05/1988 01:06:40','dd/MM/yyyy HH:mm:ss') , '19 Avenue Pierre Dupont, 42330 Saint-Galmier', 2, TRUE),
    ('user2@mail.com', 'User2Password', 'User 2', parsedatetime('31/05/1989 01:06:40','dd/MM/yyyy HH:mm:ss') , '19 Avenue Pierre Dupont, 42330 Saint-Galmier', 2,FALSE ),
    ('user3@mail.com', 'User3Password', 'User 3', parsedatetime('31/05/1990 01:06:40','dd/MM/yyyy HH:mm:ss') , '19 Avenue Pierre Dupont, 42330 Saint-Galmier', 2,TRUE),
    ('user4@mail.com', 'User4Password', 'User 4', parsedatetime('31/05/1991 01:06:40','dd/MM/yyyy HH:mm:ss') , '19 Avenue Pierre Dupont, 42330 Saint-Galmier', 2,TRUE),
    ('admin1@mail.com', 'Admin1Password', 'Admin 1', parsedatetime('23/02/1987 01:00:00','dd/MM/yyyy HH:mm:ss'), '19 Rue Dupont Pierre, 42330 Saint-Galmier', 1, TRUE),
('adminfalse@mail.com', 'Admin2Password', 'Admin 2', parsedatetime('23/02/1987 01:00:00','dd/MM/yyyy HH:mm:ss'), '19 Rue Dupont Pierre, 42330 Saint-Galmier', 1, FALSE);