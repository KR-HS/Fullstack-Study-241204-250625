<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String uri = request.getRequestURI(); // uri
	StringBuffer url = request.getRequestURL(); // url
	String conPath = request.getContextPath(); // contextPath - 프로젝트 구분단위
	String address = request.getRemoteAddr(); // 원격접속 주소
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	uri: <%=uri %> <br>
	url: <%=url %> <br>
	컨텍스트패스 : <%=conPath %> <br>
	상대방 접속 주소 : <%=address %> <br>
</body>
</html>