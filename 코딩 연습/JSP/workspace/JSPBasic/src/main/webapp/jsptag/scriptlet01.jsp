<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% 
	//모든 자바코드가 들어갈 수 있음~
	int a = 1;
	if(a >= 10) {
		out.println("참");
	} else {
		out.println("거짓");
	}
	%>
	
	<hr>
	
	<%
	if(a >= 10) {
		out.println("<b>참</b>");
	} else {
		out.println("<b>거짓</b>");
	}
	%>
	
	<hr>
	
	<% if(a >= 10) { %>
	<a href="#">참</a>
	<% } else { %>
	<a href="#">거짓</a>
	<% } %>
	
	<hr>
	
	<%--
	jsp주석 
	<% for(int i = 1; i <= 20; i++) { %>
		<input type="checkbox" name="num">박스<%=i %>
	<% } %>
	
 	--%>	
	
	<!-- 
	html주석
	 -->
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>