<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	background-color: #CCC;
	width: 80%;
	margin: 10px auto;
	padding: 15px;
	border: 10px solid #000;
}

form {
	text-align: center;
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
	padding: 10px;
	/* position: relative;
   			right:0; */
	border: 3px solid blue;
}

.champs-droite {
	display: block;
	width: 40%;
	margin: 0 50px 50px;
	padding: 10px;
	float: right;
	/* position: relative;
   			right:0; */
	border: 3px solid blue;
}

input[type=text] {
	padding: 10px;
}

input[type=submit] {
	width: 300px;
	height: 50px;
	padding: 10px;
	font-size: 20px;
	font-weight: 400;
	max-width: 550px;
	margin: 0 auto;
	background: #D1F2EB;
	border-radius: 5px;
	box-shadow: 0 0 5px #011627ff;
	text-align: center;
}

.form2 {
	display: inline;
	outline: solid #A23;
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
	<br>
	<br>
	<br>



<!-- Message de validation -->
	<%
	if (request.getAttribute("modifie") != null) {
	%>
	<p>
		<%=request.getAttribute("modifie")%>
	</p>
	<%}%>



	<!-- Récupération des données -->
	<label for="pseudo">Pseudo :</label>${sessionScope.majUtilisateur.pseudo}<br>
	<label for="nom">Nom :</label>${sessionScope.majUtilisateur.nom}<br>
	<label for="prenom">Prénom :</label>${sessionScope.majUtilisateur.prenom}<br>
	<label for="email">Email :</label>${sessionScope.majUtilisateur.email}<br>
	<label for="telephone">Téléphone :</label>${sessionScope.majUtilisateur.telephone}<br>
	<label for="rue">Rue :</label>${sessionScope.majUtilisateur.rue}<br>
	<label for="codePostal">Code postal :</label>${sessionScope.majUtilisateur.codePostal}<br>
	<label for="ville">Ville :</label>${sessionScope.majUtilisateur.ville}<br>

	<!-- Boutons -->
	<a href="<%=request.getContextPath()%>/supprimerprofil" class="bouton">Supprimer Profil</a>
	<a href="<%=request.getContextPath()%>/modifierprofil" class="bouton">Modifier Profil</a>


</body>
</html>

