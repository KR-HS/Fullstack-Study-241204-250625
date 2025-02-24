<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
	
	<div id="container">
		<!-- location_area -->
		<div class="location_area customer">
			<div class="box_inner">
				<h2 class="tit_page">TOURIST <span class="in">in</span> TOUR</h2>
				<p class="location">고객센터 <span class="path">/</span> 공지사항</p>
				<ul class="page_menu clear">
					<li><a href="#" class="on">공지사항</a></li>
					<li><a href="#">문의하기</a></li>
				</ul>
			</div>
		</div>	
		<!-- //location_area -->

		<!-- bodytext_area -->
		<div class="bodytext_area box_inner">
			<form action="#" class="minisrch_form">
				
				<fieldset>
					<select name="###" style="height: 35px;">
						<option value="#">제목</option>
						<option value="#">내용</option>
						<option value="#">작성자</option>
						<option value="#">제목+내용</option>
					</select>
					<legend>검색</legend>
					<input type="text" class="tbox" title="검색어를 입력해주세요" placeholder="검색어를 입력해주세요">
					<a href="javascript:;" class="btn_srch">검색</a>
				</fieldset>
			</form>
			<table class="bbsListTbl" summary="번호,제목,조회수,작성일 등을 제공하는 표">
				<caption class="hdd">공지사항  목록</caption>
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">조회수</th>
						<th scope="col">작성일</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td class="tit_notice"><a href="javascript:;">이번 여름 휴가 제주 갈까? 미션 투어 (여행경비 50만원 지원)</a> </td>
						<td>123</td>
						<td>2018-08-01</td>
					</tr>
					<tr>
						<td>2</td>
						<td class="tit_notice"><a href="javascript:;">박물관 미션 투어 응모 당첨자 발표</a> </td>
						<td>123</td>
						<td>2018-08-01</td>
					</tr>
					<tr>
						<td>3</td>
						<td class="tit_notice"><a href="javascript:;">추석 연휴 티켓/투어 배송 및 직접 수령 안내</a> </td>
						<td>123</td>
						<td>2018-08-01</td>
					</tr>
					<tr>
						<td>4</td>
						<td class="tit_notice"><a href="javascript:;">하롱베이 서비스 OPEN! (여행정보, 가이드북, 가이드맵)</a> </td>
						<td>123</td>
						<td>2018-08-01</td>
					</tr>
					<tr>
						<td>5</td>
						<td class="tit_notice"><a href="javascript:;">투어리스트인투어 서비스 점검 안내 - 투어리스트인투어에서 매월 실시하는 정기점검 안내</a> </td>
						<td>123</td>
						<td>2018-08-01</td>
					</tr>
					<tr>
						<td>6</td>
						<td class="tit_notice"><a href="javascript:;">이번 여름 휴가 제주 갈까? 미션 투어 (여행경비 50만원 지원)</a> </td>
						<td>123</td>
						<td>2018-08-01</td>
					</tr>
					<tr>
						<td>7</td>
						<td class="tit_notice"><a href="javascript:;">박물관 미션 투어 응모 당첨자 발표</a> </td>
						<td>123</td>
						<td>2018-08-01</td>
					</tr>
					<tr>
						<td>8</td>
						<td class="tit_notice"><a href="javascript:;">추석 연휴 티켓/투어 배송 및 직접 수령 안내</a> </td>
						<td>123</td>
						<td>2018-08-01</td>
					</tr>
					<tr>
						<td>9</td>
						<td class="tit_notice"><a href="javascript:;">하롱베이 서비스 OPEN! (여행정보, 가이드북, 가이드맵)</a> </td>
						<td>123</td>
						<td>2018-08-01</td>
					</tr>
					<tr>
						<td>10</td>
						<td class="tit_notice"><a href="javascript:;">투어리스트인투어 서비스 점검 안내</a> </td>
						<td>123</td>
						<td>2018-08-01</td>
					</tr>
				</tbody>
			</table>
			<!-- pagination -->
			<div class="pagination">
				<a href="javascript:;" class="firstpage  pbtn"><img src="${pageContext.request.contextPath }/img/btn_firstpage.png" alt="첫 페이지로 이동"></a>
				<a href="javascript:;" class="prevpage  pbtn"><img src="${pageContext.request.contextPath }/img/btn_prevpage.png" alt="이전 페이지로 이동"></a>
				<a href="javascript:;"><span class="pagenum currentpage">1</span></a>
				<a href="javascript:;"><span class="pagenum">2</span></a>
				<a href="javascript:;"><span class="pagenum">3</span></a>
				<a href="javascript:;"><span class="pagenum">4</span></a>
				<a href="javascript:;"><span class="pagenum">5</span></a>
				<a href="javascript:;" class="nextpage  pbtn"><img src="${pageContext.request.contextPath }/img/btn_nextpage.png" alt="다음 페이지로 이동"></a>
				<a href="javascript:;" class="lastpage  pbtn"><img src="${pageContext.request.contextPath }/img/btn_lastpage.png" alt="마지막 페이지로 이동"></a>
			</div>
			<!-- //pagination -->
			
		</div>
		<!-- //bodytext_area -->

	</div>
	<!-- //container -->

	<%@ include file="../include/footer.jsp"%>