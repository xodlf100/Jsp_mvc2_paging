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
		margin: 10rem auto 0 auto;
		font-size: 2rem;
		padding: 2rem;
	}
	
	.form1 {
	}
	
	.cont {
		width: 800px;
	    height: 300px;
	}
	
	.title {
	    width: 100%;
    	height: 25px;	
   	    margin-bottom: 5%;
	}
	
	.content {
	    width: 100%;
    	height: 400px;	
	}
	
	.btn1 {
		float: right;
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


@-webkit-keyframes shiny-btn1 {
    0% { -webkit-transform: scale(0) rotate(45deg); opacity: 0; }
    80% { -webkit-transform: scale(0) rotate(45deg); opacity: 0.5; }
    81% { -webkit-transform: scale(4) rotate(45deg); opacity: 1; }
    100% { -webkit-transform: scale(50) rotate(45deg); opacity: 0; }
}

.form1  button:nth-child(8) {
	margin-left: 1rem;
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
						<form action="/writeAction" method="post" class="form1">
							title <br><input type="text" name="title" class="title"/><br>
							comment <br><textarea name="content" class="content" rows="10"></textarea><br>
							<input type="hidden" name="joinName" />
							<button type="submit" class="btn1 custom-btn btn-11" onclick="return check()">작성</button>
						</form>
							<button class="btn1 custom-btn btn-11" onclick="location.href='/board'">이전</button>
					</div>
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
	alert("세선이 만료되었습니다.");
	location.href="/index";
	</script>
	</c:if>

	
	<script>
	let title = document.querySelector('.title')
	let titleValue;
	function check(){	
		titleValue = title.value;
		if(titleValue == ""){
			alert("제목을 입력해주세요.");
			title.focus();
			return false;
		}
	}
	</script>
	
</body>
</html>
