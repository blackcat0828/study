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
<%@ page import="java.awt.Image" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String oPath = "C:/Users/KTE/Pictures/test3.jpg"; // 원본 경로
	File oFile = new File(oPath);

	String fileName= "test3.jpg";
	
	int index = oPath.lastIndexOf(".");
	String ext = oPath.substring(index + 1); // 파일 확장자

	String tPath = oFile.getParent() + File.separator + "t-" + oFile.getName(); // 썸네일저장 경로
	File tFile = new File(tPath);

	double ratio = 2; // 이미지 축소 비율

	try {
		BufferedImage oImage = ImageIO.read(oFile); // 원본이미지
		int tWidth = (int) (oImage.getWidth() / ratio); // 생성할 썸네일이미지의 너비
		int tHeight = (int) (oImage.getHeight() / ratio); // 생성할 썸네일이미지의 높이
		
		BufferedImage tImage = new BufferedImage(tWidth, tHeight, BufferedImage.TYPE_3BYTE_BGR); // 썸네일이미지
		Graphics2D graphic = tImage.createGraphics();
		Image image = oImage.getScaledInstance(tWidth, tHeight, Image.SCALE_SMOOTH);
		graphic.drawImage(image, 0, 0, tWidth, tHeight, null);
		graphic.dispose(); // 리소스를 모두 해제

		ImageIO.write(tImage, ext, tFile);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	%>
	
	원본이미지<img src="C:/Users/KTE/Pictures/<%=fileName%>">
	썸네일이미지<img src="C:/Users/KTE/Pictures/t_<%=fileName%>">
</body>
</html>