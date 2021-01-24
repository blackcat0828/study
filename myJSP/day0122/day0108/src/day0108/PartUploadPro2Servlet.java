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

@WebServlet("/partUploadPro2")
@MultipartConfig(fileSizeThreshold=0,location="d:/upload")
public class PartUploadPro2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PartUploadPro2Servlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String writer = request.getParameter("writer");
		String uploadFileNameList = "";
		
		//현재 사용중인 웹브라우저 체크
		String agent = request.getHeader("User-Agent");
		
		boolean ie = 
		 (agent.indexOf("MSIE")>-1)||(agent.indexOf("Trident")>-1);
		
		String uploadFileName;
		
		//Part 인터페이스
		//Servlet 3.0부터 지원가능
		//form 안에 있는 multipart/form-data 형태로 전송된 전송방식 POST
		//요청의 항목 데이터를 다루는 기능을 포함하는 인터페이스.
		//getName() ?
		//Part 객체의 이름을 String 타입으로 리턴
		for(Part part:request.getParts()) {
			if(!part.getName().equals("writer")) {
				String contentDisposition = part.getHeader("content-disposition");
				
				if(ie) {//internet explorer 인 경우
					uploadFileName = getUploadFileName(contentDisposition,"ie");
				}else {
					uploadFileName = getUploadFileName(contentDisposition,"ch");
				}
				
				part.write(uploadFileName);
				uploadFileNameList += " " + uploadFileName;
			}
		}
	}
	
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
