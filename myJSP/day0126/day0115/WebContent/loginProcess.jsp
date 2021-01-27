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
		//한글처리
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			
			Context init = new InitialContext();
			DataSource ds = 
					(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			
			conn = ds.getConnection();
			//member 테이블에서 폼에서 입력받은 id값이 존재하는지 체크
			String sql = "select * from member where id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,id);
			
			rs = pstmt.executeQuery();
			
			//rs.next()이 true라는 것은 member 테이블에 자료가
			//있으므로 비밀번호 체크를 수행한다.
			if(rs.next()){
				//rs.getString("password")에서
				//password는 필드명
				if(pass.equals(rs.getString("password"))){
					
					//정상적인 사용자의 로그인일 경우
					//id라는 속성값을 생성한다.
					//현재 실행중인 웹 브라우저를 close하기 전까지
					//속성값이 유지된다.
					session.setAttribute("id",id);

					//정상 로그인 경우 메인페이지로 이동
					out.println("<script>");
					out.println("location.href='main.jsp'");
					out.println("</script>");
				}else{
					//비밀번호 오류인 경우
					out.println("<script>");
					out.println("alert('비밀번호 오류')");
					out.println("location.href='loginForm.jsp'");
					out.println("</script>");
				}
				
			}else{
				//비정상 로그인인 경우 로그인 화면으로 이동하게 한다.
				out.println("<script>");
				out.println("location.href='loginForm.jsp'");
				out.println("</script>");
			}			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	%>
</body>
</html>


