<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogIn administrator</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
</head>
<body>

	
	<form action="/administrator/login" method="POST">
			<table align="center">
			<tr><td></td><td><font >Email: </font></td></tr>
			<tr><td></td><td><input type="text" name="email"/></td></tr>
			 <tr><td></td><td> <font >Sifra: </font></td></tr>
			 <tr><td></td><td><input type="password" name="lozinka"/></td></tr>
			 <tr><td></td><td><input  type="submit" value="Prijava"></td></tr>
			 </table>
		</form>
		<c:if test="${empty administrator}">
			<font >${porukaLogin}</font>
		</c:if>

</body>
</html>