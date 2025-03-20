<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션 삭제
	//session.removeAttribute("my_id");
	session.invalidate(); //완전히 세션객체를 삭제 
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