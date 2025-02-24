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
	<!-- 변수의 선언 -->
	<c:set var="a" value="홍길동" />
	<!-- 변수의 출력 -->
	<c:out value="${a }"/>
	
	
	<c:if test="true">
		<b>무조건 실행되는 문장</b>
	</c:if>

	<c:if test="${param.name eq '홍길동' }" >
		참 입니다.
	</c:if>
	
	<c:if test="${param.age >=20 }">
	 	성인 입니다.
	</c:if>
	<c:if test="${param.age<20 }">
		미성년자 입니다.
	</c:if>
</body>
</html>