<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border-collapse: collapse;
		width: 100%;
	}
</style>
</head>
<body>
<%@ include file="./include/header.jsp" %>
	<h2>도서 상세보기</h2>
	<table border="1">
		<tr>
			<th>ISBN</th>
			<td>${book.isbn}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${book.title}</td>
		</tr>
		<tr>
			<th>저자</th>
			<td>${book.author}</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>${book.price}</td>
		</tr>
		<tr>
			<th>설명</th>
			<td>${book.desc}</td>
		</tr>
	</table>
	<a href="modifyform?isbn=${book.isbn}">수정</a>
	<a href="delete?isbn=${book.isbn}">삭제</a>
	<a href="list">목록</a>
</body>
</html>