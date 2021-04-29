<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
<title>상품목록</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container" align="center">
		<div class="col-lg-8" align="center">
			<h2>상품목록</h2>

			<table class="table table-borderless">
				<tr>
					<td align="right"><a href="insertProduct" type="button"
						id="mvWriteBtn" class="btn btn-primary">상품등록</a></td>
				</tr>
			</table>
			<form id="searchform" method="get" class="form-inline" action="">
				<input type="hidden" name="pg" id="pg" value="1">
				<table class="table table-borderless">
					<tr>
						<td align="right"><select class="form-control" name="key"
							id="skey">
								<option value="articleno">상품번호</option>
								<option value="subject">상품이름</option>
								<option value="subject">내용</option>
						</select> <input type="text" class="form-control" placeholder="검색어 입력."
							name="word" id="sword">
							<button type="button" id="searchBtn" class="btn btn-primary">검색</button>
						</td>
					</tr>
				</table>
			</form>

			<table class="table table-bordered">
				<tr>
					<th>작성자 아이디</th>
					<th>상품이름</th>
					<th>상품가격</th>
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

		</div>
	</div>
</body>
</html>
