<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//setAttiribute로 저장한 값은 getAttribute로 얻음
	String address = (String)request.getAttribute("address");
	String name = (String)request.getAttribute("name");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	포워드로 넘어온값:<%=address %>, <%=name %>
	
	
</body>
</html>