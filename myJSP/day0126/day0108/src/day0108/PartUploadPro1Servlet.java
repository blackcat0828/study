package day0108;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//서블릿 설정
//어노테이션(annotation)
@WebServlet("/partUploadPro1")
//fileSizeThreshold
//업로드를 하면 미디어가 기본적으로 메모리에 저장
//지정한 크기를 넘어서면 임시 디렉토리에 미디어를 임시 보관후 업로드 처리
@MultipartConfig(fileSizeThreshold=0,location="d:/upload")
public class PartUploadPro1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//기본생성자
    public PartUploadPro1Servlet() {
    	//상속을 받았으므로 부모의 기본생성자를 먼저 호출
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//입력 폼에서 입력받은 데이터 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		String writer = request.getParameter("writer");
		//폼에서 입력받은 속성값을 가져온다. 
		Part part = request.getPart("partFile1");
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		//헤더정보를 읽어오는데 content-disposition 정보를 읽어온다.
		String contentDisposition = part.getHeader("content-disposition");
		
		//현재 사용중인 웹브라우저 체크
		String agent = request.getHeader("User-Agent");
		
		boolean ie = 
		 (agent.indexOf("MSIE")>-1)||(agent.indexOf("Trident")>-1);
		
		String uploadFileName;
		
		if(ie) {
		 		uploadFileName = getUploadFileName(contentDisposition,"ie");
		}else {
				uploadFileName = getUploadFileName(contentDisposition,"ch");
		}

		part.write(uploadFileName);
		
		out.println("작성자 " + writer + "님이 " + uploadFileName + " 파일을 업로드 하였습니다.");
		
	}
	
	//IE 인 경우
	private String getUploadFileName(String contentDisposition,String browser) {
		
		String uploadFileName = null;
		//split() 메서드를 이용하여 ;을 기준으로 모두 String배열에 대입한다.
		/*
		 * content-disposition form-data ; name="partFile1"; filename =
		 * "c:\Users\oh\desktop\test test.txt"
		 * 
		 * contentSplitStr[0] <= form-data 
		 * contentSplitStr[1] <= name="partFile1"
		 * contentSplitStr[2] <= filename = "c:\Users\oh\desktop\test test.txt"
		 */
		String[] contentSplitStr = contentDisposition.split(";");
		//lastIndexOf(찾고자하는 문자열)
		//우측에서 좌측으로 스캔하면서 찾고자하는 문자열을 찾은 첫위치를 리턴 
		//마지막 \를 찾는다
		
		//현재 사용중인 브라우저가 Internet Expolorer 이면
		if(browser.equals("ie")) {
			int lastPathSeparatorIndex = contentSplitStr[2].lastIndexOf("\\");
			//마지막 "를 찾는다
			int lastQutosIndex = contentSplitStr[2].lastIndexOf("\"");
			
			//substring(start,end)
			//문자열에서 start 부터 end -1 까지 문자열을 가져온다.
			//Internet Explorer인 경우에 한해서
			//파일업로드시 파일명만 표시되는게 아니라 경로까지 모두 포함되므로
			//파일명만 가져오기 위해 별도 처리를 해줘야 한다.
			uploadFileName = contentSplitStr[2]
					          .substring(lastPathSeparatorIndex+1,lastQutosIndex);
		}else {//크롬을 실행시
			
			int firstQutosIndex = contentSplitStr[2].indexOf("\"");
			int lastQutosIndex = contentSplitStr[2].lastIndexOf("\"");
			
			uploadFileName = contentSplitStr[2]
			          .substring(firstQutosIndex+1,lastQutosIndex);
			
			System.out.println("uploadFileName"+uploadFileName);
		}
		
		return uploadFileName;
	}

}