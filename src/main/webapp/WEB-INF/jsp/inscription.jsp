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

<style type="text/css">
        h1 {
        	text-align:left;
        	padding-left:50px;
        }
        
        h2 {
        	text-align:center;
        	font-size:200%;
        }
        
        .formulaire {
			display:block; 
	        background-color:#CCC;
	        width:80%;
	        margin: 10px auto;
	        padding : 15px;
	        border: 10px solid #000;
        
        }
        
		form{
			text-align:center;
		}
		
		label {
			display: inline-block;
			width: 150px;
			float: left;
			text-align:left;
}
   		.champs-gauche{
   			display:block;
   			width:40%;
   			margin:0 50px 50px;
   			float:left;
   			padding:10px;
   			/* position: relative;
   			right:0; */
   			border:3px solid blue;
   		}
   		.champs-droite{
   			display:block;
   			width:40%;
   			margin:0 50px 50px;
   			padding:10px;
   			
   			float:right;
   			/* position: relative;
   			right:0; */
   			border:3px solid blue;
   		}
   		input[type=text]{
   			padding: 10px;
   		
   		}
	   input[type=submit]
	   {
			width : 300px;
			height:50px;
			padding : 10px;
			font-size: 20px;
			font-weight:400;
			max-width: 550px;
			margin: 0 auto;
			background:#D1F2EB;
			border-radius: 5px;
			box-shadow: 0 0 5px #011627ff;
			text-align:center;
		}
		.form2{
			display:inline;
			outline:solid #A23;
		}
		.requis{
			color:#C00;
			
		}
</style>



	<h2>Mon Profil</h2>
	<br>
	<div class="formulaire">
	
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
		
<%-- 		<c:if test="${!empty=(String)listeCodesErreur }">
			<p>
				pas vide
			</p>
		
		
		</c:if>
		
		<c:if test="${empty=listeCodesErreur }">
			<p>
				vide
			</p>
		
		
		</c:if>
		 --%>
	
	
		<form action="${pageContext.servletContext.contextPath}/ServletInscription" method="POST">
<%-- 		<form action="<%=request.getContextPath()%>/ServletInscription" method="POST"> --%>
			<div class="champs-gauche">
				<label for="pseudo">Pseudo : <span class="requis">*</span></label>
				<input type="text" name="pseudo" value="pseudo"/>
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
			
			</div>
			
			
  		  <div class="boutons" >
		      <input type="submit" name="valider" value="Valider" class="valider">
		  <!--   </form> -->
		
		  	  <input type="submit" value="Annuler" class="annuler">
		   <!--  </form> -->
  		
  		  </div>
		</form>
		<br>
	</div>
	
	
	




</body>
</html>