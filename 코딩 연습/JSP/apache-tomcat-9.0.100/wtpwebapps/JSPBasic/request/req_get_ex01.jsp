<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3>get방식</h3>
		
		<form action="req_get_ex02.jsp">
			날짜:<input type="date" name="date"><br>
			메시지:<textarea rows="5" cols="50" name="msg"></textarea><br>
			
			
			<!-- checkbox, radio 버튼이 실제로 가지는 값은 value -->
			동의항목:<br>
			<input type="checkbox" name="agree" value="조항1"> coding404의 말을 잘 듣겠습니다.
			<input type="checkbox" name="agree" value="조항2"> 하루에 적어도 1개의 코딩테스트 문제를 풀겠습니다.
			<input type="checkbox" name="agree" value="조항3"> coding404에게 말대답하지 않겠습니다
			
			<br>
			<input type="submit" value="get방식">
		</form>
</body>
</html>