<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name="";
		String subject="";
	
	    String imagePath = 
	    		"D:\\fileUpload";
	    
		int size=10*1024*1024;
		String filename = "";
		
		try{	
			MultipartRequest multi = new MultipartRequest(
				request,
				imagePath,
				size,
				"UTF-8",
				new DefaultFileRenamePolicy());
			name = multi.getParameter("name");
			subject = multi.getParameter("subject");

			
			//getFileNames?
			//입력 폼에서 type="file"로 선언된 속성이름들을 가져와서
			//배열형태에 대입
			Enumeration files = multi.getFileNames();
			//커서가 현재 위치의 파일명을 가져온다.
			String file=(String)files.nextElement();
			//getFilesystemName : 서버에 업로드된 파일명
			filename = multi.getFilesystemName(file);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		PrintWriter ot = response.getWriter();

		ot.print("이름 : "  + name + "<br>");
		ot.print("제목 : "  + subject + "<br>");
		ot.print("파일명 : " +  filename + "<br>");
	%>

</body>
</html>
