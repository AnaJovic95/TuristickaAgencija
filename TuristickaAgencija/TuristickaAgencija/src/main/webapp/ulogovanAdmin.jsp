<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ulogovan admin</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">

</head>
<body>

<a href="/dodajDestinaciju.jsp">Dodaj destinaciju</a> <br>
<a href="/administrator/sveDestinacije">Dodaj ponudu</a> <br>
<a href="/administrator/svePonude">Pregled ponuda</a> <br>
<a href="/administrator/sviKorisnici">Pregled rezervacija za korisnika</a> <br>
<a href="/administrator/sveOcene">Pregled ocena</a> <br>
<a href="/administrator/sviKomentari">Pregled komentara</a> <br>
<a href="/administrator/generisiIzvestajSviKorisnici">Izvestaj svih korisnika</a> <br>
<a href="/administrator/sveDestinacijeZaIzvestaj">Izvestaj sve ponude</a> <br>
<a href="/index.jsp">Log out</a> <br>
</body>
</html>