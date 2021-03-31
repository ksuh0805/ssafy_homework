<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String root = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function save() {
	if(document.getElementById("pnum").value == "") {
		alert("상품번호 입력!!!");
		return;
	}
	if(document.getElementById("pname").value == "") {
		alert("상품이름 입력!!!");
		return;
	}
	if(document.getElementById("pprice").value == "") {
		alert("상품가격 입력!!!");
		return;
	}
	if(document.getElementById("pdesc").value == "") {
		alert("상품정보 입력!!!");
		return;
	}
	
	document.getElementById("productform").action = "<%=root%>/main";
	document.getElementById("productform").submit();

}	
</script>
</head>
<body>
<div align="center">
	 <h2>상품을 등록해주세요</h2>
	 <form id="productform" action="" method="post">
	 <input type="hidden" name="act" value="last">
		 <div>
		 	상품 번호 : <input type="text" id="pnum" name="pnum"/> 
		 </div>
		 <div>
		 	상품명 : <input type="text" id="pname" name="pname"/> 
		 </div>
		 <div>
		 	상품 가격 : <input type="number" id="pprice" name="pprice"/>
		 </div>
		 <div>
		 	상품 설명 : <input type="text" id="pdesc" name="pdesc"/>
		 </div>
			<button type="button" onclick="save();">저장</button>
			<button type="reset">취소</button>
	 </form>
</div>
</body>
</html>