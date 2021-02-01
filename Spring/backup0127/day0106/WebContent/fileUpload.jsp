<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//업로드하는 위치 지정
		//String uploadPath = request.getRealPath("/upload");
	    String uploadPath = "d:\\upload";
		
		int size = 10*1024*1024;//한번에 올릴수 있는 최대크기 : 10M
		
		String name="",subject="",filename1="",filename2="";
		String origfilename1="",origfilename2="";
		
		try{
			
			//파일업로드를 위한 설정 5가지 선언
			MultipartRequest multi = 
					new MultipartRequest(
						request,
						uploadPath,
						size,
						"UTF-8",
						new DefaultFileRenamePolicy());
			
			//폼에서 입력받은 올린사람 값을 가져온다.
			name = multi.getParameter("name");
			//폼에서 입력받은 제목의 값을 가져온다.
			subject = multi.getParameter("subject");
			
			//입력 폼에서 input type="file"로 선언된 속성의
			//값들을 배열형태로 대입처리		
			Enumeration files = multi.getFileNames();
			
			//현재 커서(Cursor)가 가리키는 데이터를 Return
			String file1 = (String)files.nextElement();
			//실제로 서버에 올라간 미디어 이름
			filename1 = multi.getFilesystemName(file1);
			//서버에 올리기전 원본 미디어 이름
			origfilename1 = multi.getOriginalFileName(file1);
			
			//폼에서 입력받은 두번째 파일정보를 가져온다.
			String file2 = (String)files.nextElement();
			filename2 = multi.getFilesystemName(file2);
			origfilename2 = multi.getOriginalFileName(file2);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
	<%--
	  type="hidden" 은 Form에서는 보이지 않고 다른 jsp로 값들을 보내고 싶을때
	  사용 
	--%>
	<form action="fileCheck.jsp" method="post" name="filecheck">
		<input type="hidden" name="name" value="<%=name%>">
		<input type="hidden" name="subject" value="<%=subject%>">
		<input type="hidden" name="filename1" value="<%=filename1%>">
		<input type="hidden" name="filename2" value="<%=filename2%>">
		<input type="hidden" name="origfilename1" value="<%=origfilename1%>">
		<input type="hidden" name="origfilename2" value="<%=origfilename2%>">			
	</form>
	<%--폼의 값을 submit() 메서드에 의해 fileCheck.jsp로 전송처리 --%>
	<a href="#" onclick="javascript:filecheck.submit()">
	   업로드 확인및 다운로드 페이지로 이동
	</a>
</body>
</html>






