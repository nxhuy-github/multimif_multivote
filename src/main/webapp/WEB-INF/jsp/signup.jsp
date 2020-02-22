<!DOCTYPE html>
<html lang="fr">
<head>
  <title>Inscription</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
  <link href="/css/style.css" rel="stylesheet">
  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</head>
<body>

  <div class="container col-md-5">
    <form action="/signup" method="post">
      <h2>Inscription</h2>
      <div class="row">
        <div class="col-md-6 mb-3">
          <label for="nameMember">Nom</label>
          <input type="text" name="nameMember" id="nameMember" class="form-control" placeholder="Nom et Prénom" required />
        </div>
      </div>
      <div class="mb-3">
        <label for="addressMember">Adresse</label>
        <input type="text" name="addressMember" id="addressMember" class="form-control" placeholder="Adresse" required/>
        <div class="invalid-feedback">
          Veuillez incrire votre adresse
        </div>
      </div>
      <div class="mb-3">
        <label for="birthdayMember">Date de naissance</label>
        <input type="date" name="birthdayMember" id="birthdayMember" class="form-control" required />
        <div class="invalid-feedback">
          Veuillez incrire votre date de naissance
        </div>
      </div>
      <div class="mb-3">
        <label for="mailMember">Adresse email</label>
        <input type="email" name="mailMember" id="mailMember" class="form-control" placeholder="Adresse email" required autofocus/>
      </div>
      <div class="mb-3">
        <label for="passwordMember">Mot de passe</label>
        <input type="password" name="passwordMember" id="passwordMember" class="form-control" placeholder="Mot de passe" required/>
      </div>
      <div class="mb-3">
        <label for="inputPasswordConfirm">Confirmer mot de passe</label>
        <input type="password" name="inputPasswordConfirm" id="inputPasswordConfirm" class="form-control" placeholder="Confirmer mot de passe" required/>
      </div>
      <button class="btn btn-lg btn-dark btn-block" type="submit">S'inscrire</button>
    </form>
  </div>
</body>
</html>
