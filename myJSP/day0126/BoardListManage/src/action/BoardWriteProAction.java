package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.BoardWriteProService;
import vo.ActionForward;
import vo.BoardBean;

//게시판등록 처리
public class BoardWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		//board 테이블에 저장하기 위한 클래스
		BoardBean boardBean = null;
		String realFolder = "";
		//첨부파일이 저장되는 위치
		//String saveFolder = "/boardUpload";
		int fileSize = 5 * 1024 * 1024;//5M
		ServletContext context = request.getServletContext();
		//realFolder = context.getRealPath(saveFolder);
		
		realFolder = "C:\\study\\myJSP\\day0126\\BoardListManage\\WebContent\\resources\\images";
		
		//파일 업로드시 사용되는 클래스
		MultipartRequest multi = new MultipartRequest(
					request,//내장객체
					realFolder,//업로드 위치
					fileSize,//업로드 파일 크기
					"UTF-8",//인코딩 방식
					//동일한 파일 업로드시 미디어 넘버링 처리
					new DefaultFileRenamePolicy());
		
		//테이블 board에 저장하기 위해서 BoardBean 인스턴스 생성
		boardBean = new BoardBean();
		
		boardBean.setBoard_name(multi.getParameter("board_name"));
		boardBean.setBoard_pass(multi.getParameter("board_pass"));
		boardBean.setBoard_subject(multi.getParameter("board_subject"));
		boardBean.setBoard_content(multi.getParameter("board_content"));
		//getFileNames() : 입력폼에서 type이 file로 선언된 속성값들을 가져온다.
		boardBean.setBoard_file(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		
		//Controller가 클라이언트로 부터 요청을 받으면
		//적절한 Service 에 전달하고 Service는 Business Logic을 수행한다
		//DAO로 데이터베이스를 접근하고 DTO로 데이터를 전달받은 다음 결과값을
		//반환하면 결과값을 Controller가 가져가서 View에 전달하면 화면출력한다.
		
		BoardWriteProService boardWriteProService = 
				new BoardWriteProService();
		
		//신규 게시판 등록처리
		boolean isWriteSuccess = boardWriteProService.registArticle(boardBean);
		
		//신규 게시판 등록이 실패하면 
		if(!isWriteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back();");
			out.println("<script>");
			
		}else {//게시판 등록 성공
			
			//신규 게시판 등록이 성공을 하면 게시판 목록으로 이동처리
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.bo");
			
			//response.sendRedirect("boardList.bo");
			
		}
		
		return forward;
	}
}
