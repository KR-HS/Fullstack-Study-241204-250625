
        var menubar = document.querySelector('.menubar');
        var menu = document.querySelector('.menu');
        var closing = document.querySelector('.closed');
        var html = document.querySelector('html');
        // 메뉴 열기
        menubar.addEventListener('click', function () {
            event.preventDefault(); // a태그 기능 삭제
            menu.classList.toggle('show'); //class에 'show'가 있으면 삭제, 없으면 추가 하는 함수 - toggle
            html.style.overflowY='hidden';
        });
        
        // 메뉴 닫기
        closing.addEventListener('click',function(){
            // event.preventDefault(); // a태그 기능 삭제
            menu.classList.toggle('show');
            html.style.overflowY='auto';
        });
