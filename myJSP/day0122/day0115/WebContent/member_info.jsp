<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 상세보기</title>
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
	
		//상세보기를 위한 회원ID 값을 가져온다.
		String info_id = request.getParameter("id");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			
			conn = ds.getConnection();
			
			String sql = "select * from member where id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,info_id);
			
			//특정 id에 대한 데이터를 ResultSet 테이블 형태로 저장 
			rs = pstmt.executeQuery();
			
			//커서(Cursor)를 다음 자료를 가리킨다.
			rs.next();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
	
	<table>
		<tr>
			<td>아이디:</td>
			<td><%=rs.getString("id")%></td>
		</tr>
		<tr>
			<td>비밀번호:</td>
			<td><%=rs.getString("password")%></td>
		</tr>
		<tr>
			<td>이름:</td>
			<td><%=rs.getString("name")%></td>
		</tr>
		<tr>
			<td>나이:</td>
			<td><%=rs.getString("age")%></td>
		</tr>
		<tr>
			<td>성별:</td>
			<td><%=rs.getString("gender")%></td>
		</tr>
		<tr>
			<td>이메일 주소:</td>
			<td><%=rs.getString("email")%></td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="member_list.jsp">리스트로 돌아가기</a>
			</td>
		</tr>		
	</table>
</body>
</html>



