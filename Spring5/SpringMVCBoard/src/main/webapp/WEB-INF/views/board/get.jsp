<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../includes/header.jsp"%>

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
				
					<form id="operForm" 
					      action="/board/modify"
					      method="get">
						<input type="hidden" 
						       id="bno" 
						       name="bno" 
						       value='<c:out value="${board.bno}"/>'>
						 
						<input type="hidden" 
						       name="pageNum" 
						       value='<c:out value="${cri.pageNum}"/>'> 
						 
						<input type="hidden" 
						       name="amount" 
						       value='<c:out value="${cri.amount}"/>'>	 
						
						<input type="hidden" 
						       name="type" 
						       value='<c:out value="${cri.type}"/>'>	 
						       
						       
						<input type="hidden" 
						       name="keyword" 
						       value='<c:out value="${cri.keyword}"/>'>	       
						       
					</form>
				
					<form role="form" 
					      action="/board/modify" method="post">
						
					   <div class="form-group">
					   		<label>번호</label>
					   		<input class="form-control" 
					   		       name="bno"
					   		       value='<c:out value="${board.bno}"/>'>
					   </div>	


                       <div class="form-group">
                       		<label>제목</label>
                       		<input class="form-control" 
                       		       name="title"
                       		       value='<c:out value="${board.title}"/>'
                       		>
                       </div>
                       
                       <div class="form-group">
                       		<label>내용</label>
                       		<textarea class="form-control" 
                       		          rows="3" name="content"
                       		><c:out value="${board.content}"/></textarea>                       
                       </div>
                       
                       <div class="form-group">
                       		<label>작성자</label>
                       		<input class="form-control" 
                       		       name="writer"
                       		       value='<c:out value="${board.writer}"/>'
                       		>
                       </div>
		
					   <button type="button" data-oper="modify" 
	                           class="btn btn-primary">
	                       			수정
	                   </button>
							
					   <button type="button" data-oper="list" 
						        class="btn btn-danger">
	                       			목록
	                   </button>		
		
					</form>

				</div>
				
			</div>
		</div>
	</div>
	
	<%@ include file="../includes/footer.jsp" %>
	
</body>
</html>

<script>
	$(document).ready(function(){
		
		var operForm = $("#operForm");
		
		//form에서 태그가 button 이고 속성이 data-oper 이면서
		//data-oper 속성의 값이 modify인 버튼이 클릭됬을때 처리
		//수정버튼이 클릭되면 
		$("button[data-oper='modify']").on("click",function(e){
			operForm.attr("action","/board/modify").submit();
		});
		
		//목록버튼이 클릭되면
		$("button[data-oper='list']").on("click",function(e){
			//form에서 hidden 으로 전달받은 게시판번호를 
			//form에서 삭제처리
			operForm.find("#bno").remove();
			operForm.attr("action","/board/list");
			operForm.submit();
		});
	});
</script>











