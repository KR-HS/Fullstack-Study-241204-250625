var btn = document.querySelector('.writeCapsuleBtn');
var capsuleBox = document.querySelector('.capsuleBox');


btn.onclick=function(){
	window.location.href='writeCapsule.jsp';
}

capsuleBox.onclick=function(){
	//alert(event.target.closest('.capsule'));
	
	window.location.href='viewCapsule.jsp';
}