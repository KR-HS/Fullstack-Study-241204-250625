<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//쿠키는 서버에서 생성해서, 클라이언트로 전달합니다.
	//1. 쿠키생성 - (쿠키이름, 쿠키값)
	Cookie cookie = new Cookie("user_id", "aaa123");
	Cookie cookie2 = new Cookie("user_name", "유진초이");	

	//2. 쿠키의 속성을 - 시간
	cookie.setMaxAge(1800); //1800초
	cookie2.setMaxAge(20); //20초
	
	
	//3. 쿠키를 response에 담는다.
	response.addCookie(cookie);
	response.addCookie(cookie2);

%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="cookie_get.jsp">쿠키값 확인하기</a>
	
	
</body>
</html>