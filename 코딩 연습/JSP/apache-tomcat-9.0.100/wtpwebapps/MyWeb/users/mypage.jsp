<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<div id="container">
	<!-- location_area -->
	<div class="location_area member">
		<div class="box_inner">
			<h2 class="tit_page">
				TOURIST <span class="in">in</span> TOUR
			</h2>
			<p class="location">
				MYPAGE <span class="path">/</span> 개인 정보 수정
			</p>
			<ul class="page_menu clear">
				<li><a href="#" class="on">개인 정보 수정</a></li>
			</ul>
		</div>
	</div>
	<!-- //location_area -->

	<!-- bodytext_area -->
	<div class="bodytext_area box_inner">
		<!-- myinfo -->
		<dl class="myinfo">
			<dt>내 정보</dt>
			<dd>
				<!-- appForm -->
				<form action="modifyform.users" method="post" class="regForm">
					<fieldset>
						<legend>내정보 입력 양식</legend>
						<ul class="reg_list">
							<li class="clear"><span class="tit_lbl">이름</span>
								<div class="reg_content" style="padding-top: 8px;">
									<input type="text" class="w70p" placeholder="이름" name="name"
										required value="${sessionScope.userDTO.name }" />
								</div></li>
							<li class="clear"><span class="tit_lbl">성별</span>
								<div class="reg_content radio_area">
									<input type="radio" class="css-radio" id="mmm_lbl"
										name="gender" value='M'
										${sessionScope.userDTO.gender=='M'?'checked':'' }><label
										for="mmm_lbl">남</label> <input type="radio" class="css-radio"
										id="www_lbl" name="gender" value='F'
										${sessionScope.userDTO.gender=='F'?'checked':'' }><label
										for="www_lbl">여</label>
								</div></li>
							<!-- 
								<li class="clear">
									<span class="tit_lbl">주소</span>
									<div class="reg_content" style="padding-top:8px;"><input type="text" class="w70p" placeholder="서울시"/></div>
								</li>
								 -->
							<li class="clear"><span class="tit_lbl">핸드폰</span>
								<div class="reg_content" style="padding-top: 8px;">
									<input type="text" class="w70p" placeholder="010-0000-0000"
										name="phone" value="${sessionScope.userDTO.getPhone()}"
										pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" />
								</div></li>
							<li class="clear"><span class="tit_lbl">SMS 수신동의</span>
								<div class="reg_content radio_area">
									<input type="radio" class="css-radio" id="smsyes_lbl"
										name="snsYn" value='Y'
										${sessionScope.userDTO.snsYn=='Y'?'checked':'' }><label
										for="smsyes_lbl">허용</label> <input type="radio"
										class="css-radio" id="smsno_lbl" name="snsYn" value='N'
										${sessionScope.userDTO.snsYn=='N'?'checked':'' }><label
										for="smsno_lbl">거부</label>
									<p class="info_line">(고객님의 편의를 위해 알림, 공지사항, 이벤트 등의 내용을
										제공하고자 합니다.)</p>
								</div></li>
							<li class="clear">
								<span class="tit_lbl">이메일</span>
								<div class="reg_content">${sessionScope.userDTO.email}
								<a href="delete.users" style="color:red;">회원탈퇴</a>
								</div>
							</li>
								
							<!-- 
								<li class="clear">
								<span class="tit_lbl">이메일 수신동의</span>
									<div class="reg_content radio_area">
										<input type="radio" class="css-radio" id="emailyes_lbl" name="emailyesno" checked><label for="emailyes_lbl">허용</label>
											<input type="radio" class="css-radio" id="emailno_lbl" name="emailyesno"><label for="emailno_lbl">거부</label>
										<p class="info_line">(고객님의 편의를 위해 알림, 공지사항, 이벤트 등의 내용을 제공하고자 합니다.)</p>
									</div>
								</li>
								 -->
						</ul>
						<p class="btn_line">
							<input type="submit" class="btn_baseColor" value="변경하기">
						</p>
						<p>${msg}</p>
					</fieldset>
				</form>
				<!-- //appForm -->
			</dd>
		</dl>
		<!-- //myinfo -->

	</div>
	<!-- //bodytext_area -->

</div>
<!-- //container -->

<%@ include file="../include/footer.jsp"%>







