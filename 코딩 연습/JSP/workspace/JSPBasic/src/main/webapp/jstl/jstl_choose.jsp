<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<c:choose>
		<c:when test="${param.name== '홍길동'}">
			홍길동님 환영합니다.
		</c:when>
		<c:when test="${param.name== '이순신'}">
			이순신님 환영합니다.
		</c:when>
		<c:otherwise>
			else문장을 대신합니다.
		</c:otherwise>
	</c:choose>
	
	<hr>
	<!-- 20세 이상, 20미만을 choose문장으로 -->
	<c:choose>
		<c:when test="${param.age>=20 }">
			20세 이상
		</c:when>
		<c:otherwise>
			20세 미만
		</c:otherwise>
	</c:choose>
</body>
</html>