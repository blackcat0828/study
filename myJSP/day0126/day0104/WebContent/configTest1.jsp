<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Config Test</title>
</head>
<body>
	<h2>Config 테스트</h2>
	<table>
		<tr>
			<td>초기 파라메터 이름</td>
			<td>초기 파라메터 값</td>
		</tr>
		
		<%
		
			String id = config.getInitParameter("id");
		    String passwd = config.getInitParameter("passwd");
			
		    if(id.equals("fintech") && passwd.equals("fintech1234")){
		    	out.print("정상적으로 로그인");
		    }else{
		    	out.print("로그인 실패");
		    }
		    
		    
		
		    //Tomcat서버의 web.xml의 <init-param> 설정값과
		    //프로젝트의 web.xml의 <init-param> 설정값을 동시에 가져옴
			Enumeration e = config.getInitParameterNames();
		
		    //다음에 가져올 자료가 있는지 여부 체크
			while(e.hasMoreElements()){
				//다음 자료를 가져온다.
				String init_paramName = (String)e.nextElement();
		%>
			<tr>
				<td><%=init_paramName%></td>
				<td><%=config.getInitParameter(init_paramName)%></td>
			</tr>		
		<%
			}
		%>
	</table>
</body>
</html>





