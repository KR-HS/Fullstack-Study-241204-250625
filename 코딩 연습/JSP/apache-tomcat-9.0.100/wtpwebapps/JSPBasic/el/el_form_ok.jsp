<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 
	 <h3>파라미터 값을 얻을때는 param객체를 쓰면 됨</h3>
	 ${param.name }<br>
	 ${param.age }<br>
</body>
</html>