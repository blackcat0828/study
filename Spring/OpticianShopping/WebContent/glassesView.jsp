<%@page import="vo.Glasses" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	#listForm{
		width:640px;
		margin:auto;
		
	}
	
	body { 
		padding-bottom: 70px;
		padding-top: 70px;
	 }
	
	h2 {
		text-align:center;
	}


</style>
</head>
<body>
<%@ include file="header.jsp" %>
<section id = "listForm">
	<div class="col-xs-8 col-md-10">
		    <div class="thumbnail">
		      <h2>${glasses.kind }의 상세정보</h2>
		      <img src="resources/images/${glasses.image}" alt="image" style="min-height:300px;height:300px;width:100%;"  >
		      <div class="caption">
		        <h3>${glasses.kind }</h3>
		        <b>가격:</b>${glasses.price }<br>
		        <b>브랜드:</b>${glasses.brand }<br>
		        <b>설명:</b>${glasses.content }<br><br>
		        <a href="glassesList.glasses" class="btn btn-primary" role="button">쇼핑계속하기</a>
		        <c:if test="${userId !=null }">
		        <a href="glassesCartAdd.glasses?id=${glasses.id }" class="btn btn-primary" role="button">장바구니에담기</a>
		        </c:if>
		        <c:if test="${userId == 'admin' }">
		        <a href="glassesUpdateForm.glasses?id=${glasses.id }" class="btn btn-primary" role="button">상품 수정</a>
		        <a href="glassesDelete.glasses?id=${glasses.id }" class="btn btn-primary" role="button">상품 삭제</a>
		        </c:if>
		      </div>
		    </div>
		  </div>
	
</section>
<%@ include file="footer.jsp" %>
</body>
</html>