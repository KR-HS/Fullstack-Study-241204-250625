var userChoice = document.querySelector('.userChoice');
var adminChoice = document.querySelector('.adminChoice');



var username = document.getElementById('username');
var birth = document.getElementById('birth');
var userid = document.getElementById('userid');
var userpw = document.getElementById('userpw');
var userpwOk = document.getElementById('userpwOk');
var email = document.getElementById('email');
var domain = document.getElementById('domain');
var phone = document.getElementById('phone');

var reg_name = /^(?:[가-힣]{2,4}|[a-zA-Z]{2,10})$/; // 한글 이름 2~4자 이내, 영문 이름 2~10자 이내
var reg_id = /^[a-zA-Z0-9]{4,12}$/; //// 4~12자/영문 소문자(숫자 조합 가능)
var reg_pw =/^(?=.*[a-zA-Z0-9!@#$%^&*()_+={}\[\]:;"'<>,.?/\\|-]).{6,20}$/;
var reg_phone=/^(01[0-9])(\d{4})(\d{4})$/;


/* 유저 유형 선택 버튼 클릭시 디자인 변경*/
userChoice.addEventListener('click',function(){
	event.target.style.backgroundColor='#809CC4';
	event.target.style.color='white';
	

	adminChoice.style.backgroundColor='rgba(255, 255, 255, 0.5)';
	adminChoice.style.color='#777';
})

adminChoice.addEventListener('click',function(){
	event.target.style.backgroundColor='#809CC4';
	event.target.style.color='white';

	userChoice.style.backgroundColor='rgba(255, 255, 255, 0.5)';
	userChoice.style.color='#777';
})


/* 이름 형식 확인 */
username.addEventListener('input',function(){
	if(username.value.length==0){
		var text = document.querySelector('.user .error-text');
		text.innerHTML = "";
	}
	else if(!reg_name.test(username.value)){
			document.querySelector('.user .error-text').innerHTML='이름 형식이 일치하지않습니다.';
			document.querySelector('.user .error-text').style.color='red';
			return;
	}
	else{
		document.querySelector('.user .error-text').innerHTML='올바른 형식입니다.';
		document.querySelector('.user .error-text').style.color='green';
	}
})

/* 생년 월일 input태그 어디든 누르면 달력 열리게*/
birth.onclick=function(){
	this.showPicker();
}


/* 아이디 형식 확인 */
userid.addEventListener('input',function(){
	

	if(userid.value.length==0){
		var text = document.querySelector('.id .error-text');
		text.innerHTML = "";
	}
	else if(!reg_id.test(userid.value)){
		document.querySelector('.id .error-text').innerHTML='아이디 형식이 일치하지않습니다.';
		document.querySelector('.id .error-text').style.color='red';
		return;
	}
	else{
		document.querySelector('.id .error-text').innerHTML='올바른 형식입니다.';
		document.querySelector('.id .error-text').style.color='green';
	}
})

/* 패스워드 형식 확인 */
userpw.addEventListener('input',function(){
	

	if(userpw.value.length==0){
		var text = document.querySelector('.pw .error-text');
		text.innerHTML = "";
		userpwOk.value="";
		userpwOk.setAttribute('readonly',true);
		document.querySelector('.pw .error-text.duple').innerHTML="";
	}
	else if(!reg_pw.test(userpw.value)){
		document.querySelector('.pw .error-text').innerHTML='비밀번호 형식이 일치하지않습니다.';
		document.querySelector('.pw .error-text').style.color='red';
		userpwOk.value="";
		userpwOk.setAttribute('readonly',true);
		document.querySelector('.pw .error-text.duple').innerHTML="";
		return;
	}
	else{
		document.querySelector('.pw .error-text').innerHTML='올바른 형식입니다.';
		document.querySelector('.pw .error-text').style.color='green';
		userpwOk.removeAttribute('readonly');
	}
})

/* 패스워드 일치 확인 */
userpwOk.addEventListener('input',function(){
	if(this.value.length==0){
		var text = document.querySelector('.pw .error-text.duple');
		text.innerHTML = "";
	}
	else if(userpw.value!=this.value){
		document.querySelector('.pw .error-text.duple').innerHTML='비밀번호가 일치하지 않습니다.';
		document.querySelector('.pw .error-text.duple').style.color='red';
		return;
	}
	else{
		document.querySelector('.pw .error-text.duple').innerHTML='비밀번호가 일치합니다.';
		document.querySelector('.pw .error-text.duple').style.color='green';
	}
})

function getEmailPrefix(email) {
    var reg_email_prefix = /^[a-zA-Z0-9]+/;
    var result = email.match(reg_email_prefix);
    return result ? result[0] : null;
}

function getEmailDomain(email) {
    var reg_email_domain = /@([a-zA-Z0-9.-]+\.[a-zA-Z]{2,})$/;
    var result = email.match(reg_email_domain);
    return result ? result[1] : null;  // 첫 번째 캡처 그룹을 반환
}

/* 이메일 입력값처리 */
email.addEventListener('blur',function(){
	domain.value = getEmailDomain(this.value);
	this.value = getEmailPrefix(this.value)
	
})


/* 휴대폰 번호 입력값 변환 */
phone.addEventListener('input',function(){
	

	this.value = this.value.replaceAll("-","");
	
	if(this.value.length==0){
		var text = document.querySelector('.phone .error-text');
		text.innerHTML = "";
	}
	else if(!reg_phone.test(this.value)){
		document.querySelector('.phone .error-text').innerHTML='전화번호 형식이 일치하지않습니다.';
		document.querySelector('.phone .error-text').style.color='red';
	}
	else{
		document.querySelector('.phone .error-text').innerHTML='올바른 형식입니다.';
		document.querySelector('.phone .error-text').style.color='green';
	}
	
	
})


function register(){
	event.preventDefault();
	var userType = document.querySelector('input[name="userType"]:checked');
	var gender = document.querySelector('input[name="gender"]:checked');
	
	if(!userType){
		alert('회원유형을 선택하세요');
		document.querySelector('.choice').focus();
		return;
	}else if(!reg_name.test(username.value)){
		alert("이름을 확인해주세요");
		username.focus();
		return;
	}else if(!gender){
		alert('성별을 선택하세요');
		document.querySelector('.gender').focus();
		return;
	}else if(!reg_id.test(userid.value)){
		alert("아이디를 확인해주세요");
		userid.focus();
		return;
	}else if(!reg_pw.test(userpw.value)){
		alert("패스워드를 확인해주세요");
		userpw.focus();
		return;
	}else if(userpw.value!=userpwOk.value){
		alert('입력한 패스워드와 일치하지 않습니다');
		userpwOk.focus();
		return;
	}else if(!reg_phone.test(phone.value)){
		alert('전화번호를 확인해주세요');
		phone.focus();
		return;
	}else{
		/* form 제출코드 추가 */
		document.getElementById('signupForm').submit();
	}
	
}
