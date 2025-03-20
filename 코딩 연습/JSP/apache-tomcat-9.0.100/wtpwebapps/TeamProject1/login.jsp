<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<jsp:include page="include/link.html" />

<link rel='stylesheet' href='css/login.css'>
<script src='js/login.js' defer></script>
</head>
<body>
	<div class='wrap'>
		<jsp:include page="include/header.html" />

		<div id="contents">
			<div class="login">
				<div class="login-title">
					<h2>
						안녕하세요 :)<br> 피움입니다.
					</h2>
					<p>sns계정으로 로그인이 가능합니다.</p>
				</div>

				<div class="doLogin">
					<input type="text" placeholder="아이디 입력" name="id" class="id">
					<input type="password" placeholder="비밀번호 입력" name="pw" class="pw">
					<button type="button" id="loginBtn">로그인</button>

					<div class="search-id">
						<ul>
							<li><a href="#">아이디 찾기</a></li>
							<li><a href="#">비밀번호 찾기</a></li>
							<li><a href="#">회원 가입</a></li>
						</ul>
					</div>
				</div>

				<div class="sns">
					<p>SNS 계정으로 로그인</p>
					<ul>
						<li><a href="#"><img src="/img/kakao.png" alt=""></a></li>
						<li><a href="#"><img src="/img/facebook.png" alt=""></a></li>
						<li><a href="#"><img src="/img/naver.png" alt=""></a></li>
						<li><a href="#"><img src="/img/google.jpg" alt=""></a></li>
						<li><a href="#"><img src="/img/apple.jpg" alt=""></a></li>
					</ul>
				</div>

			</div>
		</div>

		<jsp:include page="include/footer.html" />
	</div>
</body>
</html>