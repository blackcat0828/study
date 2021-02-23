<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<%@include file= "../includes/header.jsp"%>
<style>
	th {
		text-align:center;
	}
	
	.td {
		text-align:center;
	}

</style>	
	
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
                            
                            <button id="regBtn"
                                    type="button"
                                    class="btn btn-primary btn-xs pull-right">
                            	게시판 등록
                            </button>
                            
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th class="danger">게시판번호</th>
                                            <th class="danger">제목</th>
                                            <th class="danger">작성자</th>
                                            <th class="danger">작성일</th>
                                            <th class="danger">수정일</th>
                                        </tr>
                                    </thead>
                                    
                                    <!-- tbl_board 에 있는 게시판 내역 보여주기 -->
                                    <c:forEach items="${list}" var="board">
                                    	
											<tr>
											   <td class="td"><c:out value="${board.bno}"/></td>
											   <td id="td2">
											   		<a class="move" href="<c:out value="${board.bno}"/>">
											   			<c:out value="${board.title}"/>
											   		</a>
											   		
											   </td>
											   <td class="td"><c:out value="${board.writer}"/></td>
											   <td class="td"><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}" /></td>
											   <td class="td"><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updatedate}" /></td>
											 </tr>
                                    
                                    </c:forEach>	

                                </table>
                                
                                <!-- 검색기능 추가 02.22 -->
                                <div class="row">
									<div class="col-lg-12">
										<form id="searchForm" action="/board/list" method="get">
											<select name="type">
												<option value="" 
													<c:out value="${pageMaker.cri.type == null ? 'selected' : ''}"/>>--</option>
												<option value="T"
													<c:out value="${pageMaker.cri.type == 'T' ? 'selected' : ''}"/>>제목</option>
												<option value="C"
													<c:out value="${pageMaker.cri.type == 'C' ? 'selected' : ''}"/>>내용</option>
												<option value="W"
													<c:out value="${pageMaker.cri.type == 'W' ? 'selected' : ''}"/>>작성자</option>
												<option value="TC"
													<c:out value="${pageMaker.cri.type == 'TC' ? 'selected' : ''}"/>>제목 or 내용</option>
												<option value="TW"
													<c:out value="${pageMaker.cri.type == 'TW' ? 'selected' : ''}"/>>제목 or 작성자</option>
												<option value="TWC"
													<c:out value="${pageMaker.cri.type == 'TWC' ? 'selected' : ''}"/>>제목 or 내용 or 작성자</option>
											</select>
											<input type="text" name="keyword"/>
											<input type="hidden" name="pageNum" 
											       value="${pageMaker.cri.pageNum}">
											<input type="hidden" name="amount" 
											       value="${pageMaker.cri.amount}">
											<button class="btn btn-primary">검색</button>	       
											              
										</form>
									</div>	                                
                                </div>                               
                                
                                
                                
                                
                                <!-- 페이징 처리 부분 추가 02.22 -->
                                <div class="pull-right">
                                	<ul class="pagination">
                                	
                                		<c:if test="${pageMaker.prev}">
									        <li class="paginate_button previous">
									             <a href="${pageMaker.startPage - 1}">이전</a>
									        </li>                       			
										</c:if>
										
										
										<c:forEach var="num" 
										              begin="${pageMaker.startPage}" 
										              end="${pageMaker.endPage}">
										    
										    <li class="paginate_button ${pageMaker.cri.pageNum == num ? 'active':''}" >
										 	<a href="${num}">${num}</a>		
										    </li>	
										
										</c:forEach>
										
										<c:if test="${pageMaker.next}">
										        <li class="paginate_button next">
										             <a href="${pageMaker.endPage + 1}">다음</a>
										        </li>                       			
										</c:if>
	                                	
                                	</ul>
                                </div>
                                
                                
                                
                           <!-- 페이징처리를 위한 form 추가 02.22-->
                           <form id="actionForm" action="/board/list" method="get">
							      <input type="hidden" name="pageNum" 
							             value="${pageMaker.cri.pageNum}">
							      <input type="hidden" name="amount" 
							             value="${pageMaker.cri.amount}">
							             
							      <!-- 검색 조건, 키워드 정보도 hidden으로 처리 -->
							      <input type="hidden" name="type" 
							             value='<c:out value="${pageMaker.cri.type}" />'>
							      <input type="hidden" name="keyword" 
							             value='<c:out value="${pageMaker.cri.keyword}" />'>
						   </form>     
                                
                           <!-- Modal 시작 -->
                            <div class="modal fade"
                            	 id="myModal"
                            	 tabindex="-1"
                            	 role="dialog"
                            	 aria-labelledby="myModalLabel"
                            	 aria-hidden="true">
                            	 
                             	<div class="modal-dialog">
                             		<div class="modal-content">
                             			<div class="modal-header">
                             				<button 
                             				    type="button"
                             				    class="close"
                             				    data-dismiss="modal"
                             				    aria-hidden="true">&times;
                             				</button>
                             				<h4 class="modal-title"
                             				    id="myModalLabel">
                             				    Modal title
                             				</h4>
                             			</div>
                             			<div class="modal-body">
                             				처리가 완료되었습니다.
                             			</div>
                             			<div class="modal-footer">
                             				<button type="button"
                             						class="btn btn-primary"
                             						data-dismiss="modal">
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
            <!-- /.row -->

 
 <%@include file= "../includes/footer.jsp"%>
 
 <script>
 	$(document).ready(function(){
 		//게시판 신규 등록시 게시판 번호
 		var result = '<c:out value="${result}"/>';
 		
 		checkModal(result);
 		
 		/*
 			1.이전 페이지로 이동
 			window.history.back()
 			
 			2.다음 페이지로 이동
 			window.history.forward()
 			
 			3.특정 페이지로 이동
 			window.history.go(인덱스번호)
 		
 		*/
 		
 		//현재 주소창의 상태값을 변경한다.
 		history.replaceState({},null,null);
 		
 		function checkModal(result){
 			
 			//매개변수 게시판 번호가 없으면
 			//history.state : 현재 history에 해당하는 상태값을 가져온다.
 			//게시판 상세보기 후 이전 페이지 클릭시
 			//모달창 뜨지 않게 처리
 			if(result === '' || history.state){
				return;
 			}
 			
 			//alert(result);
 		
 			//매개변수 게시판 번호가 있으면
 			if(parseInt(result) > 0){
 				$(".modal-body")
 				  .html("게시글 " + parseInt(result) + "번이 등록되었습니다.");
 			}
 			
 			//모달창을 보이게 처리
 			$("#myModal").modal("show");
 			
 		}
 		
 		//게시판 등록 버튼 클릭 처리
 		$("#regBtn").on("click",function(){
 			self.location = "/board/register";
 		});
 		
 		//페이징 처리 02.22
 		var actionForm = $("#actionForm");
 		
 		//class로 지정된 하단의 현재 페이지 번호를 클릭하면
 		$(".paginate_button a").on("click",function(e){
 			
 			//html 정상적인 처리를 중지시킨다.
 			e.preventDefault();
 			
 			//actionForm 폼에서 input 태그중에서 name이 pageNum인 것을
 			//찾아서 하단에 있는 클릭한 페이지번호를 대입해라.
 			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
 			
 			//클릭한 페이지로 이동
 			actionForm.submit();
 			
 		});
 		
 		//수정,삭제등 작업후 현재 페이지에 그대로 있기 위한 처리 02.22
 		$(".move").on("click",function(e){
 			e.preventDefault();
 			//게시물 제목을 클릭하면 
 			//속성이 hidden이고 name이 bno인 게시물 번호를 가지는 
 			//input 태그를 추가하여 url은 /board/get로 변경 
 			actionForm.append(
 			   "<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
 			actionForm.attr("action","/board/get");
 			actionForm.submit();
 		});
 		
 		
 		//검색버튼 처리 02.23
 		var searchForm = $("#searchForm");
 		$("#searchForm button").on("click",function(e){
 			
 			if(!searchForm.find("option:selected").val()){
 				alert("검색조건을 선택하세요");
 				return false;
 			}
 		
 			if(!searchForm.find("input[name='keyword']").val()){
 				alert("키워드를 입력하세요!");
 				return false;
 			}
 		
 			//검색후 페이지번호를 1 페이지로 이동하게 한다.
 			searchForm.find("input[name='pageNum']").val("1");
 			
 			//button을 클릭하면 type=button 으로 지정되어 있지 
 			//않으면 btuoon 태그는 기본적으로 submit을 실행하므로 
 			//이것을 중지시키기 위해 선언
 			e.preventDefault();
 			
 			searchForm.submit();
 		});
 		
 		
 		
 	 		
 	});
 	
 	
 </script>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 