<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	table {
		border-collapse: collapse;
		width: 100%;
	}
</style>
</head>
<script>
	/* function detail(){
		let cnt = $("input[type='checkbox']").filter(':checked').length;
		console.log(cnt);
		if(cnt > 1) alert("하나만 선택하세요!");
		else{
			let td = $("input[name='ischecked']:checked").parent().eq(2).text();
			console.log(td);
			document.getElementById("act").value = "modify";
			document.getElementById("isbn").value = td;
			//document.getElementById("listform").submit();
		}
	} */
</script>
<body>
	<%@ include file="./include/header.jsp" %>
	<h1>도서 목록</h1>
	<form id="listform">
		<input type="hidden" name="act" id="act" value="">
		<input type="hidden" name="isbn" id="isbn" value="">
	</form>
	<div align="right">
		<a href="registform">등록</a>
		<a href="#" onclick="location.href='deletelist'">전체삭제</a>
	</div>
	<table border="1">
		<tr>
		<!-- <th>선택</th> -->
		<th>번호</th>
		<th>ISBN</th>
		<th>제목</th>
		<th>저자</th>
		<th>가격</th>
		</tr>
		<c:forEach var="book" items="${books}" varStatus="status">
		<tr align="center">
			<!-- <td><input name="ischecked" type="checkbox"/></td> -->
			<td>${status.index + 1}</td>
			<td onclick="location.href='detail?isbn=${book.isbn}'">${book.isbn}</td>
			<td>${book.title}</td>
			<td>${book.author}</td>
			<td>${book.price}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>