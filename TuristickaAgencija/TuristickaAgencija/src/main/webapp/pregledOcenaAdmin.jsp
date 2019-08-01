<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ocene</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">

</head>
<body>

<form action="/administrator/sveOcene" method="GET">
	
	<table border="1" align="center" width="100%">
		<tr>
			<th>Grad</th>
			<th>Prevoz</th>
			<th>Smestaj</th>
			<th>Ocena</th>
		</tr>
		<c:forEach items="${ocene}" var="o">
			 <tr align="center"s>
			 	<td> ${o.ponuda.destinacija.grad}</td>
				<td>${o.ponuda.prevoz}</td>
				<td>${o.ponuda.smestaj}</td>
				<td>${o.ocena}</td>
			</tr> 
		</c:forEach>
	</table>
	
</form>

</body>
</html>