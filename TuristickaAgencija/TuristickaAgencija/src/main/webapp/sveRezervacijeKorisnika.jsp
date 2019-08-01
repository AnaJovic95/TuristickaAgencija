<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sve rezervacije korisnika</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">

</head>
<body>

	<form action="/korisnik/sveRezervacijeKorisnika" method="POST">
	<div style="margin-left:-200px;width:100%">
	<table border="1" align="center" width="200%" >
		<tr>
			<th>Grad</th>
			<th>Drzava </th>
			<th>Prevoz</th>
			<th>Datum od</th>
			<th>Datum do</th>
			<th>Cena</th>
			<th>Otkazi</th>
		</tr>
		<c:forEach items="${rezervacije}" var="r">
			 <tr >
			 	<td>${r.ponuda.destinacija.grad}</td>
			 	<td>${r.ponuda.destinacija.drzava}</td>
				<td>${r.ponuda.prevoz}</td>
				<td>${r.ponuda.datumOd}</td>
				<td>${r.ponuda.datumDo}</td>
				<td>${r.ponuda.cena}</td>
				<td><a href="/korisnik/otkaziRezervaciju?rezervacija=${r.idrezervacija}" >Otkazi</a></td>
			</tr> 
		</c:forEach>
	</table>
	</div>
</form>
<a href="/ulogovaniKorisnik.jsp" style="width:20%">Nazad</a> <br>

</body>
</html>