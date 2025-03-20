var loginBtn = document.getElementById("loginBtn");

loginBtn.onclick = function () {
    var id = document.querySelector(".id").value;
    var pw = document.querySelector(".pw").value;


    if (id !=null && pw !=null) {
        sessionStorage.setItem('userId', id);
        sessionStorage.setItem('userPw', pw);

        window.location.href = 'home.jsp';
    } else {
        alert('아이디와 비밀번호를 입력해주세요.');
    }
}
