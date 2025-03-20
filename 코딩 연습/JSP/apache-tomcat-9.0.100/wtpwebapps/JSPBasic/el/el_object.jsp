<%@page import="com.hr.model.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	// 리퀘스트에 강제로 값 지정하기
	DepartmentDTO dto = new DepartmentDTO(100,"영업부",120,130);
	String name = "홍길동";

	request.setAttribute("dto",dto);
	request.setAttribute("name",name);

	
	
	//세션에 값 지정하기
	session.setAttribute("userId","abc123");
	
	
	// application객체에 값 지정
	application.setAttribute("menu","김밥");
	
	
	request.getRequestDispatcher("el_object_ok.jsp").forward(request,response);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>