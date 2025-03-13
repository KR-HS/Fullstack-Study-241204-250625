
        var menubar = document.querySelector('.menubar');
        var menu = document.querySelector('.menu');
        var closing = document.querySelector('.closed');
        var html = document.querySelector('html');
        // 메뉴 열기
        menubar.addEventListener('click', function () {
            menu.classList.add('show');
            html.style.overflowY='hidden';
        });
        
        // 메뉴 닫기
        closing.onclick = function () {
            menu.classList.remove('show');
            html.style.overflowY='auto';
        }
