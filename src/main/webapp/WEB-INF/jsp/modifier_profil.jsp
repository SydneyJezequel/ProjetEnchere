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


	<h2>Mon Profil</h2>
	<br>
	<br>


	<!-- Message de validation -->
	<%
	if (session.getAttribute("modifie") != null) {
	%>
	<p>
		<%=request.getAttribute("modifie")%>
	</p>
	<%}%>

	<br>
	<br>


	<!-- Formulaire de modification -->
	<div class="formulaire">
		<form action="<%=request.getContextPath()%>/modifierprofil"
			method="POST">
			<div class="champs-gauche">
				<label for="pseudo">Pseudo :</label> <input type="text" name="pseudo" <c:out value="${sessionScope.utilisateur.pseudo}"/> /> <br>
				<label for="prenom">Prénom :</label> <input type="text" name="prenom" <c:out value="${sessionScope.utilisateur.prenom}"/> /> <br>
				<label for="telephone">Téléphone :</label> <input type="text" name="telephone" <c:out value="${sessionScope.utilisateur.telephone}"/> /> <br>
				<label for="code_postal">Code postal :</label> <input type="text" name="code_postal" <c:out value="${sessionScope.utilisateur.code_postal}"/> /> <br>
				<label for="mdpactuel">Mot de passe actuel :</label> <input type="password" name="mdpactuel" /> <br>
				<label for="nouveaumdp">Nouveau mot de passe :</label> <input type="password" name="nouveaumdp" /> <br>
			</div>
			<div class="champs-droite">
				<label for="nom">Nom :</label> <input type="text" name="nom" <c:out value="${sessionScope.utilisateur.nom}"/> /> <br>
				<label for="email">Email :</label> <input type="text" name="email" <c:out value="${sessionScope.utilisateur.email}"/> /> <br>
				<label for="rue">Rue :</label> <input type="text" name="rue" <c:out value="${sessionScope.utilisateur.rue}"/> /> <br>
				<label for="ville">Ville :</label> <input type="text" name="ville" <c:out value="${sessionScope.utilisateur.ville}"/> /> <br>
				<label for="confirmation">Confirmation :</label> <input type="password" name="confirmation"/> <br>
			</div>
			<div class="boutons">
				<input type="submit" name="valider" value="Enregistrer"
					class="valider">
				<!--   </form> -->
				<input type="submit" value="Supprimer" class="annuler">
				<!--  </form> -->
			</div>
		</form>
		<br>
	</div>


	<label for="credit">Crédit</label> <%=session.getAttribute("credit")%>




</body>
</html>

