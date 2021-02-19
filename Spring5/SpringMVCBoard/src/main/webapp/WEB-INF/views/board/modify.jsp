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
			<h1 class="page-header">게시판 수정</h1>
		</div>
	</div>
	
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					게시판 수정
				</div>
				
				<div class="panel-body">
					<form role="form" action="/board/modify" method="post">
					
						<div class="form-group">
							<label>번호</label>
							<input class="form-control" name="bno" value='<c:out value="${board.bno }" />' readonly="readonly">
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
							<input class="form-control" name="writer" value='<c:out value="${board.writer }" />' readonly="readonly"> 
						</div>
						
						<button type="submit" data-oper="modify" class="btn btn-primary" >
							수정
						</button>
						
						<button type="submit" data-oper="remove" class="btn btn-warning" >
							삭제
						</button>
						
						
						<button type="submit" data-oper="list" class="btn btn-danger">
							목록
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<script type="text/javascript">
	$(document).ready(function(){
		
		//form의 모든 정보를 변수에 대입
		var formObj = $("form");
		
		//form에 있는 button이 클릭되면 이밴트 처리
		$("button").on("click",function(e){
			//html의 기본동작을 중단시킨다.
			e.preventDefault();
			
			var operation = $(this).data("oper");
			
			if(operation == "remove"){
				formObj.attr("action","/board/remove");
			}else if(operation == "list"){
				formObj.attr("action","/board/list").attr("method","get");
				
				//empty() & remove() 차이
				//empty() => html에서 태그는 그대로 두고 내용만 삭제
				//remove() => html에서 태그와 내용을 모두 삭제
				formObj.empty();
				
			}else if(operation == "modify"){
				formObj.attr("action", "/board/modify");
			}
			
			formObj.submit();
		})
	});
</script>