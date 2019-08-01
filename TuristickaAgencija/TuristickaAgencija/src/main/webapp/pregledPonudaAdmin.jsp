<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pregled ponuda</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">

</head>
<body>

<form action="/administrator/svePonude" method="GET">
	
	<table border="1" align="center">
		<tr>
			<th>Grad</th>
			<th>Cena</th>
			<th>Prevoz</th>
			<th>Smestaj</th>
			<th>Datum od</th>
			<th>Datum do</th>
		</tr>
		<c:forEach items="${ponude}" var="p">
			 <tr >
			 	<td>${p.destinacija.grad} </td>
				<td>${p.cena} </td>
				<td>${p.prevoz}</td>
				<td>${p.smestaj}</td>
				<td>${p.datumOd}</td>
				<td>${p.datumDo}</td>
			</tr> 
		</c:forEach>
	</table>
	
</form>

</body>
</html>