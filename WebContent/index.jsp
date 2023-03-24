<%@page import="java.text.DecimalFormat"%>
<%@page import="showM.Dto.Dto"%>
<%@page import="java.util.List"%>
<%@page import="showM.Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>메인페이지</title>
<link rel="stylesheet" href="/css/reset.css" />
<link rel="stylesheet" href="/css/common.css" />
<link rel="stylesheet" href="/css/main.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
</head>

<body>
	<div class="wrap">
		<%@include file="header.jsp"%>
		<!-- header -->
		<div class="sec_banner">
			<div class="row">
				<div class="banner">
					<div class="swiper mySwiper">
						<div class="swiper-wrapper">
							<c:forEach var="i" begin="1" end="9">
							<div class="swiper-slide">
								<img src="./img/${i}.jfif" alt="${i}번" />
							</div>
							</c:forEach>
						</div>
						<div class="swiper-pagination"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- banner -->

		<div class="sec_contents">
			<div class="inner row">
				<div class="contents">
					<h2 class="weekly">WEEKLY BEST</h2>
					<ul class="content">
						<c:forEach var="pic" items="${a}">
						<li class="content_li"><a href="./product.jsp?idx=${pic.idx}"><img src="${pic.picture}"
								alt="${pic.title}" /></a>
							<div class="title1">${pic.contents}</div>
							<div class="title2">${pic.title}</div>
							<hr>
							<div class="title3">${pic.price}원
							</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<!-- contents -->

		<%@include file="footer.jsp"%>
		<!-- footer -->

</div>
	<!-- wrap -->
	<script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
	<script src="./js/main.js"></script>
</body>
</html>
