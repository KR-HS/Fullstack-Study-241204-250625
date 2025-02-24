<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] arr = request.getCookies();	
	
	String userId = null;
	if(arr != null) {
		for(Cookie c : arr) {
			if(c.getName().equals("userId") ) {
				userId = c.getValue();
			}
		}
	}
	//여기에서 쿠키가 없으면? 로그인을 안했다는 의미
	if(userId == null) {
		response.sendRedirect("cookie_ex01.jsp");
	}
	
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%=userId %>님 환영합니다~! 
	
	
</body>
</html>