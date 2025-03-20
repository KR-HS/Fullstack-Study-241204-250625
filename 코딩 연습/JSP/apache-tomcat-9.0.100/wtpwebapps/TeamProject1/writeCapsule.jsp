<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
    <meta name="viewport" content="width=400, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Document</title>


    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<jsp:include page = "include/link.html" />
   
    <link rel="stylesheet" href="css/writeCapsule.css">
    <script src="js/writeCapsule.js" defer></script>
    
</head>
<body>
<div class='wrap'>
    <jsp:include page="include/header.html" />

    <div id="contents">
        <div class="write">
            <form action="#">
                <div class="line"><input type="text" id='title' name="title" placeholder="제목"></div>
                <div class="line"><textarea name="content" id="content" maxlength="1000" placeholder="내용을 적으세요."></textarea></div>
                <p class="context">태그</p>
                <div class="tagList">
                    <div class="tag">
                        <input type="checkbox" name="tags" id="tag1" value="1">
                        <label for="tag1" class="radio-btn">태그1</label>
                    </div>
                    <div class="tag">
                        <input type="checkbox" name="tags" id="tag2" value="12">
                        <label for="tag2" class="radio-btn">태그12222</label>
                    </div>
                    <div class="tag">
                        <input type="checkbox" name="tags" id="tag3" value="13">
                        <label for="tag3" class="radio-btn">태그12222</label>
                    </div>
                    <div class="tag">
                        <input type="checkbox" name="tags" id="tag4" value="14">
                        <label for="tag4" class="radio-btn">태그12222</label>
                    </div>
                    <div class="tag">
                        <input type="checkbox" name="tags" id="tag5" value="15">
                        <label for="tag5" class="radio-btn">태그12222</label>
                    </div>
                    <div class="tag">
                        <input type="checkbox" name="tags" id="tag6" value="16">
                        <label for="tag6" class="radio-btn">태그12222</label>
                    </div>
                    <div class="tag">
                        <input type="checkbox" name="tags" id="tag7" value="17">
                        <label for="tag7" class="radio-btn">태그12222</label>
                    </div>
                    <div class="tag">
                        <input type="checkbox" name="tags" id="tag8" value="18">
                        <label for="tag8" class="radio-btn">태그12222</label>
                    </div>
                </div>
                <p class="context">추억 담기</p>
                <div class="line preViewWrap">
                    <input type="file" id="file" accept="image/*" multiple>
                    <div class="preView">
                        <label for="file" class="fileUpload fileBox">+</label>
                    </div>
                </div>
                <div class="line submit">
                    <button type="submit" class="submitBtn">작성하기</b>
                </div>
            </form>
        </div>
	    <jsp:include page="include/footer.html" />
    </div>
</div>

</body>

</html>
