<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Izmena lozinke</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">

</head>
<body>

<form action="/korisnik/promenaLozinke" method="POST">
	
	Stara lozinka <p><input type="password" name="staraLozinka">  </p>
	Nova lozinka <p><input type="password" name="novaLozinka"> </p>
	Ponovite novu lozinku <p><input type="password" name="novaLozinka2">  </p>
	<input type="submit" value="Potvrdi"> 
</form>


</body>
</html>