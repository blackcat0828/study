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
		String sql = "insert into student(num,name)" + 
		             "            values(7,'홍길동') ";
		Statement stmt = null;
	
		try{
			
			//애플리케이션이 처음으로 실행될때 모든 설정에 관련되는 사항은
			//java:comp/env 부분에 설정된다.
			Context init = new InitialContext();
			
		    //데이터베이스 연결 객체
		    //jdbc/OracleDB 명칭은 context.xml 의 
		    //Resouce name을 그대로 선언하면 된다
			DataSource ds = 
			(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			
		    //톰캣서버에서 제공하는 Connection 객체를 얻어온다.
			conn = ds.getConnection();
		    
		    //sql 문장을 실행하기 위한 준비
		    stmt = conn.createStatement();
		    
		    //실제로 sql 문장을 실행
		    //Returns:
	        //either (1) the row count for SQL Data 
	        //Manipulation Language (DML) statements or (2) 
	        //0 for SQL statements that return nothing
		    int result = stmt.executeUpdate(sql);
		    
	        //리턴값이 0이면 정상 다른값이면 오류
		    if(result != 0){
		    	out.println("<h3>자료가 등록되었습니다.</h3>");
		    }
			
		}catch(Exception e){
			out.println("<h3> statementTest.jsp 자료등록에 실패하였습니다.</h3>");
			e.printStackTrace();
		}finally{//반드시 실행하는 문장
			try{
				stmt.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
	%>
</body>
</html>