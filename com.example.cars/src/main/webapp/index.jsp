<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!Doctype html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Home</title>
</head>
<body>
<div class="container mt-3">
<div class="row">

<div class="col-md-12">

<h1 class="text-center mb-3">Cars Portal</h1>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Car Name</th>
      <th scope="col">Description</th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${cars}" var="c">
    <tr>
      <th scope="row">${c }</th>
      <td>${c }</td>
      <td>${c }</td>
    </tr>
    </c:forEach>
  </tbody>
</table>



</div>

</div>
</div>
</body>
</html>
