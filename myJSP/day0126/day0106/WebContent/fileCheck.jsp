<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//한글깨짐 방지
		request.setCharacterEncoding("UTF-8");
	
		//fileUpload.jsp에서 넘어온 hidden 속성값들을 가져오기
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String filename1 = request.getParameter("filename1");
		String filename2 = request.getParameter("filename2"); 
		String origfilename1 = request.getParameter("origfilename1");
		String origfilename2 = request.getParameter("origfilename2");
	%>
	
	올린사람 : <%=name%><br>
	제목 : <%=subject%><br>
	<%--
		filename1 : 서버에 올린 미디어 이름을 매개변수로
		file_down.jsp로 보낸다.
	--%>
	파일명1:<a href="file_down.jsp?file_name=<%=filename1%>">
				<%=origfilename1%></a><br>
		<%--
		filename1 : 서버에 올린 미디어 이름을 매개변수로
		file_down.jsp로 보낸다.
	--%>			
	파일명2:<a href="file_down.jsp?file_name=<%=filename2%>">
				<%=origfilename2%></a>			
</body>
</html>



