<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<jsp:include page="include/link.html" />

<link rel="stylesheet" href="css/signup.css">
<script src="js/signup.js" defer></script>


</head>
<body>
	<div class='wrap'>
		<jsp:include page="include/header.html" />

		<div id="contents">
			<form method="post" action="index.jsp" name="signupForm" id='signupForm'>
				<div class='signup'>
					<div class="title">
						<h3>회원 가입</h3>
					</div>
					<div class="choice">
						<input type="radio" name="userType" id='userType1' value="user" hidden>
						<label for="userType1" class="userChoice choiceBtn">일반회원</label>
						
						<input type="radio" name="userType" id='userType2' value="admin" hidden>
						<label for="userType2" class="adminChoice choiceBtn">관리자</label>
					</div>

					<div class="user">
						<p class="main-text">이름</p>
						<input type="text" placeholder="이름" class="name" id='username' required>
						<p class='sub-text'>한글 이름 2~4자 이내, 영문 이름 2~10자 이내</p>
						<p class="error-text"></p>
					</div>

					<div class="userBirth">
						<p class="main-text">생년월일</p>
						<input type="date" id='birth' required>
						<!-- 생년월일 8자리 입력 받기 -->
					</div>

					<div class="gender">
						<p class="main-text">성별</p>
						<span class="left">
							<input type="radio" class="man" name='gender' value='M'>
							<span>남자</span>
						</span> 
						<span class="left">
							<input type="radio" class="woman" name='gender' value='F'>
							<span>여자</span>
						</span>
					</div>


					<div class="id">
						<p class="main-text">아이디</p>
						<div class='input-Wrap'>
							<input type="text" placeholder="아이디" id='userid' required>
							<button>중복확인</button>
						</div>
						<p class="sub-text">4~12자 / 영문 소문자(숫자 조합 가능)</p>
						<p class="error-text"></p>
					</div>

					<div class="pw">
						<p class="main-text">비밀번호</p>
						<input type="password" placeholder="비밀번호" class="password" id='userpw' required>
						<p class="error-text"></p>
						<input type="password" placeholder="비밀번호 확인" class="password_ok" id='userpwOk' required readonly>
						<p class="sub-text">6~20자 / 영문 대문자, 소문자, 숫자, 특수문자 사용 가능</p>
						<p class="error-text duple"></p>
					</div>

					<div class="email">
						<p class="main-text">이메일</p>
						<div class='input-Wrap'>
							<input type="text" placeholder="이메일" id='email' required>
							<p>@</p>
							<select id="domain" required>
								<option value="">직접 선택</option>
								<option value="naver.com">naver.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="daum.net">daum.net</option>
								<option value="yahoo.com">yahoo.com</option>								
								<option value="nate.com">nate.com</option>								
							</select>
						</div>
					</div>

					<div class="phone">
					<p class="main-text">휴대폰 번호</p>
						<input type="text" placeholder="휴대폰 번호" id='phone' required>
						<p class="error-text"></p>
					</div>

					<div class="ok">
						<button id='register' onclick="register()">가입하기</button>
					</div>
				</div>
			</form>
		</div>
		<!-- contents영역종료 -->

		<jsp:include page="include/footer.html" />

	</div>
</body>
</html>