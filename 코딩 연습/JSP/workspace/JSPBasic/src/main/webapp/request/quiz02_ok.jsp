<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String sCm = request.getParameter("cm");
	String sKg = request.getParameter("kg");
	//bmi계산
	double cm = Double.parseDouble(sCm);
	double kg = Double.parseDouble(sKg);
	double bmi = kg / (cm / 100 *  cm / 100);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%=name %>님의 신장:<%=cm %>cm, 몸무게:<%=kg %><br>
	bmi지수:<%=bmi %><br>
	
	<% if(bmi >= 25) { %>
		<b>과체중입니다</b>
	<% } else if(bmi <= 18) { %>
		<b>저체중입니다</b>
	<% } else { %>
		<b>정상입니다</b>
	<% } %>
	
	
	
</body>
</html>