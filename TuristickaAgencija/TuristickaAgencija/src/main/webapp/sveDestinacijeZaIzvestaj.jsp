<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sve destinacije izvestaj</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">

 
</head>
<body>

<form action="/administrator/generisiIzvestajSvePonudeZaDestinacije" method="GET">
	Odaberite destinaciju:  <br>
	<select name="destinacija">
				<c:forEach items="${destinacije}" var="d">
						<option value="${d.iddestinacija}">${d.grad} ${d.drzava}  </option>
				</c:forEach>
	</select> <br>
	<input type="submit" value="Izvestaj" >
	<br> 
</form>
<br>
<a href="/ulogovanAdmin.jsp" >Nazad</a> <br>

</body>
</html>