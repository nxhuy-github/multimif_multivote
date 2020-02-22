<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Créer un vote</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="/css/style.css" rel="stylesheet">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
            integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
            integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
            crossorigin="anonymous"></script>

    <script>
            function addVoteOption(){
                let listItem = $("<li></li>");
                let fieldName = $("<input />");
                let fieldDesc = $("<input />");
                fieldName.attr("id", "voteOptions.nameVoteOption");
                fieldName.attr("name", "voteOptions.nameVoteOption");
                fieldName.attr("class", "form-control");
                fieldName.attr("type", "text");
                fieldName.attr("placeholder", "Nom de l'option");

                fieldDesc.attr("id", "voteOptions.descriptionVoteOption");
                fieldDesc.attr("name", "voteOptions.descriptionVoteOption");
                fieldDesc.attr("class", "form-control");
                fieldDesc.attr("type", "text");
                fieldDesc.attr("placeholder", "Description de l'option");

                let button = $("<input />");
                button.attr("value", "-");
                button.attr("type", "button");
                button.on("click", function(){
                    removeVoteOption(listItem);
                });
                listItem.append(button);
                listItem.append(fieldName);
                listItem.append(fieldDesc);
                $("#voteOptionList").append(listItem);
            }

            function removeVoteOption(listItem){
                listItem.remove();
            }

            function INIT(){
                $("#voteOptionButton").on("click", addVoteOption);
            }

            $(window).on("load", function(){INIT();});
    </script>
</head>
<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">VOTE_3000</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
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

<div class="container">
        <form method="post" action="/createvote">
            <div class="row">
                <div class="col-md-4 form-group">
                    <label for="nameVote">Nom</label>
                    <input name="nameVote" id="nameVote" class="form-control" type="text"/>
                </div>
                <div class="col-md-4 form-group">
                    <label for="voteOptionButton">Liste des choix</label>
                    <input name="voteOptionButton" type="button" id="voteOptionButton" value="+"/>
                    <ul id="voteOptionList">
                    </ul>
                </div>
                <div class="col-md-4 form-group">
                    <label for="descriptionVote">Description</label>
                    <input name="descriptionVote" id="descriptionVote" class="form-control" type="text"/>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 form-group">
                    <label for="startDateVote">Date début</label>
                    <input name="startDateVote" id="startDateVote" class="form-control" type="text" placeholder="yyyy-MM-dd hh:mm:ss"/>
                </div>

            </div>

            <div class="row">
                <div class="col-md-4 form-group">
                    <label for="endDateVote">Date fin</label>
                    <input name="endDateVote" id="endDateVote" class="form-control" type="text" placeholder="yyyy-MM-dd hh:mm:ss"/>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 form-group">
                    <label for="currentTurnVote">Current Turn Vote</label>
                    <input name="currentTurnVote" id="currentTurnVote" class="form-control" type="number" placeholder="currentTurnVote"/>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 form-group">
                    <label for="idVoteType">Vote Type</label>
                    <div class="btn-group" role="group">
                        <select name="idVoteType" id="idVoteType">
                            <c:forEach var="voteType" items="${voteTypes}">
                                <option value="${voteType.idVoteType}">${voteType.nameVoteType}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-4 form-group">
                    <label for="isPublicVote">Public Vote</label>
                    <div class="btn-group" role="group">
                        <select name="isPublicVote" id="isPublicVote">
                            <option value="1">Yes</option>
                            <option value="0">No</option>
                        </select>
                    </div>
                </div>
            </div>
            <button class="btn btn-dark btn-block" type="submit">Créer le vote</button>

        </form>
</div>


</body>
</html>
