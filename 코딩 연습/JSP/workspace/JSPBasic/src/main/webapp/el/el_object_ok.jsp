<%@page import="com.hr.model.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	
	//DepartmentDTO dto = (DepartmentDTO)request.getAttribute("dto");
	//String name = (String)request.getAttribute("name");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>scope키워드는 전부 생략이 가능</h3>
	<!-- request > session > application 순서로 참조 -->	
	${requestScope.dto}<br>
	${requestScope.dto.departmentId }<br>
	${dto.departmentName }<br>
	${dto.managerId }<br>
	${dto.locationId }<br>
	${name }
	
	${sessionScope.userId }<br>
	${applicationScope.menu }<br>
</body>
</html>