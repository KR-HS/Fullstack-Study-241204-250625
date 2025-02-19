<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 		<%@ include file="다른페이지의 경로" %> --%>
		<%@ include file="include_header.jsp" %>
		
		<section>
			여기는 본문..
			
			html의 iframe태그는 include처럼 다른페이지를 삽일할 때 쓸수 있음
		</section>

		<%@ include file="include_footer.jsp" %>
</body>
</html>