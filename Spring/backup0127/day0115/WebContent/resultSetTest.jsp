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
		Connection conn = null;
		String sql = "select * from student";
		PreparedStatement pstmt = null;
		//select문을 실행한후 데이터를 배열형태로 가지는 객체
		ResultSet rs = null;
		
		try{
			
			Context init = new InitialContext();
			//JNDI(Java and Directory Intetface) 방식
			//jdbc/OracleDB 이름은
			//context.xml 의 resource name과 반드시 동일해야 한다.
			DataSource ds = 
					(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			
			//데이터베이스와 연결 
			conn = ds.getConnection();
			
			//sql 문장을 실행하기 위해 준비
			pstmt = conn.prepareStatement(sql);
			
			//select문장일 경우에는 executeQuery()이고
			//나머지는 executeUpdate() 이다.
			rs = pstmt.executeQuery();
			
			//getInt(1)는 getInt("num")과 같은 내용이다
			//getString(2) 는 getString("name") 과 같은 내용이다.
			while(rs.next()){
				out.println("<h3>" + rs.getInt(1) + "," + rs.getString(2) + "</h3>");
			}
			
		}catch(Exception e){
			out.println("<h3>데이터 가져오기에 실패하였습니다.</h3>");
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
	%>
</body>
</html>