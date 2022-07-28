<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../jspf/header.jspf"%>

<meta charset="UTF-8">
</header>

 

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