<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.awt.Graphics2D"%>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="java.io.File" %>
<%@ page import="javax.imageio.ImageIO" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	   try{
		//썸네일 가로사이즈
		int thumbnail_width = 100;
		//썸네일 세로사이즈
		int thumbnail_height = 100;
		//원본이미지파일의 경로+파일명
		File origin_file_name = new File("D:\\test4.jpg");
		//생성할 썸네일파일의 경로+썸네일파일명
		//File thumb_file_name = new File("D:\\"+File.separator+"thumbnail_image.jpg");
		File thumb_file_name = new File("D:\\tn_test4.jpg");
	
		BufferedImage buffer_original_image = ImageIO.read(origin_file_name);
		BufferedImage buffer_thumbnail_image = new BufferedImage(thumbnail_width, thumbnail_height,
				BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D graphic = buffer_thumbnail_image.createGraphics();
		graphic.drawImage(buffer_original_image, 0, 0, thumbnail_width, thumbnail_height, null);
		ImageIO.write(buffer_thumbnail_image, "jpg", thumb_file_name);
		System.out.println("썸네일 생성완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
</body>
</html>