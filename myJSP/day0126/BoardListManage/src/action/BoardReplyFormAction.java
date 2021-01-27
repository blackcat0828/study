package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

//댓글 입력 폼 요청을 위한 Action 클래스
public class BoardReplyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();;
		//댓글 입력 처리후 작업중인 페이지로 다시 되돌아가기 위해 현재 페이지 번호
		//를 관리한다.
		String nowPage = request.getParameter("page");
		//댓글을 입력하기 위해 게시판 번호를 가져온다.
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		//게시판 상세보기 처리를 위한 Service 클래스
		BoardDetailService boardDetailService = new BoardDetailService();
		
		//댓글을 입력하려는 게시판의 정보를 가져오기
		BoardBean article = boardDetailService.getArticle(board_num);
		
		//댓글을 입력하기 위한 게시판 정보와 현재 페이지 번호를 속성을 선언한다.
		request.setAttribute("article",article);
		request.setAttribute("page",nowPage);
		
		//댓글 입력 폼으로 이동
		forward.setPath("/board/qna_board_reply.jsp");
		
		return forward;
	}

}