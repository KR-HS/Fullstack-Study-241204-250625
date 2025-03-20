<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <jsp:include page = "include/link.html" />
    <link rel="stylesheet" href="css/inquiry.css">
</head>
<body>
	<div class='wrap'>
	    <jsp:include page="include/header.html" />   
	    
	    <div id="contents">
	    	<div class='inquiry'>
	    		<p class='main-text'>문의하기</p>
		    	<div class="background">
			        <p class="inquiry-title">문의제목</p>
			        <div class="title-box">
			        	<input type="text" class="title">
			        </div>
			        <p class="inquiry-detail">문의내용</p>
			        <div class="detail-box">
			        	<textarea name="" class="detail" ></textarea>
			        </div>
			        <button class="bbtn">작성완료</button>
		        </div>
		    </div>
	    </div>
	    <jsp:include page="include/footer.html"/>
	</div>
</body>
</html>