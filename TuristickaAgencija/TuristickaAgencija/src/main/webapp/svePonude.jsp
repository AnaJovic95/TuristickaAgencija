<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pregled ponuda po destinacijama</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">

</head>
<body>

<form action="/korisnik/svePonude" method="GET">
	Odaberite destinaciju:  <br>
	<select name="destinacija" style="width:210px">
				<c:forEach items="${destinacije}" var="d">
						<option value="${d.iddestinacija}">${d.grad} </option>
				</c:forEach>
	</select> 
	<input type="submit" value="Prikazi" >
	
	<table border="1" align="center" width="200%">
		<tr>
			<th>Cena</th>
			<th>Prevoz</th>
			<th>Smestaj</th>
			<th>Datum od</th>
			<th>Datum do</th>
			<th>Rezervisi</th>
		</tr>
		<c:forEach items="${ponude}" var="p">
			 <tr >
				<td>${p.cena} </td>
				<td>${p.prevoz}</td>
				<td>${p.smestaj}</td>
				<td>${p.datumOd}</td>
				<td>${p.datumDo}</td>
				<td><a href="/korisnik/rezervisi?ponuda=${p.idponuda}" style="width:100px">Rezervisi</a> </td> 
			</tr> 
		</c:forEach>
	</table>
	
</form>
<a href="/ulogovaniKorisnik.jsp" style="width:20%">Nazad</a>
</body>
</html>