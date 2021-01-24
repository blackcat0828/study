package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//게시물 목록에서 클릭한 게시물 번호를 가져온다.
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		//현재 페이지도 가져온다.
		String page = request.getParameter("page");
		
		//BoardDetailService 
		//특정 게시물 상세보기를 처리하기 위한 클래스
		BoardDetailService boardDetailService = new BoardDetailService();
		//getArticle()?
		//특정게시물의 모든 정보를 가져오는 메서드
		BoardBean article = boardDetailService.getArticle(board_num);
		
		ActionForward forward = new ActionForward();
		
		//특정게시물 정보를 가져와서 article 변수에 대입하였으므로
		//이것을 board/qna_board_view.jsp 로 보내 세부항목을 출력한다.
		//제어권이 넘어갈때 현재페이지 번호와 특정게시물 세부정보도 같이 공유된다.
		request.setAttribute("page",page);
		request.setAttribute("article",article);
		forward.setPath("/board/qna_board_view.jsp");
		
		return forward;
		
	}

}



