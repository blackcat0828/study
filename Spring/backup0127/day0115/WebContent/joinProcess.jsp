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
		String name = request.getParameter("name");
		//request.getParameter(속성이름)=> 문자열로 값을 가져온다.
		//age인 경우 테이블에 Number 타입이므로 정수로 변환		
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			
			Context init = new InitialContext();
			DataSource ds = 
					(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			
			conn = ds.getConnection();

			String sql = "insert into member values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,id);
			pstmt.setString(2,pass);
			pstmt.setString(3,name);
			pstmt.setInt(4,age);
			pstmt.setString(5,gender);
			pstmt.setString(6,email);
			
			int result = pstmt.executeUpdate();

			//executeUpdate() 리턴값은
			//반영된 rowCount를 리턴한다.
			//정상으로 회원가입 처리가 되었으므로 로그인창으로 이동
			if(result != 0){
					out.println("<script>");
					out.println("location.href='loginForm.jsp'");
					out.println("</script>");
			}else{
					//회원가입이 정상적으로 안된 경우 회원가입 창으로 이동
					out.println("<script>");
					out.println("location.href='joinForm.jsp'");
					out.println("</script>");
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