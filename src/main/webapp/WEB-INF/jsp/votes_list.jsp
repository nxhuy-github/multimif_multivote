<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <title>Liste des votes</title>
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
  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">VOTE_3000</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/listVotes">Liste des votes
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/createvote">Créer un vote</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/info">Mes infos</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/logout">Déconnexion</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <h1 class="mt-5">En cours</h1>
        <div class="container bootstrap snippet">
          <div class="row">
            <div class="col-lg-12">
              <div class="main-box no-header clearfix">
                <div class="main-box-body clearfix">
                  <div class="table-responsive">
                    <table class="table">
                      <tbody>
                      <c:forEach items="${voteInProgress}" var="voteIP">
                        <tr>
                          <td>
                            <span class="oi oi-check"></span>
                          </td>
                          <td>
                            <a href="votes/vote/${voteIP.idVote}">
                              <i class="oi oi-plus" aria-hidden="true"></i>${voteIP.nameVote}
                            </a>
                          </td>
                          <td>
                            <span class="label label-default">${voteIP.idVoteVoteType.nameVoteType}</span>
                          </td>
                          <td>
                            Du ${voteIP.startDateVote} au ${voteIP.endDateVote}
                          </td>
                        </tr>
                      </c:forEach>
                      </tbody>

                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <h1 class="mt-5">A venir</h1>
        <div class="container bootstrap snippet">
          <div class="row">
            <div class="col-lg-12">
              <div class="main-box no-header clearfix">
                <div class="main-box-body clearfix">
                  <div class="table-responsive">
                    <table class="table">
                      <tbody>
                      <c:forEach items="${voteInFuture}" var="voteIF">
                      <tr>
                        <td>
                          <span class="oi oi-check"></span>
                        </td>
                        <td>
                          <a href="votes/vote/${voteIF.idVote}">
                            <i class="oi oi-plus" aria-hidden="true">${voteIF.nameVote}</i>
                          </a>
                        </td>
                        <td>
                          <span class="label label-default">${voteIF.idVoteVoteType.nameVoteType}</span>
                        </td>
                        <td>
                          Du ${voteIF.startDateVote} au ${voteIF.endDateVote}
                        </td>
                      </tr>
                      </c:forEach>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <h1 class="mt-5">Historique</h1>
        <div class="container">
          <table class="table table-fixed">
            <tbody>
            <c:forEach items="${voteInHistory}" var="voteIH">
              <tr>
                <td>
                  <span class="oi oi-check"></span>
                </td>
                <td>
                  <a href="votes/vote/${voteIH.idVote}">
                    <i class="oi oi-plus" aria-hidden="true"></i>${voteIH.nameVote}
                  </a>
                </td>
                <td>
                  <span class="label label-default">${voteIH.idVoteVoteType.nameVoteType}</span>
                </td>
                <td>
                  Du ${voteIH.startDateVote} au ${voteIH.endDateVote}
                </td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>

      </div>
    </div>
  </div>
</body>
</html>
