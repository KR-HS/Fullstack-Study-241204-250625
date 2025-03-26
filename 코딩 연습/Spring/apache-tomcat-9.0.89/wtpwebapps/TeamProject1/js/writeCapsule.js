var fileInput = document.querySelector('#file');
var fileUploadLabel  = document.querySelector('.fileUpload');
var preView = document.querySelector('.preView');
var tagList = document.querySelector('.tagList');

tagList.addEventListener('change',function(){
    if(event.target.tagName!='INPUT') return;
    if(event.target.checked){
        if(event.target.nextElementSibling.tagName!='LABEL') return;
        event.target.nextElementSibling.style.backgroundColor='rgba(128,156,196,0.4)';
        event.target.nextElementSibling.style.color='white';
        
    }else{
        if(event.target.nextElementSibling.tagName!='LABEL') return;
        event.target.nextElementSibling.style.backgroundColor='white';
        event.target.nextElementSibling.style.color='#777';
        
    }
})
preView.onclick=function(){
    if(event.target.tagName!='IMG') return;

    // 이미지 제거
    var div = event.target.closest('.fileBox');
    div.remove();

    // form 데이터에서도 제거
    var fileIndex = Array.from(preView.children).indexOf(div);
    removedFiles.push(fileIndex);

}

fileInput.addEventListener('change',function(){
    var files = fileInput.files;
    if(files.length>5||preView.children.length+files.length>6){
        alert('사진은 5장까지만 업로드 가능합니다.');
        return;
    }
    for(var i in files){
        var file = files[i];
        if(file.type.startsWith('image/')){
            var reader = new FileReader();

            reader.onload = function(){
                var div = document.createElement('div');
                div.className='fileBox';
                var img = document.createElement('img');
                img.src=event.target.result;
                div.appendChild(img);
                preView.insertBefore(div,fileUploadLabel );
            }

            reader.readAsDataURL(file);
        }else{

            alert(file.name+'은 이미지 파일이 아닙니다.');
        }
    }
});