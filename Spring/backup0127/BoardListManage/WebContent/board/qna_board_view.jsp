<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.BoardBean" %>
<%
	//게시판 리스트 
	//BoardDetailAction 클래스에서 지정한 article 속성을 가져온다.
	BoardBean article = (BoardBean)request.getAttribute("article");
	//현재 페이지번호
	String nowPage = (String)request.getAttribute("page");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<style>
	#articleForm{
		width:500px;
		height:500px;
		border:1px solid red;
		margin:auto;
	}
	
	h2{
		text-align:center;
	}
	
	#basicInfoArea{
		height:40px;
		text-align:center;
	}
	
	#articleContentArea{
		background:orange;
		margin-top:20px;
		height:350px;
		text-align:center;
		overlow:auto;
	}
	
	#commandList{
		margin:auto;
		width:500px;
		text-align:center;
	}
</style>
</head>
<body>

	<section id="articleForm">
		<h2>글내용 상세보기</h2>
		<section id="basicInfoArea">
			제목:<%=article.getBoard_subject()%>
			첨부파일:
			<%
				//첨부파일이 있으면
				if(!(article.getBoard_file() == null)){
			%>
				<%--첨부파일을 클릭하면 다운로드 처리 --%>
<%-- 					<a href="file_down?downFile=<%=article.getBoard_file()%>">
					   <%=article.getBoard_file()%>
					</a> --%>
					
				<a href="resources/images/<%=article.getBoard_file()%>" 
				   download="<%=article.getBoard_file()%>">
					   <%=article.getBoard_file()%>	
				</a>	   
		
			<%		
				}
			%>
		</section>
	
		<section id="articleContentArea">
			<%=article.getBoard_content()%>
		</section>
		
	</section>
	
	<section id="commandList">
		<%-- 
		   답변을 클릭하면 boardReplyForm.bo 여기로 이동하되
		   게시판번호와 현재 페이지번호도 매개변수로 가져간다.  
		--%>
		<a href="boardReplyForm.bo?board_num=<%=article.getBoard_num()%>&page=<%=nowPage%>">
			[답변]			
		</a>
		<a href="boardModifyForm.bo?board_num=<%=article.getBoard_num()%>&page=<%=nowPage%>">
			[수정]			
		</a>
		<a href="boardDeleteForm.bo?board_num=<%=article.getBoard_num()%>&page=<%=nowPage%>">
			[삭제]			
		</a>
		<a href="boardList.bo?page=<%=nowPage%>">[목록]</a>
		&nbsp;&nbsp;		
	</section>
</body>
</html>