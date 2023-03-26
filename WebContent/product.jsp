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
<title>product</title>
<link rel="stylesheet" href="./css/reset.css" />
<link rel="stylesheet" href="./css/common.css" />
<link rel="stylesheet" href="./css/product.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
</head>
<style>
	
	
	
	
</style>
<body>
	<div class="wrap">
		<%@include file="header.jsp"%>
		<!-- header -->
		
		<div class="sec_contents">
			<div class="contents">
				<div class="main1">
					<div class="main1_1"><img src="${dto.picture}" alt="5개 사진 항목"></div>
					<p class="middle_text">WITH ITEM</p>
					<hr>
					<ul class="limitSel">
					<c:forEach var="pic" items="${dtoo}">
						<a class="limitSel_li" href="product?idx=${pic.idx}"><img src="${pic.picture}" alt="WITH ITEM"></a>					
					</c:forEach>	
					</ul>
					<hr>
					<div class="benefit"><img src="./img/product.jpg" alt="product"></div>
				</div>
				<div class="main2">
					<div class="main2_1">
						<hr>
						<div class="detail">
							<ul>
								<li>상품명</li>
								<li>${dto.title}</li>
							</ul>
							<ul>
								<li>세부 사항</li>
								<li>${dto.contents}</li>
							</ul>
							<ul>
								<li>price</li>
								<li>${dto.price}</li>
							</ul>
							<ul>
								<li>환불조건</li>
								<li>배송 완료 후 7일 이내에 가능합니다.</li>
							</ul>
						</div>
					</div>
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
