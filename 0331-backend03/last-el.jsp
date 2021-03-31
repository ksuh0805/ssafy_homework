<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%!
private String getCookieValue(Cookie[] cookies, String name){

    if(cookies == null) return null;

    for(Cookie cookie : cookies){
	if(cookie.getName().equals(name)) 
		return cookie.getValue();
    }
    return null;
}
%>
<%
//MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
Cookie[] cookies = request.getCookies();
%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<h2>마지막 등록한 상품</h2>
<div>상품 번호 : ${getCookieValue(cookies, "num")}</div>
<div>상품명 : ${getCookieValue(cookies, "name")}</div>
<div>상품 가격 : ${getCookieValue(cookies, "price")}</div>
<div>상품 설명 : ${getCookieValue(cookies, "desc")}</div>
</div>
<div align="center">
			<a href="${root}/main?act=input">상품 등록</a>
			<a href="javascript:void(0)">상품 수정</a>
			<a href="javascript:void(0)">상품 목록</a>
</div>
</body>
</html>