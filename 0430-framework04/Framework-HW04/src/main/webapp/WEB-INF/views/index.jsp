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
	<%@ include file="./include/header.jsp" %>
	<c:if test="${empty userinfo}">
	<h2>로그인 해주세요</h2>
	</c:if>
	<c:if test="${not empty userinfo}">
	<ul>
		<li><a href="registform">도서 등록</a>
		<li><a href="list">도서 목록</a>
	</ul>
	</c:if>
</body>
</html>