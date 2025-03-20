var myInquiryLink = document.querySelector('.mypage .myinquiryLink');
var inquiryLink = document.querySelector('.mypage .inquiryLink');
var modifyLilnk = document.querySelector('.mypage .modifyLink');
var mygroupLink = document.querySelector('.mypage .mygroupLink');
var myCapsuleLink = document.querySelector('.mypage .myCapsuleLink');
var logoutLink = document.querySelector('.mypage .logoutLink');
var mygroups = document.querySelector('.mypage .mygroups');
var mycapsule = document.querySelector('.mypage .mycapsule');


/* 단순 페이지 이동 링크*/
myInquiryLink.onclick=function(){
	event.preventDefault();
	window.location.href='myInquiry.jsp';
}

inquiryLink.onclick=function(){
	event.preventDefault();
	window.location.href='inquiry.jsp';
}

modifyLilnk.onclick=function(){
	event.preventDefault();
	window.location.href='modifyInfo.jsp';
}

mygroupLink.onclick=function(){
	event.preventDefault();
	window.location.href='mygroup.jsp';
}

myCapsuleLink.onclick=function(){
	event.preventDefault();
	window.location.href='capsuleList.jsp';
}

logoutLink.onclick=function(){
	event.preventDefault();
	
	window.location.href='home.jsp';
}


/* 컨텐츠,그룹 클릭시 상세보기  */
mygroups.onclick=function(){
	console.log(event.target.closest('.group'))
	window.location.href='groupdetails.jsp';
}

mycapsule.onclick=function(){
	console.log(event.target.closest('.capsule'))
	window.location.href='viewCapsule.jsp';
}