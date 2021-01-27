<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.BoardBean" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#registForm{
		width:500px;
		height:610px;
		border:1px solid red;
		margin:auto;
	}
	
	h2{
		text-align:center;
	}
	
	table{
		margin:auto;
		width:450px;
	}
	
	.td_left{
		width:150px;
		background:orange;
	}
	
	.td_right{
		width:300px;
		background:skyblue;
	}
	
	#commandCell{
		text-align:center;
	}		
	
</style>
</head>
<body>
	<%-- 특정 게시판에 대한 댓글입력 처리 --%>
	<%
		//BoardReplyFormAction 클래스에서 
		//request.setAttribute("article",article);
		BoardBean article = (BoardBean)request.getAttribute("article");
		//댓글을 입력할 게시판이 존재하는 페이지 번호
 		String nowPage = (String)request.getAttribute("page");
	%>

	<section id="writeForm">
		<h2>게시판등록</h2>
		<form name="boardform" action="boardReplyPro.bo" method="post">
			<input type="hidden" name="page" value="<%=nowPage%>">
			<input type="hidden" name="board_num" value="<%=article.getBoard_num()%>">
			<input type="hidden" name="board_re_ref" value="<%=article.getBoard_re_ref()%>">
			<input type="hidden" name="board_re_lev" value="<%=article.getBoard_re_lev()%>">
			<input type="hidden" name="board_re_seq" value="<%=article.getBoard_re_seq()%>">
			
			<table>
				<tr>
					<td class="td_left">
						<label for="board_name">글쓴이</label>
					</td>
					<td class="td_right">
						<input type="text" name="board_name" id="board_name">
					</td>
				</tr>
				
				<tr>
					<td class="td_left">
						<label for="board_pass">비밀번호</label>
					</td>
					<td class="td_right">
						<input type="password" name="board_pass" id="board_pass">
					</td>
				</tr>
				
				<tr>
					<td class="td_left">
						<label for="board_subject">제목</label>
					</td>
					<td class="td_right">
						<input type="text" name="board_subject" id="board_subject">
					</td>
				</tr>
			
				<tr>
					<td class="td_left">
						<label for="board_content">내용</label>
					</td>
					<td class="td_right">
						<textarea cols="40" rows="15" 
						          name="board_content" id="board_content"></textarea>
					</td>
				</tr>				
			</table>
			
			<section id="commandCell">
				<input type="submit" value="댓글등록"/>&nbsp;&nbsp;
				<input type="reset" value="다시작성"/>
			</section>
			
		</form>
	</section>


</body>
</html>



