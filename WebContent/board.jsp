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
	
	.sec_contents {
		height: 800px;
	}
	
	.contents {
		border: 1px solid black;
	    width: 60%;
    	height: 500px;
   	    margin: 10rem auto 0 auto;
	}
	
	.head {
		display: flex;
		justify-content: space-between;
	    height: 40px;
	    font-size: 1.8rem;
	    font-weight: bold;
	    padding: 0.5rem 2rem 0.5rem 2rem;
        background: #777;
  	  	color: #fff;
        
	}
	
	.main {
		display: flex;
    	justify-content: space-between;
    	font-size: 1.5rem;
    	padding: 0.5rem 2rem 0.5rem 3rem;
    	margin-bottom: 0.5rem;
	}
	
	.BtnM {
		width: 26.88%;
		margin: 2rem 0 0 auto;
	}
	
	.head li:nth-child(1){
		width: 5%;
	}
	.head li:nth-child(2){
		width: 65%;
  	  	padding-left: 35.2rem;
	}
	.head li:nth-child(3){
	    width: 7%;
	    margin-right: 4rem;
	}
	.head li:nth-child(4){
		width: 10%;
	}
	
	.main li:nth-child(1){
		width: 5%;
	}
	.main li:nth-child(2){
		width: 70%;
		text-align: center;
	}
	.main li:nth-child(3){
		width: 10%;
	}
	.main li:nth-child(4){
		width: 11%;
	}
	
	.custom-btn {
	  width: 130px;
	  height: 40px;
	  padding: 10px 25px;
	  border: 2px solid #000;
	  font-family: 'Lato', sans-serif;
	  font-weight: 500;
	  background: transparent;
	  cursor: pointer;
	  transition: all 0.3s ease;
	  position: relative;
	  display: inline-block;
	}
	
	.btn-11 {
	  overflow: hidden;
	  transition: all 0.3s ease;
	}
	.btn-11:hover {
	   background: #000;
	  color: #fff;
	}
	.btn-11:before {
	    position: absolute;
	    content: '';
	    display: inline-block;
	    top: -180px;
	    left: 0;
	    width: 30px;
	    height: 100%;
	    background-color: #fff;
	    animation: shiny-btn1 3s ease-in-out infinite;
	}
	.btn-11:active{
	  box-shadow:  4px 4px 6px 0 rgba(255,255,255,.3),
	              -4px -4px 6px 0 rgba(116, 125, 136, .2), 
	    inset -4px -4px 6px 0 rgba(255,255,255,.2),
	    inset 4px 4px 6px 0 rgba(0, 0, 0, .2);
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
