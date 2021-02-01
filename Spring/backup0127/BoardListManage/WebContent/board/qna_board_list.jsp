<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.PageInfo"%>
<%@ page import="vo.BoardBean"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<style>
	#registForm{
		width:500px;
		height:600px;
		border:1px solid red;
		margin:auto;
	}
	
	h2{
		text-align:center;
	}
	
	.t1{
		text-align:center;
	}
	
	table{
		margin:auto;
		width:450px;
	}
	
	#tr_top{
		background:orange;
		text-align:center;
	}
	
	#pageList{
		margin:auto;
		width:500px;
		text-align:center;
	}

	#emptyArea{
		margin:auto;
		width:500px;
		text-align:center;
	}	
	
</style>
</head>
<body>
	<%
		//게시판내역을 관리하기 위해 ArrayList선언
		//BoardListAction.java에서 지정한 articleList 속성값을 가져온다.
		ArrayList<BoardBean> articleList = (ArrayList<BoardBean>)request.getAttribute("articleList");
	
		//페이징 처리를 하기 위해 PageInfo 선언
		PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
		
		//화면에 보여줄 총 게시판 갯수
		int listCount = pageInfo.getListCount();
		//현재 작업중인 페이지 번호
		int nowPage = pageInfo.getPage();
		//게시판을 보여주기 위한 최대 페이지수
		int maxPage = pageInfo.getMaxPage();
		//해당페이지의 첫페이지
		int startPage = pageInfo.getStartPage();
		//해당페이지의 마지막페이지
		int endPage = pageInfo.getEndPage();
	
	%>
	
	<section id="listForm">
			<h2>
				글목록<br>
			</h2>

		<table>
			<tr>
				<td>
					<button type="button" 
				            onclick="location.href='boardWriteForm.bo'">게시판글쓰기
				    </button>
				</td>
			</tr>
			<%
				//게시판목록을 가진 속성값이 있고 게시물 총건수가 1이상이면
				if(articleList != null && listCount > 0){
			%>
			
			<tr id="tr_top">
				<td>번호</td>		
				<td>제목</td>
				<td>작성자</td>
				<td>날짜</td>
				<td>조회수</td>
			</tr>
			
			<%
				//게시판 출력
				//get() 메서드를 이용하여 articleList에 
				//저장된 행전체를 가져온 후 각 속성들을 분리하여
				//화면에 출력한다.
				for(int i=0;i<articleList.size();i++){
			%>
			
			<tr>
				<td class="t1"><%=articleList.get(i).getBoard_num()%></td>
				<td>
					<%
						//특정게시판에 대한  댓글이 존재하는 경우
						//getBoard_re_lev()*2 만큼 공백처리를 하여 댓글 들여쓰기 효과를
						//내기 위함
						if(articleList.get(i).getBoard_re_lev() != 0){
							
							
							for(int a=0;a<=articleList.get(i).getBoard_re_lev()*2;a++){
					%>
									&nbsp;
					<%
							} 
					%>		
							▶
							
					<%		
						}else{
					%>		
							▶
					<%
						}
					%>		
				    <%-- 
				    	제목을 클릭하면 게시판 상세보기로 이동시 특정게시판 번호와 
				    	현재 페이지 번호를 같이 갖고 이동한다. 
				    --%>			
					<a href="boardDetail.bo?board_num=<%=articleList.get(i).getBoard_num()%>&page=<%=nowPage%>">
							<%=articleList.get(i).getBoard_subject()%>
					</a>
				</td>
				<td class="t1"><%=articleList.get(i).getBoard_name()%></td>
				<td class="t1"><%=articleList.get(i).getBoard_date()%></td>
				<td class="t1"><%=articleList.get(i).getBoard_readcount()%></td>
			</tr>		
					<%		
					 	}//else
					%>
		</table>	
	</section>
	
	<section id="pageList">
		<%
			if(nowPage <= 1){
		%>
				[이전]&nbsp;
		<%
			}else{
		%>	
				<%-- 이전을 클릭하면 현재페이지의 이전페이지로 이동 --%>
				<a href="boardList.bo?page=<%=nowPage-1%>">[이전]</a>&nbsp;
		<%
			}
		%>
		
		<%
			//만약현재 페이지가 1페이지이면 startPage = 1 endPage=10
			//만약현재 페이지가 2페이지이면 startPage = 11 endPage=20
			//만약현재 페이지가 3페이지이면 startPage = 21 endPage=30
			for(int a=startPage;a<=endPage;a++){
			
				//현재 작업중인 페이지인 경우
				if(a == nowPage){
		%>
					[<%=a %>]
		<%		}else{
					//현재 작업중인 페이지를 제외한 페이지번호를 클릭시
					//해당 페이지에 대한 게시판 내역을 가져오도록 처리
				
		%>
					<a href="boardList.bo?page=<%=a %>">[<%=a %>]</a>&nbsp;
		<%				
				}	
			}
				if(nowPage >= maxPage){
		%>
					[다음]
		<%				
				}else{
		%>		
					<a href="boardList.bo?page=<%=nowPage+1%>">[다음]</a>
		<%
				}//else
	
		%>		
	</section>
	
	<%
		}else{
	%>
			<section id="emptyArea">등록된 글이 없습니다.</section>
	<%				
		}
	
	%>
</body>
</html>