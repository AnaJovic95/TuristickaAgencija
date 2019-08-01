<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pregled destinacija</title>
 <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
</head>
<body>

<form action="/korisnik/sveDestinacije" method="POST">
	<table border="1" align="center" width="100%">
		<tr>
			<th>Grad</th>
			<th>Drzava</th>
		</tr>
		<c:forEach items="${destinacije}" var="d">
			 <tr >
				<td>${d.grad} </td>
				<td>${d.drzava}</td>
			</tr> 
		</c:forEach>
	</table>
	
</form>
</body>
</html>