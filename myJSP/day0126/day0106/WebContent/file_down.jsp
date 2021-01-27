<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>    
<%@ page import="java.io.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 다운로드</title>
</head>
<body>
	<%
		//파일명1,파일명2중 선택한 파일이름을 가져온다.
		String fileName = request.getParameter("file_name");
		//String savePath = "d:\\download";
		//ServletContext context = getServletContext();
		//context.getRealPath():
		//파일을 다운로드 하기 위한 서버의 물리적인 경로를 가져온다.
		//String sDownLoadPath = context.getRealPath(savePath);
		String sDownLoadPath = "d:\\upload";
		
		//예를 들어 d:\\upload\\test2.jpg 에 있는 파일 다운로드
		String sFilePath = sDownLoadPath + "\\" + fileName;
		
		//이미지 저장을 위한 바이트 배열 선언
		byte b[] = new byte[4096];
		
		//FileInputStream : 바이트 단위 입력 스트림(기반 스트림)
		//보조 스트림 ? 기반스트림과 병행해서 사용을 해야 한다. 
		FileInputStream in = new FileInputStream(sFilePath);
		
		//MIME : Context의 자료 형태를 표시
		//image/jpg,image/jpeg,text/html,video/avi,video/mp4
		//audio/mp3
		String sMimeType = getServletContext().getMimeType(sFilePath);
		
		System.out.println("sMimeType>>" + sMimeType);
		
		if(sMimeType == null){
			//다운로드 하기 위한 MIME 설정
			sMimeType = "application/octet-stream";
		}
		
		//Context 타입을 해당 MIME으로 지정
		response.setContentType(sMimeType);
		
		//getHeader ?
		//http 헤더 정보중 현재 사용중인 웹브라우저 종류를 가져온다.		
		String agent = request.getHeader("User-Agent");
		
		//헤더의 User-Agent의 문자열 값에 MSIE 혹은 Trident 문자열을 
		//찾으면 현재 웹브라우저가 Internet Explorer 임을 알수 있다.
		boolean ieBrowser = 
			(agent.indexOf("MSIE")>-1) || (agent.indexOf("Trident")>-1);
		
		//현재 웹브라우저가 Internet Explorer 이면
		if(ieBrowser){
			//URLEncoder.encode
			//다운로드 하려는 미디어에 한글명이 존재하면 문제가 발생하므로
			//인코딩 작업은 필수 
			//파일을 다운로드 하려고 할때
			//Internet Explorer 인 경우 공백이 +로 표시되므로 %20 을 사용
			//하여 공백표시 추가
			fileName =	URLEncoder.encode(fileName,"UTF-8")
				                  .replaceAll("\\+","%20");
		}else{//현재 웹브라우저가 Internet Explorer 아닌 경우
			fileName = 
					new String(fileName.getBytes("UTF-8"),"iso-8859-1");
		}
		
		//Content-Disposition : 헤더에 다운로드에 대한 선언
		//선언방식
		//Content-Disposition : inline (화면에 파일 내용을 미리보기)
		//Content-Disposition : attachment(미디어 다운로드)
		//Content-Disposition : attachment;filename="test.jpg"
		 response.setHeader("Content-Disposition",
				"attachment; filename= " + fileName);
		
		//출력을 위한 스트림 선언
		//out 는 JspWriter 이 지원
		ServletOutputStream out2 = response.getOutputStream();
		
		int numRead;
		
		//바이트 배열의 크기만큼 미디어(이미지,동영상)의 내용을 읽어와서
		//ServletOutputStream 을 이용하여 다운로드 폴더에 write
		//-1 : 파일의 끝(EOF: End Of File)
		while((numRead = in.read(b,0,b.length)) != -1){
			out2.write(b,0,numRead);
		}
		
		out2.flush();//버퍼의 내용을 비움
		out2.close();
		in.close();

	%>
</body>
</html>