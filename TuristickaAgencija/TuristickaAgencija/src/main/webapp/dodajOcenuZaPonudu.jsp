<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ocena</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">

 
</head>
<body>

<form action="/korisnik/dodajOcenuZaPonudu" method="GET">
	Odaberite ponudu  <br>
	<select name="ponuda" style="width:170px">
				<c:forEach items="${ponude}" var="p">
						<option value="${p.idponuda}">${p.destinacija.grad} ${p.smestaj} ${p.prevoz} ${p.datumOd} ${p.datumDo}</option>
				</c:forEach>
	</select> <br>
	
	Ocena <br>
	<select name="ocena" style="width:100px">
	  <option value="1">1</option>
	  <option value="2">2</option>
	  <option value="3">3</option>
	  <option value="4" >4</option>
	  <option value="5" selected>5</option>
	</select><br>
	<input type="submit" value="Oceni" >
</form>
<br>

</body>
</html>