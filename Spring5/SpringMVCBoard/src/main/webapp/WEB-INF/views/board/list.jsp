<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../includes/header.jsp" %>

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시판 리스트</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            게시판 목록
                            
                            <button id="regBtn" type="button" class="btn btn-warning btn-xs">
                            	게시판 등록
                            </button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th class="info" style='text-align:center;'>게시판번호</th>
                                            <th class="info" style='text-align:center;'>제목</th>
                                            <th class="info" style='text-align:center;'>작성자</th>
                                            <th class="info" style='text-align:center;'>작성일</th>
                                            <th class="info" style='text-align:center;'>수정일</th>
                                        </tr>
                                    </thead>
                                    
                                    <!--  tbl_board 에 있는 게시판 내역 보여주기 -->
                                    <c:forEach items="${list}" var="board">
                                    	<tr>
                                    		<td style='text-align:center;'><c:out value="${board.bno }"/></td>
                                    		<td>
                                    			<a href='/board/get?bno=<c:out value="${board.bno}" />'>
                                    				<c:out value="${board.title }"/>
                                    			</a>
                                    		</td>
                                    		<td style='text-align:center;'><c:out value="${board.writer }"/></td>
                                    		<td style='text-align:center;'><c:out value="${board.regdate }"/></td>
                                    		<td style='text-align:center;'><c:out value="${board.updatedate }"/></td>
                                    	</tr>
                                    </c:forEach>
                                </table>
                                <!-- Modal 시작 -->
								<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
										aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLable">
													Modal title
												</h4>
											</div>
											<div class="modal-body">
												처리가 완료 되었습니다.
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-primary">
													Close
												</button>
											</div>											
										</div>
									</div>
																			
								</div>
                                <!-- Modal 종료 -->
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            
<%@ include file="../includes/footer.jsp" %>

<script>
	$(document).ready(function(){
		var result = '<c:out value="${result}" />';
		
		
		checkModal(result);
		
		/*
			1. 이전 페이지로 이동
			window.history.back()
			
			2.다음 페이지 이동
			window.history.forward()
			
			3.특정 페이지로 이동
			window.history.go(인덱스번호)
		
		*/
		
		//현재 주소창의 상태값을 변경한다.
		history.replaceState({},null,null);
		
		function checkModal(result){
			
			//게시판 번호가 없으면
			//hitstory.state : 현재 history에 해당하는 상태값을 가져온다.
			//게시판 상세보기 후 이전 페이지 클릭시 모달창 뜨지 않게 처리
			if(result === '' || history.state){
				return;
			}
			//매개변수 게시판 번호가 있으면
			if(parseInt(result) > 0){
				$(".modal-body").html("게시글" + parseInt(result) + "번이 등록되었습니다.");
			}
			
			//모달창 보이게 처리
			$("#myModal").modal("show");
		}
		
		
		//게시판 등록 버튼 클릭 처리
		$("#regBtn").on("click", function(){
			self.location = "/board/register";
		});
	
	});
	
	
</script>