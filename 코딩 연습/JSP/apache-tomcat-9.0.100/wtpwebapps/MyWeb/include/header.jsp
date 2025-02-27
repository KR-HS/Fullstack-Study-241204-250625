<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<title> 투어리스트인투어 </title>
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/swiper.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/js/rollmain.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.easing.js"></script>	
<script src="${pageContext.request.contextPath}/js/common.js"></script>  
<script src="${pageContext.request.contextPath}/js/jquery.smooth-scroll.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/swiper.min.js"></script>


<!-- 데이트피커 -->
<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>




</head>
<body>

<!-- wrap -->
<div id="wrap">

	<header id="header">
		<div class="header_area box_inner clear">	
			<h1><a href="${pageContext.request.contextPath}/index.jsp">Tourist in tour</a></h1>
			<p class="openMOgnb"><a href="#"><b class="hdd">메뉴열기</b> <span></span><span></span><span></span></a></p>
			<!-- header_cont -->
			<div class="header_cont">
				<ul class="util clear">
					<c:choose>
						<c:when test="${sessionScope.userDTO==null }">
							<li><a href="${pageContext.request.contextPath }/users/login.users">로그인</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath }/users/mypage.users">마이페이지</a></li>
						</c:otherwise>
					</c:choose>
					<li><a href="${pageContext.request.contextPath }/users/join.users">회원가입</a></li>
					
				</ul>	
				<nav>
				<ul class="gnb clear">
					<li><a href="javascript:;" class="openAll1">여행정보</a>

                        <div class="gnb_depth gnb_depth2_1">
                            <ul class="submenu_list">
                                <li><a href="javascript:;">국내</a></li>
                                <li><a href="javascript:;">해외</a></li>
                            </ul>
                        </div>
					</li>
					<li><a href="javascript:;" class="openAll2">고객센터</a>
				        <div class="gnb_depth gnb_depth2_2">
                            <ul class="submenu_list">
                                <li><a href="${pageContext.request.contextPath }/notice/list.board">문의내역보기</a></li>
                                <li><a href="${pageContext.request.contextPath }/notice/regist.board">문의하기</a></li>
                            </ul>
                        </div>
					</li>
					<li><a href="javascript:;" class="openAll3">상품투어</a>
                        <div class="gnb_depth gnb_depth2_3">
                            <ul class="submenu_list">
                                <li><a href="javascript:;">프로그램 소개</a></li>
                                <li><a href="javascript:;">여행자료</a></li>
                            </ul>
                        </div>
					</li>
					<li><a href="javascript:;" class="openAll4">티켓/가이드</a>
                        <div class="gnb_depth gnb_depth2_4">
                            <ul class="submenu_list">
                                <li><a href="javascript:;">항공</a></li>
                                <li><a href="javascript:;">호텔</a></li>
                            </ul>
                        </div>
					</li>
				</ul>
                </nav>
				<p class="closePop"><a href="javascript:;">닫기</a></p>
			</div>
			<!-- //header_cont -->
		</div>
	</header>