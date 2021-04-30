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
	<h1>도서 등록 결과</h1>
 	<c:if test="${empty book}">
		<div>등록된 도서가 없습니다.</div>
	</c:if>
	<c:if test="${not empty book}">
		<h2>등록 도서 정보</h2>
		<table border="1">
			<tr>
				<th>항목</th>
				<th>내용</th>
			</tr>
			<tr>
				<td>도서번호</td>
				<td>${book.isbn}</td>
			</tr>
			<tr>
				<td>도서명</td>
				<td>${book.title}</td>
			</tr>
			<tr>
				<td>저자</td>
				<td>${book.author}</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>${book.price}</td>
			</tr>
			<tr>
				<td>설명</td>
				<td>${book.desc}</td>
			</tr>
		</table>
	</c:if>
	<div>
	<a href="registform">추가 등록</a>
	<a href="list">목록</a>
	</div>
</body>
</html>