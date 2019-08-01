<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ocene</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">

</head>
<body>

<form action="/administrator/sviKomentari" method="GET">
	
	<table border="1" align="center">
		<tr>
			<th>Grad</th>
			<th>Prevoz</th>
			<th>Smestaj</th>
			<th>Ime korisnika</th>
			<th>Prezime korisnika</th>
			<th>Komentar</th>
		</tr>
		<c:forEach items="${komentari}" var="k">
			 <tr >
			 	<td>${k.ponuda.destinacija.grad}</td>
				<td>${k.ponuda.prevoz}</td>
				<td>${k.ponuda.smestaj}</td>
				<td>${k.korisnik.ime}</td>
				<td>${k.korisnik.prezime}</td>
				<td>${k.tekst}</td>
			</tr> 
		</c:forEach>
	</table>
	
</form>

</body>
</html>