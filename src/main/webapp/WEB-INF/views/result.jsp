<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel Search</title>
</head>
<body>
<h1> Hotel Search</h1>
<form class="form-inline" action="/result" autocomplete="off">
<table><tr>
<c:forEach items="${cities}" var="city">
   ${city.name}  ${city.pricePerNight}<br> </c:forEach>
</tr>
</table>
</form>
<a href="/" > Go Back</a>
</body>
</html>