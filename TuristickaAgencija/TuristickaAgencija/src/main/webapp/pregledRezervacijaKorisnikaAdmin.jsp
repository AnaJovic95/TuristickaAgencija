<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pregled rezervacija</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">

</head>
<body>

<form action="/administrator/sveRezervacijeKorisnikAdmin" method="POST">
<div >
Korisnik:
<select name="korisnik">
			<c:forEach items="${korisnici}" var="k">
					<option value="${k.idkorisnik}">${k.ime} ${k.prezime}</option>
			</c:forEach>
</select>
<input type="submit" value="Prikazi"></div> <br>
 
	<div style="width:100%;margin-left:-120px">
		<table border="1" align="center" >
			<tr>
				<th>Ime</th>
				<th>Prezime</th>
				<th>Grad</th>
				<th>Drzava </th>
				<th>Prevoz</th>
				<th>Datum od</th>
				<th>Datum do</th>
				<th>Cena</th>
			</tr>
			<c:forEach items="${rez}" var="r">
				 <tr >
				 	<td>${r.korisnik.ime}</td>
				 	<td>${r.korisnik.prezime}</td>
				 	<td>${r.ponuda.destinacija.grad}</td>
				 	<td>${r.ponuda.destinacija.drzava}</td>
					<td>${r.ponuda.prevoz}</td>
					<td>${r.ponuda.datumOd}</td>
					<td>${r.ponuda.datumDo}</td>
					<td>${r.ponuda.cena}</td>
				</tr> 
			</c:forEach>
		</table>
	</div>
</form>
<a href="/ulogovanAdmin.jsp" style="width:20%">Nazad</a> <br>
</body>
</html>