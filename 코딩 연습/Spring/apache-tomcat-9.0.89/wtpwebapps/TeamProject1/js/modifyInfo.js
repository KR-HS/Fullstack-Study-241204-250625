var username = document.getElementById('username');
var userpw = document.getElementById('userpw');
var newuserpw = document.getElementById('newuserpw');
var newuserpwOk = document.getElementById('newuserpwOk');


var reg_name = /^(?:[가-힣]{2,4}|[a-zA-Z]{2,10})$/; // 한글 이름 2~4자 이내, 영문 이름 2~10자 이내
var reg_pw =/^(?=.*[a-zA-Z0-9!@#$%^&*()_+={}\[\]:;"'<>,.?/\\|-]).{6,20}$/;


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

/* 기존 패스워드 형식 확인 */
userpw.addEventListener('input',function(){
	if(this.value.length==0){
		var text = document.querySelector('.pw .error-text');
		text.innerHTML = "";
	}
	else if(this.value!='aaa123'){
		document.querySelector('.pw .error-text').innerHTML='비밀번호가 일치하지 않습니다';
		document.querySelector('.pw .error-text').style.color='red';
		return;
	}
	else{
		document.querySelector('.pw .error-text').innerHTML='비밀번호가 일치합니다';
		document.querySelector('.pw .error-text').style.color='green';
	}
})


/* 새패스워드 형식 확인 */
newuserpw.addEventListener('input',function(){
	if(this.value.length==0){
		var text = document.querySelector('.pw .error-text.new');
		text.innerHTML = "";
		this.value="";
		newuserpwOk.setAttribute('readonly',true);
		document.querySelector('.pw .error-text.newduple').innerHTML="";
	}
	else if(!reg_pw.test(this.value)){
		document.querySelector('.pw .error-text.new').innerHTML='비밀번호 형식이 일치하지않습니다.';
		document.querySelector('.pw .error-text.new').style.color='red';
		newuserpwOk.value="";
		newuserpwOk.setAttribute('readonly',true);
		document.querySelector('.pw .error-text.newduple').innerHTML="";
		return;
	}
	else{
		document.querySelector('.pw .error-text.new').innerHTML='올바른 형식입니다.';
		document.querySelector('.pw .error-text.new').style.color='green';
		newuserpwOk.removeAttribute('readonly');
	}
})

/* 새패스워드 일치 확인 */
newuserpwOk.addEventListener('input',function(){
	if(this.value.length==0){
		var text = document.querySelector('.pw .error-text.newduple');
		text.innerHTML = "";
	}
	else if(newuserpw.value!=this.value){
		document.querySelector('.pw .error-text.newduple').innerHTML='비밀번호가 일치하지 않습니다.';
		document.querySelector('.pw .error-text.newduple').style.color='red';
		return;
	}
	else{
		document.querySelector('.pw .error-text.newduple').innerHTML='비밀번호가 일치합니다.';
		document.querySelector('.pw .error-text.newduple').style.color='green';
	}
})




function modify(){
	event.preventDefault();
	var userType = document.querySelector('input[name="userType"]:checked');
	var gender = document.querySelector('input[name="gender"]:checked');
	
	if(!reg_name.test(username.value)){
		alert("이름을 확인해주세요");
		username.focus();
		return;
	}else if(userpw.value!='aaa123'){
		alert("기존 비밀번호가 일치하지 않습니다")
		userpw.focus();
		return;
	}else if(!reg_pw.test(userpw.value)){
		alert("새로운 패스워드를 확인해주세요");
		newuserpw.focus();
		return;
	}else if(newuserpw.value!=newuserpwOk.value){
		alert('입력한 패스워드와 일치하지 않습니다');
		newuserpwOk.focus();
		return;
	}else{
		/* form 제출코드 추가 */
		document.getElementById('modifyForm').submit();
	}
	
}
