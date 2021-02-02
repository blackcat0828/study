<%@page import="vo.Glasses" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#listForm{
		width:640px;
		border:1px solid red;
		margin:auto;
	}
	
	h2 {
		text-align:center;
	}
	
	img {
		width: 280px;
		height: 280px;
		border: none;
	}
	
	#content_main{
		height:300px;
	}
	
	#content_left{
		width:300px;
		float:left;
	}
	
	#content_right{
		width: 340px;
		float:left;
	}
	
	#commandList{
		text-align: center;
	}
	
	#desc{
		height:170px;
		background: skyblue;
	}

</style>
</head>
<body>
<section id = "listForm">
<h2>${glasses.kind }의 상세정보</h2>
	<section id="content_main">
		<section id = "content_left">
			<img src="resources/images/${glasses.image }" />
		</section>
	<section id = "content_right">
		<b>품종: </b> ${glasses.kind }<br>
		<b>가격: </b> ${glasses.price }<br>
		<b>브랜드: </b> ${glasses.brand }<br>
		<p id="desc">
		<b>내용 : </b> ${glasses.content }<br>
		</p>
	</section>
	<div style="clear:both"></div>
	<nav id = "commandList">
		<a href="glassesList.glasses">쇼핑계속하기</a>
		<a href="glassesCartAdd.glasses?id=${glasses.id }">장바구니에담기</a>
	</nav>
	</section>
</section>
</body>
</html>