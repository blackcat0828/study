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
		String id = null;
		
		//세션 id 값이 없거나 폼에서 입력한 id 값이 admin 아닌 경우
		//비정상적으로 로그인 이므로 다시 로그인 화면으로 이동시킴 
		if((session.getAttribute("id")==null) ||
		   (!((String)session.getAttribute("id")).equals("admin"))){
			
			out.println("<script>");
			out.println("location.href='loginForm.jsp'");
			out.println("</script>");
		}
	
		//member_list.jsp에서 클릭한 회원ID값을 가져온다.
		String delete_id = request.getParameter("id");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try{
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			
			conn = ds.getConnection();
			
			String sql = "delete from member where id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,delete_id);
			
			pstmt.executeUpdate();
			
			out.print("정상적으로 삭제되었습니다.");
			
			//정상삭제 처리후 회원 리스트 화면으로 가도록 선언
			response.sendRedirect("member_list.jsp");
			
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