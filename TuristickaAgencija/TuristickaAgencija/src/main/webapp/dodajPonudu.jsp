<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dodavanje ponude</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">

 
</head>
<body>

<form action="/administrator/dodajPonudu" method="POST">
	Odaberite destinaciju:  <br>
	<p><select name="destinacija" style="width:210px">
				<c:forEach items="${destinacije}" var="d">
						<option value="${d.iddestinacija}">${d.grad} </option>
				</c:forEach>
	</select></p>
	
	Prevoz: <p><input type="text" name="prevoz"/></p>
	Smestaj <p><input type="text" name="smestaj"/></p>
	Cena: <p> <input type="text" name="cena"/></p>
	Datum od: <p><input type="text" name="datumOd"/></p>
	Datum do: <p><input type="text" name="datumDo"/></p>
	<input type="submit" value="Dodaj" >
</form>

</body>
</html>