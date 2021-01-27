<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.BoardBean" %>     

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<script type="text/javascript">
	function modifyboard(){
		
		//유효성 검사
		
 		if(!document.modifyform.board_name.value){
			alert("글쓴이를 입력하세요");
			return;
		}
		
		if(!document.modifyform.board_pass.value){
			alert("비밀번호를 입력하세요");
			return;
		}
		
		if(!document.modifyform.board_subject.value){
			alert("제목을 입력하세요");
			return;
		}
		
		if(!document.modifyform.board_content.value){
			alert("내용을 입력하세요");
			return;
		} 
		
		modifyform.submit();
	}
</script>
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
	<%
		//BoardModifyFormAction 클래스에 article 속성지정
		BoardBean article = (BoardBean)request.getAttribute("article");	
		String nowPage = (String)request.getAttribute("page");
		System.out.println("모디파이폼 JSP");
		System.out.println(article.getBoard_num());

	%>
	
	<section id="writeForm">
		<h2>게시판수정</h2>
		<form name="modifyform"
		      action="boardModifyPro.bo" 
		      method="post">
	
			<input type="hidden" name="board_num" 
			     value="<%=article.getBoard_num()%>">      
			 
			  <input type="hidden" name="page" 
          					 value="<%=nowPage%>">      
		
			<table>
				<tr>
					<td class="td_left">
						<label for="board_name">글쓴이 <%=article.getBoard_num() %></label>
					</td>
					
					<td class="td_right">
						<input type="text" 
						       name="board_name" 
						       id="board_name" 
						       value="<%=article.getBoard_name()%>"/>
					</td>
				</tr>
				
				<tr>
					<td class="td_left">
						<label for="board_pass">비밀번호</label>
					</td>
					<td class="td_right">
						<input type="password" 
						       name="board_pass" 
						       id="board_pass"
						       value="<%=article.getBoard_pass()%>"/>
					</td>
				</tr>
				
				<tr>
					<td class="td_left">
						<label for="board_subject">제목</label>
					</td>
					<td class="td_right">
						<input type="text" 
						       name="board_subject" 
						       id="board_subject"
						       value="<%=article.getBoard_subject()%>"/>
					</td>
				</tr>
				
				<tr>
					<td class="td_left">
						<label for="board_content">내용</label>
					</td>
					<td>
						<textarea id="board_content"
						          name="board_content"
						          cols="40" rows="15"><%=article.getBoard_content()%>
  			     	    </textarea>
					</td>
				</tr>
				
			</table>
			
			<section id="commandCell">
				
				<a href="javascript:modifyboard()">[수정]</a>&nbsp;&nbsp;
				<a href="javascript:history.go(-1)">[뒤로]</a>
			</section>
		
		</form>
		
	</section>

</body>
</html>