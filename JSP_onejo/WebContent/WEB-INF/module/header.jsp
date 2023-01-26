<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta name="Robots" content="noindex,nofollow">
<title>ONE_PROJECT</title>

<!-- font awesome -->

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome Icons -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/newdjeV2/common_v1.css"
	media="all">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/newdjeV2/con_com.css"
	media="all">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/newdjeV2/layout.css"
	media="all">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/newdjeV2/sub_cnt.css"
	media="all">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/newdjeV2/board-gray.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/template/00001/print.css"
	media="print" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/template/00001/sub.css"
	media="all" />
<!-- summernote -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css"
	rel="stylesheet">





<style>
.gnb {
	background-color: white;
}
</style>
</head>
<body>
	<!-- wrap start -->
	<div class="wrap">
		<!-- header start -->
		<header id="header">
			<!-- 메뉴 -->
			<div class="headerWrap" style="background-color: #003366;">

				<div class="toputil">




					<!-- 상단 메뉴 -->
					<ul class="topMenu">
						<c:if test="${loginUser !=null }">
							<li><a href="#">${loginUser.id } 님 환영합니다.</a></li>
						</c:if>
						<c:if test="${loginUser==null }">
							<li><a
								href="javascript:OpenWindow('<%=request.getContextPath()%>/common/loginForm.do','상세보기',800,700);"
								title="로그인" style="display: block;">로그인</a></li>

						</c:if>
						<c:if test="${loginUser!=null }">
							<li><a href="<%=request.getContextPath()%>/common/logout.do"
								title="로그아웃">로그아웃</a></li>
						</c:if>
						<li class="lang"><a href="#none" title="LANGUAGE">LANGUAGE</a>
							<ul
								style="display: none; height: 100px; padding-top: 0px; margin-top: 0px; padding-bottom: 0px; margin-bottom: 0px;">
								<li><a href="#" title="Korean">Korean</a></li>
								<li><a href="#" title="English(새 창으로 이동합니다)"
									target="_blank" rel="noopener noreferrer">English</a></li>
								<!--<li><a href="/sub/japan/index.jsp" title="Japanese(새 창으로 이동합니다)" target="_blank">Japanese</a></li>
									<li><a href="/sub/china/index.jsp" title="Chinese(새 창으로 이동합니다)" target="_blank">Chinese</a></li>-->
							</ul></li>
					</ul>
					<!-- //상단 메뉴 -->
				</div>

				<!-- 로고 -->
				<h1 class="logo" id="logo">
					<a href="<%=request.getContextPath()%>/board/weeklyReportBoard/list.do" title="대전광역시교육청 로고"><img
						src="<%=request.getContextPath()%>/resources/images/logo.png"
						alt="대전광역시교육청 로고"></a>
				</h1>

				<a href="#" class="mob_btn" title="모바일 메뉴">모바일 메뉴<span></span><span></span><span></span></a>

				<!-- Main Navigation -->
				<div id="gnb" class="gnb">
					<div class="gnb_wrap">

						<div class="d01">

							<ul>
								<li><a href="#" target="_self"><span>민원·신고센터</span></a>
									<div
										style="display: none; height: 438px; padding-top: 0px; margin-top: 0px; padding-bottom: 0px; margin-bottom: 0px;">
										<div class="d02">
											<div class="head"></div>
											<ul>
												<li><a href="#" title="교육행정서비스헌장">교육행정서비스헌장</a>
													<ul class="d03">
														<li><a href="#" title="교육행정서비스헌장제란">교육행정서비스헌장제란</a></li>
														<li><a href="#" title="교육행정서비스헌장">교육행정서비스헌장</a></li>
														<li><a href="#" title="공통이행기준">공통이행기준</a></li>
														<li><a href="#" title="부서별이행기준">부서별이행기준</a></li>
													</ul></li>
												<li><a href="#" title="민원안내">민원안내</a>
													<ul class="d03">
														<li><a href="#" title="민원신청안내">민원신청안내</a></li>
														<li><a href="#" title="폐쇄·교명변경학교안내">폐쇄·교명변경학교안내</a></li>
														<li><a href="#" title="외국어증명발급안내">외국어증명발급안내</a></li>
														<li><a href="#" title="행정정보공동이용">행정정보공동이용</a></li>
														<li><a href="#" title="민원후견인제">민원후견인제</a></li>
														<li><a href="#" title="민원1회방문처리제">민원1회방문처리제</a></li>
														<li><a href="#" title="민원봉사실안내">민원봉사실안내</a></li>
													</ul></li>
												<li><a href="#" title="민원신청">민원신청</a>
													<ul class="d03">
														<li><a href="#" title="방문신청">방문신청</a></li>
														<li><a href="#" target="_blank"
															title="Home-Edu민원(새창으로 이동됩니다.)" rel="noopener noreferrer">Home-Edu민원</a></li>
														<li><a href="#" target="_blank"
															title="정부24(새창으로 이동됩니다.)" rel="noopener noreferrer">정부24</a></li>
														<li><a href="#" title="어디서나민원">어디서나민원</a></li>
														<li><a href="#" title="무인발급">무인발급</a></li>
														<li><a href="#" title="제증명 전화 예약접수창구">제증명 전화
																예약접수창구</a></li>
													</ul></li>
												<li><a href="#" title="인·허가민원">인·허가민원</a>
													<ul class="d03">
														<li><a href="#" title="유치원">유치원</a></li>
														<li><a href="#" title="학교법인">학교법인</a></li>
														<li><a href="#" title="공익법인">공익법인</a></li>
														<li><a href="#" title="학원">학원</a></li>
														<li><a href="#" title="교습소">교습소</a></li>
														<li><a href="#" title="개인과외교습">개인과외교습</a></li>
														<li><a href="#" title="평생교육시설">평생교육시설</a></li>
														<li><a href="#" title="교육환경보호구역">교육환경보호구역</a></li>
													</ul></li>
												<li><a href="#" title="전·입학안내">전·입학안내</a>
													<ul class="d03">
														<li><a href="#" title="고등학교">고등학교</a></li>
														<li><a href="#" title="중학교">중학교</a></li>
														<li><a href="#" title="초등학교">초등학교</a></li>
														<li><a href="#" title="고등학교결원현황">고등학교결원현황</a></li>
													</ul></li>
												<li><a href="#" title="민원자료실">민원자료실</a>
													<ul class="d03">
														<li><a href="#" title="민원편람">민원편람</a></li>
														<li><a href="#" title="민원자료안내">민원자료안내</a></li>
														<li><a href="#" title="민원서식">민원서식</a></li>
														<li><a href="#" title="대민친절응대방법">대민친절응대방법</a></li>
													</ul></li>
												<li><a href="#" title="대전교육신문고">대전교육신문고</a>
													<ul class="d03">
														<li><a href="#" title="진정·질의·건의민원">진정·질의·건의민원</a></li>
														<li><a href="#" target="_blank"
															title="국민콜채팅상담(새창으로 이동됩니다.)" rel="noopener noreferrer">국민콜채팅상담</a></li>
														<li><a href="#" title="자주찾는질의사례">자주찾는질의사례</a></li>
													</ul></li>
												<li><a href="#" title="신고센터">신고센터</a>
													<ul class="d03">
														<li><a href="#" title="신고센터안내">신고센터안내</a></li>
														<li><a href="#" title="교육분야 성폭력·성희롱신고">교육분야
																성폭력·성희롱신고</a></li>
														<li><a href="#" title="학교폭력·성폭력신고">학교폭력·성폭력신고</a></li>
														<li><a href="#" title="감사분야신고">감사분야신고</a></li>

													</ul></li>
											</ul>
										</div>
									</div></li>
								<li><a href="#" target="_self"><span>참여·제안</span></a>
									<div
										style="display: none; height: 510px; padding-top: 0px; margin-top: 0px; padding-bottom: 0px; margin-bottom: 0px;">
										<div class="d02">
											<div class="head"></div>
											<ul>
												<li><a href="#" title="칭찬합시다">칭찬합시다</a>
													<ul class="d03">
														<li><a
															href="/boardCnts/list.do?boardID=18&amp;m=0202&amp;s=dje"
															title="칭찬합시다">칭찬합시다</a></li>
													</ul></li>
												<li><a href="#" title="정책제안">정책제안</a>
													<ul class="d03">
														<li><a href="#" title="나의제안보기">나의제안보기</a></li>
														<li><a href="#" title="국민·공무원 제안">국민·공무원 제안</a></li>
														<li><a href="#" title="학생제안">학생제안</a></li>
														<li><a href="#" title="아이디어 숙성방">아이디어 숙성방</a></li>
														<li><a href="#" title="자료실">자료실</a></li>
													</ul></li>
												<li><a href="#" title="정책토론">정책토론</a>
													<ul class="d03">
														<li><a href="#" title="전자공청회">전자공청회</a></li>
														<li><a href="#" title="정책포럼">정책포럼</a></li>
														<li><a href="#" title="정책연구자료">정책연구자료</a></li>
														<li><a href="#" target="_blank"
															title="대전교육공감원탁회의(새창으로 이동됩니다.)" rel="noopener noreferrer">대전교육공감원탁회의</a></li>
														<li><a href="#" title="중학교군 주민참여방">중학교군 주민참여방</a></li>
													</ul></li>
												<li><a href="#" title="설문조사·투표">설문조사·투표</a>
													<ul class="d03">
														<li><a href="#" title="설문조사">설문조사</a></li>
														<li><a href="#" title="투표">투표</a></li>
													</ul></li>
												<li><a href="#" title="대전행복교육장학재단">대전행복교육장학재단</a>
													<ul class="d03">
														<li><a href="#" title="대전행복교육장학재단소개">대전행복교육장학재단소개</a></li>
														<li><a href="#" title="장학사업현황">장학사업현황</a></li>
														<li><a href="#" title="외부기부장학금운영안내">외부기부장학금운영안내</a></li>
														<li><a href="#" title="이중한장학회">이중한장학회</a></li>
													</ul></li>
												<li><a href="#" target="_blank"
													title="대전교육기부(새창으로 이동됩니다.)" rel="noopener noreferrer">대전교육기부</a>
													<ul class="d03">
														<li><a href="#" target="_blank"
															title="대전교육서포터즈단소개(새창으로 이동됩니다.)"
															rel="noopener noreferrer">대전교육서포터즈단소개</a></li>
														<li><a href="#" target="_blank"
															title="교육기부참여(새창으로 이동됩니다.)" rel="noopener noreferrer">교육기부참여</a></li>
														<li><a href="#" target="_blank"
															title="인력풀운영(새창으로 이동됩니다.)" rel="noopener noreferrer">인력풀운영</a></li>
														<li><a href="#" target="_blank"
															title="교육기부홍보(새창으로 이동됩니다.)" rel="noopener noreferrer">교육기부홍보</a></li>
														<li><a href="#" target="_blank"
															title="공지사항(새창으로 이동됩니다.)" rel="noopener noreferrer">공지사항</a></li>
														<li><a href="#" target="_blank"
															title="교육기부 명예의 전당(새창으로 이동됩니다.)"
															rel="noopener noreferrer">교육기부 명예의 전당</a></li>
													</ul></li>
												<li><a href="#" title="교육학예행사">교육학예행사</a>
													<ul class="d03">
														<li><a href="#" title="교육학예행사">교육학예행사</a></li>
													</ul></li>
												<li><a href="#" target="_blank"
													title="주민참여예산(새창으로 이동됩니다.)" rel="noopener noreferrer">주민참여예산</a>
													<ul class="d03">
														<li><a href="#" target="_blank"
															title=" 주민참여예산제(새창으로 이동됩니다.)" rel="noopener noreferrer">
																주민참여예산제</a></li>
														<li><a href="#" target="_blank"
															title="주민참여예산위원회(새창으로 이동됩니다.)" rel="noopener noreferrer">주민참여예산위원회</a></li>
														<li><a
															href="<%=request.getContextPath()%>/board/notificationBoard/list.do"
															target="_blank" title="알림방 (새창으로 이동됩니다.)"
															rel="noopener noreferrer">알림방 </a></li>
														<li><a href="#" target="_blank"
															title="주민참여방(새창으로 이동됩니다.)" rel="noopener noreferrer">주민참여방</a></li>
														<li><a href="#" target="_blank"
															title="예산관련 법령(새창으로 이동됩니다.)" rel="noopener noreferrer">예산관련
																법령</a></li>
														<li><a href="#" target="_blank"
															title="예산절감 아이디어(새창으로 이동됩니다.)" rel="noopener noreferrer">예산절감
																아이디어</a></li>
													</ul></li>
												<li><a href="#" title="적극행정">적극행정</a>
													<ul class="d03">
														<li><a href="#" title="적극행정이란?">적극행정이란?</a></li>
														<li><a href="#" title="적극행정 자료실">적극행정 자료실</a></li>
														<li><a href="#" title="소극행정이란?">소극행정이란?</a></li>
													</ul></li>
												<li><a href="#" title="산업안전">산업안전</a>
													<ul class="d03">
														<li><a href="#" title="산업안전자료실">산업안전자료실</a></li>
														<li><a href="#" title="소통창구">소통창구</a></li>
													</ul></li>
											</ul>
										</div>
									</div></li>
								<li><a href="#" target="_self"><span>정보마당</span></a>
									<div>
										<div class="d02">
											<div class="head"></div>
											<ul>
												<li><a
													href="<%=request.getContextPath()%>/board/notificationBoard/list.do"
													title="소식알림방">소식알림방</a>
													<ul class="d03">
														<li><a href="#" title="공지사항">공지사항</a></li>
														<li><a href="#" title="고시·공고">고시·공고</a></li>
														<li><a
															href="<%=request.getContextPath()%>/board/weeklyReportBoard/list.do"
															title="주간업무">주간업무</a></li>
														<li><a
															href="<%=request.getContextPath()%>/board/notificationBoard/list.do"
															title="알림방">알림방</a></li>
													</ul></li>
												<li><a href="#" title="인사정보">인사정보</a>
													<ul class="d03">
														<li><a href="<%=request.getContextPath() %>/board/teacherAffairsBoard/list.do" title="교원인사">교원인사</a></li>
														<li><a href="<%=request.getContextPath() %>/board/nomalAffairsBoard/list.do">일반직인사</a></li>
														<li><a href="#" title="교육공무직인사">교육공무직인사</a></li>
														<li><a href="#" title="인사 정보 조회">인사 정보 조회</a></li>
													</ul></li>
												<li><a href="#" title="시험정보">시험정보</a>
													<ul class="d03">
														<li><a href="<%=request.getContextPath() %>/board/appointmentBoard/list.do" title="임용시험">임용시험</a></li>
														<li><a href="<%=request.getContextPath() %>/board/qualificationBoard/list.do" title="검정고시">검정고시</a></li>
													</ul></li>
												<li><a href="#" title="구인·구직">구인·구직</a>
													<ul class="d03">
														<li><a href="#" title="기간제교사">기간제교사</a></li>
														<li><a href="#" title="학교인력 채용공고">학교인력 채용공고</a></li>
														<li><a href="#" title="산학겸임.강사.명예교사신청">산학겸임.강사.명예교사신청</a></li>
													</ul></li>
												<li><a href="#" title="연수·교육안내">연수·교육안내</a>
													<ul class="d03">
														<li><a href="#" title="교원연수">교원연수</a></li>
														<li><a href="#" title="특수분야연수">특수분야연수</a></li>
													</ul></li>
												<li><a href="#" title="업무매뉴얼">업무매뉴얼</a>
													<ul class="d03">
														<li><a href="#" title="유치원업무 길라잡이">유치원업무 길라잡이</a></li>
														<li><a href="#" title="학교업무 길라잡이(초등)">학교업무
																길라잡이(초등)</a></li>
														<li><a href="#" title="학교업무 길라잡이(중·고등)">학교업무
																길라잡이(중·고등)</a></li>
														<li><a href="#" title="학교업무지원자료실">학교업무지원자료실</a></li>
														<li><a href="#" title="단위학교 공문서 발송현황">단위학교 공문서
																발송현황</a></li>
														<li><a href="#" title="교육행정업무매뉴얼">교육행정업무매뉴얼</a></li>
														<li><a href="#" title="현장의견제안">현장의견제안</a></li>
														<li><a href="#" title="정보보안 안내">정보보안 안내</a></li>
													</ul></li>
												<li><a href="#" title="학교운영위원회">학교운영위원회</a>
													<ul class="d03">
														<li><a href="#" title="연혁 및 구성절차">연혁 및 구성절차</a></li>
														<li><a href="#" title="관련법령·조례">관련법령·조례</a></li>
														<li><a href="#" title="안건처리절차">안건처리절차</a></li>
														<li><a href="#" title="관련자료">관련자료</a></li>
														<li><a href="#" target="_blank"
															title="전국학부모지원센터(새창으로 이동됩니다.)" rel="noopener noreferrer">전국학부모지원센터</a></li>
													</ul></li>
												<li><a href="#" title="학교안전공제회">학교안전공제회</a>
													<ul class="d03">
														<li><a href="#" title="운영개요">운영개요</a></li>
														<li><a href="#" title="공제급여지급요건 및 범위">공제급여지급요건 및
																범위</a></li>
														<li><a href="#" title="사고통지 및 공제급여청구">사고통지 및
																공제급여청구</a></li>
														<li><a href="#" title="질의응답">질의응답</a></li>
														<li><a href="#" title="자료실">자료실</a></li>
													</ul></li>
												<li><a href="#" title="법인·학원설립안내">법인·학원설립안내</a>
													<ul class="d03">
														<li><a href="#" title="공익법인설립안내">공익법인설립안내</a></li>
														<li><a href="#" title="학원설립안내">학원설립안내</a></li>
														<li><a href="#" title="학교법인현황">학교법인현황</a></li>
														<li><a href="#" title="학원(교습소) 공지">학원(교습소) 공지</a></li>
													</ul></li>
												<li><a href="#" title="온라인학습터">온라인학습터</a>
													<ul class="d03">
														<li><a href="#" title="온라인학습터">온라인학습터</a></li>
													</ul></li>
												<li><a href="#" title="통합자료실">통합자료실</a>
													<ul class="d03">
														<li><a href="#" title="통합자료실">통합자료실</a></li>
														<li><a href="#" title="코로나19 자료실">코로나19 자료실</a></li>
														<li><a href="#" title="학사일정 공유 자료실">학사일정 공유 자료실</a></li>
													</ul></li>
												<li><a href="#" target="_blank"
													title="법무행정서비스(새창으로 이동됩니다.)" rel="noopener noreferrer">법무행정서비스</a>
													<ul class="d03">
														<li><a href="#" target="_blank"
															title="법무행정서비스(새창으로 이동됩니다.)" rel="noopener noreferrer">법무행정서비스</a></li>
													</ul></li>
											</ul>
										</div>
									</div></li>
								<li><a href="#" target="_self"><span>홍보마당</span></a>
									<div
										style="display: none; height: 357px; padding-top: 0px; margin-top: 0px; padding-bottom: 0px; margin-bottom: 0px;">
										<div class="d02">
											<div class="head"></div>
											<ul>
												<li><a href="#" title="대전교육뉴스">대전교육뉴스</a>
													<ul class="d03">
														<li><a href="#" title="대전교육뉴스">대전교육뉴스</a></li>
													</ul></li>
												<li><a href="#" title="홍보영상">홍보영상</a>
													<ul class="d03">
														<li><a href="#" title="홍보영상">홍보영상</a></li>
													</ul></li>
												<li><a href="#" title="포토뉴스">포토뉴스</a>
													<ul class="d03">
														<li><a href="#" title="포토뉴스">포토뉴스</a></li>
													</ul></li>
												<li><a href="#" title="보도자료">보도자료</a>
													<ul class="d03">
														<li><a href="#" title="보도자료">보도자료</a></li>
														<li><a href="#" title="보도 해명(설명)자료">보도 해명(설명)자료</a></li>
													</ul></li>
												<li><a href="#" title="대전교육소식지">대전교육소식지</a>
													<ul class="d03">
														<li><a href="#" title="대전교육소식지">대전교육소식지</a></li>
														<li><a href="#" title="대전교육소식지 공모전 응모작">대전교육소식지
																공모전 응모작</a></li>
													</ul></li>
												<li><a href="#" title="대전교육화보">대전교육화보</a>
													<ul class="d03">
														<li><a href="#" title="대전교육화보">대전교육화보</a></li>
													</ul></li>
												<li><a href="#" title="카드뉴스">카드뉴스</a>
													<ul class="d03">
														<li><a href="#" title="카드뉴스">카드뉴스</a></li>
													</ul></li>
											</ul>
										</div>
									</div></li>
								<li><a href="#" target="_self"><span>정보공개</span></a>
									<div
										style="display: none; height: 489px; padding-top: 0px; margin-top: 0px; padding-bottom: 0px; margin-bottom: 0px;">
										<div class="d02">
											<div class="head"></div>
											<ul>
												<li><a href="#" title="정보공개안내">정보공개안내</a>
													<ul class="d03">
														<li><a href="#" title="제도안내">제도안내</a></li>
														<li><a href="#" title="관련 법령·규정·수수료">관련 법령·규정·수수료</a></li>
														<li><a href="#" title="비공개대상정보">비공개대상정보</a></li>
														<li><a href="#" title="정보목록">정보목록</a></li>
														<li><a href="#" title="정보공개사례">정보공개사례</a></li>
														<li><a href="#" target="_blank"
															title="정보공개청구(새창으로 이동됩니다.)" rel="noopener noreferrer">정보공개청구</a></li>
													</ul></li>
												<li><a href="#" title="사전정보공표">사전정보공표</a>
													<ul class="d03">
														<li><a href="#" title="사전정보공표">사전정보공표</a></li>
														<li><a href="#" title="모니터링안내">모니터링안내</a></li>
														<li><a href="#" title="모니터링게시판">모니터링게시판</a></li>
													</ul></li>
												<li><a href="#" title="정책실명제">정책실명제</a>
													<ul class="d03">
														<li><a href="#" title="중점관리대상사업">중점관리대상사업</a></li>
														<li><a href="#" title="국민신청실명제">국민신청실명제</a></li>
													</ul></li>
												<li><a href="#" title="대전교육통계">대전교육통계</a>
													<ul class="d03">
														<li><a href="#" title="교육통계연보자료실">교육통계연보자료실</a></li>
														<li><a href="#" title="통계분석자료집">통계분석자료집</a></li>
													</ul></li>
												<li><a href="#" title="공공데이터개방">공공데이터개방</a>
													<ul class="d03">
														<li><a href="#" title="공공데이터개방">공공데이터개방</a></li>
													</ul></li>
												<li><a href="#" target="_blank"
													title="재정정보(새창으로 이동됩니다.)" rel="noopener noreferrer">재정정보</a>
													<ul class="d03">
														<li><a href="#" target="_blank"
															title="예·결산현황(새창으로 이동됩니다.)" rel="noopener noreferrer">예·결산현황</a></li>
														<li><a href="#" target="_blank"
															title="재정분석(새창으로 이동됩니다.)" rel="noopener noreferrer">재정분석</a></li>
														<li><a href="#" target="_blank"
															title="재정공시(새창으로 이동됩니다.)" rel="noopener noreferrer">재정공시</a></li>
														<li><a href="#" target="_blank"
															title="중기지방재정계획(새창으로 이동됩니다.)" rel="noopener noreferrer">중기지방재정계획</a></li>
														<li><a href="#" target="_blank"
															title="재정투자심사(새창으로 이동됩니다.)" rel="noopener noreferrer">재정투자심사</a></li>
														<li><a href="#" title="재정운용상황">재정운용상황</a></li>
														<li><a href="#" target="_blank"
															title="업무추진비(새창으로 이동됩니다.)" rel="noopener noreferrer">업무추진비</a></li>
													</ul></li>
												<li><a href="#" target="_blank"
													title="계약정보(새창으로 이동됩니다.)" rel="noopener noreferrer">계약정보</a>
													<ul class="d03">
														<li><a href="#" target="_blank"
															title="계약정보공개(새창으로 이동됩니다.)" rel="noopener noreferrer">계약정보공개</a></li>
														<li><a href="#" target="_blank"
															title="발주계획(새창으로 이동됩니다.)" rel="noopener noreferrer">발주계획</a></li>
														<li><a href="#" target="_blank"
															title="입찰공고(새창으로 이동됩니다.)" rel="noopener noreferrer">입찰공고</a></li>
														<li><a href="#" target="_blank"
															title="개찰결과(새창으로 이동됩니다.)" rel="noopener noreferrer">개찰결과</a></li>
														<li><a href="#" target="_blank"
															title="계약체결현황(새창으로 이동됩니다.)" rel="noopener noreferrer">계약체결현황</a></li>
														<li><a href="#" target="_blank"
															title="수의계약공개(새창으로 이동됩니다.)" rel="noopener noreferrer">수의계약공개</a></li>
													</ul></li>
												<li><a href="#" title="감사정보">감사정보</a>
													<ul class="d03">
														<li><a href="#" title="감사예고">감사예고</a></li>
														<li><a href="#" title="자체감사결과">자체감사결과</a></li>
														<li><a href="#" title="외부감사결과">외부감사결과</a></li>
														<li><a href="#" title="국정감사">국정감사</a></li>
														<li><a href="#" title="사전의견청취">사전의견청취</a></li>
														<li><a href="#" title="감사참관신청">감사참관신청</a></li>
														<li><a href="#" title="기타감사자료">기타감사자료</a></li>
														<li><a href="#" title="모범사례">모범사례</a></li>
													</ul></li>
												<li><a href="#" title="각종정보공개">각종정보공개</a>
													<ul class="d03">
														<li><a href="#" title="포상후보자 공개">포상후보자 공개</a></li>
														<li><a href="#" title="공무국외여행공개">공무국외여행공개</a></li>
														<li><a href="#" target="_blank"
															title="현장체험학습공개(새창으로 이동됩니다.)" rel="noopener noreferrer">현장체험학습공개</a></li>
														<li><a href="#" title="학습준비물집행내역">학습준비물집행내역</a></li>
														<li><a href="#" title="위원회현황">위원회현황</a></li>
														<li><a href="#" title="업무협약(MOU) 체결현황">업무협약(MOU)
																체결현황</a></li>
														<li><a href="#" target="_blank"
															title="학교운동부 예산집행(새창으로 이동됩니다.)" rel="noopener noreferrer">학교운동부
																예산집행</a></li>
														<li><a href="#" title="물품소요조회">물품소요조회</a></li>
													</ul></li>
											</ul>
										</div>
									</div></li>
								<li><a href="#" target="_self"><span>교육청소개</span></a>
									<div style="display: none;">
										<div class="d02">
											<div class="head"></div>
											<ul>
												<li><a href="#" title="교육감인사말">교육감인사말</a>
													<ul class="d03">
														<li><a href="#" title="교육감프로필">교육감프로필</a></li>
														<li><a href="#" title="교육감인사말">교육감인사말</a></li>
													</ul></li>
												<li><a href="#" title="역대교육감">역대교육감</a>
													<ul class="d03">
														<li><a
															href="/sub/info.do?page=0502&amp;m=0502&amp;s=dje"
															title="역대교육감">역대교육감</a></li>
													</ul></li>
												<li><a href="#" title="교육청연혁">교육청연혁</a>
													<ul class="d03">
														<li><a
															href="/sub/info.do?page=0503&amp;m=0503&amp;s=dje"
															title="교육청연혁">교육청연혁</a></li>
													</ul></li>
												<li><a href="#" title="대전교육기본방향">대전교육기본방향</a>
													<ul class="d03">
														<li><a href="#" title="대전교육기본방향">대전교육기본방향</a></li>
														<li><a href="#" title="주요업무계획">주요업무계획</a></li>
													</ul></li>
												<li><a href="#" title="조직도·직원찾기">조직도·직원찾기</a>
													<ul class="d03">
														<li><a href="#" title="조직도·직원찾기">조직도·직원찾기</a></li>
														<li><a href="#" title="스승찾기">스승찾기</a></li>
													</ul></li>
												<li><a href="#" title="전화번호·주소">전화번호·주소</a>
													<ul class="d03">
														<li><a href="#" title="본청">본청</a></li>
														<li><a href="#" title="지원청·직속">지원청·직속</a></li>
														<li><a href="#" title="학교(유치원) 현황">학교(유치원) 현황</a></li>
														<li><a href="#" title="코로나19 관련 부서">코로나19 관련 부서</a></li>
													</ul></li>
												<li><a href="#" title="청사안내">청사안내</a>
													<ul class="d03">
														<li><a href="#" title="청사안내">청사안내</a></li>
														<li><a href="#" title="찾아오시는길">찾아오시는길</a></li>
													</ul></li>
												<li><a href="#" title="교육청CI">교육청CI</a>
													<ul class="d03">
														<li><a href="#" title="교육청CI">교육청CI</a></li>
														<li><a href="#" title="파워브랜드">파워브랜드</a></li>
													</ul></li>
											</ul>
										</div>
									</div></li>
							</ul>
						</div>
					</div>
				</div>


				<!-- //Main Navigation -->

				<!-- 검색 -->
				<div class="search_btn">
					<button type="button" title="검색영역 열기">검색영역 열기</button>
				</div>
				<div class="search">
					<h2>통합검색</h2>
					<div class="search_wrap">
						<form name="searchForm" method="post"
							action="https://www.dje.go.kr/search/front/Search.jsp"
							target="_blank" onsubmit="return searchEngine()"
							rel="noopener noreferrer">
							<fieldset>
								<legend>통합검색</legend>
								<input type="text" id="qt" name="qt" value="" title="검색어 입력"
									accesskey="s" style="ime-mode: active;" autocomplete="off">
								<a
									href="javascript:if(searchEngine()){document.searchForm.submit();}"
									class="btn_top_sear" title="검색">검색</a>
							</fieldset>
						</form>
					</div>
					<div class="search_close">
						<button type="button" title="검색영역 닫기">검색영역 닫기</button>
					</div>
				</div>
				<!-- // 검색 -->

				<!-- 사이트맵-->
				<a href="#" class="sitemap_btn" title="전체메뉴(레이어팝업으로 열립니다.)">전체메뉴
					<span></span> <span></span> <span></span>
				</a>
				<!-- 전체메뉴 pc -->
				<div class="menu_all">
					<div class="menu_box">
						<ul>
							<li class="ma01"><a href="#" title="민원·신고센터">민원·신고센터</a>
								<div class="depth_wrap">
									<ul>
										<li><a href="#" title="교육행정서비스헌장">교육행정서비스헌장</a>
											<ul>
												<li><a href="#" title="교육행정서비스헌장제란">교육행정서비스헌장제란</a></li>
												<li><a href="#" title="교육행정서비스헌장">교육행정서비스헌장</a></li>
												<li><a href="#" title="공통이행기준">공통이행기준</a></li>
												<li><a href="#" title="부서별이행기준">부서별이행기준</a></li>
											</ul></li>
										<li><a href="#" title="민원안내">민원안내</a>
											<ul>
												<li><a href="#" title="민원신청안내">민원신청안내</a></li>
												<li><a href="#" title="폐쇄·교명변경학교안내">폐쇄·교명변경학교안내</a></li>
												<li><a href="#" title="외국어증명발급안내">외국어증명발급안내</a></li>
												<li><a href="#" title="행정정보공동이용">행정정보공동이용</a></li>
												<li><a href="#" title="민원후견인제">민원후견인제</a></li>
												<li><a href="#" title="민원1회방문처리제">민원1회방문처리제</a></li>
												<li><a href="#" title="민원봉사실안내">민원봉사실안내</a></li>
											</ul></li>
										<li><a href="#" title="민원신청">민원신청</a>
											<ul>
												<li><a href="#" title="방문신청">방문신청</a></li>
												<li><a href="#" target="_blank" title="Home-Edu민원(새창)"
													rel="noopener noreferrer">Home-Edu민원</a></li>
												<li><a href="#" target="_blank" title="정부24(새창)"
													rel="noopener noreferrer">정부24</a></li>
												<li><a href="#" title="어디서나민원">어디서나민원</a></li>
												<li><a href="#" title="무인발급">무인발급</a></li>
												<li><a href="#" title="제증명 전화 예약접수창구">제증명 전화 예약접수창구</a></li>
											</ul></li>
										<li><a href="#" title="인·허가민원">인·허가민원</a>
											<ul>
												<li><a href="#" title="유치원">유치원</a></li>
												<li><a href="#" title="학교법인">학교법인</a></li>
												<li><a href="#" title="공익법인">공익법인</a></li>
												<li><a href="#" title="학원">학원</a></li>
												<li><a href="#" title="교습소">교습소</a></li>
												<li><a href="#" title="개인과외교습">개인과외교습</a></li>
												<li><a href="#" title="평생교육시설">평생교육시설</a></li>
												<li><a href="#" title="교육환경보호구역">교육환경보호구역</a></li>
											</ul></li>
										<li><a href="#" title="전·입학안내">전·입학안내</a>
											<ul>
												<li><a href="#" title="고등학교">고등학교</a></li>
												<li><a href="#" title="중학교">중학교</a></li>
												<li><a href="#" title="초등학교">초등학교</a></li>
												<li><a href="#" title="고등학교결원현황">고등학교결원현황</a></li>
											</ul></li>
										<li><a href="#" title="민원자료실">민원자료실</a>
											<ul>
												<li><a href="#" title="민원편람">민원편람</a></li>
												<li><a href="#" title="민원자료안내">민원자료안내</a></li>
												<li><a href="#" title="민원서식">민원서식</a></li>
												<li><a href="#" title="대민친절응대방법">대민친절응대방법</a></li>
											</ul></li>
										<li><a href="#" title="대전교육신문고">대전교육신문고</a>
											<ul>
												<li><a href="#" title="진정·질의·건의민원">진정·질의·건의민원</a></li>
												<li><a href="#" target="_blank" title="국민콜채팅상담(새창)"
													rel="noopener noreferrer">국민콜채팅상담</a></li>
												<li><a href="#" title="자주찾는질의사례">자주찾는질의사례</a></li>
											</ul></li>
										<li><a href="#" title="신고센터">신고센터</a>
											<ul>
												<li><a href="#" title="신고센터안내">신고센터안내</a></li>
												<li><a href="#" title="교육분야 성폭력·성희롱신고">교육분야
														성폭력·성희롱신고</a></li>
												<li><a href="#" title="학교폭력·성폭력신고">학교폭력·성폭력신고</a></li>
												<li><a href="#" title="감사분야신고">감사분야신고</a></li>
												<li><a href="#" target="_blank"
													title="부패·공익신고(청렴포털)(새창)" rel="noopener noreferrer">부패·공익신고(청렴포털)</a></li>
												<li><a href="#" title="선수고충처리신고">선수고충처리신고</a></li>
												<li><a href="#" title="예산낭비신고">예산낭비신고</a></li>
												<li><a href="#" title="수능부정행위신고">수능부정행위신고</a></li>
												<li><a href="#" title="공시정보오류신고">공시정보오류신고</a></li>
												<li><a href="#" title="교과용도서부조리신고">교과용도서부조리신고</a></li>
												<li><a href="#" title="선행출제신고">선행출제신고</a></li>
												<li><a href="#" title="교육비리신고">교육비리신고</a></li>
												<li><a href="#" title="유치원폐원고충지원">유치원폐원고충지원</a></li>
											</ul></li>
									</ul>
								</div></li>
							<li class="ma02"><a href="#" title="참여·제안">참여·제안</a>
								<div class="depth_wrap">
									<ul>
										<li><a href="#" title="칭찬합시다">칭찬합시다 </a></li>
										<li><a href="#" title="정책제안">정책제안</a>
											<ul>
												<li><a href="#" title="나의제안보기">나의제안보기</a></li>
												<li><a href="#" title="국민·공무원 제안">국민·공무원 제안</a></li>
												<li><a href="#" title="학생제안">학생제안</a></li>
												<li><a href="#" title="아이디어 숙성방">아이디어 숙성방</a></li>
												<li><a href="#" title="자료실">자료실</a></li>
											</ul></li>
										<li><a href="#" title="정책토론">정책토론</a>
											<ul>
												<li><a href="#" title="전자공청회">전자공청회</a></li>
												<li><a href="#" title="정책포럼">정책포럼</a></li>
												<li><a href="#" title="정책연구자료">정책연구자료</a></li>
												<li><a href="#" target="_blank" title="대전교육공감원탁회의(새창)"
													rel="noopener noreferrer">대전교육공감원탁회의&nbsp;&nbsp;<img
														src="/images/template/00001/common/new_target_on.png"
														alt="새창"></a></li>
												<li><a href="#" title="중학교군 주민참여방">중학교군 주민참여방</a></li>
											</ul></li>
										<li><a href="#" title="설문조사·투표">설문조사·투표</a>
											<ul>
												<li><a href="#" title="설문조사">설문조사</a></li>
												<li><a href="#" title="투표">투표</a></li>
											</ul></li>
										<li><a href="#" title="대전행복교육장학재단">대전행복교육장학재단</a>
											<ul>
												<li><a href="#" title="대전행복교육장학재단소개">대전행복교육장학재단소개</a></li>
												<li><a href="#" title="장학사업현황">장학사업현황</a></li>
												<li><a href="#" title="외부기부장학금운영안내">외부기부장학금운영안내</a></li>
												<li><a href="#" title="이중한장학회">이중한장학회</a></li>
											</ul></li>
										<li><a href="#" target="_blank" title="대전교육기부(새창)"
											rel="noopener noreferrer">대전교육기부</a>
											<ul>
												<li><a href="#" target="_blank" title="대전교육서포터즈단소개(새창)"
													rel="noopener noreferrer">대전교육서포터즈단소개</a></li>
												<li><a href="#" target="_blank" title="교육기부참여(새창)"
													rel="noopener noreferrer">교육기부참여</a></li>
												<li><a href="#" target="_blank" title="인력풀운영(새창)"
													rel="noopener noreferrer">인력풀운영</a></li>
												<li><a href="#" target="_blank" title="교육기부홍보(새창)"
													rel="noopener noreferrer">교육기부홍보</a></li>
												<li><a href="#" target="_blank" title="공지사항(새창)"
													rel="noopener noreferrer">공지사항</a></li>
												<li><a href="#" target="_blank" title="교육기부 명예의 전당(새창)"
													rel="noopener noreferrer">교육기부 명예의 전당</a></li>
											</ul></li>
										<li><a href="#" title="교육학예행사">교육학예행사 </a></li>
										<li><a href="#" target="_blank" title="주민참여예산(새창)"
											rel="noopener noreferrer">주민참여예산</a>
											<ul>
												<li><a href="#" target="_blank" title=" 주민참여예산제(새창)"
													rel="noopener noreferrer"> 주민참여예산제</a></li>
												<li><a href="#" target="_blank" title="주민참여예산위원회(새창)"
													rel="noopener noreferrer">주민참여예산위원회</a></li>
												<li><a
													href="<%=request.getContextPath()%>/board/notificationBoard/list.do"
													target="_blank" title="알림방 (새창)" rel="noopener noreferrer">알림방
												</a></li>
												<li><a href="#" target="_blank" title="주민참여방(새창)"
													rel="noopener noreferrer">주민참여방</a></li>
												<li><a href="#" target="_blank" title="예산관련 법령(새창)"
													rel="noopener noreferrer">예산관련 법령</a></li>
												<li><a href="#" target="_blank" title="예산절감 아이디어(새창)"
													rel="noopener noreferrer">예산절감 아이디어</a></li>
											</ul></li>
										<li><a href="#" title="적극행정">적극행정</a>
											<ul>
												<li><a href="#" title="적극행정이란?">적극행정이란?</a></li>
												<li><a href="#" title="적극행정 자료실">적극행정 자료실</a></li>
												<li><a href="#" title="소극행정이란?">소극행정이란?</a></li>
											</ul></li>
										<li><a href="#" title="산업안전">산업안전</a>
											<ul>
												<li><a href="#" title="산업안전자료실">산업안전자료실</a></li>
												<li><a href="#" title="소통창구">소통창구</a></li>
											</ul></li>
									</ul>
								</div></li>
							<li class="ma03"><a href="#" title="정보마당">정보마당</a>
								<div class="depth_wrap">
									<ul>
										<li><a
											href="<%=request.getContextPath()%>/board/notificationBoard/list.do"
											title="소식알림방">소식알림방</a>
											<ul>
												<li><a href="#" title="공지사항">공지사항</a></li>
												<li><a href="#" title="고시·공고">고시·공고</a></li>
												<li><a
													href="<%=request.getContextPath()%>/board/weeklyReportBoard/list.do"
													title="주간업무">주간업무</a></li>
												<li><a
													href="<%=request.getContextPath()%>/board/notificationBoard/list.do"
													title="알림방">알림방</a></li>
											</ul></li>
										<li><a href="#" title="인사정보">인사정보</a>
											<ul>
												<li><a href="<%=request.getContextPath() %>/board/teacherAffairsBoard/list.do" title="교원인사">교원인사</a></li>
												<li><a href="<%=request.getContextPath() %>/board/nomalAffairsBoard/list.do" title="일반직인사">일반직인사</a></li>
												<li><a href="#" title="교육공무직인사">교육공무직인사</a></li>
												<li><a href="#" title="인사 정보 조회">인사 정보 조회</a></li>
											</ul></li>
										<li><a href="#" title="시험정보">시험정보</a>
											<ul>
												<li><a href="<%=request.getContextPath() %>/board/appointmentBoard/list.do" title="임용시험">임용시험</a></li>
												<li><a href="<%=request.getContextPath() %>/board/qualificationBoard/list.do" title="검정고시">검정고시</a></li>
											</ul></li>
										<li><a href="#" title="구인·구직">구인·구직</a>
											<ul>
												<li><a href="#" title="기간제교사">기간제교사</a></li>
												<li><a href="#" title="학교인력 채용공고">학교인력 채용공고</a></li>
												<li><a href="#" title="산학겸임.강사.명예교사신청">산학겸임.강사.명예교사신청</a></li>
											</ul></li>
										<li><a href="#" title="연수·교육안내">연수·교육안내</a>
											<ul>
												<li><a href="#" title="교원연수">교원연수</a></li>
												<li><a href="#" title="특수분야연수">특수분야연수</a></li>
											</ul></li>
										<li><a href="#" title="업무매뉴얼">업무매뉴얼</a>
											<ul>
												<li><a href="#" title="유치원업무 길라잡이">유치원업무 길라잡이</a></li>
												<li><a href="#" title="학교업무 길라잡이(초등)">학교업무 길라잡이(초등)</a></li>
												<li><a href="#" title="학교업무 길라잡이(중·고등)">학교업무
														길라잡이(중·고등)</a></li>
												<li><a href="#" title="학교업무지원자료실">학교업무지원자료실</a></li>
												<li><a href="#" title="단위학교 공문서 발송현황">단위학교 공문서 발송현황</a></li>
												<li><a href="#" title="교육행정업무매뉴얼">교육행정업무매뉴얼</a></li>
												<li><a href="#" title="현장의견제안">현장의견제안</a></li>
												<li><a href="#" title="정보보안 안내">정보보안 안내</a></li>
											</ul></li>
										<li><a href="#" title="학교운영위원회">학교운영위원회</a>
											<ul>
												<li><a href="#" title="연혁 및 구성절차">연혁 및 구성절차</a></li>
												<li><a href="#" title="관련법령·조례">관련법령·조례</a></li>
												<li><a href="#" title="안건처리절차">안건처리절차</a></li>
												<li><a href="#" title="관련자료">관련자료</a></li>
												<li><a href="#" target="_blank" title="전국학부모지원센터(새창)"
													rel="noopener noreferrer">전국학부모지원센터</a></li>
											</ul></li>
										<li><a href="#" title="학교안전공제회">학교안전공제회</a>
											<ul>
												<li><a href="#" title="운영개요">운영개요</a></li>
												<li><a href="#" title="공제급여지급요건 및 범위">공제급여지급요건 및 범위</a></li>
												<li><a href="#" title="사고통지 및 공제급여청구">사고통지 및 공제급여청구</a></li>
												<li><a href="#" title="질의응답">질의응답</a></li>
												<li><a href="#" title="자료실">자료실</a></li>
											</ul></li>
										<li><a href="#" title="법인·학원설립안내">법인·학원설립안내</a>
											<ul>
												<li><a href="#" title="공익법인설립안내">공익법인설립안내</a></li>
												<li><a href="#" title="학원설립안내">학원설립안내</a></li>
												<li><a href="#" title="학교법인현황">학교법인현황</a></li>
												<li><a href="#" title="학원(교습소) 공지">학원(교습소) 공지</a></li>
											</ul></li>
										<li><a href="#" title="온라인학습터">온라인학습터 </a></li>
										<li><a href="#" title="통합자료실">통합자료실</a>
											<ul>
												<li><a href="#" title="통합자료실">통합자료실</a></li>
												<li><a href="#" title="코로나19 자료실">코로나19 자료실</a></li>
												<li><a href="#" title="학사일정 공유 자료실">학사일정 공유 자료실</a></li>
											</ul></li>
										<li><a href="#" target="_blank" title="법무행정서비스(새창)"
											rel="noopener noreferrer">법무행정서비스 </a></li>
									</ul>
								</div></li>
						</ul>

						<ul>
							<li class="ma04"><a href="#" title="홍보마당">홍보마당</a>
								<div class="depth_wrap">
									<ul>
										<li><a href="#" title="대전교육뉴스">대전교육뉴스 </a></li>
										<li><a href="#" title="홍보영상">홍보영상 </a></li>
										<li><a href="#" title="포토뉴스">포토뉴스 </a></li>
										<li><a href="#" title="보도자료">보도자료</a>
											<ul>
												<li><a href="#" title="보도자료">보도자료</a></li>
												<li><a href="#" title="보도 해명(설명)자료">보도 해명(설명)자료</a></li>
											</ul></li>
										<li><a href="#" title="대전교육소식지">대전교육소식지</a>
											<ul>
												<li><a href="#" title="대전교육소식지">대전교육소식지</a></li>
												<li><a href="#" title="대전교육소식지 공모전 응모작">대전교육소식지 공모전
														응모작</a></li>
											</ul></li>
										<li><a href="#" title="대전교육화보">대전교육화보 </a></li>
										<li><a href="#" title="카드뉴스">카드뉴스 </a></li>
									</ul>
								</div></li>
							<li class="ma05"><a href="#" title="정보공개">정보공개</a>
								<div class="depth_wrap">
									<ul>
										<li><a href="#" title="정보공개안내">정보공개안내</a>
											<ul>
												<li><a href="#" title="제도안내">제도안내</a></li>
												<li><a href="#" title="관련 법령·규정·수수료">관련 법령·규정·수수료</a></li>
												<li><a href="#" title="비공개대상정보">비공개대상정보</a></li>
												<li><a href="#" title="정보목록">정보목록</a></li>
												<li><a href="#" title="정보공개사례">정보공개사례</a></li>
												<li><a href="#" target="_blank" title="정보공개청구(새창)"
													rel="noopener noreferrer">정보공개청구</li>
											</ul></li>
										<li><a href="#" title="사전정보공표">사전정보공표</a>
											<ul>
												<li><a href="#" title="사전정보공표">사전정보공표</a></li>
												<li><a href="#" title="모니터링안내">모니터링안내</a></li>
												<li><a href="#" title="모니터링게시판">모니터링게시판</a></li>
											</ul></li>
										<li><a href="#" title="정책실명제">정책실명제</a>
											<ul>
												<li><a href="#" title="중점관리대상사업">중점관리대상사업</a></li>
												<li><a href="#" title="국민신청실명제">국민신청실명제</a></li>
											</ul></li>
										<li><a href="#" title="대전교육통계">대전교육통계</a>
											<ul>
												<li><a href="#" title="교육통계연보자료실">교육통계연보자료실</a></li>
												<li><a href="#" title="통계분석자료집">통계분석자료집</a></li>
											</ul></li>
										<li><a href="#" title="공공데이터개방">공공데이터개방 </a></li>
										<li><a href="#" target="_blank" title="재정정보(새창)"
											rel="noopener noreferrer">재정정보</a>
											<ul>
												<li><a href="#" target="_blank" title="예·결산현황(새창)"
													rel="noopener noreferrer">예·결산현황</a></li>
												<li><a href="#" target="_blank" title="재정분석(새창)"
													rel="noopener noreferrer">재정분석</a></li>
												<li><a href="#" target="_blank" title="재정공시(새창)"
													rel="noopener noreferrer">재정공시</a></li>
												<li><a href="#" target="_blank" title="중기지방재정계획(새창)"
													rel="noopener noreferrer">중기지방재정계획</a></li>
												<li><a href="#" target="_blank" title="재정투자심사(새창)"
													rel="noopener noreferrer">재정투자심사</a></li>
												<li><a href="#" target="_blank" title="재정자료실(새창)"
													rel="noopener noreferrer">재정자료실</a></li>
												<li><a href="#" title="재정운용상황">재정운용상황</a></li>
												<li><a href="#" target="_blank" title="업무추진비(새창)"
													rel="noopener noreferrer">업무추진비</a></li>
											</ul></li>
										<li><a href="#" target="_blank" title="계약정보(새창)"
											rel="noopener noreferrer">계약정보</a>
											<ul>
												<li><a href="#" target="_blank" title="계약정보공개(새창)"
													rel="noopener noreferrer">계약정보공개</a></li>
												<li><a href="#" target="_blank" title="발주계획(새창)"
													rel="noopener noreferrer">발주계획</a></li>
												<li><a href="#" target="_blank" title="입찰공고(새창)"
													rel="noopener noreferrer">입찰공고</a></li>
												<li><a href="#" target="_blank" title="개찰결과(새창)"
													rel="noopener noreferrer">개찰결과</a></li>
												<li><a href="#" target="_blank" title="계약체결현황(새창)"
													rel="noopener noreferrer">계약체결현황</a></li>
												<li><a href="#" target="_blank" title="수의계약공개(새창)"
													rel="noopener noreferrer">수의계약공개</a></li>
											</ul></li>
										<li><a href="#" title="감사정보">감사정보</a>
											<ul>
												<li><a href="#" title="감사예고">감사예고</a></li>
												<li><a href="#" title="자체감사결과">자체감사결과</a></li>
												<li><a href="#" title="외부감사결과">외부감사결과</a></li>
												<li><a href="#" title="국정감사">국정감사</a></li>
												<li><a href="#" title="사전의견청취">사전의견청취</a></li>
												<li><a href="#" title="감사참관신청">감사참관신청</a></li>
												<li><a href="#" title="기타감사자료">기타감사자료</a></li>
												<li><a href="#" title="모범사례">모범사례</a></li>
											</ul></li>
										<li><a href="#" title="각종정보공개">각종정보공개</a>
											<ul>
												<li><a href="#" title="포상후보자 공개">포상후보자 공개</a></li>
												<li><a href="#" title="공무국외여행공개">공무국외여행공개</a></li>
												<li><a href="#" target="_blank" title="현장체험학습공개(새창)"
													rel="noopener noreferrer">현장체험학습공개</a></li>
												<li><a href="#" title="학습준비물집행내역">학습준비물집행내역</a></li>
												<li><a href="#" title="위원회현황">위원회현황</a></li>
												<li><a href="#" title="업무협약(MOU) 체결현황">업무협약(MOU)
														체결현황</a></li>
												<li><a href="#" target="_blank" title="학교운동부 예산집행(새창)"
													rel="noopener noreferrer">학교운동부 예산집행</a></li>
												<li><a href="#" title="물품소요조회">물품소요조회</a></li>
											</ul></li>
									</ul>
								</div></li>
							<li class="ma06"><a href="#" title="교육청소개">교육청소개</a>
								<div class="depth_wrap">
									<ul>
										<li><a href="#" title="교육감인사말">교육감인사말</a>
											<ul>
												<li><a href="#" title="교육감프로필">교육감프로필</a></li>
												<li><a href="#" title="교육감인사말">교육감인사말</a></li>
											</ul></li>
										<li><a href="#" title="역대교육감">역대교육감 </a></li>
										<li><a href="#" title="교육청연혁">교육청연혁 </a></li>
										<li><a href="#" title="대전교육기본방향">대전교육기본방향</a>
											<ul>
												<li><a href="#" title="대전교육기본방향">대전교육기본방향</a></li>
												<li><a href="#" title="주요업무계획">주요업무계획</a></li>
											</ul></li>
										<li><a href="#" title="조직도·직원찾기">조직도·직원찾기</a>
											<ul>
												<li><a href="#" title="조직도·직원찾기">조직도·직원찾기</a></li>
												<li><a href="#" title="스승찾기">스승찾기</a></li>
											</ul></li>
										<li><a href="#" title="전화번호·주소">전화번호·주소</a>
											<ul>
												<li><a href="#" title="본청">본청</a></li>
												<li><a href="#" title="지원청·직속">지원청·직속</a></li>
												<li><a href="#" title="학교(유치원) 현황">학교(유치원) 현황</a></li>
												<li><a href="#" title="코로나19 관련 부서">코로나19 관련 부서</a></li>
											</ul></li>
										<li><a href="#" title="청사안내">청사안내</a>
											<ul>
												<li><a href="#" title="청사안내">청사안내</a></li>
												<li><a href="#" title="찾아오시는길">찾아오시는길</a></li>
											</ul></li>
										<li><a href="#" title="교육청CI">교육청CI</a>
											<ul>
												<li><a href="#" title="교육청CI">교육청CI</a></li>
												<li><a href="#" title="파워브랜드">파워브랜드</a></li>
											</ul></li>
									</ul>
								</div></li>
						</ul>

						<ul>
							<li class="ma07"><a href="#" title="누리집가이드">누리집가이드</a>
								<div class="depth_wrap">
									<ul>
										<li><a href="#" title="로그인">로그인 </a></li>
										<li><a href="#" title="개인정보처리방침">개인정보처리방침 </a></li>
										<li><a href="#" title="개인정보 제3자 제공">개인정보 제3자 제공 </a></li>
										<li><a href="#" title="개인정보처리위탁">개인정보처리위탁 </a></li>
										<li><a href="#" title="저작권 정책">저작권 정책 </a></li>
										<li><a href="#" title="누리집 이용 가이드">누리집 이용 가이드 </a></li>
										<li><a href="#" title="뷰어다운로드">뷰어다운로드 </a></li>
										<li><a href="#" title="화상키보드 이용안내">화상키보드 이용안내 </a></li>
										<li><a href="#" title="배너모음">배너모음 </a></li>
									</ul>
								</div></li>
							<li class="ma08"><a href="#" title="부서별 소개">부서별 소개</a>
								<div class="depth_wrap">
									<ul>
										<li><a href="#" title="공보관">공보관</a>
											<ul>
												<li><a href="#" title="공보관실 과사업">공보관실 과사업</a></li>
												<li><a href="#" title="공보관실 개인별 사무분장">공보관실 개인별 사무분장</a></li>
											</ul></li>
										<li><a href="#" title="감사관">감사관</a>
											<ul>
												<li><a href="#" title="감사관실 과사업">감사관실 과사업</a></li>
												<li><a href="#" title="감사관실 개인별사무분장">감사관실 개인별사무분장</a></li>
											</ul></li>
										<li><a href="#" title="기획예산과">기획예산과</a>
											<ul>
												<li><a href="#" title="기획예산과 과사업">기획예산과 과사업</a></li>
												<li><a href="#" title="기획예산과 개인별사무분장">기획예산과 개인별사무분장</a></li>
											</ul></li>
										<li><a href="#" title="혁신정책과">혁신정책과</a>
											<ul>
												<li><a href="#" title="혁신정책과 과사업">혁신정책과 과사업</a></li>
												<li><a href="#" title="혁신정책과 개인별사무분장">혁신정책과 개인별사무분장</a></li>
											</ul></li>
										<li><a href="#" title="교육복지안전과">교육복지안전과</a>
											<ul>
												<li><a href="#" title="교육복지안전과 과사업">교육복지안전과 과사업</a></li>
												<li><a href="#" title="교육복지안전과 개인별사무분장">교육복지안전과
														개인별사무분장</a></li>
											</ul></li>
										<li><a href="#" title="교육정책과">교육정책과</a>
											<ul>
												<li><a href="#" title="교육정책과 과사업">교육정책과 과사업</a></li>
												<li><a href="#" title="교육정책과 개인별사무분장">교육정책과 개인별사무분장</a></li>
											</ul></li>
										<li><a href="#" title="유초등교육과">유초등교육과</a>
											<ul>
												<li><a href="#" title="유초등교육과 과사업">유초등교육과 과사업</a></li>
												<li><a href="#" title="유초등교육과 개인별사무분장">유초등교육과
														개인별사무분장</a></li>
											</ul></li>
										<li><a href="#" title="중등교육과">중등교육과</a>
											<ul>
												<li><a href="#" title="중등교육과 과사업">중등교육과 과사업</a></li>
												<li><a href="#" title="중등교육과 개인별사무분장">중등교육과 개인별사무분장</a></li>
											</ul></li>
										<li><a href="#" title="과학직업정보과">과학직업정보과</a>
											<ul>
												<li><a href="#" title="과학직업정보과 과사업">과학직업정보과 과사업</a></li>
												<li><a href="#" title="과학직업정보과 개인별사무분장">과학직업정보과
														개인별사무분장</a></li>
											</ul></li>
										<li><a href="#" title="체육예술건강과">체육예술건강과</a>
											<ul>
												<li><a href="#" title="체육예술건강과 과사업">체육예술건강과 과사업</a></li>
												<li><a href="#" title="체육예술건강과 개인별사무분장">체육예술건강과
														개인별사무분장</a></li>
											</ul></li>
										<li><a href="#" title="민주시민교육과">민주시민교육과</a>
											<ul>
												<li><a href="#" title="민주시민교육과 과사업">민주시민교육과 과사업</a></li>
												<li><a href="#" title="민주시민교육과 개인별사무분장">민주시민교육과
														개인별사무분장</a></li>
											</ul></li>
										<li><a href="#" title="총무과">총무과</a>
											<ul>
												<li><a href="#" title="총무과 과사업">총무과 과사업</a></li>
												<li><a href="#" title="총무과 개인별사무분장">총무과 개인별사무분장</a></li>
											</ul></li>
										<li><a href="#" title="행정과">행정과</a>
											<ul>
												<li><a href="#" title="행정과 과사업">행정과 과사업</a></li>
												<li><a href="#" title="행정과 개인별사무분장">행정과 개인별사무분장</a></li>
											</ul></li>
										<li><a href="#" title="재정과">재정과</a>
											<ul>
												<li><a href="#" title="재정과 과사업">재정과 과사업</a></li>
												<li><a href="#" title="재정과 개인별사무분장">재정과 개인별사무분장</a></li>
											</ul></li>
										<li><a href="#" title="시설과">시설과</a>
											<ul>
												<li><a href="#" title="시설과 과사업">시설과 과사업</a></li>
												<li><a href="#" title="시설과 개인별사무분장">시설과 개인별사무분장</a></li>
											</ul></li>
									</ul>
								</div></li>
							<li class="ma09"><a href="#" target="_blank"
								title="특성화페이지(새창)" rel="noopener noreferrer">특성화페이지</a>
								<div class="depth_wrap">
									<ul>
										<li><a href="#" target="_blank" title="대전자유학년제지원센터(새창)"
											rel="noopener noreferrer">대전자유학년제지원센터 </a></li>
										<li><a href="#" target="_blank" title="에듀힐링센터(새창)"
											rel="noopener noreferrer">에듀힐링센터 </a></li>
										<li><a href="#" target="_blank" title="컨설팅장학(새창)"
											rel="noopener noreferrer">컨설팅장학 </a></li>
										<li><a href="#" target="_blank" title="학교보건(새창)"
											rel="noopener noreferrer">학교보건 </a></li>
										<li><a href="#" target="_blank" title="학교시설종합정보(새창)"
											rel="noopener noreferrer">학교시설종합정보 </a></li>
										<li><a href="#" target="_blank" title="기록관(새창)"
											rel="noopener noreferrer">기록관 </a></li>
										<li><a href="#" target="_blank" title="교육감페이지(새창)"
											rel="noopener noreferrer">교육감페이지 </a></li>
										<li><a href="#" target="_blank" title="계약정보공개(새창)"
											rel="noopener noreferrer">계약정보공개 </a></li>
										<li><a href="#" target="_blank" title="교원치유지원센터(새창)"
											rel="noopener noreferrer">교원치유지원센터 </a></li>
										<li><a href="#" target="_blank" title="교육과정(새창)"
											rel="noopener noreferrer">교육과정 </a></li>
										<li><a href="#" target="_blank" title="법무행정서비스(새창)"
											rel="noopener noreferrer">법무행정서비스 </a></li>
										<li><a href="#" target="_blank" title="청렴투명행정(새창)"
											rel="noopener noreferrer">청렴투명행정 </a></li>
										<li><a href="#" target="_blank" title="학교급식(새창)"
											rel="noopener noreferrer">학교급식 </a></li>
										<li><a href="#" target="_blank" title="학교시설사용예약(새창)"
											rel="noopener noreferrer">학교시설사용예약 </a></li>
										<li><a href="#" target="_blank" title="학원 교습비 공개(새창)"
											rel="noopener noreferrer">학원 교습비 공개 </a></li>
										<li><a href="#" target="_blank" title="대전형혁신학교(새창)"
											rel="noopener noreferrer">대전형혁신학교 </a></li>
									</ul>
								</div></li>
						</ul>

						<ul>
							<li class="ma10"><a href="#" target="_blank"
								title="위(Wee) 센터(새창)" rel="noopener noreferrer">위(Wee) 센터 </a>
								<div class="depth_wrap">
									<ul>
										<li><a href="#" title="공지사항">공지사항 </a></li>
										<li><a href="#" title="센터소개">센터소개 </a></li>
										<li><a href="#" title="이용안내">이용안내 </a></li>
										<li><a href="#" title="자료실">자료실 </a></li>
									</ul>
								</div></li>
							<li class="ma11"><a href="#" target="_blank"
								title="학습종합 클리닉센터(새창)" rel="noopener noreferrer">학습종합 클리닉센터
							</a>
								<div class="depth_wrap">
									<ul>
										<li><a href="#" title="센터 소개">센터 소개 </a></li>
										<li><a href="#" title="센터 지원 사업">센터 지원 사업 </a></li>
										<li><a href="#" title="센터 소식">센터 소식 </a></li>
									</ul>
								</div></li>
							<li class="ma12"><a href="#" target="_blank"
								title="다문화교육지원센터(새창)" rel="noopener noreferrer">다문화교육지원센터</a>
								<div class="depth_wrap">
									<ul>
										<li><a href="#" title="대전다문화교육지원센터">대전다문화교육지원센터 </a></li>
										<li><a href="#" title="탈북학생교육">탈북학생교육 </a></li>
										<li><a href="#" title="자료마당">자료마당 </a></li>
										<li><a
											href="<%=request.getContextPath()%>/board/notificationBoard/list.do"
											title="알림방">알림방 </a></li>
										<li><a href="#" target="_blank" title="중앙다문화교육센터(새창)"
											rel="noopener noreferrer">중앙다문화교육센터 </a></li>
										<li><a href="#" target="_blank" title="동부다문화교육센터(새창)"
											rel="noopener noreferrer">동부다문화교육센터 </a></li>
										<li><a href="#" target="_blank" title="서부다문화교육센터(새창)"
											rel="noopener noreferrer">서부다문화교육센터 </a></li>
										<li><a href="#" target="_blank"
											title="다누리(다문화가족지원포털)(새창)" rel="noopener noreferrer">다누리(다문화가족지원포털)
										</a></li>
									</ul>
								</div></li>
						</ul>

						<ul>
							<li class="ma13"><a href="#" title="교육복지우선지원사업">교육복지우선지원사업</a>
								<div class="depth_wrap">
									<ul>
										<li><a href="#" title="사업소개">사업소개 </a></li>
										<li><a href="#" title="사업현황">사업현황 </a></li>
										<li><a href=# title="사업자료실">사업자료실 </a></li>
									</ul>
								</div></li>
							<li class="ma14"><a href="#" title="학교급식">학교급식</a>
								<div class="depth_wrap">
									<ul>
										<li><a href="#" title="학교급식소리함">학교급식소리함 </a></li>
										<li><a href="#" title="업무자료실">업무자료실 </a></li>
										<li><a href="#" title="영양·식생활교육">영양·식생활교육 </a></li>
										<li><a href="#" title="위생 및 식중독관리">위생 및 식중독관리 </a></li>
										<li><a href="#" title="학교급식지역연구협의회">학교급식지역연구협의회 </a></li>
										<li><a href="#" title="관련누리집">관련누리집 </a></li>
									</ul>
								</div></li>
							<li class="ma15"><a href="#" title="돌봄지원센터">돌봄지원센터</a>
								<div class="depth_wrap">
									<ul>
										<li><a href="#" title="돌봄지원센터">돌봄지원센터 </a></li>
										<li><a href="#" title="돌봄정책자료실">돌봄정책자료실 </a></li>
									</ul>
								</div></li>
						</ul>


					</div>
					<button type="button" class="btn_closed" title="전체메뉴 닫기 버튼">
						<span class="hid">전체메뉴 닫기</span>
					</button>
				</div>

			</div>
		</header>
		<!-- navbar end -->

		<!-- sub_container_wrap start -->
		<div id="sub_container_wrap">

			<!-- sub_content_wrap start -->
			<div class="sub_content_wrap">
				<!-- aside start -->
				<aside id="menu">
					<h2>
						<span>정보마당</span>
					</h2>
					<nav class="faq-box">
						<ul class="lnb">
							<li class="dep01 "><a class="faq-box__question " href="#">소식알림방</a>
								<ul class="subLnb faq-box__answer">
									<li class=""><a href="#">공지사항</a></li>
									<li class=""><a href="#">고시·공고</a></li>
									<li class="on"><a
										href="#" onclick="loaction.href='<%=request.getContextPath()%>/board/weeklyReportBoard/list.do'">주간업무</a></li>
									<li class=""><a href="#">알림방</a></li>
								</ul></li>
							<li class="dep01"><a class="faq-box__question " href="#">인사정보</a>
								<ul class="subLnb faq-box__answer">
									<li class=""><a href="<%=request.getContextPath() %>/board/teacherAffairsBoard/list.do">교원인사</a></li>
									<li class=""><a href="<%=request.getContextPath() %>/board/nomalAffairsBoard/list.do">일반직인사</a></li>
									<li class=""><a href="#">교육공무직인사</a></li>
									<li class=""><a href="#">인사 정보 조회</a></li>
								</ul></li>
							<li class="dep01"><a class="faq-box__question " href="#">시험정보</a>
								<ul class="subLnb faq-box__answer">
									<li class=""><a href="<%=request.getContextPath() %>/board/appointmentBoard/list.do">임용시험</a></li>
									<li class=""><a href="<%=request.getContextPath() %>/board/qualificationBoard/list.do">검정고시</a></li>
								</ul></li>
							<li class="dep01"><a class="faq-box__question " href="#">구인·구직</a>
								<ul class="subLnb faq-box__answer">
									<li class=""><a href="#">기간제교사</a></li>
									<li class=""><a href="#">학교인력 채용공고</a></li>
									<li class=""><a href="#">산학겸임.강사.명예교사신청</a></li>
								</ul></li>
							<li class="dep01"><a class="faq-box__question" href="#">연수·교육안내</a>
								<ul class="subLnb faq-box__answer">
									<li class=""><a href="#">교원연수</a></li>
									<li class=""><a href="#">특수분야연수</a></li>
								</ul></li>
							<li class="dep01"><a class="faq-box__question" href="#">업무매뉴얼</a>
								<ul class="subLnb faq-box__answer">
									<li class=""><a href="#">유치원업무 길라잡이</a></li>
									<li class=""><a href="#">학교업무 길라잡이(초등)</a></li>
									<li class=""><a href="#">학교업무 길라잡이(중·고등)</a></li>
									<li class=""><a href="#">학교업무지원자료실</a></li>
									<li class=""><a href="#">단위학교 공문서 발송현황</a></li>
									<li class=""><a href="#">교육행정업무매뉴얼</a></li>
									<li class=""><a href="#">현장의견제안</a></li>
									<li class=""><a href="#">정보보안 안내</a></li>
								</ul></li>
							<li class="dep01"><a class="faq-box__question" href="#">학교운영위원회</a>
								<ul class="subLnb faq-box__answer">
									<li class=""><a href="#">연혁 및 구성절차</a></li>
									<li class=""><a href="#">관련법령·조례</a></li>
									<li class=""><a href="#">안건처리절차</a></li>
									<li class=""><a href="#">관련자료</a></li>
									<li class=""><a href="#" target="_blank"
										rel="noopener noreferrer">전국학부모지원센터</a></li>
								</ul></li>
							<li class="dep01"><a class="faq-box__question" href="#">학교안전공제회</a>
								<ul class="subLnb faq-box__answer">
									<li class=""><a href="#">운영개요</a></li>
									<li class=""><a href="#">공제급여지급요건 및 범위</a></li>
									<li class=""><a href="#">사고통지 및 공제급여청구</a></li>
									<li class=""><a href="#">질의응답</a></li>
									<li class=""><a href="#">자료실</a></li>
								</ul></li>
							<li class="dep01"><a class="faq-box__question" href="#">법인·학원설립안내</a>
								<ul class="subLnb faq-box__answer">
									<li class=""><a href="#">공익법인설립안내</a></li>
									<li class=""><a href="#">학원설립안내</a></li>
									<li class=""><a href="#">학교법인현황</a></li>
									<li class=""><a href="#">학원(교습소) 공지</a></li>
								</ul></li>
							<li class=""><a href="#">온라인학습터</a></li>
							<li class="dep01"><a class="faq-box__question" href="#">통합자료실</a>
								<ul class="subLnb faq-box__answer">
									<li class=""><a href="#">통합자료실</a></li>
									<li class=""><a href="#">코로나19 자료실</a></li>
									<li class=""><a href="#">학사일정 공유 자료실</a></li>
								</ul></li>
							<li class=""><a href="#" target="_blank"
								rel="noopener noreferrer">법무행정서비스</a></li>
						</ul>
					</nav>
				</aside>
				<!-- aside -->

				<!-- sub_content start -->
				<section id="sub_content">