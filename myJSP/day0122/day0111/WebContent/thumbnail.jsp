<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.awt.Graphics2D" %>
<%@ page import="java.awt.image.renderable.ParameterBlock" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.media.jai.JAI" %>
<%@ page import="javax.media.jai.RenderedOp" %>
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
		ServletContext context = request.getServletContext();
	    //미디어 업로드 위치
		//String imagePath = context.getRealPath("image");
	    
	    String imagePath = 
	    		"D:\\jspStudy\\day0111\\WebContent\\image";
	    
	    //이미지 업로드시 파일의 크기를 1M로 제한
		int size=1*1024*1024;
		String filename = "";
		
		try{
			//MultipartRequest ?
			//미디어 업로드 하기 위한 설정		
			MultipartRequest multi = new MultipartRequest(
				request,
				imagePath,//이미지 업로드 물리적 위치
				size,//업로드 파일 크기 지정
				"UTF-8",//인코딩 방식
				//업로드 미디어 파일이름 처리방식 지정
				//만약 업로드 파일이름이 동일한 경우 자동 넘버링
				new DefaultFileRenamePolicy());
			
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
	
		//ParameterBlock?
		//이미지 생성을 위한 작업공간 선언		
		ParameterBlock pb = new ParameterBlock();
		
		//필요한 매개변수를 지정할때 add() 사용
		pb.add(imagePath + "/" + filename);
		
		//새로운 썸네일 미디어 생성
		RenderedOp rOp = JAI.create("fileload",pb);
		
		//미디어를 넣을 버퍼 생성
		BufferedImage bi = rOp.getAsBufferedImage();
		
		//미디어 버퍼 크기지정(가로:100,세로:100)
		//BufferedImage.TYPE_INT_RGB?
		//청색,초록색,빨간색을 8비트 정수형 픽셀에 의해 이미지를 표시		
		BufferedImage thumb = 
			new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
		
		//이미지 생성을 선언
		Graphics2D g = thumb.createGraphics();
		
		//drawImage?
		//drawImage(이미지변수,X좌표,Y좌표,가로크기,세로크기,null)
		g.drawImage(bi,0,0,100,100,null);
		
		File file = new File(imagePath + "/sm_" + filename);
		
		//특정 폴더에 썸네일 이미지 파일 생성
		ImageIO.write(thumb,"jpg",file);
		
	%>
	
	원본 이미지<br>
	<%-- <img src="image/<%=filename%>"><p> --%>
	
	<%--
		${pageContext.request.contextPath} : 
		프로젝트의 ROOT디렉토리 이를 가리킨다.
	 --%>
	<img src="${pageContext.request.contextPath}"><p>
	
	썸네일 이미지<br>
	<img src="image/sm_<%=filename%>">
</body>
</html>







