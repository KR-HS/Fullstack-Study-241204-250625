var menubar = document.querySelector('.menubar');
var menu = document.querySelector('.menu');
var closing = document.querySelector('.closed');
var html = document.querySelector('html');

var logo = document.querySelector('.logo');
var mygroupIcon = document.querySelector('.menuIcon.mygroupIcon');
var homeIcon = document.querySelector('.menuIcon.homeIcon');
var mypageIcon = document.querySelector('.menuIcon.mypageIcon');
var consultIcon = document.querySelector('.menuIcon.consultIcon');
var myConsultIcon = document.querySelector('.menuIcon.myConsultIcon');
var anounceIcon = document.querySelector('.menuIcon.anounceIcon');
var alterInfo = document.querySelector('.alterInfo');

// 로고 홈으로 이동
logo.onclick=function(){
	event.preventDefault();
	window.location.href="home.jsp";
}


// 프로필 편집
alterInfo.onclick=function(){
	event.preventDefault();
	window.location.href='modifyInfo.jsp';
}


// 메뉴버튼 링크
mygroupIcon.onclick=function(){
	window.location.href='mygroup.jsp';
}

homeIcon.onclick=function(){
	window.location.href='home.jsp';
}

mypageIcon.onclick=function(){
	window.location.href='mypage.jsp';
}

consultIcon.onclick=function(){
	window.location.href='inquiry.jsp';
}

myConsultIcon.onclick=function(){
	window.location.href='myInquiry.jsp';
}

anounceIcon.onclick=function(){
	window.location.href='anouncement.jsp';
}


// 메뉴 열기
menubar.addEventListener('click', function () {
	  // event.preventDefault();
    menu.classList.add('show');
    html.style.overflowY='hidden';
});

// 메뉴 닫기
closing.onclick = function () {
	event.preventDefault();
    menu.classList.remove('show');
    html.style.overflowY='auto';
}

var swiper = new Swiper(".mySwiper", {
    // direction: "vertical",
    loop: true,
    speed:1000,
    slidesPerView: 1,
    autoplay: {
      delay: 2500,
      disableOnInteraction: false,

    },


});

var swiper2 = new Swiper(".mySwiper2", {
    direction: "vertical",
    loop: true,
    speed:1000,
    slidesPerView: 1,
    autoplay: {
      delay: 2500,
      disableOnInteraction: false,

    },
});
