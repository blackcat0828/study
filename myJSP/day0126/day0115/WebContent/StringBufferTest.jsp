<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.lang.StringBuffer" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		StringBuffer sb = new StringBuffer("Html");
	
		//append()-> 문자열 버퍼에 문자열 추가
		//\n : escape문자(LineFeed:다음라인으로 이동)
		sb.append("Java ");
		sb.append("Jsp ");
		sb.append("Spring ");
		sb.append("Android");
		
		//문자열 버퍼 인덱스가 4인 위치부터 Python 문자열 삽입
		sb.insert(4,"Python");
		
		//특정 위치 삭제
		//4:시작위치,10:종료위치(9까지 삭제)
		sb.delete(4,10);
		out.print("문자열1:" + sb + "<br>");
		
		//문자열 버퍼의 내용을 역순으로 정렬
		sb.reverse();
		out.print("문자열2:" + sb + "<br>");
		
		//문자열 버퍼 초기화
		sb.setLength(0);
		out.print("문자열3:" + sb + "<br>");
		
		
	%>
</body>
</html>





