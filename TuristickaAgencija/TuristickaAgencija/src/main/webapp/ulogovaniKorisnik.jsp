<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pocetna korisnik</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">

</head>
<body>
	<a href="/korisnik/sveDestinacijePonuda">Pregled ponuda i rezervacija ponuda</a> <br>
	<a href="/korisnik/sveRezervacijeKorisnika">Moje rezervacije</a> <br>
	<a href="/korisnik/svePonudeZaKomentar">Komentarisanje ponuda</a> <br>
	<a href="/korisnik/svePonudeZaOcenu">Ocenivanje ponuda</a> <br>
	<a href="/promenaLozinke.jsp">Promena lozinke</a> <br>
	<a href="/index.jsp">Log out</a> <br>
</body>
</html>