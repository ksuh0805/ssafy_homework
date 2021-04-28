<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="index.jsp" %>
	<h2 align="center">상품 목록</h2>
	<table border="1">
		<tr>
			<th>상품코드</th>
			<th>상품명</th>
			<th>가격</th>
			<th>설명</th>
		</tr>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.description}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>