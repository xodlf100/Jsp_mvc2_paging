<%@page import="java.text.DecimalFormat"%>
<%@page import="showM.Dto.Dto"%>
<%@page import="java.util.List"%>
<%@page import="showM.Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>게시판</title>
<link rel="stylesheet" href="./css/reset.css" />
<link rel="stylesheet" href="./css/common.css" />
<link rel="stylesheet" href="./css/board.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
</head>
<style>
	.header {
		background: #faf6f6f8;
	}
	
	.under {
	    display: flex;
   		justify-content: center;
   		margin-top: 1rem;
	}
	.underPage {
		display: flex;
	}
	
	.underPage li a {
		padding: 2rem;
		font-size: 1.6rem;
	}
	
	.btnn {
		font-size: 1.5rem;
	    font-weight: bold;
	    background: #CCB;
	    border-radius: 20px;
	   
	}
</style>
<body>
	<div class="wrap">
		<%@include file="header.jsp"%>
		<!-- header -->

		<div class="sec_contents">
			<div class="inner row">
				<div class="contents">
					<ul class="head">
						<li>번호</li>
						<li>제목</li>
						<li>작성자</li>
						<li>작성시간</li>
					</ul>
					<c:forEach var="pic" items="${a}">
					<ul class="main">
						<li>${pic.idx}</li>
						<li><a href="/contentDetail?idx=${pic.idx}">${pic.title }</a></li>
						<li>${pic.joinName}</li>
						<li>${fn:substring(pic.regdate,0,16)}</li>
					</ul>
						<hr>
					</c:forEach>
				</div>
				<div class="under">
					<c:if test="${paging.prev}">
					<a href="${path}/board?pageNum=${paging.startNum - 1}" class="btnn">이전</a>
					</c:if>
					<ul class="underPage">
					<c:forEach begin="${paging.startNum}" end="${paging.endNum}" var="i">
						<li><a href="${path}/board?pageNum=${i}">${i}</a></li>
					</c:forEach>
					</ul>
					<c:if test="${paging.next}">
					<a href="${path}/board?pageNum=${paging.endNum + 1}" class="btnn">다음</a>
					</c:if>
				</div>
				<div class="BtnM">
				<button onclick="check()" class="btn1 custom-btn btn-11">글쓰기</button>
				</div>
			</div>
		</div>
		<!-- contents -->

		<%@include file="footer.jsp"%>
		<!-- footer -->
	</div>
	<!-- wrap -->
	
	<c:if test="${empty id}">
	<script>
	function check(){
	alert("로그인을 해주세요.")
	location.href="login.jsp";
	}
	</script>
	</c:if>
	
	<c:if test="${!empty id}">
	<script>
	function check(){
		location.href="/write";
	}
	</script>
	</c:if>
</body>
</html>
