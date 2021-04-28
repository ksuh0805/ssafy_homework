<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="index.jsp" %>
	<h2 align="center">상품 등록</h2>
	<form action="${root}/register">
		<label for="id">아이디</label>
		<input id="id" name="id" type="text"><br>
		<label for="name">상품명</label>
		<input id="name" name="name" type="text"><br>
		<label for="price">가격</label>
		<input id="price" name="price" type="number"><br>
		<label for="description">설명</label>
		<input id="description" name="description" type="text">
		<button>제출</button>
	</form>
</body>
</html>