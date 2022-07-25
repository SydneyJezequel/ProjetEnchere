<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</style>
</head>
<body>
	<h1>ENI Enchères</h1>
	<br>
	<br>
	<br>

	<!-- Récupération des données -->
	<%String pseudo = (String) session.getAttribute("id");%>
	<%String nom = (String) session.getAttribute("nom");%>
	<%String prenom = (String) session.getAttribute("prenom");%>
	<%String email = (String) session.getAttribute("email");%>
	<%String telephone = (String) session.getAttribute("telephone");%>
	<%String rue = (String) session.getAttribute("rue");%>
	<%String codePostal = (String) session.getAttribute("codePostal");%>
	<%String ville = (String) session.getAttribute("ville");%>


	<label for="pseudo">Pseudo :</label><%=pseudo%><br><br>
	<label for="nom">Nom :</label><%=nom%><br>
	<label for="prenom">Prénom :</label><%=prenom%><br>
	<label for="email">Email :</label><%=email%><br>
	<label for="telephone">Téléphone :</label><%=telephone%><br>
	<label for="rue">Rue :</label><%=rue%><br>
	<label for="codePostal">Code postal :</label><%=codePostal%><br>
	<label for="ville">Ville :</label><%=ville%><br>


<!-- A compléter avec Styve. -->
<input type="submit" value="Supprimer" class="annuler">
<a href="<%=request.getContextPath()%>/modifProfil">Modifier Profil</a>


</body>
</html>

