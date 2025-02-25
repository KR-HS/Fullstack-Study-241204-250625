<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ include file="../include/header.jsp" %>
	
	
	
	<!-- 
	required  - 필수값
	pattern - 정규표현식 유효성검사
	
	checked - 체크박스의 값을 미리 체크
	selected -  셀렉트태그의 값을 미리 선택
	readonly - 인풋태그의 읽기만 허용
	disabled - 인풋태그의 사용 금지
	
	 -->
	
	
	<div id="container">
		<!-- location_area -->
		<div class="location_area member">
			<div class="box_inner">
				<h2 class="tit_page">TOURIST <span class="in">in</span> TOUR</h2>
				<p class="location">MEMBER <span class="path">/</span> 회원가입</p>
				<ul class="page_menu clear">
					<li><a href="javascript:;" class="on">회원가입</a></li>
				</ul>
			</div>
		</div>	
		<!-- //location_area -->

		<!-- bodytext_area -->
		<div class="bodytext_area box_inner">
			<!-- appForm -->
			<form action="joinForm.users" method ="post" class="appForm">
				<fieldset>
					<legend>상담문의 입력 양식</legend>
					<p class="info_pilsoo pilsoo_item">필수입력</p>
					<ul class="app_list">
						<li class="clear">
                            <label for="email_lbl" class="tit_lbl pilsoo_item">이메일</label>
                            <div class="app_content email_area">
                                <input type="text" class="w160" id="email_lbl" title="이메일 주소" name="email_prev" required>
                                <span class="ico_space">@</span>
                                <input type="text" class="w160" id="email_next" title="이메일 제공업체 입력" name="email_next"/>										
                                <div class="select_common">
                                    <select title="이메일 제공업체 목록" id="select_email" >
                                        <option value="">직접입력</option>
                                        <option value="naver.com">naver.com</option>
                                        <option value="hanmail.net">hanmail.net</option>
                                    </select>
                                </div>	
                               	<span class="ico_space" style="color:red;">${msg}</span>				
                            </div>
						</li>
						<li class="clear">
							<label for="name_lbl" class="tit_lbl pilsoo_item">작성자명</label>
							<div class="app_content"><input type="text" class="w100p" id="name_lbl" name="name" placeholder="이름을 입력해주세요" required/></div>
						</li>
						<li class="clear">
							<label for="pwd_lbl" class="tit_lbl pilsoo_item">비밀번호</label>
							<div class="app_content"><input type="password" class="w100p" id="pwd_lbl" name="pw" placeholder="비밀번호를 입력해주세요" required/></div>
						</li>

						<!--
						<li class="clear">
							<label for="pwd2_lbl" class="tit_lbl pilsoo_item">비밀번호 확인</label>
							<div class="app_content"><input type="password" class="w100p" id="pwd2_lbl" placeholder="비밀번호를 다시 한번 입력해주세요"/></div>
						</li>
						 -->
						 
						<li class="clear">
							<label for="phone_lbl" class="tit_lbl pilsoo_item">연락처</label>
							<div class="app_content"><input type="tel" class="w100p" id="phone_lbl" name="phone" placeholder="휴대폰 번호를 입력하세요" required pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"/></div>
						</li>
						<li class="clear">
							<span class="tit_lbl">성별</span>
							<div class="app_content radio_area">
								<input type="radio" class="css-radio" id="mmm_lbl" name="gender" value="M" checked><label for="mmm_lbl">남</label>
								<input type="radio" class="css-radio" id="www_lbl" name="gender" value="F"><label for="www_lbl">여</label>
							</div>
						</li>
						<li class="clear">
                            <span class="tit_lbl">SNS 수신동의</span>
							<div class="app_content checkbox_area">
								<input type="checkbox" class="css-checkbox" id="agree_lbl" name="sns_yn" value="Y" checked><label for="agree_lbl">동의함</label>
							</div>
						</li>
						<!-- 
						<li class="clear">
                            <span class="tit_lbl">이메일 수신동의</span>
							<div class="app_content checkbox_area">
								<input type="checkbox" class="css-checkbox" id="agree_lb2" name="agree2"><label for="agree_lb2">동의함</label>
							</div>
						</li>
						 
						<li class="clear">
							<label for="content_lbl" class="tit_lbl">문의내용</label>
							<div class="app_content">
								<textarea id="content_lbl" class="w100p" placeholder="간단한 상담 요청 사항을 남겨주시면 보다 상세한 상담이 가능합니다.
	전화 상담 희망시 기재 부탁드립니다."></textarea>
							</div>
						</li>
						-->
					</ul>
					<p class="btn_line"><input type="submit" class="btn_baseColor" value="등록"></p>	
				</fieldset>
			</form>
			<!-- //appForm -->
			
		</div>
		<!-- //bodytext_area -->

	</div>
	<!-- //container -->

	<%@ include file="../include/footer.jsp" %>


	<script>
		var emailNext = document.getElementById("email_next");
		var selectEmail = document.getElementById("select_email");
		selectEmail.addEventListener('change' ,function() {
			emailNext.value = selectEmail.value;
		})
	</script>