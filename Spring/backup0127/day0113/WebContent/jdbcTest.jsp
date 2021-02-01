<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//ojdbc6.jar를 톰캣 lib에 복사
		Connection conn = null;
	
		String driver = "oracle.jdbc.driver.OracleDriver";
		//데이터베이스 연결 설정
		//실무에서 변경할 내용
		//localhost -> 서버주소 입력
		//orcl => SID이름만 변경
		//1521 => 오라클 접속 포트
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userid = "fintech2";
		String userpw = "fintech2";
		
		Boolean connect = false;
		
		try {
			
			//Class는 Class 클래스로 클래스의 모든 정보를 가져온다.
			//forName : 해당 객체를 리턴한다.
			Class.forName(driver);
			
			//데이터베이스에 연결
			conn = DriverManager.getConnection(url,userid,userpw);
			
			connect = true;
			conn.close();
			
		}catch(Exception e){
			connect = false;
			//예외 상황을 상세하게 화면에 표시
			e.printStackTrace();
		}
	%>
	<h3>
		<%
			if(connect == true){
		%>
				연결 되었습니다.
		<%
			}else{
		%>
				연결 실패입니다.				
		<%
			}
		%>
	
	</h3>
</body>
</html>


