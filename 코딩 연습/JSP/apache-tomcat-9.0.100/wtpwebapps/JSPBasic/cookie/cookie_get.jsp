<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//쿠키를 찾아쓰는방법
	//쿠키는 매 요청마다 request에 담겨서 넘어옵니다.
	
	Cookie[] cookies = request.getCookies();
	//쿠키가 브라우저에 없으면 null이 됩니다.
	if(cookies != null) {
		
		for(Cookie coo : cookies ) {
			
			String cooName = coo.getName(); //쿠키의 이름을 얻는다
			if(cooName.equals("user_id")) {
				String cooValue = coo.getValue();
				out.println("user_id쿠키의 값:" + cooValue);
			}
		}
	}


	

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