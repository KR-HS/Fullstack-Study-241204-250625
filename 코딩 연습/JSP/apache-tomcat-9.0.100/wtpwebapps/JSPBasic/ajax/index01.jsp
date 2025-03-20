<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<button type="button" onclick="get()">ajax get요청</button>
	<button type="button" onclick="post()">ajax post요청</button>
	
	
	<script>
		function get() {
			
			fetch("test.ajax?name=홍길동&age=20")
			.then(function(response) {
				return response.json(); //text()
			})
			.then(function(data) {
				console.log(data);
			})
			
		}
	
		function post() {
			fetch("example.ajax", {
				method : "post",
				headers : {
					//'Content-Type': "application/json" //제이슨형식
					'Content-type': 'application/x-www-form-urlencoded'
				},
				body: "id=aaa123&name=이순신"
			})
			.then(function(response) {
				return response.json();
			})
			.then(function(data) {
				console.log(data);
			})
			
		}
		
		
	</script>
	
	
</body>
</html>