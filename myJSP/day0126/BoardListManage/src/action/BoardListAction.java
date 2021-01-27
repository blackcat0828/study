package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardListService;
import vo.ActionForward;
import vo.BoardBean;
import vo.PageInfo;

//게시판 리스트
public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
		
		//page : 현재 페이지번호,limit : 한 페이지당 보여지는 리스트 갯수
		int page = 1,limit=10;
		
		//현재 페이지 번호가 있으면 
		if(request.getParameter("page") != null) {
			//getParameter() 메서드 리턴값은 문자열이므로
			//연산처리를 하기 위해서 정수로 변환처리
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		//게시판 내역을 보여주는 Service 객체
		BoardListService boardListService = new BoardListService();
		
		//총 게시물 목록 갯수
		int listCount = boardListService.getListCount();
		
		//현재 페이지에 해당하는 게시물 목록을 가져오는 메서드
		articleList = boardListService.getArticleList(page,limit);
		
		//총 필요한 페이지 수
		//게시물 갯수가 120개 1페이지당 10개씩 => 12Page
		//게시물 갯수가 133개 1페이지당 10개씩 => 14Page
		int maxPage = (int)((double)listCount/limit+0.95);
		
		int startPage = (((int)((double)page/10+0.9))-1)*10 + 1;
		int endPage = startPage + 10 - 1;

		//계산된 마지막 페이지 값이 maxPage보다 크면
		//maxPage값을 마지막 페이지로 대입
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		//페이지 정보를 관리하는 클래스
		PageInfo pageInfo = new PageInfo();
		
		//PageInfo 클래스에 값을 대입 
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		
		//클라이언트의 요청이 처리될때까지 유효
		//페이지 정보
		request.setAttribute("pageInfo",pageInfo);
		//게시물 목록 정보
		request.setAttribute("articleList",articleList);
		
		//게시물 출력처리
		ActionForward forward = new ActionForward();
		forward.setPath("/board/qna_board_list.jsp");
		
		return forward;
		
	}

}