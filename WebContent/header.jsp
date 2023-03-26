<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.hform{
		display: flex;
	}
	
	.find2 {
		padding-left: 0.5rem;
	}
	
	.hbutton {
		background: none;
		border-style: none;
	}
	
	.hbutton > i {
		font-size: 3rem;
		margin-left: 2rem;
		cursor: pointer;
	}
</style>
</head>
<body>
	<div class="sec_header">
		<div class="header">
			<h1 class="logo" onclick="location.href='/index'">FLADAY</h1>
			<div class="find">
				<form action="/search" method="get" class="hform">
					<input type="text" class="find2" placeholder="검색어 입력" name="keyword"/>
					 <button type="submit" class="hbutton">
					 <i class="fa-solid fa-magnifying-glass"></i>
					 </button>
				 </form>
			</div>
			
			<c:if test="${empty id}">
			<div class="header-right">
				<a href='login.jsp' class="logR">로그인</a>
				<a href='/join'>회원가입</a>
			</div>
			</c:if>
			

			<c:if test="${!empty id}">
			<div class="header-right">
				<p class="logRR">${id}님 환영합니다.</p>
				<a href="/logout" class="logR">로그아웃</a> 
				<a href="/mypage">내정보보기</a>
			</div>
			</c:if>
			
		</div>
	</div>
</body>
</html>