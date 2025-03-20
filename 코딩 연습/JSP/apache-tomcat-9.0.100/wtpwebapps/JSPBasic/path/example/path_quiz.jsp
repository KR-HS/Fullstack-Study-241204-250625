<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- request폴더 req_get_ex01페이지로 상대경로 -->
	<a href="../../request/req_get_ex01.jsp">req_get_ex01</a>
	<!-- img태그로 html/img폴더 안에 있는 이미지를 상대경로 -->
	<img alt="이미지" src="../../html/img/a.png" width="200">
	<!-- img태그로 html/img폴더 안에 있는 이미지를 절대경로 -->
	<img alt="이미지" src="/JSPBasic/html/img/b.png">
	<!-- a링크를 통해서 MyServlet페이지로 이동 상대경로 -->
	<a href="../../apple">서블릿 상대경로</a>
	<!-- a링크를 통해서 MyServlet페이지로 이동 절대경로 -->
	<a href="/JSPBasic/apple">서블릿 절대경로</a>
	

</body>
</html>