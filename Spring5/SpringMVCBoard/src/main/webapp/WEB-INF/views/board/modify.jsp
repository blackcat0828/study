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
					<form role="form" 
					      action="/board/modify" method="post">
						
					   <!--페이징 처리를 위한 hidden 속성 추가 02.22 -->	
					   <input type="hidden" name="pageNum" 
					          value="<c:out value="${cri.pageNum}"/>">
					   <input type="hidden" name="amount" 
					          value="<c:out value="${cri.amount}"/>">
					   
					   <!-- 검색조건 & 키워드 hidden 속성 추가 02.23 -->
					   <input type="hidden" name="type" 
					          value="<c:out value="${cri.type}"/>">       
					   <input type="hidden" name="keyword" 
					          value="<c:out value="${cri.keyword}"/>">              	
						
					   <div class="form-group">
					   		<label>번호</label>
					   		<input class="form-control" 
					   		       name="bno"
					   		       value='<c:out value="${board.bno}"/>' readonly="readonly">
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
                       		       value='<c:out value="${board.writer}"/>' readonly="readonly">
                       </div>
                       
                       <button type="submit" 
                               data-oper="modify" 
                               class="btn btn-primary">
                       			수정
                       </button>
                       
                       <button type="submit" 
                               data-oper="remove" 
                               class="btn btn-warning">
                       			삭제
                       </button>                       
						
					   <button type="submit"
					           data-oper="list" 
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

<script type="text/javascript">
	$(document).ready(function(){
		//form의 모든 정보를 변수에 대입
		var formObj = $("form");
		
		//form에 있는 button이 클릭되면 이벤트 처리
		$("button").on("click",function(e){
			//html의 현재 이벤트 기본동작을 중단시킨다.
			e.preventDefault();
			
			//button 3개중에 어느버튼이 클릭되었는지
			//문자열을 리턴한다.
			var operation = $(this).data("oper");
			
			if(operation == "remove"){//삭제버튼이 클릭되면
				formObj.attr("action","/board/remove");
			}else if(operation == "list"){//목록버튼이 클릭되면
				formObj.attr("action","/board/list")
				       .attr("method","get");
				
			    //empty() & remove() 차이
				//empty() =>  html에서 태그는 그대로 두고 내용만 삭제
				//remove() => html에서 태그와 내용을 모두 삭제
				
				//페이징 처리를 위한 선언 02.22
				//form에서 input 태그중에서 name이 pageNum 인 값을 복제하여
				//pageNumTag 변수에 대입
				var pageNumTag = $("input[name='pageNum']").clone();
				//form에서 input 태그중에서 name이 amount 인 값을 복제하여
				//amountTag 변수에 대입
				var amountTag = $("input[name='amount']").clone();
				
				//검색조건 & 키워드 처리 02.23
				var typeTag = $("input[name='type']").clone();
				var keywordTag = $("input[name='keyword']").clone();
				
				//선택한 요소의 값만 삭제하고 태그는 그대로 둔다.
			    formObj.empty();
				//formObj에 pageNumTag 라는 새로운 요소를 추가
			    formObj.append(pageNumTag);
			    //formObj에 amountTag 라는 새로운 요소를 추가
			    formObj.append(amountTag);
			   	//검색조건 & 키워드 02.23		  	
			    formObj.append(typeTag);
			    formObj.append(keywordTag);
			}
			
			formObj.submit();
			
		});
		
		
	});
</script>









