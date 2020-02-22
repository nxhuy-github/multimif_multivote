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
  ('admin@mail.com',
   'AdminPassword',
   'Admin',
   parsedatetime('23/02/1987 01:00:00','dd/MM/yyyy HH:mm:ss'),
   '19 Rue Dupont Pierre, 42330 Saint-Galmier',
   1,
   TRUE);