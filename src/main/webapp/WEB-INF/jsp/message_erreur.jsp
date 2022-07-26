<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PAGE ERREURS</title>
</head>
<body>
<% Exception e = (Exception) request.getAttribute("erreur"); %>
<h1>ERREUR</h1>
<h4>Une erreur s'est produite : </h4>
<font color=red>
<%=e.getMessage() %><br/> 
nom de la classe : <%=e.getStackTrace()[0].getClassName()%><br/>
nom de la methode : <%=e.getStackTrace()[0].getMethodName()%><br/>
nom du fichier : <%=e.getStackTrace()[0].getFileName()%><br/>
numero de la ligne : <%=e.getStackTrace()[0].getLineNumber()%><br/>
</font>
</body>
</html>