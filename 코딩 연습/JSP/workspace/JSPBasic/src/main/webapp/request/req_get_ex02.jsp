<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String date = request.getParameter("date"); //input의 name값
	String msg = request.getParameter("msg");
	//checkbox는 values로 받습니다
	String[] agree = request.getParameterValues("agree");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	날짜:<%=date %><br>
	메시지:<%=msg %><br>
	동의항목:<%= Arrays.toString(agree) %>
	
	
</body>
</html>