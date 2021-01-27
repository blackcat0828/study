<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자 모드(회원 목록 보기)</title>
<style>
	table {
		margin:auto;
		width:400px;
		border:1px solid gray;
		text-align:center;
	}
	
	.td_title{
		font-weight:bold;
		font-size:x-large;
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
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			
			conn = ds.getConnection();
			
			String sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
		   %>	
			
			<table>
			<tr>
				<td colspan="2" class="td_title">회원목록</td>
			</tr>

			<%
				while(rs.next()){
			%>
					<tr>
						<td>
							<a href="member_info.jsp?id=<%=rs.getString("id")%>"><%=rs.getString("id")%></a>
						</td>
						
						<td>
							<a href="member_update.jsp?id=<%=rs.getString("id")%>">수정</a>
						</td>
						
						<td>
							<a href="member_delete.jsp?id=<%=rs.getString("id")%>">삭제</a>
						</td>
					</tr>
			<%		
				}
			%>
		</table>
		
		<%	
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				if(rs != null) rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	%>
	

</body>
</html>