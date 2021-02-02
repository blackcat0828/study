<%@page import="java.util.HashMap" %>
<%@page import="vo.Glasses" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#listForm{
		width:700px;
		height:500px;
		border:1px solid red;
		margin:auto;
	}
	
	h2 {
		text-align:center;
	}
	
	table{
		margin:auto;
		width:550px;
	}
	
	.div_empty{
		background-color:red;
		width:100%;
		height: 100%;
		textalign: center;
	}
	
	#todayImageList{
		text-align: center;
	}
	
	#productImage{
		width: 150px;
		height: 150px;
		border: none;
	}
	
	#todayImage{
		width: 100px;
		height: 100px;
		border: none;
	}

</style>

</head>
<body>
<section id= "listForm">
<c:if test="${glassesList != null }">
<h2>개 상품 목록 <a href="glassesRegistForm.glasses">개상품등록</a></h2>
<table>
	<tr>
		<c:forEach var = "glasses" items="${glassesList }" varStatus="status">
		<td>
			<a href="dogView.dog?id=${glasses.id }">
				<img src="resources/images/${glasses.image}" id="productImage"/>
			</a>
			상품명:${glasses.kind }<br>
			가격:${glasses.price }<br>
		</td>
		<c:if test="${((status.index+1) mod 4)==0 }">
	</tr>
	<tr>
		</c:if>
		</c:forEach>	
	</tr>
</table>
</c:if>

<c:if test="${glassesList==null }">
	<div class="div_empty">
		개 상품이 없습니다. 분양불가
	</div>
</c:if>
<c:if test="${todayImageList != null }">
<div id="todayImageList">
	<h2>오늘 본 개 상품 목록</h2>
<table>
	<tr>
		<c:forEach var="todayImage" items="${todayImageList }" varStatus="status">
		<td>
			<img src="resources/images/${todayImage }" id="todayImage" />
		</td>
			<c:if test="${((status.index+1) mod 4)==0 }">
			</tr>
			<tr>
		</c:if>
		</c:forEach>
	</tr>
</table>
</div>
</c:if>
</section>
</body>
</html>