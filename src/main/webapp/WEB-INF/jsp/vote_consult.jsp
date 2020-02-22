<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Consulter vote</title>
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
    <script src="/js/vote-result.js"></script>
    <script src="/js/REST.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.js"></script>
    <script>
        window.addEventListener('load', function(){
            getVoteDataREST("${vote.idVote}", onReceiveDataVote);
        });
    </script>
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


    <div class="container col-md-6 vcenter">
        <h2>${vote.nameVote}</h2>
        <p>${vote.descriptionVote}</p>
            <c:choose>
                <c:when test="${isInFuture}">
                    <div class="form-group">
                        <ul class="list-group">
                            <c:forEach items="${voteChoices}" var="choice">
                                <li class="list-group-item">${choice.nameVoteOption} : ${choice.descriptionVoteOption}</li>
                            </c:forEach>
                            <h2>This vote isn't already</h2>
                        </ul>
                    </div>
                    <a href="/listVotes" class="btn btn-dark btn-block">Retour</a>
                </c:when>
                <c:when test="${isInHistory}">
                    <div id="resultView">

                    </div>
                </c:when>
                <c:otherwise>
                    <form action="dovote" method="post">
                        <div class="form-group">
                            <ul class="list-group">
                                <c:forEach items="${voteChoices}" var="choice">
                                    <li class="list-group-item">${choice.nameVoteOption} : ${choice.descriptionVoteOption}</li>
                                </c:forEach>
                            </ul>
                            <input name="idVote" value="${vote.idVote}" type="hidden"/>
                        </div>
                    <button class="btn btn-lg btn-dark btn-block" type="submit">Passer au vote</button>
                    </form>
                </c:otherwise>
            </c:choose>
    </div>
</body>
</html>
