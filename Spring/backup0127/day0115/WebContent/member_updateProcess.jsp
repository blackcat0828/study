<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("UTF-8");
		
		//입력 폼에서 입력받은 값들을 가져온다.
		String id = request.getParameter("id");
		String passwd = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try{
			Context init = new InitialContext();
			DataSource ds = 
			(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			
			//데이터베이스 연결
			conn = ds.getConnection();
			
			String sql = "update member" +
			 			 "   set password = ?," +
			             "       name = ?," +
			 		 	 "       age = ?," +
			             "       gender = ?," +
			 			 "       email = ?" +
			             " where id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,passwd);
			pstmt.setString(2,name);
			pstmt.setInt(3,age);
			pstmt.setString(4,gender);
			pstmt.setString(5,email);
			pstmt.setString(6,id);
			
			pstmt.executeUpdate();
			
			out.println("정상적으로 수정되었습니다.<br>");
			
			out.println("<a href='member_list.jsp'>");
			out.println("회원목록으로 가기");
			out.println("</a>");
			
			
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








