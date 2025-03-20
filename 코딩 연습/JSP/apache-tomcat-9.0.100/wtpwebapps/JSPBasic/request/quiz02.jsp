<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>비만 계산기 ^0^</h3>
	
<pre>
1. form태그를 이용해서 post형식으로 이름, 키와 몸무게를 입력받음
2. quiz02_ok.jsp로 전송
3. quiz02_ok.jsp페이지 에서는 넘어간 값을 BMI지수를 처리
4. BMI공식 = kg / (cm/100 * cm/100)  -> 문자열이기 때문에 형변환 진행(실수)
화면에 이름, 키, 몸무게 BMI지수를 출력
if을 통해 BMI지수가 25이상 과체중, 18 이하라면 저체중, 나머지는 정상으로 출력
</pre>

	<form action="quiz02_ok.jsp" method="post">
		
		이름:<input type="text" name="name"><br>
		신장:<input type="number" name="cm"><br>
		중량:<input type="number" name="kg"><br>
		
		<input type="submit" value="계산하기">
	</form>





	
	
</body>
</html>