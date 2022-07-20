<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>


<html>

<head>
<meta charset="UTF-8">
<title>Modifier Profil</title>
</head>


<body>

<h1>Modifier Profil</h1>

<form action="<%=request.getContextPath()%>/modifierprofil" method="post">
	<label>Pseudo</label><input type="text" name="pseudo" > 					<label>Nom</label><input type="text" name="pseudo" >
	<label>Prénom</label><input type="text" name="prenom" > 					<label>Email</label><input type="text" name="pseudo" >
	<label>Téléphone</label><input type="text" name="telephone" > 				<label>Rue</label><input type="text" name="pseudo" >
	<label>Code Postal</label><input type="text" name="codePostal" > 			<label>Ville</label><input type="text" name="pseudo" >
	<label>Mot de passe actuel</label><input type="password" name="mpActuel" > 
	<label>Nouveau mot de passe</label><input type="password" name="mpNouveau" > <label>Confirmation</label><input type="text" name="pseudo" >
	<label></label><input type="password" name="" >
	<input type="submit" value="connecter">
</form>


</body>

</html>