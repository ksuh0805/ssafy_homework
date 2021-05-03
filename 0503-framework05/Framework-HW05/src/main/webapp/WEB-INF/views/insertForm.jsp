<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>SSAFY-글작성</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
  
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container" align="center">
	<div class="col-lg-6" align="right">
	
	</div>
	<div class="col-lg-6" align="center">
		<h2>상품추가</h2>
		<form id="insertForm" method="post" action="processInsertProduct">
			<div class="form-group" align="left">
				<label for="subject">아이디</label>
				<input type="text" class="form-control" id="id" name="id">
			</div>
			<div class="form-group" align="left">
				<label for="subject">상품이름</label>
				<input type="text" class="form-control" id="name" name="name">
			</div>
			<div class="form-group" align="left">
				<label for="content">상품가격</label>
				<textarea class="form-control" id="price" name="price"></textarea>
			</div>
			<div class="form-group" align="left">
				<label for="content">상품설명</label>
				<textarea class="form-control" rows="15" id="description" name="description"></textarea>
			</div>
			<button type="submit" id="writeBtn" class="btn btn-primary">글작성</button>
			<button type="reset" class="btn btn-warning">초기화</button>
		</form>
	</div>
</div>

</body>
</html>
