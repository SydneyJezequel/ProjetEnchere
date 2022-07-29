<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="fr.eni.projetenchere.messages.LecteurMessage" %>
<%@ include file="../jspf/header.jspf"%>

<!-- Author: Styve RIBEIRO / Update : Olivier Catanese-->
<!-- Fin du header avec bouton de connexion -->

<div>
	<div class="col-lg-12 text-right">
		<a href="<%=request.getContextPath()%>/ServletInscription">S'inscrire
			- </a> <a href="<%=request.getContextPath()%>/Connexion">Se connecter</a>
	</div>
</div>
</header>


<!-- Titre -->
<div class="row">
	<div class="col-lg-12">
		<h3 class="text-center">Liste des enchères</h3>
		
		<c:if test="${!empty listeCodesErreur}">
			<div class="alert alert-danger" role="alert">
			  <strong>Erreur!</strong>
			  <ul>
			  	<c:forEach var="code" items="${listeCodesErreur}">
			  		<li>${LecteurMessage.getMessageErreur(code)}</li>
			  	</c:forEach>
			  </ul>
			</div>
		</c:if>
	</div>
</div>

<!-- Filtres -->
<h3 class="filtre">Filtres :</h3>
<form action="<%=request.getContextPath()%>/ServletEncheresEnCours" method="post">
	<div class="row">
		<div class="col-lg-4 pad text-left">

			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1"><span
					class="glyphicon glyphicon-search"></span></span> <input type="text"
					name="srecherche" class="form-control"
					placeholder="Le nom de l'article contient">
			</div>
			<br>
			<label class="col-md-3 control-label" for="scategorie">Catégories:</label>

			<div class="col-md-6">
				<select id="scategorie" name="scategorie" class="form-control">
						<option value="0">-Choisir Catégorie-</option>
						<c:forEach var="e" items="${listeCategories}">
							<option value="${e.noCategorie}">${e.libelle}</option>
						
						</c:forEach>
				</select>
			</div>
		</div>

		<!-- Bouton rechercher -->
		<div class="col-lg-6 text-center">

			<button type="submit" class="bouton" name="search">Rechercher</button>

		</div>
	</div>
</form>
<!-- Articles affichez -->

<div class="row">

<c:choose>
	<c:when test="${listeEncheres.size()>0}">
		<c:forEach var="e" items="${listeEncheres}">
	        	
			<div class="col-lg-5 bloc-article">
				<div class="col-lg-4 col-sm-4">
					<img class="media mw-25" src="./images/article_default.png" alt=""
						width="100px" height="100px">
				</div>
				<div class="col-lg-auto col-sm-auto">
					<div>
				        <ul class="list-group col-12">
		        		    <h4>${e.nomArticle}</h4>
							<p>Prix : ${e.prixInitial} points</p>
							<p>Fin de l'enchère : ${e.dateFinEncheres}</p>
							<p>Vendeur : ${e.pseudo}</p>
				        </ul>
					</div>
				</div>
			</div>
				
		</c:forEach>
	</c:when>
    <c:otherwise>
       	<p>Pas d'enchères actuellement.<p>
    </c:otherwise>
</c:choose>
		
		
		
		
		
		


<!-- 	<div class="col-lg-5 bloc-article">

		<div class="col-lg-4 col-sm-4">
			<img class="media mw-25" src="./images/article_default.png" alt=""
				width="100px" height="100px">
		</div>
		<div class="col-lg-auto col-sm-auto">
			<h4>nom article</h4>

			<p>Prix :</p>
			<p>Fin de l'enchère :</p>
			<p>Vendeur :</p>

		</div>

	</div> -->
</div>
</body>
</html>