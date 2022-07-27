<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../jspf/header.jspf"%>

<!-- Author: Styve RIBEIRO -->
<!-- Fin du header avec bouton de connexion -->
<div>
<%String nom  = (String) session.getAttribute("pseudo");%>
	<div class="col-lg-12 text-right">
		<a href="<%=request.getContextPath()%>/utilisateur">Enchères
			- </a> <a href="<%=request.getContextPath()%>/vendreArticle">Vendre un article
			- </a> <a href="<%=request.getContextPath()%>/afficherProfil">Profil de <%=nom%>		
			- </a> <a href="<%=request.getContextPath()%>/GestionDeconnexion">Déconnexion</a>
	</div>
</div>
</header>
 

<!-- Author: ??? -->





<!-- Titre -->
<div class="row">
	<div class="col-lg-12">
		<h3 class="text-center">Liste des enchères</h3>
	</div>
</div>
<!-- Filtres -->
<h3 class="filtre">Filtres :</h3>
<form action="<%=request.getContextPath()%>/encheres" method="get">
	<div class="row">
		<div class="col-lg-4 pad text-left">

			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1"><span
					class="glyphicon glyphicon-search"></span></span> <input type="text"
					name="srecherche" class="form-control"
					placeholder="Le nom de l'article contient">
			</div>

			<label class="col-md-3 control-label" for="scategorie">Catégories:</label>

			<div class="col-md-6">
				<select id="scategorie" name="scategorie" class="form-control">
					<option value="0">-Choisir Catégorie-</option>

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
	<div class="col-lg-5 bloc-article">

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

	</div>
	<div class="col-lg-5 bloc-article">

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

	</div>
</div>
</body>
</html>