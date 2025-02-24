<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>quiz03.jsp</h2>
	<p>다음을 구현하고 a태그 클릭시 quiz03_ok 에 학생번호를 출력하세요</p>
	
	<% for(int i = 1; i <= 30; i++) { %>
		<a href="quiz03_ok.jsp?num=<%=i %>"><%=i %>번 학생정보</a>
		<br>
	<% } %>
	
</body>
</html>