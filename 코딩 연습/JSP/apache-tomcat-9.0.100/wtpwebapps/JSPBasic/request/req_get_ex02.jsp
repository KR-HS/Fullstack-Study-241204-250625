<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String date = request.getParameter("date");
	String msg = request.getParameter("msg");
	
	// checkbox는 values로 받음
	String[] agree = request.getParameterValues("agree");
	
	
%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	date = <%=date %> <br>
	msg = <%=msg %> <br>
	agree : <%= Arrays.toString(agree) %>
	
</body>
</html>