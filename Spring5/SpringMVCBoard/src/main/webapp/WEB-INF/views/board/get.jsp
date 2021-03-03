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
						       
						<!-- 검색조건 & 키워드 hidden 처리 02.23 -->
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
	
	<%-- 특정 게시물에 대한 댓글 목록 처리 모달창 선언 03.02 --%>
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<i class="fa fa-comments fa-fw"></i>
				댓글목록
				<button id="addReplyBtn" 
				        class="btn btn-primary btn-xs pull-right">
				      신규 댓글 등록  
				</button>
			</div>
			<div class="panel-body">
				<ul class="chat">
					<li class="left clearfix" data-rno='12'>
						<div>
							<div class="header">
								<strong class="primary-font">
									user00
								</strong>
								<small class="pull-right text-muted">
									2021-03-02 12:10
								</small>
							</div>
							<p>댓글 테스트</p>
						</div>
					</li>
					
				</ul>
			</div>
			
			<!-- panel-footer 추가 03.03 -->
			<div class="panel-footer">
				
			</div>
		</div>
	</div>
	
	<%-- 신규 댓글 등록을 위한 모달창 선언 03.02 
		fade : 모달창이 부드럽게 나타나게 하는 효과
	--%>
	<div class="modal fade" id="myModal" tabindex="-1" 
	     role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" 
					        data-dismiss="modal" aria-hidden="true">&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">댓글 모달창</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>댓글내용</label>
						<input class="form-control" 
						       name="reply" value="New Reply!!!">
					</div>
					<div class="form-group">
						<label>댓글작성자</label>
						<input class="form-control" 
						       name="replyer" value="replyer">
					</div>
					<div class="form-group">
						<label>댓글작성일자</label>
						<input class="form-control" 
						       name="replydate" value="">
					</div>				
				</div>
				<div class="modal-footer">
					<button id="modalModBtn" type="button"
					        class="btn btn-waring">
					        수정
					</button>
					<button id="modalRemoveBtn" type="button"
					        class="btn btn-danger">
					        삭제
					</button>
					<button id="modalRegisterBtn" type="button"
					        class="btn btn-primary">
					        댓글등록
					</button>
					<button id="modalCloseBtn" type="button"
					        class="btn btn-default">
					        닫기
					</button>
				</div>
			</div>
		</div>
	
	</div>
	
	
	
	<%@ include file="../includes/footer.jsp" %>
	
</body>
</html>

<!-- 03.02 댓글처리를 위한 자바스크립트 선언 -->
<script src="/resources/js/reply.js"></script>

<script type="text/javascript">
	
	//클릭한 게시물 번호
	//var bnoValue = '<c:out value="${board.bno}"/>';
	
/* 	replyService.add(
		{ reply:"03.02댓글 테스트",
		  replyer:"홍길동",	
		  bno:bnoValue
		},
		function(result){
			alert("입력결과:" + result);
		}
	) */
	
	
	//특정 게시물에 대한 댓글 목록 처리 03.02
	//list에 서버로 부터 가져온 json형태의 자료를 대입처리한다.
/* 	replyService.getList({bno:bnoValue,page:1},function(list){
		
		for(var i=0;i<list.length;i++){
			console.log(list[i]);
		}
	}); */
	
	//특정 댓글 삭제처리 03.02
	/* replyService.remove(13,
			
		function(count){
			if(count === "success"){
				alert("정상적으로 댓글 삭제");
			}
		},
		function(err){
			alert("댓글 삭제 오류");
		}
	); */
	
	//특정 댓글 수정처리 03.02
/* 	replyService.update({
		rno:3,
		bno:bnoValue,
		reply:"<Ajax 이용한 댓글수정>"
	},
	function(result){
		alert("정상적으로 댓글 수정");	
	}); */
	
	//특정 댓글 상세보기 03.02
/* 	replyService.get(3,function(data){
		console.log(data);
	}); */
	
</script>


<script>
	$(document).ready(function(){

		//클릭한 게시물 번호
		var bnoValue = '<c:out value="${board.bno}"/>';
		var replyUL = $(".chat");
		
		//댓글목록 보여주는 메서드 03.02
		showList(1);
		function showList(page){

	 		replyService.getList(
	 				{bno:bnoValue,page:page||1},
				    function(replyCnt, list){
	 					
	 					if(page == -1){
	 						pageNum = Math.ceil(replyCnt/10.0);
	 						showList(pageNum);
	 						return;
	 					}
	 					
	 					
						var str = "";
						//특정 게시물에 대한 댓글이 없는 경우
						if(list == null || list.length == 0){
							replyUL.html("");
							return;
						}
						
		 				//댓글이 있으면
						for(var i=0;i<list.length;i++){
							
							str += "<li class='left clearfix' data-rno='"+list[i].rno+"'>";
							str += " <div><div class='header'><strong class='primary-font'>" +
							        list[i].replyer + "</strong>";
							str += " <small class='pull-right text-muted'>" + list[i].replydate +
								   " </small></div>";
							str += " <p>" + list[i].reply + "</p></div></li>";
							
						}	 
							replyUL.html(str);
							//03.03 추가
							showReplyPage(replyCnt);
						}); 
			
		}//end showList()
	
		
		//댓글 페이징 처리 시작 03.03
		var pageNum = 1;
		var replyPageFooter = $(".panel-footer");
		
		function showReplyPage(replyCnt){
			var endNum = Math.ceil(pageNum / 10.0) * 10;
			var startNum = endNum - 9;
			var prev = startNum != 1;
			var next = false;
			
			//각 페이지의 하단 마지막 페이지를 구하는데 실제 페이지수 구하기
			if(endNum*10 >= replyCnt){
				endNum = Math.ceil(replyCnt/10.0);
			}
			
			//다음 페이지가 존재하면
			if(endNum * 10 < replyCnt){
				next = true;
			}
			
			var str = "<ul class='pagination pull-right'>";
				//이전 페이지가 존재하면
				if(prev){
					str += "<li class='page-item'><a class='page-link' href='"+(startNum-1)+"'>이전</a></li>";
				}
				
				for(var i=startNum; i<=endNum; i++){
					//현재 작업중인 페이지 처리
					var active = pageNum == i ? "active" : "";
					
					str += "<li class='page-item "+active+"'><a class='page-link' href='"+i+"'>"+i+"</a></li>";
					
				}
				
				//다음 페이지가 존재하면
				if(next){
					str += "<li class='page-item'><a class='page-link' href='"+(endNum+1)+"'>다음</a></li>";
				}
				
				str += "</ul></div>";
				
				replyPageFooter.html(str);
				
		}
		
		
		
		
		//댓글 페이징 처리 종료 03.03
		
		
		
		
	
		//모달창 버튼 처리 추가 03.02
		var modal = $(".modal");
		
		//모달창에서 input 태그중에 name이 reply(댓글내용)을 찾아서 변수에 대입
		var modalInputReply = modal.find("input[name='reply']");
		//모달창에서 input 태그중에 name이 replyer(댓글작성자)을 찾아서 변수에 대입
		var modalInputReplyer = modal.find("input[name='replyer']");
		//모달창에서 input 태그중에 name이 replyDate(댓글작성일)을 찾아서 변수에 대입
		var modalInputReplyDate = modal.find("input[name='replydate']");
		
		//모달창 버튼 처리 03.02
		var modalModBtn = $("#modalModBtn");//수정버튼
		var modalRemoveBtn = $("#modalRemoveBtn");//삭제버튼
		var modalRegisterBtn = $("#modalRegisterBtn");//등록버튼
		var modalCloseBtn = $("#modalCloseBtn");//종료버튼
		
		//신규 댓글 입력 처리 03.02
		$("#addReplyBtn").on("click",function(e){
			//모달창 입력 폼에서 input태그의 모든 값을 클리어
			modal.find("input").val("");
			//모달창 입력 폼에서 댓글 작성일자 부분을 안보이게 처리
			//closest : 현재 위치에서 가장 가까운 요소를 찾는다.
			//모달창에서 댓글내용과 작성자만 보여준다
			modalInputReplyDate.closest("div").hide();
			//수정,삭제,등록버튼은 화면에 안보이게 처리
			modal.find("button[id !='modalCloseBtn']").hide();
			//등록버튼을 화면에 보이게 처리
			modalRegisterBtn.show();
			
			//모달창이 화면에 보이게 처리
			$(".modal").modal("show");
			
		});
		
		//신규 댓글 버튼 클릭후 내용을 입력하고 댓글등록 버튼클릭시 처리 03.02
		modalRegisterBtn.on("click",function(){
		
			//JSON 형태의 데이터 구성
			var reply = {
					reply : modalInputReply.val(),
					replyer : modalInputReplyer.val(),
					bno : bnoValue					
			};
			
			replyService.add(reply,function(result){

				alert(result);
				//모달창의 input 태그를 Clear
				modal.find("input").val("");
				//모달창을 닫는다.
				modal.modal("hide");
				
				//댓글 신규 등록후 화면 새로고침 기능 추가
				showList(-1);
				
			});
			
			
		});
		
		
		
		
		//특정 댓글 상세보기 03.02
		$(".chat").on("click","li",function(e){
			
			//클릭한 댓글번호를 변수에 대입
			var rno = $(this).data("rno");
			
			replyService.get(rno,function(reply){
				//모달창의 내용 input 태크에 reply 객체의 내용값을 세팅
				modalInputReply.val(reply.reply);
				//모달창의 내용 input 태크에 reply 객체의 작성자 값을 세팅
				modalInputReplyer.val(reply.replyer);
				//모달창의 내용 input 태크에 reply 객체의 작성일 값을 세팅
				modalInputReplyDate.val(reply.replydate).attr("readonly","readonly");
				//댓글번호를 rno에 대입
				modal.data("rno",reply.rno);
				//닫기 버튼을 제외한 나머지 버튼은 안보이게 처리
				modal.find("button[id != 'modalCloseBtn']").hide();
				//수정,삭제 버튼만 보이게 처리
				modalModBtn.show();
				modalRemoveBtn.show();
				
				$(".modal").modal("show");
				
			});
			
		});
		
		modalModBtn.on("click", function(e){
			var reply = {
					rno : modal.data("rno"),//댓글번호
					reply : modalInputReply.val()//수정 댓글 내용
			};
			
			replyService.update(reply,function(result){
				
				alert(result);
				modal.modal("hide"); //모달창을 닫기
				showList(pageNum); //화면 새로고침
				
			});
		});
		
		modalRemoveBtn.on("click", function(e){
			var rno = modal.data("rno")//댓글번호
		
			
			replyService.remove(rno,function(result){
				
				alert(result);
				modal.modal("hide"); //모달창을 닫기
				showList(pageNum); //화면 새로고침
				
			});
		});
		
		//댓글 페이지 번호 클릭시 댓글 목록 가져오기 03.03
		replyPageFooter.on("click","li a", function(e){
			//html의 <a>,<submit>등 고유의 태그동작을 중지시킨다.
			e.preventDefault();
			
			//현재 클릭한 페이지 번호를 가져오기
			var targetPageNum = $(this).attr("href");
			pageNum = targetPageNum;
			
			showList(pageNum);
		});
		
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











