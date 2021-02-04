<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	#registForm{
		width: 500px;
		height: 600px;
		margin:auto;
	}
	
	h2 {
		text-align: center;
	}
	
	table {
		margin:auto;
		width: 450px;
	}

	
	#commandCell{
		text-align: center;
	}
</style>

</head>
<body>
<%@ include file="header.jsp" %>
<section id = "registForm">
	<header>
		<h2>상품 정보등록</h2>
	</header>
	<form class="form-group" action="glassesRegist.glasses" method="post" name = "writeForm" enctype="multipart/form-data">
	
	<div class="form-group">
			<label for = "kind">종류 : </label>
			<input type = "text" class="form-control" name = "kind" id = "kind" required="required" />
	</div>
	
	
	<div class="form-group">
			<label for = "price">가격 : </label>
			<input type = "text" class="form-control" name = "price" id = "price" />
	</div>
	
	
	<div class="form-group">
			<label for = "brand">브랜드 : </label>
			<input type = "text" class="form-control" name = "brand" id = "brand" />
	</div>	
	
	<div class="form-group">	
			<label for = "content">글내용 : </label>
			<textarea name="content" class="form-control" id="content" rows="13" cols="40" wrap="off"></textarea>
	</div>	
	
	<div class="form-group">
			<label for = "image">상품이미지 : </label>
			<input type = "file"  name = "image" id = "image" />
	</div>
	<div class="form-group">
			<button type="submit" class="btn btn-default">상품등록</button>
			<button type="reset" class="btn btn-default">다시작성</button>
			
			
	</div>
	</form>
	
</section>
<%@ include file="footer.jsp" %>
</body>
</html>