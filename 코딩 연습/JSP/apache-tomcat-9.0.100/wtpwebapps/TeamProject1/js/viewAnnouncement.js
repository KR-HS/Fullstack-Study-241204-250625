var home=document.querySelector(".homeBtn");
var back=document.querySelector(".submitBtn");

home.addEventListener('click',function(){
    window.location.href = 'home.jsp';
})


back.addEventListener('click',function(){
    window.location.href = 'anouncement.jsp';
})

