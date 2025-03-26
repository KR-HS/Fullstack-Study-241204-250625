<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<jsp:include page="include/link.html" />

<link rel="stylesheet" href="css/home.css">
<script src="js/home.js" defer></script>
</head>
<body>
	<div class='wrap'>
		<jsp:include page="include/header.html" />

		<div id="contents">
			<div class="homepage">
				<section id="home">
					<h5>내 정보 🚀</h5>
					<div class="login flex">
						<figure>
							<img src="img2/ex.jpg" alt="home_login_img">
						</figure>
						<div class="homeLoginInfo">
							<p class="name">송택호</p>
							<div class="genderAndage">
								<span>남</span> <span>10세</span>
							</div>
							<div class="myGroup">
								<span style="padding-right: 20px;">내 그룹 <span
									class="myGroupNum">5</span></span> <span>문의 <span
									class="myGroupNum">12</span></span>
							</div>
						</div>
						<div class="myPageLink">
							<div class='myPagewrap'>
								<p>마이페이지</p>
								<span><img src="img2/next.png" alt=""></span>
							</div>
						</div>
					</div>
	
					<!-- 로그인 전 -->
					<div class="beforeLogin">
						<h3>로그인 하러가기</h3>
						<p>로그인하고 피움 서비스를 자유롭게 이용해보세요.</p>
					</div>
				</section>
	
	
	
	
				<section class="announcement">
					<h5>공지사항 📢</h5>
					<div class="swiper mySwiper2">
						<div class="swiper-wrapper flex">
							<div class="swiper-slide">
								<h2>[안내] 네이버웍스 경영지원 성과평가 서비스 베타 오픈</h2>
								<p>yyyy년 MM월 dd일</p>
							</div>
							<div class="swiper-slide">
								<h2>[사전 안내 2차] 상반기 Windows WORKS Drive탐색기 신규 업데이트 주요 변경 사항</h2>
								<p>yyyy년 MM월 dd일</p>
							</div>
							<div class="swiper-slide">
								<h2>[교육] 네이버웍스 클로바노트 사용자 무료 교육 안내ㅣ25년 2월 13일(목)</h2>
								<p>yyyy년 MM월 dd일</p>
							</div>
							<div class="swiper-slide">
								<h2>네이버웍스 경영지원 정기 업데이트 소식</h2>
								<p>yyyy년 MM월 dd일</p>
							</div>
						</div>
					</div>
	
				</section>
	
				<section class="CapsuleReveal">
					<h5>타입캡슐 ⌛</h5>
					<div class="swiper mySwiper3">
						<div class="swiper-wrapper">
							<div class="swiper-slide">
								<div class="group">
									<div class="groupinfo">
										<div class="groupCreator">
											<img src="img2/ex.jpg" alt="#">
											<p>rivermoon___</p>
										</div>
										<div class="groupDate">24.09.08 ~ 24.09.19</div>
									</div>
	
									<div class="groupmember">
										<span><img src="img2/ex.jpg" alt="#" class="member1"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member2"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member3"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member4"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member5"></span>
									</div>
									<div class="grouptag">
										<p>#활발</p>
										<p>#여름</p>
										<p>#카페</p>
										<p>#맑음</p>
									</div>
								</div>
							</div>
							<div class="swiper-slide">
								<div class="group">
									<div class="groupinfo">
										<div class="groupCreator">
											<img src="img2/ex.jpg" alt="#">
											<p>rivermoon___</p>
										</div>
										<div class="groupDate">24.09.08 ~ 24.09.19</div>
									</div>
	
									<div class="groupmember">
										<span><img src="img2/ex.jpg" alt="#" class="member1"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member2"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member3"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member4"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member5"></span>
									</div>
									<div class="grouptag">
										<p>#활발</p>
										<p>#여름</p>
										<p>#카페</p>
										<p>#맑음</p>
									</div>
								</div>
							</div>
							<div class="swiper-slide">
								<div class="group">
									<div class="groupinfo">
										<div class="groupCreator">
											<img src="img2/ex.jpg" alt="#">
											<p>rivermoon___</p>
										</div>
										<div class="groupDate">24.09.08 ~ 24.09.19</div>
									</div>
	
									<div class="groupmember">
										<span><img src="img2/ex.jpg" alt="#" class="member1"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member2"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member3"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member4"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member5"></span>
									</div>
									<div class="grouptag">
										<p>#활발</p>
										<p>#여름</p>
										<p>#카페</p>
										<p>#맑음</p>
									</div>
								</div>
							</div>
							<div class="swiper-slide">
								<div class="group">
									<div class="groupinfo">
										<div class="groupCreator">
											<img src="img2/ex.jpg" alt="#">
											<p>rivermoon___</p>
										</div>
										<div class="groupDate">24.09.08 ~ 24.09.19</div>
									</div>
	
									<div class="groupmember">
										<span><img src="img2/ex.jpg" alt="#" class="member1"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member2"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member3"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member4"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member5"></span>
									</div>
									<div class="grouptag">
										<p>#활발</p>
										<p>#여름</p>
										<p>#카페</p>
										<p>#맑음</p>
									</div>
								</div>
							</div>
							<div class="swiper-slide">
								<div class="group">
									<div class="groupinfo">
										<div class="groupCreator">
											<img src="img2/ex.jpg" alt="#">
											<p>rivermoon___</p>
										</div>
										<div class="groupDate">24.09.08 ~ 24.09.19</div>
									</div>
	
									<div class="groupmember">
										<span><img src="img2/ex.jpg" alt="#" class="member1"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member2"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member3"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member4"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member5"></span>
									</div>
									<div class="grouptag">
										<p>#활발</p>
										<p>#여름</p>
										<p>#카페</p>
										<p>#맑음</p>
									</div>
								</div>
							</div>
							<div class="swiper-slide">
								<div class="group">
									<div class="groupinfo">
										<div class="groupCreator">
											<img src="img2/ex.jpg" alt="#">
											<p>rivermoon___</p>
										</div>
										<div class="groupDate">24.09.08 ~ 24.09.19</div>
									</div>
	
									<div class="groupmember">
										<span><img src="img2/ex.jpg" alt="#" class="member1"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member2"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member3"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member4"></span>
										<span><img src="img2/ex.jpg" alt="#" class="member5"></span>
									</div>
									<div class="grouptag">
										<p>#활발</p>
										<p>#여름</p>
										<p>#카페</p>
										<p>#맑음</p>
									</div>
								</div>
							</div>
						</div>
						<div class="swiper-pagination" style="top: 3px;"></div>
					</div>
	
				</section>
	
				<section class="memory">
					<h5>추억을 함께한 사람 💫</h5>
					<div class="memoryList">
						<ul>
							<li><img src="img2/ex.jpg" alt="memoryImages">
								<p>김대영</p></li>
							<li><img src="img2/ex.jpg" alt="memoryImages">
								<p>김현수</p></li>
							<li><img src="img2/ex.jpg" alt="memoryImages">
								<p>김나연</p></li>
							<li><img src="img2/ex.jpg" alt="memoryImages">
								<p>송택호</p></li>
						</ul>
					</div>
	
					<div class="beforeLogin-memory">
						<img src="img/time.gif" alt="time">
						<p>로그인 하시고 많은 사람들과 추억을 공유하세요!</p>
					</div>
				</section>
	
				<section class="topViews">
					<h5>TOP 조회수 👀</h5>
					<div class="viewBox">
						<div class="image">
							<!-- <img src="/img/backgorund.jpg" alt="topViewsImg"> -->
						</div>
						<div class="viewInfo">
							<p>타임캡슐 제목</p>
							<div>
								<span><img src="img2/person.png" alt="personIcon"></span> <span
									style="font-size: 15px; color: var(--text-color);">8 / 15</span>
							</div>
	
						</div>
						<div class="viewIcon">
							<img src="img2/next.png" alt="viewNextIcon">
						</div>
					</div>
				</section>
			</div>
		</div>
		
		<jsp:include page="include/footer.html" />
	</div>
</body>
</html>