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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	body { 
		padding-bottom: 70px;
		padding-top: 70px;
	 }
	
	#listForm{
		width:1000px;

		margin:auto;
	}
	
	h2 {
		text-align:center;
	}
	
	table{
		margin:auto;
		width:1000px;
	}
	
	.div_empty{
		background-color:red;
		width:100%;
		height: 100%;
		textalign: center;
	}
	
	#todayImageList{
		text-align: center;
		margin: auto;
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
	
	.floating { position: fixed; right: 45%; top: 180px; margin-right: -720px; text-align:center; width: 200px; }


</style>
<script>
function check(theForm){
		if(!theForm.searchValue.value){
				alert("검색 값을 입력하세요.")
				return true;
		}else{
			theForm.submit();
		}
		
}
</script>


</head>
<body>

<%@ include file="header.jsp" %>

<section id= "listForm">
<c:if test="${glassesList != null }">
<div class="jumbotron">
<h2>상품 목록 </h2>
</div>

<form class="form-inline" action="glassesList.glasses" method="get">
	<select class="form-control" name="searchType" id="searchType">
			<option value="종류">종류</option>
			<option value="최대가격">최대가격</option>
	</select>
	<input class="form-control mr-sm-2" type="text" name="searchValue" id="searchValue" placeholder="검색" />
	<button class="btn btn-success" onclick="check(this.form)" />검색</button>
</form>
<br>
	<div class="row">
		<c:forEach var = "glasses" items="${glassesList }" varStatus="status">
		
		<!-- <div class="row"> -->
		  <div class="col-xs-6 col-md-3">
		    <div class="thumbnail">
		      <img src="resources/images/${glasses.image}" alt="image" style="min-height:180px;height:180px;width:100%;"  >
		      <div class="caption">
		        <h3>${glasses.kind }</h3>
		        <p>가격:${glasses.price }</p>
		        <p><a href="glassesView.glasses?id=${glasses.id }" class="btn btn-primary" role="button">상세정보</a></p>
		      </div>
		    </div>
		  </div>
		<!-- </div> -->
<%-- 		<c:if test="${((status.index+1) mod 4)==0 }">
		<br>
		</c:if> --%>
		</c:forEach>	
	</div>
</c:if>

<c:if test="${glassesList==null }">
	<div class="div_empty">
		상품이 없습니다. 상품을 등록하세요.
	</div>
</c:if>
</section>


<c:if test="${todayImageList[0] != null }">
<div class="floating">
<h3>최근 본 상품 목록</h3>

		<c:forEach var="todayImage" items="${todayImageList }" varStatus="status">
	
			<img src="resources/images/${todayImage }" id="todayImage" />
	
			<c:if test="${((status.index+1) mod 4)==0 }">

		</c:if>
		</c:forEach>


</div>
</c:if>

<footer>
<%@ include file="footer.jsp" %>
</footer>
</body>
</html>