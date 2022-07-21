<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../jspf/header.jspf"%>

<!-- Author: Styve RIBEIRO -->
<!-- Fin du header avec bouton de connexion -->
<div>
	<div class="col-lg-12 text-right">
		<a href="<%=request.getContextPath()%>/utilisateur">Enchères
			- </a> <a href="<%=request.getContextPath()%>/VendreArticle">Vendre un article
			- </a> <a href="<%=request.getContextPath()%>/ProfilUtilisateur">Mon profil
			- </a> <a href="<%=request.getContextPath()%>/GestionDéconnexion">Déconnexion</a>
	</div>
</div>
</header>


<!-- Author: ??? -->

<%String nom  = (String) session.getAttribute("pseudo");%>

<h1>Bienvenue <%=nom%></h1>










</body>
</html>