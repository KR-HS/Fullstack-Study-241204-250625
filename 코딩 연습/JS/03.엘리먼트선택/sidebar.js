
var menuBtn = document.querySelector(".menuBtn");
var sidenav = document.querySelector('.sidenav');

menuBtn.addEventListener('click',function(){
    var width= sidenav.style.width;
    // if(width=='0px'||width=='') sidenav.style.width='200px';
    // else sidenav.style.width='0px';

    if(window.innerWidth<=767){ // 모바일사이즈

        if(width=='0px'||width==''){
            sidenav.style.width='100%';
        }
        else{
            sidenav.style.width='0px';
        }
    }else{ // 브라우저 사이즈
        if(width=='0px') sidenav.style.width='200px';
        else sidenav.style.width='0px';
    }
})