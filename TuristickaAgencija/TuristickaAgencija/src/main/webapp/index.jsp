<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pocetna</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
</head>
<body>
	<a href="/loginKorisnik.jsp">Prijava korisnika</a> <br>
	<a href="/loginAdmin.jsp">Prijava administratora</a> <br>
	<a href="/korisnik/sveDestinacije">Pregled svih destinacija</a> <br>
	<a href="/registracija.jsp">Registruj se</a>
	
</body>
</html>