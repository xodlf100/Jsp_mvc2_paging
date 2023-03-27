<%@page import="java.text.DecimalFormat"%>
<%@page import="showM.Dto.Dto"%>
<%@page import="java.util.List"%>
<%@page import="showM.Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
    	height: 600px;
   	    margin: 10rem auto 0 auto;
	}
	
	.head {
		display: flex;
		justify-content: space-between;
	    background: crimson;
	    height: 40px;
	    font-size: 1.8rem;
	    font-weight: bold;
	    padding: 0.5rem 2rem 0.5rem 2rem;
        background: green;
        
	}
	
	.main {
		display: flex;
    	justify-content: space-between;
    	font-size: 1.5rem;
    	padding: 0.5rem 2rem 0.5rem 3rem;
    	
	}
	
	.BtnM {
		width: 22.3%;
		margin: 2rem 0 0 auto;
	}
	
	.head li:nth-child(1){
		width: 5%;
	}
	.head li:nth-child(2){
		width: 70%;
		padding-left: 37rem;
	}
	.head li:nth-child(3){
		width: 10%;
	}
	.head li:nth-child(4){
		width: 8%;
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
		width: 8%;
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
						<li>${pic.title }</li>
						<li>${pic.joinName}</li>
						<li>${fn:split(pic.regdate, " ")[0]}</li>
					</ul>
					</c:forEach>
				</div>
				<div class="BtnM">
				<input type="button" value="글쓰기" onclick="location.href='/write'"/>
				</div>
			</div>
		</div>
		<!-- contents -->

		<%@include file="footer.jsp"%>
		<!-- footer -->



	</div>
	<!-- wrap -->
</body>
</html>
