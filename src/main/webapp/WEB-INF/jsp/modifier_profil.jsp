<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
<!-- <link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet">  -->
<style type="text/css">
h1 {
	text-align: left;
	padding-left: 50px;
}

h2 {
	text-align: center;
	font-size: 200%;
}

.formulaire {
	display: block;
	width: 80%;
	padding: 15px;

}


label {
	display: inline-block;
	width: 150px;
	float: left;
	text-align: left;
}

.champs-gauche {
	display: block;
	width: 40%;
	margin: 0 50px 50px;
	float: left;
	padding: 15px;
	border: 3px solid blue;
}

.champs-droite {
	display: block;
	width: 40%;
	margin: 0 50px 50px;
	padding: 15px;
	float: center;
	border: 3px solid blue;
}


.bouton {
	-webkit-appearance: button;
	-moz-appearance: button;
	appearance: button;
	background-color: #1c87c9;
	border: none;
	color: black;
	padding: 20px 34px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 20px;
	margin: 4px 2px;
	border-radius : 10px;
	cursor: pointer;
}
</style>
</head>
<body>
	<h1>ENI Enchères</h1>


	<h2>Mon Profil</h2>
	<br>
	<br>
	<br>
	<br>
"${sessionScope.listeCate.items}"

	<!-- Formulaire de modification -->
	<div class="formulaire">
		<form action="<%=request.getContextPath()%>/modifierprofil"
			method="POST">
			<div class="champs-gauche">
				<label for="pseudo">Pseudo :</label> <input type="text" name="pseudo" value="${sessionScope.utilisateurConnecte.pseudo}" /> <br>
				<label for="prenom">Prénom :</label> <input type="text" name="prenom" value="${sessionScope.utilisateurConnecte.prenom}"/> <br>
				<label for="telephone">Téléphone :</label> <input type="text" name="telephone" value="${sessionScope.utilisateurConnecte.telephone}"/> <br>
				<label for="codePostal">Code postal :</label> <input type="text" name="code_postal" value="${sessionScope.utilisateurConnecte.codePostal}"/> <br>
				<label for="mdpactuel">Mot de passe actuel :</label> <input type="password" name="mdpactuel" /> <br>
				<label for="nouveaumdp">Nouveau mot de passe :</label> <input type="password" name="nouveaumdp" /> <br>
			</div>
			<div class="champs-droite">
				<label for="nom">Nom :</label> <input type="text" name="nom" value="${sessionScope.utilisateurConnecte.nom}"/> <br>
				<label for="email">Email :</label> <input type="text" name="email" value="${sessionScope.utilisateurConnecte.email}"/> <br>
				<label for="rue">Rue :</label> <input type="text" name="rue" value="${sessionScope.utilisateurConnecte.rue}"/> <br>
				<label for="ville">Ville :</label> <input type="text" name="ville" value="${sessionScope.utilisateurConnecte.ville}"/> <br>
				<label for="confirmation">Confirmation :</label> <input type="password" name="confirmation"/> <br>
				<label for="credit">Crédit :</label> ${sessionScope.utilisateurConnecte.credit}
			</div>
			<div class="boutons">
				<input type="submit" name="valider" value="Enregistrer" class="bouton">
				<!--   </form> -->
				<input type="submit" value="Supprimer" class="bouton">
				<!--  </form> -->
			</div>
		</form>
		<br>
	</div>





</body>
</html>

