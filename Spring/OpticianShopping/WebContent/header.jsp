<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>



<!DOCTYPE html>
<html>
<head>
  <title>상품관리</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">핀테크 쇼핑몰</a>
    </div>
    
    <ul class="nav navbar-nav ml-auto">
      <li class="active"><a href="shopMain.jsp">Home</a></li>
      <li class="dropdown"><a class="btn-lg dropdown-toggle" data-toggle="dropdown" href="#">공지사항<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li class="list-group-item"><a href="<c:url value="#"/>">게시판</a></li>
        </ul>
      </li>
    </ul>  

    <ul class="nav navbar-nav navbar-right">
	   	 <c:choose>
			<c:when test="${empty userId}">
      <li><a  class="btn-lg dropdown-toggle" href="<c:url value="loginForm.member"/>"><span class="glyphicon glyphicon-user"></span>로그인</a></li>
      <li><a  class="btn-lg dropdown-toggle" href="<c:url value="addMemberForm.member"/>"><span class="glyphicon glyphicon-log-in"></span>회원가입</a></li>
				
			</c:when>
			<c:when test="${userId == 'admin'}">
				<li style="padding-top:8px; color:white;font-size:22px">
				[${userId}님]</li>
				
				
				
			      <li class="dropdown"><a class="btn-lg dropdown-toggle" data-toggle="dropdown" href="#">관리자용</a>
			        <ul class="dropdown-menu">
                      <li class="list-group-item"><a href="<c:url value="/products.jsp"/>">상품목록</a></li>
		              <li class="list-group-item"><a href="<c:url value="glassesRegistForm.glasses"/>">상품 등록</a></li>		              
		              <li class="list-group-item"><a href="<c:url value="/editProduct.jsp?edit=update"/>">상품 수정</a></li>
		              <li class="list-group-item"><a href="<c:url value="/editProduct.jsp?edit=delete"/>">상품 삭제</a></li>
			          <li class="list-group-item"><a href="<c:url value="logout.member"/>">로그아웃 </a></li>
				      <li class="list-group-item"><a href="<c:url value="/member/updateMember.jsp"/>">회원 수정</a></li>
			        </ul>
			      </li>  
			</c:when>
			<c:when test="${userId != 'admin'}">
				<li style="padding-top:8px; color:white;font-size:22px">
				[${userId}님]</li>
				<li style="font-weight:bold" class="nav-item"><a class="btn-lg nav-link" href="<c:url value="logout.member"/>">로그아웃 </a></li>
				<li style="font-weight:bold" class="nav-item"><a class="btn-lg nav-link" href="<c:url value="/member/updateMember.jsp"/>">회원 수정</a></li>
			</c:when>	
		 </c:choose>
    </ul>
  </div>
</nav>
</body>
</html>