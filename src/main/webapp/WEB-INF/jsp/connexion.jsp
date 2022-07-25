<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue sur le site des Enchères</title>
</head>
<body>


	<h1>Bienvenue sur le site des Enchères</h1>

	<h2>Donner une seconde vie à vos objets est positif pour la
		planète et pour votre pouvoir d'achat.</h2>




	<!-- Message de validation -->
	<%
	if (request.getAttribute("refuse") != null) {
	%>
	<p>
		<%=request.getAttribute("refuse")%>
	</p>
	<%}%>




	<!-- Formulaire de connexion -->
	<form action="<%=request.getContextPath()%>/Connexion" method="post">
		<label>Id : </label><input type="text" name="pseudo"> <label>Mot
			de passe : </label><input type="password" name="mp"> <input
			type="submit" value="connecter">
	</form>




	<footer>
		<div>
			<a href="<%=request.getContextPath()%>/sinscrire">S'incrire</a>
		</div>
	</footer>






</body>
</html>