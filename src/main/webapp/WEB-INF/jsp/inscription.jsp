<%@page import="fr.eni.projetenchere.messages.LecteurMessage"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../jspf/header.jspf"%>

<meta charset="UTF-8">

<!-- <link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet">  -->
<div>
	<div class="col-lg-12 text-right">
		<a href="<%=request.getContextPath()%>/accueil">Accueil
			- </a> <a href="<%=request.getContextPath()%>/Connexion">Se connecter</a>
	</div>
</div>
</header>

	<h2 class="text-center">Mon Profil</h2>
	<br>
<!-- 	<div class="formulaire"></div> -->
	
 		<%
			List<Integer> listeCodesErreur = (List<Integer>)request.getAttribute("listeCodesErreur");
			if(listeCodesErreur!=null)
			{
		%>
				<p style="color:red;">Erreur, l'utilisateur n'a pas pu être ajouté :</p>
		<%
				for(int codeErreur:listeCodesErreur)
				{
		%>
					<p><%=LecteurMessage.getMessageErreur(codeErreur)%></p>
		<%	
				}
			}
		%>
	
	
	
 		<form action="<%=request.getContextPath()%>/ServletInscription" method="POST">
			<div class="row">
				<div class="col-lg-4 bloc-article">
					<label for="pseudo">Pseudo : <span class="requis">*</span></label>
					<input type="text" name="pseudo" value="pseudo"/>
				</div>
				<div class="col-lg-4 bloc-article">
					<label for="nom">Nom : <span class="requis">*</span></label>
					<input type="text" name="nom" value="nomtest"/>
				</div>
				<div class="col-lg-4 bloc-article">
					<label for="prenom">Prénom : <span class="requis">*</span></label>
					<input type="text" name="prenom" value="prenom"/>
				</div>
				<div class="col-lg-4 bloc-article">
					<label for="email">Email : <span class="requis">*</span></label>
					<input type="text" name="email" value="email@email.com"/>
				</div>
				<div class="col-lg-4 bloc-article">
					<label for="telephone">Téléphone :</label>
					<input type="text" name="telephone" value="0123456789"/>
				</div>
				<div class="col-lg-4 bloc-article">
					<label for="rue">Rue : <span class="requis">*</span></label>
					<input type="text" name="rue" value="rue"/>
				</div>
				<div class="col-lg-4 bloc-article">
					<label for="code_postal">Code postal : <span class="requis">*</span></label>
					<input type="text" name="code_postal" value="12345"/>
				</div>
				<div class="col-lg-4 bloc-article">
					<label for="ville">Ville : <span class="requis">*</span></label>
					<input type="text" name="ville" value="ville"/>
				</div>
				<div class="col-lg-4 bloc-article">
					<label for="mdp">Mot de passe :</label>
					<input type="password" name="mdp"/>
				</div>
				<div class="col-lg-4 bloc-article">
					<label for="confirmation">Confirmation :</label>
					<input type="password" name="confirmation"/>
				</div>
			</div>
			
			<br>
			<div class="row">
						<!-- Bouton valider -->
				<div class="col-lg-5 text-center">
		
					<button type="submit" class="bouton" name="valider">Valider</button>
		
				</div>
						<!-- Bouton anniler -->
				<div class="col-lg-5 text-center">
		
					<button type="submit" class="bouton" name="annuler">Annuler</button>
		
				</div>
			
			</div>
		</form>
				
		<!-- 	<div class="champs-gauche">
				<br>
				<label for="prenom">Prénom : <span class="requis">*</span></label>
				<input type="text" name="prenom" value="prenom"/>
				<br>
				<label for="telephone">Téléphone :</label>
				<input type="text" name="telephone" value="0123456789"/>
				<br>
				<label for="code_postal">Code postal : <span class="requis">*</span></label>
				<input type="text" name="code_postal" value="12345"/>
				<br>
				<label for="mdp">Mot de passe :</label>
				<input type="password" name="mdp"/>
				<br>
			</div>
			<div class="champs-droite">
			
				<label for="nom">Nom : <span class="requis">*</span></label>
				<input type="text" name="nom" value="nomtest"/>
				<br>
				<label for="email">Email : <span class="requis">*</span></label>
				<input type="text" name="email" value="email@email.com"/>
				<br>
				<label for="rue">Rue : <span class="requis">*</span></label>
				<input type="text" name="rue" value="rue"/>
				<br>
				<label for="ville">Ville : <span class="requis">*</span></label>
				<input type="text" name="ville" value="ville"/>
				<br>
				<label for="confirmation">Confirmation :</label>
				<input type="password" name="confirmation"/>
				<br>
			
			</div> -->
			
			
<!--   		  <div class="boutons" >
		      <input type="submit" name="valider" value="Valider" class="valider">
		    </form>
		
		  	  <input type="submit" value="Annuler" class="annuler">
		    </form>
  		
  		  </div>
		</form>
		<br>
	</div> -->
	
	
	




</body>
</html>