var moreContent = document.querySelector(".title_bottom_content span");
var content = document.querySelector(".title_bottom_content p");
var replyButtons=document.querySelectorAll(".chat_info .reply");
var commentInput=document.querySelector(".comment .input-wrapper input");
var uploadButton = document.querySelector(".comment .upload");
var chatList = document.querySelector("#watchContents .chat ul");

/* swiper*/
var swiper4= new Swiper(".mySwiper4", {
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },

});



moreContent.onclick = function() {
    // 현재 높이 저장
    var startHeight = content.clientHeight;
    
    // 제한 해제
    content.style.webkitLineClamp = "inherit";
    content.style.height = "auto";
    
    // 전체 높이 계산
    var endHeight = content.clientHeight;
    
    // 원래 높이로 되돌린 후 애니메이션 준비
    content.style.height = startHeight + "px";
    content.style.overflow = "hidden";
    content.style.transition = "height 0.4s ease-out";
    
    // 다음 프레임에서 애니메이션 실행
    setTimeout(function() {
        content.style.height = endHeight + "px";
    }, 10);
    
    // 애니메이션 완료 후 정리
    content.addEventListener("transitionend", function handler() {
        content.style.height = "auto";
        content.removeEventListener("transitionend", handler);
    });
    
    // 더보기 버튼 숨기기
    moreContent.style.display = "none";
}




replyButtons.forEach(function(button) {
    button.addEventListener('click', function(e) {
        
        var userName = e.target.parentElement.querySelector("h6"). textContent;
        
        commentInput.value = "@" + userName + " ";
        
        commentInput.focus();
    });
});

chatList.onclick = function (e) {

    if (e.target.tagName != "SPAN") return;

    e.target.closest(".chat li").remove();
}
