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
		width: 50%;
		height: 600px;
		background: crimson;
		margin: 10rem auto 0 auto;
	}
	
</style>
<body>
	<div class="wrap">
		<%@include file="header.jsp"%>
		<!-- header -->

		<div class="sec_contents">
			<div class="inner row">
				<div class="contents">
					<div class="center">
						<form action="/write" method="post" class="form1">
							ID : <input type="text" name="id"/>
							제목 : <input type="text" name="title"/>
							작성일자 : <input type="text" name="regdate"/>
							내용 : <input type="text" name="joinName"/>
							<input type="submit" value="작성">
						</form>
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
