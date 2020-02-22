<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h1>User profile Page</h1>
<table>
    <tr>
        <td>Nom et Prénom</td>
        <td>${member.nameMember}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${member.mailMember}</td>
    </tr>
    <tr>
        <td>Date de naissance</td>
        <td>${member.birthdayMember}</td>
    </tr>
    <tr>
        <td>Adresse</td>
        <td>${member.addressMember}</td>
    </tr>

</table>
<a href="/listVotes">Retour</a>
</body>
</html>
