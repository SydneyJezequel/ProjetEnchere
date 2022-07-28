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
</head>


<body>

	<img src="./images/logo_eni_encheres.png" alt="" name="Logo Eni Enchères" class="logo">

	<h1>ENI Enchères</h1>
	<br>
	<br>
	<h2>Nouvelle vente</h2>
	<br>
	<br>


	<!-- Formulaire : Nouvelle Vente -->
	<div class="formulaire">
		<form action="<%=request.getContextPath()%>/vendreArticle"
			method="POST">
			<div class="champs-gauche">
				<label for="article">Article :</label> <input type="text" name="article" /> <br> 
				<label for="description">Description :</label> <textarea name="description"></textarea> <br> 
				<label for="categorie">Catégorie :</label> 
				<select name="categorie">
    				<c:forEach var="categorie" items="${sessionScope.listeCate.items}">
    					<option>${item}</option>
    				</c:forEach>
				</select> <br>
				<label for="photoArticle">Photo de l'article :</label> <input type="file" name="photoArticle" accept="image/png, image/jpeg"> <br>
				<label for="prixDepart">Mise à prix :</label> <input type="number" name="prixDepart" value="0" min="0"> <br>
				<label for="debutEnchere">Début de l'enchère :</label> <input type="date" name="debutEnchere" value="${sessionScope.date}" min="${sessionScope.date}" /> <br>
				<label for="finEnchere">Fin de l'enchère :</label> <input type="date" name="finEnchere" /> <br>
			</div>
			<div class="champs-droite">
				<label>Retrait</label>
				<label for="rue">Rue :</label> <input type="text" name="rue" value="${utilisateurConnecte.rue}"/> <br> 
				<label for="codePostal">Code Postal :</label> <input type="text" name="codePostal" value="${utilisateurConnecte.codePostal}"/> <br>
				<label for="ville">Ville :</label> <input type="text" name="ville" value="${utilisateurConnecte.ville}"/> <br>
			</div>
			<div class="boutons">
				<input type="submit" name="valider" value="Enregistrer"
					class="valider">
				<input type="submit" value="Supprimer" class="annuler">
			</div>
		</form>
		<br>
	</div>



</body>
</html>




<!-- 
	<select name="categorie">
		
					<option value="livre">livre</option>
					<option value="film">films</option>
					<option value="jeuxVideos">jeux vidéos</option>
				</select> 
 -->
 
 
 
 
 
 
 