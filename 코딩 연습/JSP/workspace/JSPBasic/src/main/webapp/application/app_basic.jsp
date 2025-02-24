<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//applicaion은 session과 사용방법은 동일합니다.
	//단, 생명주기가 프로젝트를 시작할 때 1개 생성되고, 종료할 때 소멸됩니다.
	//그래서 application객체에는 프로그램 전역적으로 사용할 값을 저장할 수 있습니다
	int total = 0;
	
	//만약 app에 total이 있으면 값을 찾아와서 기존 값을 app의 total대체 
	if(application.getAttribute("total_count") != null) {
		total = (int)application.getAttribute("total_count");
	}
	application.setAttribute("menu", Arrays.asList("홈", "등록", "구매", "관리"));
	application.setAttribute("total_count", ++total);	
	
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="app_home.jsp">다음페이지로</a>
	
	<br>
	누적된 총계:<%=total %>
	
	
	
	
	
</body>
</html>