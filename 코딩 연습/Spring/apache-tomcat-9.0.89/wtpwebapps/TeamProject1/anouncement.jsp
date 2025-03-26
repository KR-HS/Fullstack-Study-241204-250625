<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <jsp:include page = "include/link.html" />
    <link rel="stylesheet" href="css/anouncement.css">
    <script src="js/anouncement.js" defer></script>
</head>
<body>
	<div class='wrap'>
	    <jsp:include page="include/header.html" />   
	    
	    <div id="contents">
	    	<div class='anouncement'>
		    	<p class='main-text'>공지사항</p>
		    	<div class="background">
			        <div class="cardbox">
			            <ul id="notice-list">
			                <!-- 공지사항 리스트 -->
			                <li>
			                	<div class="card">
			                		<p class="title">공지사항1</p>
			                		<span class="date">yyyy년MM월dd일</span>
			                	</div>
			                </li>
			               
			                
			                <!-- 더 많은 공지사항 추가 -->
			            </ul>
			            <div id="pagination"></div>
			        </div>
			    </div>
		    </div>
	   	</div>
	    
	    <jsp:include page="include/footer.html"/>
	</div>
</body>
</html>