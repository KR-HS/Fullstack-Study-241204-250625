<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션은 내장객체로 서버에서 생성해서 서버가 관리합니다.
	//기본 30분 or 브라우저 종료 하기 까지 세션은 유지 됩니다.
	
	//값 저장
	session.setAttribute("my_id", "abc123");
	session.setAttribute("my_name", "홍길자");	
	
	//세션의 시간을 설정
	//session.setMaxInactiveInterval(3600); //이 세션은 1시간 동안 유지
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="session_get.jsp">세션확인하기</a>
	
</body>
</html>