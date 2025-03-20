var checkbox = document.querySelector('input[type=checkbox]');


checkbox.addEventListener('change',function(){
    var date = new Date();
    date.setDate(date.getDate()+1);
    date.setHours(9);
    date.setMinutes(0);
    date.setSeconds(0);
    if(checkbox.checked) {
        var cookie = "closePopup=true;expires="+date.toUTCString()
        document.cookie= cookie;
        window.close();
    }
})