<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션이 없다는 것은 로그인이 안되어있다는 의미
	if(session.getAttribute("user_id") == null ) {
		response.sendRedirect("login.jsp");
	}
	//세션을 얻음
	String userId = (String)session.getAttribute("user_id");


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%=userId %>님이 로그인 중입니다
	
	[<a href="logout.jsp">로그아웃</a>]
	
	
</body>
</html>