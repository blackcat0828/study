<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>   
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원내역 수정</title>
<style>
	table {
		margin:auto;
		width:400px;
		border:1px solid gray;
		text-align:center;
	}
</style>
</head>
<body>

<%
		String id = null;
		
		//세션 id 값이 없거나 폼에서 입력한 id 값이 admin 아닌 경우
		//비정상적으로 로그인 이므로 다시 로그인 화면으로 이동시킴 
		if((session.getAttribute("id")==null) ||
		   (!((String)session.getAttribute("id")).equals("admin"))){
			
			out.println("<script>");
			out.println("location.href='loginForm.jsp'");
			out.println("</script>");
		}
	
		//회원 수정 화면에서 클릭한 회원ID 값을 가져온다
		String update_id = request.getParameter("id");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Context init = new InitialContext();
			DataSource ds = 
			(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			
			//데이터베이스 연결
			conn = ds.getConnection();
			
			conn.setAutoCommit(false);
			
			String sql = "select * from member where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,update_id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()){
				
		%>
		<form name="frm" 
		      action="member_updateProcess.jsp" method="post">
			<table>
				<tr>
					<td>아이디:</td>
					<td>
						<input type="text" name="id" 
						       value="<%=rs.getString("id")%>">
					</td>
				</tr>
				<tr>
					<td>비밀번호:</td>
					<td>
						<input type="text" name="pass" 
						       value="<%=rs.getString("password")%>"/>
					</td>
				</tr>
				<tr>
					<td>이름:</td>
					<td>
						<input type="text" name="name" 
						       value="<%=rs.getString("name")%>">
					</td>
				</tr>
				<tr>
					<td>나이:</td>
					<td>
						<input type="text" name="age" 
						       value="<%=rs.getInt("age")%>">
					</td>
				</tr>

				<tr>
					<td>성별:</td>
					<td>
						<input type="radio" name="gender" value="남"
						       <%
						       	  if(rs.getString("gender").equals("남")){	
						       %> 
						          checked
						       <%
						       	  }
						       %>>남자   
						       
						<input type="radio" name="gender" value="여"
						       <%
						       	  if(rs.getString("gender").equals("여")){	
						       %> 
						          checked
						       <%
						       	  }
						       %>>여자   
						       
						            
					</td>
				</tr>
				<tr>
					<td>이메일주소:</td>
					<td>
						<input type="text" name="email" 
						       value="<%=rs.getString("email")%>">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="javascript:frm.submit()">수정</a>
					</td>
				</tr>										
			</table>
		</form>
		<%		
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	%> 
</body>
</html>