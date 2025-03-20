var myInquiryLink = document.querySelector('.mypage .myinquiryLink');
var inquiryLink = document.querySelector('.mypage .inquiryLink');
var modifyLilnk = document.querySelector('.mypage .modifyLink');
var mygroupLink = document.querySelector('.mypage .mygroupLink');
var myCapsuleLink = document.querySelector('.mypage .myCapsuleLink');

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