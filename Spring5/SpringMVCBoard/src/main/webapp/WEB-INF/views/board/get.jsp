<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ include file="../includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">게시판 상세보기</h1>
		</div>
	</div>
	
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					게시판 상세보기
				</div>
				
				<div class="panel-body">
					<form id="operForm" action="/board/modifyForm" method="get">
						<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno }"/>' />
					
					</form>
				
					<form role="form" action="/board/modify" method="post">
					
						<div class="form-group">
							<label>번호</label>
							<input class="form-control" name="bno" value='<c:out value="${board.bno }" />'>
						</div>
					
						<div class="form-group">
							<label>제목</label>
							<input class="form-control" name="title" value='<c:out value="${board.title }" />'> 
						</div>
						
						<div class="form-group">
							<label>내용</label>
							<textarea class="form-control" rows="3" name="contents"><c:out value="${board.contents }" /></textarea> 
						</div>
						
						<div class="form-group">
							<label>작성자</label>
							<input class="form-control" name="writer" value='<c:out value="${board.writer }" />'> 
						</div>
						<button type="button" class="btn btn-primary"
							onClick="location.href='/board/modifyForm?bno=<c:out value="${board.bno }"/>'">
							수정
						</button>
						
						<button type="button"  class="btn btn-danger" 
							onclick="location.href='/board/list'">
							목록
						</button>
						
					</form>
						
				</div>
			</div>
		</div>
	</div>
</body>
</html>
