<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!Doctype html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
</head>
<body>
Welcome ${cname }
<br>
<ul>
<c:forEach var="listValue" items="${lists }">
<li><a href=description id="temp" name="temp">${listValue }</a></li>
</c:forEach>
</ul>
<form:form method="POST" action="/description">
<table cellpadding="2" cellspacing="2" border="1">
<tr>
<th>Cars</th>
</tr>
<c:forEach var="p" items="${lists }">
<tr>
<td>${p }</td>
</tr>
</c:forEach>
</table>
</form:form>
</body>
</html>
