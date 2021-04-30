<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function login(){
		document.getElementById("loginform").submit();
		if("${msg}") alert("${msg}");
	}
</script>
<body>
	<h1 align="center">SSAFY 도서 관리</h1>
	<div align="right">
	<c:if test="${empty userinfo}">
	<form id="loginform" action="login" method="post">
		<input type="hidden" name="action" value="login">
		<input type="text" id="id" name="id" placeholder="아이디">
		<input type="password" id="pass" name="pass" placeholder="비밀번호">
		<button type="button" onclick="login();">로그인</button>
	</form>
	</c:if>
	<c:if test="${not empty userinfo}">
		${userinfo.name} 님 반갑습니다.
		<a href="logout">로그아웃</a>
	</c:if>
	</div>
</body>
</html>