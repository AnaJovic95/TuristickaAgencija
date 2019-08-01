<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dodavanje dogadjaja</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
</head>
<body>

<form action="/administrator/dodajDestinaciju" method="POST">
	
	Drzava:<p> <input type="text" name="drzava"/></p><br>
	Grad:<p> <input type="text" name="grad"/></p><br>
	<input type="submit" value="Dodaj" >
	<br> 
</form>
<br>
<a href="/ulogovanAdmin.jsp" style="width:40px;margin-left:-10px">Nazad</a> <br>

</body>
</html>