<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	function modify(){
		document.getElementById("modifyform").submit();
	}
</script>
<body>
<%@ include file="./include/header.jsp" %>
<h2>SSAFY 도서 관리</h2>
	<form action="modify" id="modifyform">
		<fieldset>
			<legend>도서 등록</legend>
			<div>
				<label for="isbn">도서번호 </label><input type="text" id="isbn" name="isbn" value="${book.isbn}">
			</div>
			<div>
				<label for="title">도서명 </label><input type="text" id="title" name="title" value="${book.title}">
			</div>
			<div>
				<label for="author">저자 </label><input type="text" id="author" name="author" value="${book.author}">
			</div>
			<div>
				<label for="price">가격 </label><input type="number" id="price" name="price" value="${book.price}">
			</div>
			<div>설명</div>
			<div>
				<textarea id="desc" name="desc" rows="2" cols="50">${book.desc}</textarea>
			</div>
			<div>
				<button type="button" onclick="modify();">수정</button>
				<button type="reset">취소</button>
			</div>
		</fieldset>
	</form>
</body>
</html>