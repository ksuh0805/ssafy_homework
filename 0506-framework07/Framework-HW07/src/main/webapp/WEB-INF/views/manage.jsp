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
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script>
$(document).ready(function() {
	let result = $('#result');
	$('#retrieveBtn').click(function() {
		console.log("clickre");
		$.ajax({
			url:'${root}/manage/product',  
			type:'GET',
			contentType:'application/json;charset=utf-8',
			success:function(products){
				idlist(products);
				result.text('조회 성공');
			},
			error:function(xhr,status,msg){
				console.log("상태값 : " + status + " Http에러메시지 : "+msg);
				result.text('조회 실패');
			}
		});
	});
	$('#idlist').on('click', 'li', function() {
		console.log("clickli");
		console.log($(this).attr('id'));
		$.ajax({
			url:'${root}/manage/product/' + $(this).attr('id'),  
			type:'GET',
			contentType:'application/json;charset=utf-8',
			success:function(product){
				$('#pid').val(product.id);
				$('#pname').val(product.name);
				$('#pprice').val(product.price);
				$('#pdesc').val(product.description);
				result.text('조회 성공');
			},
			error:function(xhr,status,msg){
				console.log("상태값 : " + status + " Http에러메시지 : "+msg);
				result.text('조회 실패');
			}
		});
	});
	$('#add').click(function() {
		console.log("clickadd");
		let registerinfo = JSON.stringify({
			"id" : $("#pid").val(), 
			"name" : $("#pname").val(), 
			"price" : $("#pprice").val(), 
			"description" : $("#pdesc").val()
		   });
		$.ajax({
			url:'${root}/manage/product',  
			type:'POST',
			contentType:'application/json;charset=utf-8',
			dataType:'json',
			data: registerinfo,
			success:function(products){
				idlist(products);
				$('#pid').val('');
				$('#pname').val('');
				$('#pprice').val('');
				$('#pdesc').val('');
				result.text('추가 성공');
			},
			error:function(xhr,status,msg){
				console.log("상태값 : " + status + " Http에러메시지 : "+msg);
				result.text('추가 실패');
			}
		});
	});
	$('#modify').click(function() {
		console.log("clickmod");
		let modifyinfo = JSON.stringify({
			"id" : $("#pid").val(), 
			"name" : $("#pname").val(), 
			"price" : $("#pprice").val(), 
			"description" : $("#pdesc").val()
		   });
		$.ajax({
			url:'${root}/manage/product',  
			type:'PUT',
			contentType:'application/json;charset=utf-8',
			dataType:'json',
			data: modifyinfo,
			success:function(products){
				idlist(products);
				result.text('수정 성공');
			},
			error:function(xhr,status,msg){
				console.log("상태값 : " + status + " Http에러메시지 : "+msg);
				result.text('수정 실패');
			}
		});
	});
	$('#delete').click(function() {
		console.log("clickldel");
		$.ajax({
			url:'${root}/manage/product/' + $('#pid').val(), 
			type:'DELETE',
			contentType:'application/json;charset=utf-8',
			success:function(products){
				idlist(products);
				$('#pid').val('');
				$('#pname').val('');
				$('#pprice').val('');
				$('#pdesc').val('');
				result.text('삭제 성공');
			},
			error:function(xhr,status,msg){
				console.log("상태값 : " + status + " Http에러메시지 : "+msg);
				result.text('삭제 실패');
			}
		});
	});
});
function idlist(products) {
	$('#idlist').empty();
	$(products).each(function(index, p){
		let str = "<li id=" + p.id + ">" + p.id + "</li>";
	$('#idlist').append(str);
	});
}
</script>
</head>
<body>
<%@ include file="header.jsp" %>
	<div class="container">
		<div>
			<h2>상품관리</h2>
			<div>
				<button id="retrieveBtn" class="btn btn-primary">목록조회</button>
			</div>
			<ul id="idlist">
			</ul>
		<div style="margin-top:10px">
			<button id="add">추가</button>
			<button id="modify">수정</button>
			<button id="delete">삭제</button>
		</div>
		<div style="margin-top:10px">
			<label for="pid">ID</label><input type="text" id="pid" name="pid"><br>
			<label for="pname">이름</label><input type="text" id="pname" name="pname"><br>
			<label for="pprice">가격</label><input type="number" id="pprice" name="pprice"><br>
			<textarea id="pdesc">
			</textarea>
		</div>
		<div id="result">
		</div>
		</div>
	</div>
</body>
</html>
