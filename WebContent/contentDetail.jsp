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
<link rel="stylesheet" href="./css/contentDetail.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
</head>
<style>
	.header {
		background: #faf6f6f8;
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
						<c:if test="${id eq a.joinName}">
						<form action="/contentUpdate" method="get" class="form1">
							<input type="hidden" name="idx" value="${a.idx}" />
							title <br><input type="text" name="title" class="list" value="${a.title}" /><br>
							ID <br><input type="text" name="joinName" class="list" value="${a.joinName}" readonly/><br>
							Date <br><input type="text" name="regdate" class="list" value="${fn:substring(a.regdate,0,16)}" readonly/><br>
							comment <br><textarea name="content" class="content" rows="10" >${a.content}</textarea><br>
							<div class="btnList">
							<button type="submit" class="btn1 custom-btn btn-11">수정</button>
							<button onclick="/board" class="btn1 custom-btn btn-11">목록</button>
							<button onclick="return check()" class="btn1 custom-btn btn-11">삭제</button>
							</div>
						</form>
						</c:if>
						<c:if test="${id ne a.joinName}">
						<form action="/contentUpdate" method="get" class="form1">
							<input type="hidden" name="idx" value="${a.idx}" />
							title <br><input type="text" name="title" class="list" value="${a.title}" readonly/><br>
							ID <br><input type="text" name="joinName" class="list" value="${a.joinName}" readonly/><br>
							Date <br><input type="text" name="regdate" class="list" value="${fn:substring(a.regdate,0,16)}" readonly/><br>
							comment <br><textarea name="content" class="content" rows="10" readonly>${a.content}</textarea><br>
							<div class="btnList">
							<button onclick="/board" class="btn1 custom-btn btn-11">목록</button>
							</div>
						</form>
						</c:if>
					</div>
				</div>
			</div>
		</div>
		<!-- contents -->	

		<%@include file="footer.jsp"%>
		<!-- footer -->



	</div>
	<!-- wrap -->
	
	<script>
	
	function check(){
		if(confirm("삭제하시겠습니까?")){
			location.href='/contentDetailDelete?idx=${a.idx}'
		} else {
			return false;
		}
	}
	
	</script>
	
</body>
</html>
