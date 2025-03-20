<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <jsp:include page = "include/link.html" />
    <link rel="stylesheet" href="css/myInquiry.css">
</head>
<body>
	<div class='wrap'>
	    <jsp:include page="include/header.html" />   
	    
	    <div id="contents">
	    	<div class='myInquiry'>
		    	<h3>문의 내역</h3>
		        <div class="card">
		            <div class="first">
		                <p class="date">yyyy년MM월dd일</p>
		            </div>
		            <div class="second">
		                <a class="title">제목aaaaaaaaaaaaaaaaaaaaaaaa</a>
		                <span class="status">답변상태</span>
		            </div>
		            <div class="third">
		                <button class="bbtn">상세보기</button>
		            </div>
		        </div>
		
		        <div class="card">
		            <div class="first">
		                <p class="date">yyyy년MM월dd일</p>
		            </div>
		            <div class="second">
		                <a class="title">제목</a>
		                <span class="status">답변상태</span>
		            </div>
		            <div class="third">
		                <button class="bbtn">상세보기</button>
		            </div>
		        </div>
	        </div>
	    </div>
	    
	    <jsp:include page="include/footer.html"/>
	</div>
</body>
</html>