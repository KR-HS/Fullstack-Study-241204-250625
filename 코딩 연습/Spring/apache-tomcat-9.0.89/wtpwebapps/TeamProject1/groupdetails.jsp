<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <jsp:include page = "include/link.html" />
    <link rel="stylesheet" href="css/groupdetails.css">
    <script src="js/groupdetails.js" defer></script>
</head>
<body>
	<div class='wrap'>
	    <jsp:include page="include/header.html" />   
	    
	    <div id="contents">
	    	<div class='groupdetails'>	
		        <div class="box1">
		            <div class="first-floor">
		                <h6>그룹 멤버</h6>
		            </div>
		        </div>
		        <div class="box2">
		
		            <div class="group">
		        
		                <div class="groupmember">
		                    <span><img src="img/profile.jpg" alt="#" class="member1"></span>
		                    <span><img src="img/profile.jpg" alt="#" class="member2"></span>
		                    <span><img src="img/profile.jpg" alt="#" class="member3"></span>
		                    <span><img src="img/profile.jpg" alt="#" class="member4"></span>
		                    <span><img src="img/profile.jpg" alt="#" class="member5"></span>
		                    <!-- <div class="next">  <img src="img2/next.png" alt="#"></div> -->
		                </div>
		               
		            </div>
		           
		        </div>
		       	
		       	<div class='cardList'>
			        <div class="card">
			            <div class="first">
			            
			            </div>
			            <div class="second">
			                <p>제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목제목</p>
			                
			            </div>
			            <div class="third">
			                <div class="date">
			                    <span>남은시간 :</span>
			                    <span class="resttime">yyyy년MM월dd일</span>
			                </div>
			            </div>
			        </div>
			        
		        </div>
			</div>
		   
	    </div>
	    
	    <jsp:include page="include/footer.html"/>
	</div>
</body>
</html>