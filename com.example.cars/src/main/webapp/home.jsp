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
<table cellpadding="2" cellspacing="2" border="1">
<tr>
<th>Cars</th>
</tr>
<tr>
<th>Desc</th>
</tr>
<c:forEach items="${cars }" var="p">
<tr>
<td>${p.name }</td>
</tr>
<tr>
<td>${p.desc }</td>
</tr>
</c:forEach>
</table>
</body>
</html>
