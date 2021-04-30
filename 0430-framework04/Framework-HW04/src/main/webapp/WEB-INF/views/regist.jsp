<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	function register(){
		document.getElementById("registform").submit();
		if("${msg}") {
			var isbn = document.getElementById("isbn").value;
			alert(isbn + "${msg}");
		}
	}
</script>
<body>
<%@ include file="./include/header.jsp" %>
<h2>SSAFY 도서 관리</h2>
	<form action="register" id="registform">
		<fieldset>
			<legend>도서 등록</legend>
			<div>
				<label for="isbn">도서번호 </label><input type="text" id="isbn" name="isbn">
			</div>
			<div>
				<label for="title">도서명 </label><input type="text" id="title" name="title">
			</div>
			<div>
				<label for="author">저자 </label><input type="text" id="author" name="author">
			</div>
			<div>
				<label for="price">가격 </label><input type="number" id="price" name="price">
			</div>
			<div>설명</div>
			<div>
				<textarea id="desc" name="desc" rows="2" cols="50"></textarea>
			</div>
			<div>
				<button type="button" onclick="register();">등록</button>
				<button type="reset">취소</button>
			</div>
		</fieldset>
			<a href="list">도서 목록</a>
	</form>
</body>
</html>